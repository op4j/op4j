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
package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
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
public class Level0ArrayOfSetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfSetOperator<T>  {

    
    public Level0ArrayOfSetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfSetOperator<T> add(final Set<T>... newElements) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(newElements)));
    }


    public Level0ArrayOfSetOperator<T> insert(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, newElements)));
    }


    public Level0ArrayOfSetOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(collection)));
    }


    public Level0ArrayOfSetOperator<T> distinct() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.FlattenArrayOfSets<T>(type)));
    }


    public Level1ArrayOfSetElementsOperator<T> forEach() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ArrayOfSetOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Set<T>>(indices)));
    }


    public Level0ArrayOfSetOperator<T> removeEquals(final Set<T>... values) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<Set<T>>(values)));
    }


    public Level0ArrayOfSetOperator<T> removeMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<Set<T>>(eval)));
    }

    public Level0ArrayOfSetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Set<T>>(eval)));
    }


    public Level0ArrayOfSetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Set<T>>(indices)));
    }



    public Level0ArrayOfSetOperator<T> removeNulls() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<Set<T>>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetOperator<T> sort() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfSetOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public Level0ArrayOfListOperator<T> toArrayOfList() {
        return forEach().toList().endFor();
    }


    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(forEach().toList().get()).toList().get());
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(get()).toList().get());
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onArray(forEach().toArray(of).get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(forEach().toList().get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(get()).toSet().get());
    }


    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return forEach().toMap().endFor();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onArray(forEach().toMap().get()).toList().get());
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onArray(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public Set<T>[] get() {
        return (Set<T>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T>[]> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type) {
        return generic().asArrayOfSetOf(type);
    }


    public Level0ArrayOfSetOperator<?> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public Level0ArrayOfSetSelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfSetSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ArrayOfSetOperator<X> convert(final IConverter<? extends Set<X>[], ? super Set<T>[]> converter) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0ArrayOfSetOperator<X> eval(final IEvaluator<? extends Set<X>[], ? super Set<T>[]> eval) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0ArrayOfSetOperator<X> exec(final IFunction<? extends Set<X>[], ? super Set<T>[]> function) {
        return new Level0ArrayOfSetOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
    }
    
    
    
    
}
