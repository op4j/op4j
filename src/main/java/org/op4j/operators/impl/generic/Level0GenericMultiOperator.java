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
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
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
import org.op4j.select.ISelector;
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
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel0ArrayOperator<T> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperator<T>(arrayOf, getTarget().execute(new ToArray.FromCollection<T>(arrayOf)));
    }


    public ILevel0ListOperator<T> buildList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public <K> ILevel0MapOperator<K, T> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOperator<T, T> buildMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> ILevel0MapOfArrayOperator<K, T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperator<K, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperator<K, V>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public ILevel0MapOfArrayOperator<T, T> buildMapOfArray(final Type<T> valueArrayOf) {
        return new Level0MapOfArrayOperator<T, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByAlternateElements<T>(valueArrayOf)));
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperator<K, T>(getTarget().execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOfListOperator<T, T> buildMapOfList() {
        return new Level0MapOfListOperator<T, T>(getTarget().execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperator<K, T>(getTarget().execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperator<K, V>(getTarget().execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0MapOfSetOperator<T, T> buildMapOfSet() {
        return new Level0MapOfSetOperator<T, T>(getTarget().execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public ILevel0SetOperator<T> buildSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public <X> ILevel0GenericMultiOperator<X> of(final Type<X> of) {
        return new Level0GenericMultiOperator<X>(getTarget());
    }


    public ILevel0GenericMultiOperator<?> raw() {
        return new Level0GenericMultiOperator<T>(getTarget());
    }


    public ILevel0GenericMultiOperator<T> removeIndexes(final int... indices) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel0GenericMultiOperator<T> removeEquals(final T... values) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public ILevel0GenericMultiOperator<T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel0GenericMultiOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel0GenericMultiOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0GenericMultiOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0GenericMultiOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel0GenericMultiOperator<T> removeIndexesNot(final int... indices) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel0GenericMultiOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel0GenericMultiOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(expression, optionalExpParams))));
    }


    public ILevel0GenericMultiOperator<T> removeNulls() {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
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
    
    
}
