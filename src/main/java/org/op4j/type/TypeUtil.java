/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.op4j.exceptions.TypeRecognitionException;
import org.op4j.exceptions.TypeValidationException;
import org.op4j.type.parser.TypeLexer;
import org.op4j.type.parser.TypeParser;
import org.op4j.typedef.BoundedTypeDefVariable;
import org.op4j.typedef.InnerClassTypeDefVariable;
import org.op4j.typedef.InnerNamedTypeDefVariable;
import org.op4j.typedef.InnerParameterizedTypeTypeDefVariable;
import org.op4j.typedef.InnerTypeDefVariable;
import org.op4j.typedef.InnerWildcardTypeDefVariable;
import org.op4j.typedef.NamedTypeDefVariable;
import org.op4j.typedef.TypeDef;
import org.op4j.typedef.TypeDefVariable;
import org.op4j.typedef.TypeDefs;

/*
 * (non-javadoc)
 * 
 * This class contains internal algorithms for Type processing and
 * handling.
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeUtil {
    
    
    
    static Type forName(final String typeName) {

        try {
            
            final TypeLexer lex = new TypeLexer(new ANTLRStringStream(typeName));
            final CommonTokenStream tokens = new CommonTokenStream(lex);

            final TypeParser parser = new TypeParser(tokens);

            final CommonTree tree = (CommonTree) parser.type().getTree();
            return createTypeFromTree(tree);
            
        } catch (Exception e) {
            throw new TypeRecognitionException(typeName, e);
        }
        
    }
    
    
    
    private static Type createTypeFromTree(final Tree tree) 
            throws ClassNotFoundException {

        if (tree.getType() != TypeLexer.CLASSNAME) {
            throw new TypeRecognitionException(
                    "A class name was expected (was: " + tree.getType() + ")");
        }

        final String className = tree.getText();
        Class<?> typeClass = null;
        try {
            typeClass = ClassUtils.getClass(className);
        } catch (ClassNotFoundException e) {
            try {
                typeClass = ClassUtils.getClass(TypeNaming.TYPE_PACKAGE_LANG + className);
            } catch (ClassNotFoundException ex) {
                try {
                    typeClass = ClassUtils.getClass(TypeNaming.TYPE_PACKAGE_UTIL + className);
                } catch (ClassNotFoundException exc) {
                    try {
                        typeClass = ClassUtils.getClass(TypeNaming.TYPE_PACKAGE_IO + className);
                    } catch (ClassNotFoundException exce) {
                        throw new ClassNotFoundException(className);
                    }
                }
            }
        }
        
        final List<TypeParameter> typeParameters = new LinkedList<TypeParameter>();
        int arrayDimensions = 0;
        
        for (int i = 0; i < tree.getChildCount(); i++) {
                
            final Tree child = tree.getChild(i);
            
            if (child.getType() == TypeLexer.ARRAY) {
                
                arrayDimensions++;
                
            } else {
                
                switch (child.getType()) {
                
                    case TypeLexer.WILDCARD:
                        typeParameters.add(WildcardTypeParameter.WILDCARD); 
                        break;
                        
                    case TypeLexer.EXT:
                        Type extendedType = createTypeFromTree(child.getChild(0));
                        typeParameters.add(new ExtendsTypeParameter(extendedType));
                        break;
                        
                    case TypeLexer.SUP:
                        Type superType = createTypeFromTree(child.getChild(0));
                        typeParameters.add(new SuperTypeParameter(superType));
                        break;
                        
                    default:
                        Type type = createTypeFromTree(child);
                        typeParameters.add(new StandardTypeParameter(type));
                
                }
                
            }
        
        }
        
        // Maybe the type has been specified as raw without the wildcards
        if (typeParameters.size() == 0) {
            for (int i = 0; i < typeClass.getTypeParameters().length; i++) {
                typeParameters.add(WildcardTypeParameter.WILDCARD);
            }
        }
        
        final TypeParameter[] typeParametersArray = 
            typeParameters.toArray(new TypeParameter[typeParameters.size()]);
        
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();

        return typeRegistry.getType(typeClass, typeParametersArray, arrayDimensions);
        
    }
  
    
    
    static Type getRawTypeForType(final Type type) {
        return getRawTypeForClass(type.getComponentClass(), type.getArrayDimensions());
    }
  
    
    
    static Type getRawTypeForClass(final Class<?> typeClass) {
        return getRawTypeForClass(typeClass, 0);
    }
  
    
    
    private static Type getRawTypeForClass(
            final Class<?> typeClass, final int arrayDimensions) {
        
        Class<?> componentClass = typeClass;
        int newArrayDimensions = arrayDimensions;
        
        while (componentClass.isArray()) {
            componentClass = componentClass.getComponentType();
            newArrayDimensions++;
        }
        
        final TypeDef typeDef = TypeDefs.forClass(componentClass);
        final TypeDefVariable[] variables = typeDef.getVariables();
        
        final TypeParameter[] typeParameters = new TypeParameter[variables.length];
        for (int i = 0; i < variables.length; i++) {
            typeParameters[i] = WildcardTypeParameter.WILDCARD;
        }
            
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();

        return typeRegistry.getType(componentClass, typeParameters, newArrayDimensions);

    }

    
    
    static Set<Type> getExtendedTypes(final Type type) {
        
        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        
        final Set<Type> equivalenceSet = new HashSet<Type>();
        
        if (Object.class.equals(type.getComponentClass())) {
            // If we reached the Object class, then we only need to add
            // all the Object-based classes down to array dimension zero.
            int currentArrayDim = type.getArrayDimensions();
            while (currentArrayDim > 0) {
                currentArrayDim--;
                equivalenceSet.add(
                        typeRegistry.getTypeWithoutValidation(Object.class, new TypeParameter[0], currentArrayDim));
            }
            return equivalenceSet;
        }
        
        if (type.isInterface()) {
            equivalenceSet.add(typeRegistry.getRawTypeForClass(Object.class));
        }

        final Class<?> componentClass = type.getComponentClass();
        
        final java.lang.reflect.Type superclassTypeDeclaration = 
            componentClass.getGenericSuperclass();
        if (superclassTypeDeclaration != null) {
            final Type superclassType = resolveExtendedTypeByDeclaration(type, superclassTypeDeclaration);
            equivalenceSet.add(superclassType);
            equivalenceSet.addAll(typeRegistry.getExtendedTypes(superclassType));
        }
        
        for (java.lang.reflect.Type interfaceTypeDeclaration : componentClass.getGenericInterfaces()) {
            final Type interfaceType = resolveExtendedTypeByDeclaration(type, interfaceTypeDeclaration);
            equivalenceSet.add(interfaceType);
            equivalenceSet.addAll(typeRegistry.getExtendedTypes(interfaceType));
        }
        
        return Collections.unmodifiableSet(equivalenceSet);
        
    }
    
    
    private static Type resolveExtendedTypeByDeclaration(
            final Type originalType, final java.lang.reflect.Type typeDeclaration) {

        final Map<String,TypeParameter> typeParametersMap = 
            new HashMap<String, TypeParameter>();

        Class<?> componentClass = null;
        
        if (typeDeclaration instanceof ParameterizedType) {
            
            /*
             * If the declaration is for a parameterized type and its 
             * declaration specifies values for its type parameters 
             * (like "<T,F>"), we will add the corresponding TypeParameter 
             * objects to the type, using the own TypeParameter objects of 
             * the containing (original) class.
             */

            final ParameterizedType parameterizedTypeDeclaration = 
                (ParameterizedType) typeDeclaration;

            // Get the type argument declarations as they appear in the 
            // original type (eg: "class Original implements Map<A,B>" -> 
            // "[A,B]")
            final java.lang.reflect.Type[] parameterizedTypeDeclarationArguments = 
                parameterizedTypeDeclaration.getActualTypeArguments();
            
            componentClass = 
                (Class<?>) parameterizedTypeDeclaration.getRawType();
            
            // Get the type arguments as they are declared in the type declared
            // itself as argument of the original type (eg: "class Map<K,V>" ->
            // "[K,V]") 
            final TypeVariable<?>[] componentClassTypeParameters =
                componentClass.getTypeParameters();
            
            for (int i = 0; i < parameterizedTypeDeclarationArguments.length; i++) {
                
                final TypeParameter typeParameter = 
                    resolveEquivalentTypeParameterByDeclaration(
                            originalType, 
                            parameterizedTypeDeclarationArguments[i], 0);

                typeParametersMap.put(
                        componentClassTypeParameters[i].getName(),
                        typeParameter);
                
            }
            
        } else {

            /*
             * If the declaration is not parameterized, it can mean either that
             * the type has no type parameters or that it has type parameters
             * but these have not been specified (raw type).
             * In the first case, the type class is simply set as component 
             * class. In the second case, the type parameters are filled with
             * wildcards (eg: "implements List" -> "implements List<?>").
             */
            
            componentClass = (Class<?>) typeDeclaration;
            
            for (int i = 0; i < componentClass.getTypeParameters().length; i++) {
                typeParametersMap.put(
                        componentClass.getTypeParameters()[i].getName(), 
                        WildcardTypeParameter.WILDCARD);
            }
            
        }

        final TypeDef typeDef = TypeDefs.forClass(componentClass);
        
        final TypeParameter[] typeParameters = 
            new TypeParameter[typeDef.getVariables().length];
        for (int i = 0; i < typeDef.getVariables().length; i++) {
            typeParameters[i] = 
                typeParametersMap.get(typeDef.getVariables()[i].getVariableName());
        }

        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        return typeRegistry.getTypeWithoutValidation(
                componentClass, typeParameters, originalType.getArrayDimensions());
        
    }
    
    
    
    private static TypeParameter resolveEquivalentTypeParameterByDeclaration(
            final Type originalType, final java.lang.reflect.Type typeDeclaration,
            final int arrayDimensions) {
        
        if (typeDeclaration instanceof TypeVariable) {

            /*
             * The type argument is a variable, as in "List<E>"
             */
            
            final String argumentName = ((TypeVariable<?>) typeDeclaration).getName();

            // Return a type with the suitable array dimensions
            final TypeParameter typeParameter = 
                originalType.getTypeParameterForVariable(argumentName);
            
            // For returning a TypeParameter, we will have to make sure that
            // the array dimensions of the type referred by the TypeParameter
            // correspond with the dimensions we are being requested plus
            // the ones at the original type parameter. 
            
            if (typeParameter instanceof WildcardTypeParameter) {
                
                // If it is a wildcard, simply return it
                return typeParameter;
                
            } 
                
            // If it is not a wildcard, we will extract the referred
            // type and return the same type of TypeParameter, but
            // with the original arrayDimensions in the type plus
            // the dimensions we are currently using.

            if (arrayDimensions == 0) {
                return typeParameter;
            }
            
            final Type containedType = typeParameter.getType();
            final int newArrayDimensions = 
                containedType.getArrayDimensions() + arrayDimensions;

            final TypeRegistry typeRegistry = TypeRegistry.getInstance();
            
            final Type newType = 
                typeRegistry.getTypeWithoutValidation(
                        containedType.getComponentClass(), 
                        containedType.getTypeParametersArray(), 
                        newArrayDimensions);
            
            if (typeParameter instanceof StandardTypeParameter) {
                return new StandardTypeParameter(newType);
            } else if (typeParameter instanceof ExtendsTypeParameter){
                return new ExtendsTypeParameter(newType);
            } else { // typeParameter instanceof SuperTypeParameter
                return new SuperTypeParameter(newType);
            }

        } else if (typeDeclaration instanceof GenericArrayType) {

            final GenericArrayType genericArrayType = 
                (GenericArrayType) typeDeclaration;
            
            return resolveEquivalentTypeParameterByDeclaration(
                    originalType, genericArrayType.getGenericComponentType(), 
                    (arrayDimensions + 1));
            
        } else {

            /*
             * The type argument is a specific type, as in "List<String>"
             * It could be parameterized ("List<Comparable<E>>") 
             * or not ("List<String>")
             */
            
            // We should propagate the new array dimensions
            Type baseType = originalType;
            if (baseType.isArray()) {
                TypeRegistry typeRegistry = TypeRegistry.getInstance();
                baseType = 
                    typeRegistry.getType(
                        baseType.getComponentClass(),
                        baseType.getTypeParametersArray(),
                        arrayDimensions);
            }
            
            // Create the appropiate type recursively
            final Type parameterizedTypeDeclarationArgumentType = 
                resolveExtendedTypeByDeclaration(baseType, typeDeclaration);

            return new StandardTypeParameter(parameterizedTypeDeclarationArgumentType);
            
        }
        
    }
    
    
    
    static void validateTypeParameters(final Type type) {
        
        if (!isTypeParametersValid(type)) {
            
            throw new TypeValidationException(
                    type.getName() + " is not a valid type " +
                    "according to definition " + type.getTypeDef());
            
        }
        
    }

    
    
    private static boolean isTypeParametersValid(final Type type) {

        final TypeDefVariable[] typeDefVariables = type.getTypeDef().getVariables();
        final TypeParameter[] typeParameters = type.getTypeParametersArray();
        
        if (typeDefVariables.length != typeParameters.length) {
            return false;
        }

        final Map<String,TypeParameter> checkedTypeParametersByName =
            new HashMap<String, TypeParameter>();
        
        for (int i = 0; i < typeDefVariables.length; i++) {
            
            if (typeParameters[i] == null) {
                return false;
            }
            
            if (typeDefVariables[i] instanceof NamedTypeDefVariable) {

                checkedTypeParametersByName.put(
                        typeDefVariables[i].getVariableName(), 
                        typeParameters[i]);
                
            } else { // typeDefVariables[i] instanceof BoundedTypeDefVariable
                
                final BoundedTypeDefVariable boundedVar = 
                    (BoundedTypeDefVariable) typeDefVariables[i];
                
                final String variableName = boundedVar.getVariableName();
                final InnerTypeDefVariable[] innerVariables = boundedVar.getBounds();

                // A wildcard will always be checked. For the rest of types,
                // we will need to resolve
                if (!(typeParameters[i] instanceof WildcardTypeParameter)) {

                    final List<Type> extendedTypes = resolveFormalExtendedTypes(
                            checkedTypeParametersByName, variableName, 
                            typeParameters[i], innerVariables);

                    // If there was an error resolving inner types, return false
                    if (extendedTypes == null) {
                        return false;
                    }

                    for (Type extendedType : extendedTypes) {
                        if (!extendedType.isAssignableFrom(typeParameters[i].getType())) {
                            return false;
                        }
                    }
                    
                }
                
                // If we have not returned false, the type parameter can be
                // considered checked
                checkedTypeParametersByName.put(
                        typeDefVariables[i].getVariableName(), 
                        typeParameters[i]);
                    
            }
            
        }
        
        return true;
        
    }
    
    
    
    private static List<Type> resolveFormalExtendedTypes(
            final Map<String, TypeParameter> checkedTypeParametersByName,
            final String currentVariableName, final TypeParameter currentTypeParameter,
            final InnerTypeDefVariable[] innerVariables) {

        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        final List<Type> types = new LinkedList<Type>();
        for (int i = 0; i < innerVariables.length; i++) {

            
            if (innerVariables[i] instanceof InnerClassTypeDefVariable) {
                
                /*
                 * We simply get the raw type (as it is not
                 * an InnerParameterizedTypeDefVariable) and add it to the
                 * types array.
                 */
                
                final InnerClassTypeDefVariable classVariable = 
                    (InnerClassTypeDefVariable) innerVariables[i];
                final Type innerType = 
                    getRawTypeForClass(
                            classVariable.getComponentClass(), 
                            classVariable.getArrayDimensions());
                types.add(innerType);
                
            } else if (innerVariables[i] instanceof InnerNamedTypeDefVariable) {

                /*
                 * We will check the variables which already have an assigned
                 * type parameter (checkedTypeParameters).
                 */
                
                final InnerNamedTypeDefVariable innerVariable = 
                    (InnerNamedTypeDefVariable) innerVariables[i];
                
                // We check if the variable has already been defined and checked
                final TypeParameter linkedTypeParameter = 
                    checkedTypeParametersByName.get(
                            innerVariable.getVariableName());

                // If variable has not been set before, return null
                if (linkedTypeParameter == null) {
                    return null;
                }
                
                /*
                 * Basing on the linked type parameter, add the
                 * types which must conform
                 */
                if (linkedTypeParameter instanceof WildcardTypeParameter) {
                    
                    // No types to be added, any type would be valid
                    
                } else if (linkedTypeParameter instanceof StandardTypeParameter) {
                    
                    types.add(linkedTypeParameter.getType());
                    
                } else if (linkedTypeParameter instanceof ExtendsTypeParameter) {
                    
                    types.add(linkedTypeParameter.getType());
                    
                } else { // linkedTypeParameter instanceof SuperTypeParameter
                    
                    // No types to be added, any type would be valid
                    
                }
                
            } else if (innerVariables[i] instanceof InnerWildcardTypeDefVariable) {
                
                // This can never happen, as a Wildcard is not allowed here
                throw new IllegalStateException("Wildcard should not appear " +
                		"at first level of 'extends' clause in type definition");
                
            } else { // innerVariables[i] instanceof InnerParameterizedTypeTypeDefVariable 
            
                final InnerParameterizedTypeTypeDefVariable parameterizedVariable =
                    (InnerParameterizedTypeTypeDefVariable) innerVariables[i];
                
                final TypeParameter[] typeParameters =
                    resolveInnerParameterizedType(checkedTypeParametersByName,
                            currentVariableName, currentTypeParameter,
                            parameterizedVariable.getVariables());

                if (typeParameters == null) {
                    // We have tried to solve a non-existing variable
                    return null;
                }
                
                final Class<?> componentClass = 
                    parameterizedVariable.getComponentClass();
                final int arrayDimensions = parameterizedVariable.getArrayDimensions();

                final Type parameterizedType =
                    typeRegistry.getTypeWithoutValidation(
                            componentClass, typeParameters, arrayDimensions);
                
                types.add(parameterizedType);
                
            }

            
        }
        
        return types;
        
    }
    
    
    
    private static TypeParameter[] resolveInnerParameterizedType(
            final Map<String, TypeParameter> checkedTypeParametersByName,
            final String currentVariableName, final TypeParameter currentTypeParameter,
            final InnerTypeDefVariable[] innerVariables) {

        final TypeRegistry typeRegistry = TypeRegistry.getInstance();
        final TypeParameter[] typeParameters = 
            new TypeParameter[innerVariables.length];
        
        for (int i = 0; i < innerVariables.length; i++) {

            if (innerVariables[i] instanceof InnerClassTypeDefVariable) {
                
                final InnerClassTypeDefVariable classVariable = 
                    (InnerClassTypeDefVariable) innerVariables[i];
                final Type innerType = 
                    getRawTypeForClass(
                            classVariable.getComponentClass(), 
                            classVariable.getArrayDimensions());
                typeParameters[i] = new StandardTypeParameter(innerType);

            } else if (innerVariables[i] instanceof InnerNamedTypeDefVariable) {
                
                final InnerNamedTypeDefVariable innerVariable = 
                    (InnerNamedTypeDefVariable) innerVariables[i];
                
                // We check if the variable has already been defined and checked
                TypeParameter linkedTypeParameter = 
                    checkedTypeParametersByName.get(
                            innerVariable.getVariableName());

                // If variable has not been set before, check if we are
                // linking to the current variable itself. If not, return null.
                if (linkedTypeParameter == null) {
                    if (innerVariable.getVariableName().equals(currentVariableName)) {
                        linkedTypeParameter = currentTypeParameter;
                    } else {
                        return null;
                    }
                }
                
                // We need to take care of the array dimensions, and if it is
                // more than 0, no wildcard-based type parameters will be 
                // allowed

                if ((linkedTypeParameter instanceof WildcardTypeParameter) ||
                    (linkedTypeParameter instanceof ExtendsTypeParameter) ||
                    (linkedTypeParameter instanceof SuperTypeParameter)) {
                    
                    return null;
                    
                }

                // If it is allowed, compute the arrayDimensions
                final Type containedType = linkedTypeParameter.getType();
                int newArrayDimensions = 
                    containedType.getArrayDimensions() + 
                    innerVariable.getArrayDimensions();
                final Type newType = 
                    typeRegistry.getTypeWithoutValidation(
                            containedType.getComponentClass(), 
                            containedType.getTypeParametersArray(), 
                            newArrayDimensions);
                
                typeParameters[i] = new StandardTypeParameter(newType);
                
            } else if (innerVariables[i] instanceof InnerWildcardTypeDefVariable) {
                
                final InnerWildcardTypeDefVariable wildcardVariable = 
                    (InnerWildcardTypeDefVariable) innerVariables[i];

                if (wildcardVariable.isUnbound()) {
                    
                    typeParameters[i] = WildcardTypeParameter.WILDCARD;
                    
                } else {

                    /*
                     * We need to recursively obtain the inner type
                     */
                    
                    InnerTypeDefVariable bound = null;
                    if (wildcardVariable.hasUpperBound()) {
                        bound = wildcardVariable.getUpperBound();
                    } else { // wildcardVariable.hasLowerBound() == true
                        bound = wildcardVariable.getLowerBound();
                    }
                    
                    final TypeParameter[] resolvedTypeParameters = 
                        resolveInnerParameterizedType(checkedTypeParametersByName,
                                currentVariableName, currentTypeParameter,
                                new InnerTypeDefVariable[] { bound });

                    if (resolvedTypeParameters == null) {
                        return null;
                    }
                    
                    if (resolvedTypeParameters.length != 1) {
                        throw new IllegalStateException("Wildcard variable " +
                                "is supposed to have a resolvable upper bound");
                    }
                    if (!(resolvedTypeParameters[0] instanceof StandardTypeParameter)) {
                        throw new IllegalStateException("Wildcard variable " +
                                "is supposed to have a resolvable upper bound " +
                                "in the form of a Standard Type parameter");
                    }
                    
                    final Type type = 
                        ((StandardTypeParameter) resolvedTypeParameters[0]).getType();
                    
                    if (wildcardVariable.hasUpperBound()) {
                        typeParameters[i] = new ExtendsTypeParameter(type);
                    } else { // wildcardVariable.hasLowerBound() == true
                        typeParameters[i] = new SuperTypeParameter(type);
                    }
                    
                }
                
            } else { // innerVariables[i] instanceof InnerParameterizedTypeTypeDefVariable
                
                final InnerParameterizedTypeTypeDefVariable parameterizedVariable =
                    (InnerParameterizedTypeTypeDefVariable) innerVariables[i];

                final TypeParameter[] innerTypeParameters = 
                    resolveInnerParameterizedType(checkedTypeParametersByName,
                            currentVariableName, currentTypeParameter,
                            parameterizedVariable.getVariables());

                if (innerTypeParameters == null) {
                    // We have tried to solve a non-existing variable
                    return null;
                }
                
                final Class<?> componentClass = 
                    parameterizedVariable.getComponentClass();
                final int arrayDimensions = parameterizedVariable.getArrayDimensions();
                
                final Type parameterizedType =
                    typeRegistry.getTypeWithoutValidation(
                            componentClass, innerTypeParameters, arrayDimensions);
                
                typeParameters[i] = new StandardTypeParameter(parameterizedType);
                
            }
            
        }
        return typeParameters;
    }

    
    
    static boolean isAssignableFrom(final Type type, final Type fromType) {

        if (type.equals(fromType)) {
            return true;
        }
        if (type.getComponentClass().equals(Object.class) &&
            type.getArrayDimensions() <= fromType.getArrayDimensions()) {
            return true;
        }
        if (isTypeAssignableFrom(type,fromType)) {
            return true;
        }
        final Set<Type> extendedTypes = getExtendedTypes(fromType);
        for (Type extendedType : extendedTypes) {
            if (isTypeAssignableFrom(type,extendedType)) {
                return true;
            }
        }

        return false;
        
    }
    

    
    private static boolean isTypeAssignableFrom(final Type type, final Type fromType) {
        if (type.getArrayDimensions() != fromType.getArrayDimensions()) {
            return false;
        }
        if (!type.getComponentClass().isAssignableFrom(fromType.getComponentClass())) {
            return false;
        }
        if (type.getTypeParametersArray().length != fromType.getTypeParametersArray().length) {
            return false;
        }
        for (int i = 0; i < type.getTypeParametersArray().length; i++) {
            if (!type.getTypeParametersArray()[i].isAssignableFrom(fromType.getTypeParametersArray()[i])) {
                return false;
            }
        }
        return true;
    }
    
    
    
    static String createName(final Class<?> componentClass, 
            final TypeParameter[] typeParameters, final int arrayDimensions) {
        
        final StrBuilder strBuilder = new StrBuilder();
        strBuilder.append(componentClass.getName());
        if (typeParameters.length > 0) {
            strBuilder.append(TypeNaming.TYPE_NAME_PARAMETERS_START);
            strBuilder.appendWithSeparators(
                    typeParameters, TypeNaming.TYPE_NAME_PARAMETERS_SEPARATOR);
            strBuilder.append(TypeNaming.TYPE_NAME_PARAMETERS_END);
        }
        for (int i = 0; i < arrayDimensions; i++) {
            strBuilder.append(TypeNaming.TYPE_NAME_ARRAY);
        }
        return strBuilder.toString();
        
    }
    
    
    private TypeUtil() {
        super();
    }
    
}
