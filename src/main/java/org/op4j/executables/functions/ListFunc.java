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

package org.op4j.executables.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.IEval;
import org.op4j.executables.ISelect;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class ListFunc {
    
    
    
    private ListFunc() {
        super();
    }

    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends CollectionFunc.Sort<T, List<T>> {

        public Sort() {
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


    
    
    public static final class SortByComparator<T> extends CollectionFunc.SortByComparator<T, List<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }

    }
    
    
    
    
    public static final class Distinct<T> implements IFunc<List<T>, List<T>> {

        public Distinct() {
            super();
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        public List<T> execute(final List<T> object) throws Exception {
            return new ArrayList<T>(new LinkedHashSet<T>(object));
        }

    }

    
    
    
    
    public static final class Add<T> extends CollectionFunc.Add<T, List<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends CollectionFunc.Insert<T, List<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends CollectionFunc.AddAll<T, List<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveIndexes<T> extends CollectionFunc.RemoveIndexes<T, List<T>> {

        
        public RemoveIndexes(final int... indices) {
            super(indices);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveEquals<T> extends CollectionFunc.RemoveEquals<T, List<T>> {

        public RemoveEquals(final T... values) {
            super(values);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveMatching<T> extends CollectionFunc.RemoveMatching<T, List<T>> {

        public RemoveMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveSelected<T> extends CollectionFunc.RemoveSelected<T, List<T>> {

        public RemoveSelected(final ISelect<T> selector) {
            super(selector);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveIndexesNot<T> extends CollectionFunc.RemoveIndexesNot<T, List<T>> {

        public RemoveIndexesNot(final int... indices) {
            super(indices);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveNulls<T> extends CollectionFunc.RemoveNulls<T, List<T>> {

        public RemoveNulls() {
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
    

    
    
    public static final class RemoveNotNullMatching<T> extends CollectionFunc.RemoveNotNullMatching<T, List<T>> {

        public RemoveNotNullMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    public static final class RemoveNullOrMatching<T> extends CollectionFunc.RemoveNullOrMatching<T, List<T>> {

        public RemoveNullOrMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    public static final class FlattenArrays<T> extends CollectionFunc.FlattenArrays<T, List<T>, List<T[]>> {

        
        public FlattenArrays() {
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
    

    
    
    public static final class FlattenLists<T> extends CollectionFunc.FlattenCollections<T, List<T>, List<List<T>>> {

        
        public FlattenLists() {
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
    

    
    
    public static final class FlattenSets<T> extends CollectionFunc.FlattenCollections<T, List<T>, List<Set<T>>> {

        
        public FlattenSets() {
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
