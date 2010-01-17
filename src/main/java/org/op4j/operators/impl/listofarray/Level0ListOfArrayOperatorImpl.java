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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOfArrayOperator<T>  {

    
    public Level0ListOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T[]>(NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ListOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ListOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T[]>(NormalizationUtils.normalizeArrays(collection))));
    }


    public Level0ListOfArrayOperator<T> distinct() {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOperator<T> flatten() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.FlattenListOfArrays<T>()));
    }


    public Level1ListOfArrayElementsOperator<T> forEach() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0ListOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0ListOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }

    public Level0ListOfArrayOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0ListOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public Level0ListOfArrayOperator<T> removeNulls() {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfArrayOperator<T> sort() {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onList(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onList(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onList(get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onList(forEach().toList().get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onList(forEach().toSet().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public List<T[]> get() {
        return (List<T[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T[]>> generic() {
        return new Level0GenericUniqOperatorImpl<List<T[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type) {
        return generic().asListOfArrayOf(type);
    }


    public Level0ListOfArrayOperator<?> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public Level0ListOfArraySelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ListOfArraySelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfArraySelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListOfArraySelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfArraySelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfArrayOperator<X> convert(final IConverter<? extends List<X[]>, ? super List<T[]>> converter) {
        return new Level0ListOfArrayOperatorImpl<X>(getTarget().execute(converter, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0ListOfArrayOperator<X> eval(final IEvaluator<? extends List<X[]>, ? super List<T[]>> eval) {
        return new Level0ListOfArrayOperatorImpl<X>(getTarget().execute(eval, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0ListOfArrayOperator<X> exec(final IFunction<? extends List<X[]>, ? super List<T[]>> function) {
        return new Level0ListOfArrayOperatorImpl<X>(getTarget().execute(function, Normalization.LIST_OF_ARRAY));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }
    
    
    
}
