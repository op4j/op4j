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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.evaluators.IEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class ListFuncs {
    
    
    
    private ListFuncs() {
        super();
    }

    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends CollectionFuncs.Sort<T, List<T>> {

        public Sort() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }


    
    
    public static final class SortByComparator<T> extends CollectionFuncs.SortByComparator<T, List<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }
    
    
    
    
    public static final class Distinct<T> extends AbstractNotNullNonConvertingFunc<List<T>> {

        public Distinct() {
            super();
        }

        @Override
        public List<T> notNullExecute(final List<T> object, final ExecCtx ctx) throws Exception {
            return new ArrayList<T>(new LinkedHashSet<T>(object));
        }

    }

    
    
    
    
    public static final class Add<T> extends CollectionFuncs.Add<T, List<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends CollectionFuncs.Insert<T, List<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends CollectionFuncs.AddAll<T, List<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllIndexes<T> extends CollectionFuncs.RemoveAllIndexes<T, List<T>> {

        
        public RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllEqual<T> extends CollectionFuncs.RemoveAllEqual<T, List<T>> {

        public RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllTrue<T> extends CollectionFuncs.RemoveAllTrue<T, List<T>> {

        public RemoveAllTrue(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllFalse<T> extends CollectionFuncs.RemoveAllTrue<T, List<T>> {

        public RemoveAllFalse(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllIndexesNot<T> extends CollectionFuncs.RemoveAllIndexesNot<T, List<T>> {

        public RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNull<T> extends CollectionFuncs.RemoveAllNull<T, List<T>> {

        public RemoveAllNull() {
            super();
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends CollectionFuncs.RemoveAllNotNullAndTrue<T, List<T>> {

        public RemoveAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends CollectionFuncs.RemoveAllNotNullAndTrue<T, List<T>> {

        public RemoveAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    public static final class RemoveAllNullOrTrue<T> extends CollectionFuncs.RemoveAllNullOrTrue<T, List<T>> {

        public RemoveAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    public static final class RemoveAllNullOrFalse<T> extends CollectionFuncs.RemoveAllNullOrTrue<T, List<T>> {

        public RemoveAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    public static final class FlattenListOfArrays<T> extends CollectionFuncs.FlattenCollectionOfArrays<T, List<T>, List<T[]>> {

        
        public FlattenListOfArrays() {
            super();
        }

        @SuppressWarnings("unchecked")
        public Type<? extends List<T>> getResultType(final Type<? extends List<T[]>> targetType) {
            return Types.listOf(Types.arrayComponentOf(Types.listComponentOf((Type<List<T[]>>)targetType)));
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class FlattenListOfLists<T> extends CollectionFuncs.FlattenCollectionOfCollections<T, List<T>, List<List<T>>> {

        
        public FlattenListOfLists() {
            super();
        }

        @SuppressWarnings("unchecked")
        public Type<? extends List<T>> getResultType(final Type<? extends List<List<T>>> targetType) {
            return Types.listOf(Types.listComponentOf(Types.listComponentOf((Type<List<List<T>>>)targetType)));
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class FlattenListOfSets<T> extends CollectionFuncs.FlattenCollectionOfCollections<T, List<T>, List<Set<T>>> {

        
        public FlattenListOfSets() {
            super();
        }

        @SuppressWarnings("unchecked")
        public Type<? extends List<T>> getResultType(final Type<? extends List<Set<T>>> targetType) {
            return Types.listOf(Types.setComponentOf(Types.listComponentOf((Type<List<Set<T>>>)targetType)));
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
}
