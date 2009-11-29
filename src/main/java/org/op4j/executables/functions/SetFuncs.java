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
public class SetFuncs {

    
    
    private SetFuncs() {
        super();
    }

    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends CollectionFuncs.Sort<T, Set<T>> {

        public Sort() {
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


    
    
    
    public static final class SortByComparator<T> extends CollectionFuncs.SortByComparator<T, Set<T>> {

        public SortByComparator(final Comparator<? super T> comparator) {
            super(comparator);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
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

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
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

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
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

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveIndexes<T> extends CollectionFuncs.RemoveIndexes<T, Set<T>> {

        
        public RemoveIndexes(final int... indices) {
            super(indices);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveEquals<T> extends CollectionFuncs.RemoveEquals<T, Set<T>> {

        public RemoveEquals(final T... values) {
            super(values);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveMatching<T> extends CollectionFuncs.RemoveMatching<T, Set<T>> {

        public RemoveMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveSelected<T> extends CollectionFuncs.RemoveSelected<T, Set<T>> {

        public RemoveSelected(final ISelect<T> selector) {
            super(selector);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveIndexesNot<T> extends CollectionFuncs.RemoveIndexesNot<T, Set<T>> {

        public RemoveIndexesNot(final int... indices) {
            super(indices);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    

    
    
    public static final class RemoveNulls<T> extends CollectionFuncs.RemoveNulls<T, Set<T>> {

        public RemoveNulls() {
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
    

    
    
    public static final class RemoveNotNullMatching<T> extends CollectionFuncs.RemoveNotNullMatching<T, Set<T>> {

        public RemoveNotNullMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }


    
    
    public static final class RemoveNullOrMatching<T> extends CollectionFuncs.RemoveNullOrMatching<T, Set<T>> {

        public RemoveNullOrMatching(final IEval<Boolean,? super T> eval) {
            super(eval);
        }

        public Type<? super Set<T>> getResultType() {
            return Types.SET_OF_UNKNOWN;
        }

        @Override
        Set<T> fromList(final List<T> object) {
            return new LinkedHashSet<T>(object);
        }
        
    }
    
    
    
    
    public static final class FlattenArrays<T> extends CollectionFuncs.FlattenArrays<T, Set<T>, Set<T[]>> {

        
        public FlattenArrays() {
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
    

    
    
    
    public static final class FlattenLists<T> extends CollectionFuncs.FlattenCollections<T, Set<T>, Set<List<T>>> {

        
        public FlattenLists() {
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
    

    
    
    public static final class FlattenSets<T> extends CollectionFuncs.FlattenCollections<T, Set<T>, Set<Set<T>>> {

        
        public FlattenSets() {
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