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

import java.util.Set;
import java.util.concurrent.Callable;

import org.op4j.cache.SynchronizedCache;

/*
 * (non-javadoc)
 * 
 * This is the registry of types, a synchronized cache which ensures
 * that only one object of each type exists in memory at a time.
 * 
 * This is not for saving CPU cycles (an aspect which would probably be more
 * efficient if new instances were created), but to avoid an excessive
 * memory usage under heavy processing load. 
 * 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeRegistry {
    
    private static final String TYPES_REGISTRY_NAME = "Types";
    private static final String TYPES_BY_NAME_REGISTRY_NAME = "TypesByName";
    private static final String RAW_TYPES_BY_CLASS_REGISTRY_NAME = "RawTypesByClass";
    private static final String EXTENDED_TYPES_BY_TYPE_REGISTRY_NAME = "ExtendedTypesByType";
    private static final String TYPE_ASSIGNABILITIES_REGISTRY_NAME = "TypeAssignabilities";

    
    private final SynchronizedCache<String,Type> types = 
        new SynchronizedCache<String,Type>(TYPES_REGISTRY_NAME);
    private final SynchronizedCache<String,Type> typesByPossibleNames = 
        new SynchronizedCache<String, Type>(TYPES_BY_NAME_REGISTRY_NAME);
    private final SynchronizedCache<Class<?>,Type> rawTypesByClass = 
        new SynchronizedCache<Class<?>,Type>(RAW_TYPES_BY_CLASS_REGISTRY_NAME);
    private final SynchronizedCache<Type,Set<Type>> extendedTypesByType = 
        new SynchronizedCache<Type, Set<Type>>(EXTENDED_TYPES_BY_TYPE_REGISTRY_NAME);
    protected final SynchronizedCache<TypeAssignation, Boolean> typeAssignabilities = 
        new SynchronizedCache<TypeAssignation, Boolean>(TYPE_ASSIGNABILITIES_REGISTRY_NAME);
    
    
    private static final TypeRegistry instance = new TypeRegistry(); 
    
    

    static TypeRegistry getInstance() {
        return instance;
    }
    
    
    private TypeRegistry() {
        super();
    }
    
    

    Type forName(final String typeName) {

        final Type type = this.typesByPossibleNames.get(typeName);
        if (type != null) {
            return type; 
        }
        return this.typesByPossibleNames.computeAndGet(
                typeName, 
                new Callable<Type>() {
                    public Type call() {
                        return TypeUtil.forName(typeName);
                    }
                });
        
    }

    
    
    Type getRawTypeForClass(final Class<?> typeClass) {
        
        final Type type = this.rawTypesByClass.get(typeClass);
        if (type != null) {
            return type; 
        }
        return this.rawTypesByClass.computeAndGet(
                typeClass, 
                new Callable<Type>() {
                    public Type call() {
                        return TypeUtil.getRawTypeForClass(typeClass);
                    }
                });
        
    }
    
    
    
    
    Type getType(final Class<?> componentClass, 
            final TypeParameter[] typeParameters, final int arrayDimensions) {

        final String identifier = 
            TypeUtil.createName(componentClass, typeParameters, arrayDimensions);
        final Type type = this.types.get(identifier);
        if (type != null) {
            return type; 
        }
        return this.types.computeAndGet(
                identifier, 
                new Callable<Type>() {
                    public Type call() {
                        return Type.createType(componentClass, typeParameters, arrayDimensions);
                    }
                });
        
    }

    

    
    Type getTypeWithoutValidation(final Class<?> componentClass, 
            final TypeParameter[] typeParameters, final int arrayDimensions) {

        final String identifier = 
            TypeUtil.createName(componentClass, typeParameters, arrayDimensions);
        final Type type = this.types.get(identifier);
        if (type != null) {
            return type; 
        }
        return Type.createTypeWithoutValidation(componentClass, typeParameters, arrayDimensions);
        
    }
    
    
    
    
    Set<Type> getExtendedTypes(final Type type) {
        
        final Set<Type> extendedTypes = this.extendedTypesByType.get(type);
        if (extendedTypes != null) {
            return extendedTypes; 
        }
        return this.extendedTypesByType.computeAndGet(
                type, 
                new Callable<Set<Type>>() {
                    public Set<Type> call() {
                        return TypeUtil.getExtendedTypes(type);
                    }
                });
        
    }

    
    
    boolean isAssignableFrom(final Type type, final Type fromType) {

        final TypeAssignation assignation = new TypeAssignation(type, fromType);
        final Boolean assignable = this.typeAssignabilities.get(assignation);
        if (assignable != null) {
            return assignable.booleanValue(); 
        }
        return this.typeAssignabilities.computeAndGet(
                assignation, 
                new Callable<Boolean>() {
                    public Boolean call() {
                        return Boolean.valueOf(TypeUtil.isAssignableFrom(type, fromType));
                    }
                }).booleanValue();
        
    }
    
    
}
