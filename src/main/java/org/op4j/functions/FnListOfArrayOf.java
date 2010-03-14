/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnListOfArrayOf<T> extends FnListOf<T[]> {

    
    
    
    public final Function<List<T[]>,List<T>> flattenArrays() {
        return new FlattenArrays<T>();
    }
    
    

    
    
    protected FnListOfArrayOf(final Type<T> type) {
        super(Types.arrayOf(type));
    }
    
    
    
    
    
    static final class FlattenArrays<T> extends FnCollection.FlattenCollectionOfArrays<T, List<T>, List<T[]>> {

        
        FlattenArrays() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
}
