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
package org.op4j.typescheme;

import java.util.concurrent.Callable;

import org.op4j.cache.SynchronizedCache;

/* 
 * (non-javadoc)
 * 
 * This is the registry of type schemes, a synchronized cache which ensures
 * that only one object of each type scheme exists in memory at a time.
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
final class TypeSchemeRegistry {
    
    private static final String TYPE_SCHEMES_BY_CANONICAL_NAME = "TypeSchemesByCanonicalName";
    private static final String TYPE_SCHEMES_BY_POSSIBLE_NAMES = "TypeSchemesByPossibleNames";
    
    protected final SynchronizedCache<String,TypeScheme> typeSchemesByCanonicalName = 
            new SynchronizedCache<String, TypeScheme>(TYPE_SCHEMES_BY_CANONICAL_NAME);
    
    protected final SynchronizedCache<String,TypeScheme> typeSchemesByPossibleNames = 
            new SynchronizedCache<String, TypeScheme>(TYPE_SCHEMES_BY_POSSIBLE_NAMES);
    
    
    private final static TypeSchemeRegistry instance = new TypeSchemeRegistry(); 
    
    

    static TypeSchemeRegistry getInstance() {
        return instance;
    }
    
    
    private TypeSchemeRegistry() {
        super();
    }

    
    TypeScheme forCanonicalName(final String typeSchemeCanonicalName) {
        
        final TypeScheme typeScheme = this.typeSchemesByCanonicalName.get(typeSchemeCanonicalName);
        if (typeScheme != null) {
            return typeScheme; 
        }
        return this.typeSchemesByCanonicalName.computeAndGet(
                typeSchemeCanonicalName, 
                new Callable<TypeScheme>() {
                    public TypeScheme call() {
                        return TypeSchemeUtil.forName(typeSchemeCanonicalName, true);
                    }
                });
        
    }

    
    TypeScheme forName(final String typeSchemeName) {
        
        final TypeScheme typeScheme = this.typeSchemesByPossibleNames.get(typeSchemeName);
        if (typeScheme != null) {
            return typeScheme; 
        }
        return this.typeSchemesByPossibleNames.computeAndGet(
                typeSchemeName, 
                new Callable<TypeScheme>() {
                    public TypeScheme call() {
                        return TypeSchemeUtil.forName(typeSchemeName, false);
                    }
                });
        
    }

    
    TypeScheme forComponents(final TypeSchemeComponent[] typeSchemeComponents) {
        return forCanonicalName(TypeSchemeUtil.createName(typeSchemeComponents));
    }
    
}
