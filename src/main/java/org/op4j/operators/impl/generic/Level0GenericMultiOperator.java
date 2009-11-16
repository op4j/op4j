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
package org.op4j.operators.impl.generic;

import java.util.Collection;
import java.util.List;

import org.op4j.Of;
import org.op4j.exceptions.EmptyTargetException;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.GenericFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericMultiOperator<T> extends Operator
        implements ILevel0GenericMultiOperator<T>  {

    
    public Level0GenericMultiOperator(final Target target) {
        super(target);
        if (((List<?>)target.get()).size() <= 0) {
            throw new EmptyTargetException();
        }
    }


    public ILevel0GenericMultiOperator<T> add(final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiAdd(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiInsert(position, newElements)));
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiAddAll(collection)));
    }


    public ILevel0ArrayOperator<T> buildArray(final Of<T> arrayOf) {
        return new Level0ArrayOperator<T>(arrayOf, getTarget().execute(GenericFunc.multiBuildArray(arrayOf.getType())));
    }


    public ILevel0ListOperator<T> buildList() {
        return new Level0ListOperator<T>(getTarget().execute(GenericFunc.multiBuildList()));
    }


    public <K> ILevel0MapOperator<K, T> buildMap(final IEval<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(GenericFunc.multiBuildMap(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(GenericFunc.multiBuildMap(mapBuild)));
    }


    public ILevel0MapOperator<T, T> buildMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(GenericFunc.multiBuildMap()));
    }


    public <K> ILevel0MapOfArrayOperator<K, T> buildMapOfArray(final Of<T> valueArrayOf, final IEval<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperator<K, T>(valueArrayOf, getTarget().execute(GenericFunc.multiBuildMapOfArray(valueArrayOf.getType(), keyEval)));
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(final Of<V> valueArrayOf, final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperator<K, V>(valueArrayOf, getTarget().execute(GenericFunc.multiBuildMapOfArray(valueArrayOf.getType(), mapBuild)));
    }


    public ILevel0MapOfArrayOperator<T, T> buildMapOfArray(final Of<T> arrayOf) {
        return new Level0MapOfArrayOperator<T, T>(arrayOf, getTarget().execute(GenericFunc.multiBuildMapOfArray(arrayOf.getType())));
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(final IEval<K, ? super T> keyEval) {
        return new Level0MapOfListOperator<K, T>(getTarget().execute(GenericFunc.multiBuildMapOfList(keyEval)));
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(GenericFunc.multiBuildMapOfList(mapBuild)));
    }


    public ILevel0MapOfListOperator<T, T> buildMapOfList() {
        return new Level0MapOfListOperator<T, T>(getTarget().execute(GenericFunc.multiBuildMapOfList()));
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(final IEval<K, ? super T> keyEval) {
        return new Level0MapOfSetOperator<K, T>(getTarget().execute(GenericFunc.multiBuildMapOfSet(keyEval)));
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperator<K, V>(getTarget().execute(GenericFunc.multiBuildMapOfSet(mapBuild)));
    }


    public ILevel0MapOfSetOperator<T, T> buildMapOfSet() {
        return new Level0MapOfSetOperator<T, T>(getTarget().execute(GenericFunc.multiBuildMapOfSet()));
    }


    public ILevel0SetOperator<T> buildSet() {
        return new Level0SetOperator<T>(getTarget().execute(GenericFunc.multiBuildSet()));
    }


    public <X> ILevel0GenericMultiOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericMultiOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removePositions(final int... positions) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemovePositions(positions)));
    }


    public ILevel0GenericMultiOperator<T> removeValues(final T... values) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveValues(values)));
    }


    public ILevel0GenericMultiOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveMatching(expression, optionalExpParams)));
    }


    public ILevel0GenericMultiOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveSelected(selector)));
    }


    public ILevel0GenericMultiOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveAllExceptPositions(positions)));
    }


    public ILevel0GenericMultiOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveNotNullsMatching(expression, optionalExpParams)));
    }


    public ILevel0GenericMultiOperator<T> removeNulls() {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.multiRemoveNulls()));
    }







    public ILevel0GenericUniqOperator<T> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return new Level0GenericUniqOperator<T>(Target.forObject(((List<?>)getTarget()).get(0)));
    }


    public int size() {
        return ((List<?>) getTarget().get()).size();
    }


@Override
public String toString() {
    return "MULTIOP: " + getTarget().get();
}
    
    
}
