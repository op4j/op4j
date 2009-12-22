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
package org.op4j.operators.impl.setoflist;

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
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
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
public class Level0SetOfListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOfListOperator<T>  {

    
    public Level0SetOfListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfListOperator<T> add(final List<T>... newElements) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(newElements)));
    }


    public Level0SetOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, newElements)));
    }


    public Level0SetOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<List<T>>(collection)));
    }


    public Level0SetOperator<T> flatten() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.FlattenSetOfLists<T>()));
    }


    public Level1SetOfListElementsOperator<T> forEach() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfListOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public Level0SetOfListOperator<T> removeEquals(final List<T>... values) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<List<T>>(values)));
    }


    public Level0SetOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<List<T>>(eval)));
    }

    public Level0SetOfListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public Level0SetOfListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<List<T>>(indices)));
    }


    public Level0SetOfListOperator<T> removeNulls() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfListOperator<T> sort() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
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
        return Op.onListOfArray(of, Op.onSet(forEach().toArray(of).get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(get()).toList().get());
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


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, forEach().toArray(of).get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(forEach().toSet().get());
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
    public Set<List<T>> get() {
        return (Set<List<T>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<List<T>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<List<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<List<T>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<List<T>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<List<T>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
	}

    


    public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type) {
        return generic().asSetOfListOf(type);
    }


    public Level0SetOfListOperator<?> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }
    
    
    
    
}
