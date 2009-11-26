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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
class CollectionFunc {

    
    
    
    private CollectionFunc() {
        super();
    }

    
    
    
    
    static abstract class Sort<T extends Comparable<? super T>, X extends Collection<T>> implements IFunc<X, X> {

        public Sort() {
            super();
        }

        public X execute(final X object) throws Exception {
        	
            final List<T> result = new ArrayList<T>(object);
            Collections.sort(result);
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }

    
    
    static abstract class SortByComparator<T, X extends Collection<T>> implements IFunc<X, X> {

        private Comparator<? super T> comparator = null;

        public SortByComparator(final Comparator<? super T> comparator) {
            super();
            this.comparator = comparator;
        }

        public X execute(final X object) throws Exception {
        	
            final List<T> result = new ArrayList<T>(object);
            Collections.sort(result, this.comparator);
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }
    
    

    
    static abstract class Add<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> newElements;
        
        public Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    
    static abstract class Insert<T, X extends Collection<T>> implements IFunc<X,X> {

        private final int position;
        private final List<T> newElements;
        
        public Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.position, this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }


    
    
    
    static abstract class AddAll<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> newElements;
        
        public AddAll(final Collection<T> collection) {
            super();
            this.newElements = new ArrayList<T>(collection);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveIndexes<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<Integer> indices;
        
        public RemoveIndexes(final int... indices) {
            super();
            this.indices = VarArgsUtil.asRequiredIntegerList(indices);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.indices.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveEquals<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<T> values;
        
        public RemoveEquals(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.removeAll(this.values);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveMatching<T, X extends Collection<T>> implements IFunc<X,X> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveMatching(final IEval<Boolean,? super T> eval) {
            super();
            this.eval = eval;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element).booleanValue()) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveSelected<T, X extends Collection<T>> implements IFunc<X,X> {

        private final ISelect<T> selector;
        
        public RemoveSelected(final ISelect<T> selector) {
            super();
            this.selector = selector;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.selector.eval(element)) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class RemoveIndexesNot<T, X extends Collection<T>> implements IFunc<X,X> {

        private final List<Integer> indices;
        
        public RemoveIndexesNot(final int... indices) {
            super();
            this.indices = VarArgsUtil.asRequiredIntegerList(indices);
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.indices.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    

    
    
    static abstract class RemoveNulls<T, X extends Collection<T>> implements IFunc<X,X> {

        public RemoveNulls() {
            super();
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    

    

    
    
    static abstract class RemoveNotNullMatching<T, X extends Collection<T>> implements IFunc<X,X> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveNotNullMatching(final IEval<Boolean,? super T> eval) {
            super();
            this.eval = eval;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class RemoveNullOrMatching<T, X extends Collection<T>> implements IFunc<X,X> {

        private final IEval<Boolean,? super T> eval;
        
        public RemoveNullOrMatching(final IEval<Boolean,? super T> eval) {
            super();
            this.eval = eval;
        }

        public X execute(final X object) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    

    
    
    static abstract class FlattenArrays<T, X extends Collection<T>, Y extends Collection<T[]>> implements IFunc<X, Y> {

        public FlattenArrays() {
            super();
        }

        public X execute(final Y object) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final T[] element : object) {
                result.addAll(Arrays.asList(element));
            }
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }
    

    
    static abstract class FlattenCollections<T, X extends Collection<T>, Y extends Collection<? extends Collection<T>>> implements IFunc<X, Y> {

        public FlattenCollections() {
            super();
        }

        public X execute(final Y object) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final Collection<T> element : object) {
                result.addAll(element);
            }
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }

    
    
    
    
}
