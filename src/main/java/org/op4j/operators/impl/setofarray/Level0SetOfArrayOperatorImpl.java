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
package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfArrayOperator<T>  {

    
    public Level0SetOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T[]>(newElements)));
    }


    public Level0SetOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T[]>(position, newElements)));
    }


    public Level0SetOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T[]>(collection)));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfArrays<T>()));
    }


    public Level1SetOfArrayElementsOperator<T> forEach() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0SetOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0SetOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }

    public Level0SetOfArrayOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0SetOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public Level0SetOfArrayOperator<T> removeNulls() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfArrayOperator<T> sort() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(forEach().toList().get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onSet(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(Op.onSet(get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(forEach().toList().get()).toList().get());
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get());
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(forEach().toSet().get()).toList().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return forEach().toSet().endFor();
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onSet(forEach().toMap().get()).toList().get());
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return forEach().toMap().endFor();
    }


    @SuppressWarnings("unchecked")
    public Set<T[]> get() {
        return (Set<T[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T[]>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type) {
        return generic().asSetOfArrayOf(type);
    }


    public Level0SetOfArrayOperator<?> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public Level0SetOfArraySelectedOperator<T> ifIndex(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0SetOfArraySelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0SetOfArraySelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetOfArraySelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfArraySelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfArrayOperator<X> convert(final IConverter<? extends Set<X[]>, ? super Set<T[]>> converter) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0SetOfArrayOperator<X> eval(final IEvaluator<? extends Set<X[]>, ? super Set<T[]>> eval) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0SetOfArrayOperator<X> exec(final IFunction<? extends Set<X[]>, ? super Set<T[]>> function) {
        return new Level0SetOfArrayOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T[]>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T[]>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T[]>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
    }
    
    
    
    
    
    
}
