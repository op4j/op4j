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
import org.javaruntype.type.Types;
import org.op4j.exceptions.EmptyTargetException;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericMultiOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0GenericMultiOperator<T>  {

    
    public Level0GenericMultiOperatorImpl(final Target target) {
        super(target);
        if (((List<?>)target.get()).size() <= 0) {
            throw new EmptyTargetException();
        }
    }


    public Level0GenericMultiOperator<T> add(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }

    public Level0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOperator<T> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperatorImpl<T>(arrayOf, getTarget().execute(new ToArray.FromCollection<T>(arrayOf)));
    }


    public Level0ListOperator<T> buildList() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public <K> Level0MapOperator<K, T> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOperator<T, T> buildMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOfArrayOperator<K, T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperatorImpl<K, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> Level0MapOfArrayOperator<K, V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperatorImpl<K, V>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public Level0MapOfArrayOperator<T, T> buildMapOfArray(final Type<T> valueArrayOf) {
        return new Level0MapOfArrayOperatorImpl<T, T>(valueArrayOf, getTarget().execute(new ToMapOfArray.FromListByAlternateElements<T>(valueArrayOf)));
    }


    public <K> Level0MapOfListOperator<K, T> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperatorImpl<K, T>(getTarget().execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfListOperator<K, V> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperatorImpl<K, V>(getTarget().execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOfListOperator<T, T> buildMapOfList() {
        return new Level0MapOfListOperatorImpl<T, T>(getTarget().execute(new ToMapOfList.FromListByAlternateElements<T>()));
    }


    public <K> Level0MapOfSetOperator<K, T> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperatorImpl<K, T>(getTarget().execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0MapOfSetOperator<T, T> buildMapOfSet() {
        return new Level0MapOfSetOperatorImpl<T, T>(getTarget().execute(new ToMapOfSet.FromListByAlternateElements<T>()));
    }


    public Level0SetOperator<T> buildSet() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public <X> Level0GenericMultiOperator<X> asType(final Type<X> type) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget());
    }

    public Level0GenericMultiOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Level0GenericMultiOperator<T> removeIndexes(final int... indices) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level0GenericMultiOperator<T> removeEquals(final T... values) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level0GenericMultiOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }

    public Level0GenericMultiOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }

    public Level0GenericMultiOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public Level0GenericMultiOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level0GenericMultiOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level0GenericMultiOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level0GenericMultiOperator<T> removeIndexesNot(final int... indices) {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level0GenericMultiOperator<T> removeNulls() {
        return new Level0GenericMultiOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    public <X> Level0GenericMultiOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget().iterate().execute(converter).endIterate(Structure.LIST, null));
    }



    public <X> Level0GenericMultiOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget().iterate().execute(eval).endIterate(Structure.LIST, null));
    }


    public <X> Level0GenericMultiOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericMultiOperatorImpl<X>(getTarget().iterate().execute(function).endIterate(Structure.LIST, null));
    }







    public Level0GenericUniqOperator<T> uniq() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        return new Level0GenericUniqOperatorImpl<T>(Target.forObject(((List<?>)getTarget()).get(0)));
    }


    public int size() {
        return ((List<?>) getTarget().get()).size();
    }


    public T[] getAsArray(final Type<T> type) {
        return buildArray(type).get();
    }


    public List<T> getAsList() {
        return buildList().get();
    }


    public Level0GenericMultiSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0GenericMultiSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0GenericMultiSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNull() {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0GenericMultiSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericMultiSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }
    
}
