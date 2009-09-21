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

import java.util.concurrent.Callable;

import org.op4j.cache.SynchronizedCache;

/*
 * (non-javadoc)
 * 
 * This is the registry of type definitions, a synchronized cache which ensures
 * that only one object of each type definition exists in memory at a time.
 * 
 * This is not for saving CPU cycles (an aspect which would probably be more
 * efficient if new instances were created), but to avoid an excessive
 * memory usage under heavy processing load. 
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class TypeDefRegistry {
    
    private static final String TYPE_DEFS_BY_CLASS_REGISTRY_NAME = "TypeDefsByClass";
    
    private final SynchronizedCache<Class<?>,TypeDef> typeDefsByClass = 
        new SynchronizedCache<Class<?>, TypeDef>(
                TYPE_DEFS_BY_CLASS_REGISTRY_NAME);
    
    
    private final static TypeDefRegistry instance = new TypeDefRegistry(); 
    
    

    static TypeDefRegistry getInstance() {
        return instance;
    }
    
    
    private TypeDefRegistry() {
        super();
    }

    
    
    TypeDef forClass(final Class<?> typeClass) {

        final TypeDef typeDef = this.typeDefsByClass.get(typeClass);
        if (typeDef != null) {
            return typeDef; 
        }
        return this.typeDefsByClass.computeAndGet(
                typeClass, 
                new Callable<TypeDef>() {
                    public TypeDef call() {
                        return TypeDefUtil.forClass(typeClass);
                    }
                });
        
    }
    
}
