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
package org.op4j.typedef;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import org.apache.commons.lang.ArrayUtils;

/*
 * (non-javadoc)
 * 
 * This class contains internal algorithms for TypeDef processing and
 * handling.
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeDefUtil {

    
    private static final Type[] OBJECT_BOUNDS = new Type[] { Object.class };
   
    
    static TypeDef forClass(final Class<?> typeClass) {
        
        if (typeClass.isArray()) {
            throw new IllegalArgumentException("Cannot create TypeDef from array class");
        }

        final TypeVariable<?>[] typeVariables = typeClass.getTypeParameters();
        final TypeDefVariable[] typeDefVariables = 
            new TypeDefVariable[typeVariables.length];
        
        for (int i = 0; i < typeVariables.length; i++) {
            
            final String variableName = typeVariables[i].getName();
            final Type[] bounds = typeVariables[i].getBounds();
            
            if (ArrayUtils.isEquals(OBJECT_BOUNDS, bounds)) {
                typeDefVariables[i] = new NamedTypeDefVariable(variableName);
            } else {
                final InnerTypeDefVariable[] innerVariables =
                    new InnerTypeDefVariable[bounds.length];
                for (int j = 0; j < bounds.length; j++) {
                    innerVariables[j] = getInnerTypeDefDeclaration(bounds[j], 0);
                }
                typeDefVariables[i] = 
                    new BoundedTypeDefVariable(variableName,innerVariables);
            }
            
        }
        
        return new TypeDef(typeClass, typeDefVariables);

    }
    
    
    
    private static InnerTypeDefVariable getInnerTypeDefDeclaration(
            final Type typeDeclaration, final int arrayDimensions) {

        if (typeDeclaration instanceof ParameterizedType) {

            final ParameterizedType parameterizedType = 
                (ParameterizedType) typeDeclaration;
            final Class<?> typeClass = (Class<?>) parameterizedType.getRawType();
            
            final Type[] typeArguments = parameterizedType.getActualTypeArguments();
            final InnerTypeDefVariable[] innerVariables = 
                new InnerTypeDefVariable[typeArguments.length];
            for (int i = 0; i < typeArguments.length; i++) {
                innerVariables[i] = 
                    getInnerTypeDefDeclaration(typeArguments[i], 0);
            }
            return new InnerParameterizedTypeTypeDefVariable(
                    typeClass, innerVariables, arrayDimensions);
            
        } else if (typeDeclaration instanceof TypeVariable<?>) {

            return new InnerNamedTypeDefVariable(
                    ((TypeVariable<?>) typeDeclaration).getName(),
                    arrayDimensions);
            
        } else if (typeDeclaration instanceof GenericArrayType) {
            
            return getInnerTypeDefDeclaration(
                    ((GenericArrayType) typeDeclaration).getGenericComponentType(), 
                    (arrayDimensions + 1));
            
        } else if (typeDeclaration instanceof WildcardType) {

            final WildcardType wildcardType = (WildcardType) typeDeclaration;
            if (!ArrayUtils.isEquals(OBJECT_BOUNDS, wildcardType.getUpperBounds())) {
                
                final InnerTypeDefVariable upperBound = 
                        getInnerTypeDefDeclaration(
                                wildcardType.getUpperBounds()[0], 0);
                return new InnerWildcardTypeDefVariable(upperBound, null);
                
            } else if (!ArrayUtils.isEquals(OBJECT_BOUNDS, wildcardType.getLowerBounds())) {
                
                final InnerTypeDefVariable lowerBound = 
                        getInnerTypeDefDeclaration(
                                wildcardType.getLowerBounds()[0], 0);
                return new InnerWildcardTypeDefVariable(null, lowerBound);
                
            } else {
                
                return new InnerWildcardTypeDefVariable(null, null);
                
            }
            
        } else {

            return new InnerClassTypeDefVariable(
                    (Class<?>) typeDeclaration, arrayDimensions);
            
        }
        
        
    }

    
    
    private TypeDefUtil() {
        super();
    }

    
}
