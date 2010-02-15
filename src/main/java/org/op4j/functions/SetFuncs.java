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

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class SetFuncs {

    
    
    private SetFuncs() {
        super();
    }

    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends CollectionFuncs.Sort<T, Set<T>> {

        public Sort() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }


    
    
    
    public static final class SortByComparator<T> extends CollectionFuncs.SortByComparator<T, Set<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }

    }
    
    
    
    
    public static final class Add<T> extends CollectionFuncs.Add<T, Set<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends CollectionFuncs.Insert<T, Set<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends CollectionFuncs.AddAll<T, Set<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllIndexes<T> extends CollectionFuncs.RemoveAllIndexes<T, Set<T>> {

        
        public RemoveAllIndexes(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllEqual<T> extends CollectionFuncs.RemoveAllEqual<T, Set<T>> {

        public RemoveAllEqual(final T... values) {
            super(values);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllTrue<T> extends CollectionFuncs.RemoveAllTrue<T, Set<T>> {

        public RemoveAllTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllFalse<T> extends CollectionFuncs.RemoveAllTrue<T, Set<T>> {

        public RemoveAllFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllIndexesNot<T> extends CollectionFuncs.RemoveAllIndexesNot<T, Set<T>> {

        public RemoveAllIndexesNot(final int... indexes) {
            super(indexes);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNull<T> extends CollectionFuncs.RemoveAllNull<T, Set<T>> {

        public RemoveAllNull() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndTrue<T> extends CollectionFuncs.RemoveAllNotNullAndTrue<T, Set<T>> {

        public RemoveAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveAllNotNullAndFalse<T> extends CollectionFuncs.RemoveAllNotNullAndTrue<T, Set<T>> {

        public RemoveAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    public static final class RemoveAllNullOrTrue<T> extends CollectionFuncs.RemoveAllNullOrTrue<T, Set<T>> {

        public RemoveAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    public static final class RemoveAllNullOrFalse<T> extends CollectionFuncs.RemoveAllNullOrTrue<T, Set<T>> {

        public RemoveAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
            super(eval);
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    public static final class FlattenSetOfArrays<T> extends CollectionFuncs.FlattenCollectionOfArrays<T, Set<T>, Set<T[]>> {

        
        public FlattenSetOfArrays() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    
    public static final class FlattenSetOfLists<T> extends CollectionFuncs.FlattenCollectionOfCollections<T, Set<T>, Set<List<T>>> {

        
        public FlattenSetOfLists() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class FlattenSetOfSets<T> extends CollectionFuncs.FlattenCollectionOfCollections<T, Set<T>, Set<Set<T>>> {

        
        public FlattenSetOfSets() {
            super();
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
}
