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

package org.op4j.executables.functions.conversion;

import java.util.LinkedHashSet;
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
public class ToSet {

    
    private ToSet() {
        super();
    }
    
    
    
    
    
    public static final class FromArray<T> extends ToCollection.FromArray<T,Set<T>> {

        public FromArray() {
            super();
        }
        
        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }

    
    
    
    
    
    public static final class FromList<T> extends ToCollection.FromList<T,Set<T>> {

        public FromList() {
            super();
        }
        
        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }

    
    
    
    
    
    public static final class FromObject<T> extends ToCollection.FromObject<T,Set<T>> {

        public FromObject() {
            super();
        }
        
        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
}
