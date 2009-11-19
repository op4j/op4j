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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.op4j.executables.functions.IFunc;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
class ToCollection {
    
    
    private ToCollection() {
        super();
    }
    

    
    
    
    static abstract class FromArray<T, X extends Collection<T>> implements IFunc<X, T[]> {

        public FromArray() {
            super();
        }

        public X execute(final T[] object) throws Exception {
            return fromList(new ArrayList<T>(Arrays.asList(object)));
        }
        
        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class FromList<T, X extends Collection<T>> implements IFunc<X, List<T>> {

        public FromList() {
            super();
        }

        public X execute(final List<T> object) throws Exception {
            return fromList(new ArrayList<T>(object));
        }
        
        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class FromSet<T, X extends Collection<T>> implements IFunc<X, Set<T>> {

        public FromSet() {
            super();
        }

        public X execute(final Set<T> object) throws Exception {
            return fromList(new ArrayList<T>(object));
        }
        
        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class FromObject<T, X extends Collection<T>> implements IFunc<X, T> {

        public FromObject() {
            super();
        }

        public X execute(final T object) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            return fromList(result);
        }
        
        abstract X fromList(final List<T> object);
        
    }
    
}
