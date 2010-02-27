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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
class FnCollection {

    
    
    
    private FnCollection() {
        super();
    }

    
    
    
    
    static abstract class Sort<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        Sort() {
            super();
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            return doSort(object, ctx);
        }

        @SuppressWarnings("unchecked")
        private X doSort(final X object, final ExecCtx ctx) throws Exception {

            final List<?> list = new ArrayList<Object>(object);
            Collections.sort((List<Comparable>)list);
            return fromList((List<T>)(List<?>)list);
            
        }

        abstract X fromList(final List<T> object);

    }

    
    
    static abstract class SortByComparator<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private Comparator<? super T> comparator = null;

        SortByComparator(final Comparator<? super T> comparator) {
            super();
            Validate.notNull(comparator, "A comparator must be specified");
            this.comparator = comparator;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
        	
            final List<T> result = new ArrayList<T>(object);
            Collections.sort(result, this.comparator);
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }
    
    

    
    static abstract class Add<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final List<T> newElements;
        
        Add(final T... newElements) {
            super();
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    
    static abstract class Insert<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final int position;
        private final List<T> newElements;
        
        Insert(final int position, final T... newElements) {
            super();
            this.position = position;
            this.newElements = VarArgsUtil.asRequiredObjectList(newElements);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.position, this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }


    
    
    
    static abstract class AddAll<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final List<T> newElements;
        
        AddAll(final Collection<T> collection) {
            super();
            Validate.notNull(collection, "A collection must be specified");
            this.newElements = new ArrayList<T>(collection);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.addAll(this.newElements);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveAllIndexes<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final List<Integer> indexes;
        
        RemoveAllIndexes(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (!this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveAllEqual<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final List<T> values;
        
        RemoveAllEqual(final T... values) {
            super();
            this.values = VarArgsUtil.asRequiredObjectList(values);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>(object);
            result.removeAll(this.values);
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    static abstract class RemoveAllTrue<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (!this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    

    
    
    static abstract class RemoveAllFalse<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (this.eval.execute(element, ctx).booleanValue()) {
                    result.add(element);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    
    

    
    
    static abstract class RemoveAllIndexesNot<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final List<Integer> indexes;
        
        RemoveAllIndexesNot(final int... indexes) {
            super();
            this.indexes = VarArgsUtil.asRequiredIntegerList(indexes);
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            int i = 0;
            for (final T element : object) {
                if (this.indexes.contains(Integer.valueOf(i))) {
                    result.add(element);
                }
                i++;
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    

    
    
    static abstract class RemoveAllNull<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        RemoveAllNull() {
            super();
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
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
    

    

    
    
    static abstract class RemoveAllNotNullAndTrue<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(null);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    
    

    
    

    
    
    static abstract class RemoveAllNotNullAndFalse<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                } else {
                    result.add(null);
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }
    

    
    

    
    static abstract class RemoveAllNullOrTrue<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (!this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    


    

    
    static abstract class RemoveAllNullOrFalse<T, X extends Collection<T>> extends AbstractNotNullNonConvertingFunc<X> {

        private final IFunction<? super T,Boolean> eval;
        
        RemoveAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
            super();
            Validate.notNull(eval, "An evaluator must be specified");
            this.eval = eval;
        }

        @Override
        protected X notNullExecute(final X object, final ExecCtx ctx) throws Exception {
            final List<T> result = new ArrayList<T>();
            for (final T element : object) {
                if (element != null) {
                    if (this.eval.execute(element, ctx).booleanValue()) {
                        result.add(element);
                    }
                }
            }
            return fromList(result);
        }

        abstract X fromList(final List<T> object);
        
    }

    
    
    
    
    static abstract class FlattenCollectionOfArrays<T, X extends Collection<T>, Y extends Collection<T[]>> extends AbstractNotNullFunction<Y,X> {

        FlattenCollectionOfArrays() {
            super();
        }

        @Override
        protected X notNullExecute(final Y object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final T[] element : object) {
                result.addAll(Arrays.asList(element));
            }
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }
    

    
    static abstract class FlattenCollectionOfCollections<T, X extends Collection<T>, Y extends Collection<? extends Collection<T>>> extends AbstractNotNullFunction<Y,X> {

        FlattenCollectionOfCollections() {
            super();
        }

        @Override
        protected X notNullExecute(final Y object, final ExecCtx ctx) throws Exception {
            
            final List<T> result = new ArrayList<T>();
            for (final Collection<T> element : object) {
                result.addAll(element);
            }
            return fromList(result);
            
        }

        abstract X fromList(final List<T> object);

    }

    
    
    
    
}
