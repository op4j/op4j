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

package org.op4j.functions;

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnListOfSetOf<T> extends FnListOf<Set<T>> {

    
    
    
    public IFunction<List<Set<T>>,List<T>> flattenSets() {
        return new FlattenSets<T>();
    }
    
    

    
    
    protected FnListOfSetOf(final Type<T> type) {
        super(Types.setOf(type));
    }
    
    
    
    
    
    static final class FlattenSets<T> extends FnCollection.FlattenCollectionOfCollections<T, List<T>, List<Set<T>>> {

        
        FlattenSets() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
}
