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

import org.javaruntype.type.Type;
import org.op4j.exceptions.EmptyTargetException;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToMapOfArray;
import org.op4j.executables.functions.conversion.ToMapOfList;
import org.op4j.executables.functions.conversion.ToMapOfSet;
import org.op4j.executables.functions.conversion.ToSet;
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
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.Add<T>(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.Insert<T>(position, newElements)));
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.AddAll<T>(collection)));
    }


    public ILevel0ArrayOperator<T> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperator<T>(arrayOf, getTarget().execute(new ToArray.FromCollection<T>(arrayOf)));
    }


    public ILevel0ListOperator<T> buildList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public <K> ILevel0MapOperator<K, T> buildMap(final IEval<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOperator<T, T> buildMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> ILevel0MapOfArrayOperator<K, T> buildMapOfArray(final Type<T> valueArrayOf, final IEval<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperator<K, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperator<K, V>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public ILevel0MapOfArrayOperator<T, T> buildMapOfArray(final Type<T> valueArrayOf) {
        return new Level0MapOfArrayOperator<T, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByAlternateElements<T>(valueArrayOf)));
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(final IEval<K, ? super T> keyEval) {
        return new Level0MapOfListOperator<K, T>(getTarget().execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOfListOperator<T, T> buildMapOfList() {
        return new Level0MapOfListOperator<T, T>(getTarget().execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(final IEval<K, ? super T> keyEval) {
        return new Level0MapOfSetOperator<K, T>(getTarget().execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuild<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperator<K, V>(getTarget().execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOfSetOperator<T, T> buildMapOfSet() {
        return new Level0MapOfSetOperator<T, T>(getTarget().execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public ILevel0SetOperator<T> buildSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public <X> ILevel0GenericMultiOperator<X> of(final Type<X> of) {
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
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemovePositions<T>(positions)));
    }


    public ILevel0GenericMultiOperator<T> removeValues(final T... values) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveValues<T>(values)));
    }


    public ILevel0GenericMultiOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0GenericMultiOperator<T> removeSelected(final ISelect<T> selector) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveSelected<T>(selector)));
    }


    public ILevel0GenericMultiOperator<T> removeAllExceptPositions(final int... positions) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveAllExceptPositions<T>(positions)));
    }


    public ILevel0GenericMultiOperator<T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveNotNullsMatching<T>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0GenericMultiOperator<T> removeNulls() {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFunc.RemoveNulls<T>()));
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
