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

package org.op4j.functions.structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.AbstractNotNullFunction;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FArrayOfArray<T> extends FArray<T[]> {

    
    
    
    public FlattenArrays<T> flattenArrays() {
        return new FlattenArrays<T>(Types.arrayComponentOf(this.type));
    }
    
    

    
    
    protected FArrayOfArray(final Type<T> type) {
        super(Types.arrayOf(type));
    }
    
    
    
    
    
    public static final class FlattenArrays<T> extends AbstractNotNullFunction<T[][],T[]> {

        private final Type<T> type; 
        
        public FlattenArrays(final Type<T> type) {
            super();
            Validate.notNull(type, "A type representing the array elements must be specified");
            this.type = type;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T[] notNullExecute(final T[][] object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final T[] element : object) {
                result.addAll(Arrays.asList(element));
            }
            final T[] array = (T[]) Array.newInstance(this.type.getRawClass(), result.size());
            return result.toArray(array);
            
        }

    }
    

    
    
    
    
}
