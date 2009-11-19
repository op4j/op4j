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
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;

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

    
    
    
    public static final class Sort<T extends Comparable<? super T>> extends StructureFunc.Sort<T, List<T>> {

        public Sort() {
            super();
        }

        public Sort(final Comparator<T> comparator) {
            super(comparator);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
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

    
    
    
    
    public static final class Add<T> extends StructureFunc.Add<T, List<T>> {

        public Add(final T... newElements) {
            super(newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    
    public static final class Insert<T> extends StructureFunc.Insert<T, List<T>> {

        public Insert(final int position, T... newElements) {
            super(position, newElements);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
    
    
    public static final class AddAll<T> extends StructureFunc.AddAll<T, List<T>> {

        public AddAll(final Collection<T> collection) {
            super(collection);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemovePositions<T> extends StructureFunc.RemovePositions<T, List<T>> {

        
        public RemovePositions(final int... positions) {
            super(positions);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveValues<T> extends StructureFunc.RemoveValues<T, List<T>> {

        public RemoveValues(final T... values) {
            super(values);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveMatching<T> extends StructureFunc.RemoveMatching<T, List<T>> {

        public RemoveMatching(final String expression, final Object... optionalExpParams) {
            super(expression, optionalExpParams);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveSelected<T> extends StructureFunc.RemoveSelected<T, List<T>> {

        public RemoveSelected(final ISelect<T> selector) {
            super(selector);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveAllExceptPositions<T> extends StructureFunc.RemoveAllExceptPositions<T, List<T>> {

        public RemoveAllExceptPositions(final int... positions) {
            super(positions);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveNulls<T> extends StructureFunc.RemoveNulls<T, List<T>> {

        public RemoveNulls() {
            super();
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    

    
    
    public static final class RemoveNotNullsMatching<T> extends StructureFunc.RemoveNotNullsMatching<T, List<T>> {

        public RemoveNotNullsMatching(final String expression, final Object... optionalExpParams) {
            super(expression, optionalExpParams);
        }

        public Type<? super List<T>> getResultType() {
            return Types.LIST_OF_UNKNOWN;
        }

        @Override
        public List<T> fromList(final List<T> object) {
            return object;
        }
        
    }
    
    
    
}
