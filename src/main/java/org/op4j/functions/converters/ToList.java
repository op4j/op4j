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

package org.op4j.functions.converters;

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
public class ToList {

    
    private ToList() {
        super();
    }
    
    
    
    
    
    public static final class FromArray<T> extends ToCollection.FromArray<T,List<T>> {

        public FromArray() {
            super();
        }
        
        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    public static final class FromCollection<T> extends ToCollection.FromCollection<T,List<T>> {

        public FromCollection() {
            super();
        }
        
        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    public static final class FromObject<T> extends ToCollection.FromObject<T,List<T>> {

        public FromObject() {
            super();
        }
        
        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
 
    
    
}
