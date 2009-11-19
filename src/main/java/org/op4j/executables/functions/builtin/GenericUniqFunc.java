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

package org.op4j.executables.functions.builtin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class GenericUniqFunc {

    
    
    
    private GenericUniqFunc() {
        super();
    }

    
    
    
    
    public static final class Add<T> implements IFunc<List<T>,T> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        public List<T> execute(final T object) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            result.addAll(this.newElements);
            return result;
        }
        
    }

    
    
    public static final class Insert<T> implements IFunc<List<T>,T> {

        private final int position;
        private final List<T> newElements;
        
        public Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        public List<T> execute(final T object) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            result.addAll(this.position, this.newElements);
            return result;
        }
        
    }


    
    
    
    public static final class AddAll<T> implements IFunc<List<T>,T> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            this.newElements = new ArrayList<T>(collection);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        public List<T> execute(final T object) throws Exception {
            final List<T> result = new ArrayList<T>();
            result.add(object);
            result.addAll(this.newElements);
            return result;
        }
        
    }
    
    
}
