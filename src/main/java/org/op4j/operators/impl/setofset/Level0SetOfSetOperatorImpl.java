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
package org.op4j.operators.impl.setofset;

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
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfSetOperator<T>  {

    
    public Level0SetOfSetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(newElements)));
    }


    public Level0SetOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, newElements)));
    }


    public Level0SetOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfSets<T>()));
    }


    public Level1SetOfSetElementsOperator<T> forEach() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0SetOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0SetOfSetOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }

    public Level0SetOfSetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0SetOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }


    public Level0SetOfSetOperator<T> removeNulls() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<Set<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfSetOperator<T> sort() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
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
        return Op.onArrayOfSet(Op.onSet(get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(Op.onSet(forEach().toArray(of).get()).toList().get());
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
        return Op.onListOfSet(Op.onSet(get()).toList().get());
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(forEach().toArray(of).get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(forEach().toList().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
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
    public Set<Set<T>> get() {
        return (Set<Set<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Set<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Set<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type) {
        return generic().asSetOfSetOf(type);
    }


    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public Level0SetOfSetSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0SetOfSetSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0SetOfSetSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetOfSetSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfSetSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOfSetOperator<X> convert(final IConverter<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> converter) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0SetOfSetOperator<X> eval(final IEvaluator<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> eval) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0SetOfSetOperator<X> exec(final IFunction<? extends Set<? extends Set<X>>, ? super Set<Set<T>>> function) {
        return new Level0SetOfSetOperatorImpl<X>(getTarget().execute(function));
    }
    
    
    
}
