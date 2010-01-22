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
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
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
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0SetOperator<T,I>  {

    
    public Level0SetOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T,I> add(final T newElement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level0SetOperator<T,I> addAll(final T... newElements) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T,I> insert(final int position, final T newElement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level0SetOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level0SetOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1SetElementsOperator<T,I> forEach() {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0SetOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0SetOperator<T,I> removeAllEqual(final T... values) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0SetOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0SetOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0SetOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0SetOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0SetOperator<T,I> removeAllNull() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOperator<T,I> sort() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperator<T,I> toArray(final Type<T> of) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level0ListOperator<T,I> toList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level0MapOperator<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> Level0MapOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<T>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Set<T>,I>(getTarget());
    }

    
    
    
    
    
    
    
	public <X> Level0SetOfArrayOperator<X,I> asSetOfArrayOf(final Type<X> type) {
        return generic().asSetOfArrayOf(type);
    }


    public Level0SetOfArrayOperator<?,I> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public <X> Level0SetOfListOperator<X,I> asSetOfListOf(final Type<X> type) {
        return generic().asSetOfListOf(type);
    }


    public Level0SetOfListOperator<?,I> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	return generic().asSetOfMapOf(keyType, valueType);
    }


    public Level0SetOfMapOperator<?, ?,I> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0SetOfSetOperator<X,I> asSetOfSetOf(final Type<X> type) {
        return generic().asSetOfSetOf(type);
    }


    public Level0SetOfSetOperator<?,I> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type) {
        return generic().asSetOf(type);
    }


    public Level0SetOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level0SetSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0SetSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0SetSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> ifNotNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0SetSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> ifNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0SetSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0SetOperator<X,I> convert(final IConverter<? extends Set<X>, ? super Set<T>> converter) {
        return new Level0SetOperatorImpl<X,I>(getTarget().execute(converter, Normalization.SET));
    }


    public <X> Level0SetOperator<X,I> eval(final IEvaluator<? extends Set<X>, ? super Set<T>> eval) {
        return new Level0SetOperatorImpl<X,I>(getTarget().execute(eval, Normalization.SET));
    }


    public <X> Level0SetOperator<X,I> exec(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level0SetOperatorImpl<X,I>(getTarget().execute(function, Normalization.SET));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<T>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<T>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0SetOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level0SetOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOperator<T,I> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<T>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<Set<T>, I>((OperationChainingTarget) target);
    }

    
    
    
}
