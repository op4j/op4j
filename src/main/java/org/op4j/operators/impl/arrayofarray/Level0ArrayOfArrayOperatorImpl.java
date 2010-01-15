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
package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

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
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
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
public class Level0ArrayOfArrayOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0ArrayOfArrayOperator<T> {

    
    
    public Level0ArrayOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfArrayOperator<T> add(final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T[]>(newElements)));
    }


    public Level0ArrayOfArrayOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, newElements)));
    }


    public Level0ArrayOfArrayOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T[]>(collection)));
    }


    public Level0ArrayOfArrayOperator<T> distinct() {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOperator<T> flatten(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.FlattenArrayOfArrays<T>(type)));
    }


    public Level1ArrayOfArrayElementsOperator<T> forEach(final Type<T[]> elementType) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level0ArrayOfArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0ArrayOfArrayOperator<T> removeEquals(final T[]... values) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0ArrayOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }

    public Level0ArrayOfArrayOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0ArrayOfArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T[]>(indices)));
    }



    public Level0ArrayOfArrayOperator<T> removeNulls() {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T[]>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArrayOperator<T> sort() {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArrayOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfListOperator<T> toArrayOfList() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toList().endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public <K> Level0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap(keyEval).endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public <K, V> Level0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap(mapBuild).endFor();
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfSetOperator<T> toArrayOfSet() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toSet().endFor();
    }


    public Level0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(Op.onArray(get()).toList().get());
    }


    public Level0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onArray(toArrayOfList().get()).toList().get());
    }


    public <K> Level0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onArray(toArrayOfMap(keyEval).get()).toList().get());
    }


    public <K, V> Level0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onArray(toArrayOfMap(mapBuild).get()).toList().get());
    }


    public Level0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onArray(toArrayOfSet().get()).toList().get());
    }


    public Level0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(Op.onArray(get()).toSet().get());
    }


    public Level0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onArray(toArrayOfList().get()).toSet().get());
    }


    public <K> Level0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onArray(toArrayOfMap(keyEval).get()).toSet().get());
    }


    public <K, V> Level0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onArray(toArrayOfMap(mapBuild).get()).toSet().get());
    }


    public Level0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onArray(toArrayOfSet().get()).toSet().get());
    }


    @SuppressWarnings({ "cast", "unchecked" })
    public Level0ArrayOfMapOperator<T, T> toArrayOfMap() {
        final Type<?> auxType = (Type<?>) Types.ARRAY_OF_OBJECT; 
        return forEach((Type<T[]>)auxType).toMap().endFor();
    }


    public Level0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onArray(toArrayOfMap().get()).toList().get());
    }


    public Level0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onArray(toArrayOfMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
	public T[][] get() {
        return (T[][]) getTarget().get();
    }


    public Level0GenericUniqOperator<T[][]> generic() {
        return new Level0GenericUniqOperatorImpl<T[][]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
	public <X> Level0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> type) {
        return generic().asArrayOfArrayOf(type);
    }


    public Level0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public Level0ArrayOfArraySelectedOperator<T> ifIndex(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level0ArrayOfArrayOperator<X> convert(final IConverter<X[][], ? super T[][]> converter) {
        return new Level0ArrayOfArrayOperatorImpl<X>(getTarget().execute(converter));
    }


	public <X> Level0ArrayOfArrayOperator<X> eval(final IEvaluator<X[][], ? super T[][]> eval) {
        return new Level0ArrayOfArrayOperatorImpl<X>(getTarget().execute(eval));
    }


	public <X> Level0ArrayOfArrayOperator<X> exec(final IFunction<X[][], ? super T[][]> function) {
        return new Level0ArrayOfArrayOperatorImpl<X>(getTarget().execute(function));
    }


    
    
    
    
    
    
}
