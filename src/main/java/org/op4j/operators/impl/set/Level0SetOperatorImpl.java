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
package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOperatorImpl<T> extends AbstractOperatorImpl
        implements Level0SetOperator<T>  {

    
    public Level0SetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T> add(final T newElement) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level0SetOperator<T> addAll(final T... newElements) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T> insert(final int position, final T newElement) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level0SetOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level0SetOperator<T> addAll(final Collection<T> collection) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1SetElementsOperator<T> forEach() {
        return new Level1SetElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level0SetOperator<T> removeAllEqual(final T... values) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0SetOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0SetOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0SetOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0SetOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0SetOperator<T> removeAllNull() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T> sort() {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperator<T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperatorImpl<T>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level0ListOperator<T> toList() {
        return new Level0ListOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level0MapOperator<T, T> toMap() {
        return new Level0MapOperatorImpl<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T>>(getTarget());
    }

    
    
    
    
    
    
    
	public <X> Level0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type) {
        return generic().asSetOfArrayOf(type);
    }


    public Level0SetOfArrayOperator<?> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public <X> Level0SetOfListOperator<X> asSetOfListOf(final Type<X> type) {
        return generic().asSetOfListOf(type);
    }


    public Level0SetOfListOperator<?> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }


    public <K, V> Level0SetOfMapOperator<K, V> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	return generic().asSetOfMapOf(keyType, valueType);
    }


    public Level0SetOfMapOperator<?, ?> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type) {
        return generic().asSetOfSetOf(type);
    }


    public Level0SetOfSetOperator<?> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public <X> Level0SetOperator<X> asSetOf(final Type<X> type) {
        return generic().asSetOf(type);
    }


    public Level0SetOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level0SetSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level0SetSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level0SetSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetSelectedOperator<T> ifNotNull() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level0SetSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetSelectedOperator<T> ifNull() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level0SetSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOperator<X> convertAsSet(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level0SetOperatorImpl<X>(getTarget().execute(converter, Normalisation.SET));
    }


    public <X> Level0SetOperator<X> evalAsSet(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level0SetOperatorImpl<X>(getTarget().execute(eval, Normalisation.SET));
    }


    public <X> Level0SetOperator<X> execAsSet(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level0SetOperatorImpl<X>(getTarget().execute(function, Normalisation.SET));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<T>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<T>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOperator<T> replaceWith(final Set<T> replacement) {
        return new Level0SetOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0SetOperator<T> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
    
}
