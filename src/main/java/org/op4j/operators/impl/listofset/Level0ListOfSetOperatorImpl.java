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
package org.op4j.operators.impl.listofset;

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
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
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
public class Level0ListOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ListOfSetOperator<T>  {

    
    public Level0ListOfSetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(newElements)));
    }


    public Level0ListOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, newElements)));
    }


    public Level0ListOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0ListOfSetOperator<T> distinct() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOperator<T> flatten() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ListFuncs.FlattenListOfSets<T>()));
    }


    public Level1ListOfSetElementsOperator<T> forEach() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0ListOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0ListOfSetOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }

    public Level0ListOfSetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0ListOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public Level0ListOfSetOperator<T> removeNulls() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfSetOperator<T> sort() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
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
        return Op.onArrayOfSet(Op.onList(get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
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


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onList(forEach().toArray(of).get()).toSet().get());
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
        return Op.onSetOfSet(Op.onList(get()).toSet().get());
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
    public List<Set<T>> get() {
        return (List<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<Set<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<List<Set<T>>>(getTarget());
    }

    
    
    
    
    
    
	public <X> Level0ListOfSetOperator<X> asListOfSetOf(final Type<X> type) {
        return generic().asListOfSetOf(type);
    }


    public Level0ListOfSetOperator<?> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOfSetSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ListOfSetSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfSetSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ListOfSetSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfSetSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOfSetOperator<X> convert(final IConverter<? extends List<? extends Set<X>>, ? super List<Set<T>>> converter) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0ListOfSetOperator<X> eval(final IEvaluator<? extends List<? extends Set<X>>, ? super List<Set<T>>> eval) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0ListOfSetOperator<X> exec(final IFunction<? extends List<? extends Set<X>>, ? super List<Set<T>>> function) {
        return new Level0ListOfSetOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<Set<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<Set<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<Set<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
    }
    
    
    
}
