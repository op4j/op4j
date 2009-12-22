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
package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
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
public class Level0ArrayOfListOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfListOperator<T>  {

    
    public Level0ArrayOfListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<List<T>>(newElements)));
    }


    public Level0ArrayOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, newElements)));
    }


    public Level0ArrayOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<List<T>>(collection)));
    }


    public Level0ArrayOfListOperator<T> distinct() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<List<T>>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<? super T> type) {
        return new Level0ArrayOperatorImpl<T>(type, getTarget().execute(new ArrayFuncs.FlattenArrayOfLists<T>(type)));
    }


    public Level1ArrayOfListElementsOperator<T> forEach() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ArrayOfListOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public Level0ArrayOfListOperator<T> removeEquals(final List<T>... values) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<List<T>>(values)));
    }


    public Level0ArrayOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<List<T>>(eval)));
    }

    public Level0ArrayOfListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<List<T>>(indices)));
    }



    public Level0ArrayOfListOperator<T> removeNulls() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<List<T>>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOfListOperator<T> sort() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        return forEach().toSet().endFor();
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onArray(forEach().toArray(of).get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(get()).toList().get());
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toList().get());
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(forEach().toSet().get()).toList().get());
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onArray(forEach().toArray(of).get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(forEach().toSet().get()).toSet().get());
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
	public List<T>[] get() {
        return (List<T>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T>[]> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>[]>(getTarget());
    }

    
    
    
    
    
	public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super List<T>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<T>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
	}

    
    


    public <X> Level0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type) {
        return generic().asArrayOfListOf(type);
    }


    public Level0ArrayOfListOperator<?> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }
    
    
    
}
