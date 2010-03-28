/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.impl.fn.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExpressionFunction;
import org.op4j.functions.FnSet;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.fn.array.Level0ArrayOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.map.Level0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.ValuePair;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0SetOperator<I,T> extends AbstractOperator
        implements UniqFnOperator<I,Set<T>>, ILevel0SetOperator<I,T>  {

    
    public Level0SetOperator(final Target target) {
        super(target);
    }


    public Level0SetOperator<I,T> add(final T newElement) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().add(newElement)));
    }

    public Level0SetOperator<I,T> addAll(final T... newElements) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().add(newElements)));
    }


    public Level0SetOperator<I,T> insert(final int position, final T newElement) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElement)));
    }

    public Level0SetOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().addAll((Collection)collection)));
    }


    public Level1SetElementsOperator<I,T> forEach() {
        return new Level1SetElementsOperator<I,T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexes(indexes)));
    }


    public Level0SetOperator<I,T> removeAllEqual(final T... values) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    public Level0SetOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0SetOperator<I,T> removeAllNull() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNull()));
    }

    


    public Level0SetOperator<I,T> sort() {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperator<I,T>(getTarget().execute(FnSet.ofObject().sort((Comparator)comparator)));
    }


    public Level0ArrayOperator<I,T> toArrayOf(final Type<T> type) {
        return new Level0ArrayOperator<I,T>(type, getTarget().execute(FnSet.of(type).toArray()));
    }


    public Level0ListOperator<I,T> toList() {
        return new Level0ListOperator<I,T>(getTarget().execute(FnSet.ofObject().toList()));
    }


    public Level0MapOperator<I,T,T> couple() {
        return new Level0MapOperator<I,T,T>(getTarget().execute(FnSet.ofObject().couple()));
    }

    public Level0MapOperator<I,T,Set<T>> coupleAndGroup() {
        return new Level0MapOperator<I,T,Set<T>>(getTarget().execute(FnSet.ofObject().coupleAndGroup()));
    }


    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K,T> zipKeysBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K, T>(getTarget().execute(FnSet.ofObject().zipKeysBy((IFunction)keyEval)));
    }

    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T,V> zipValuesBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnSet.ofObject().zipValuesBy((IFunction)valueEval)));
    }

    public <K> Level0MapOperator<I,K,T> zipKeys(final K... keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnSet.ofObject().zipKeys(keys)));
    }

    public <V> Level0MapOperator<I,T,V> zipValues(final V... values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnSet.ofObject().zipValues(values)));
    }

    
    @SuppressWarnings("unchecked")
    public <K> Level0MapOperator<I,K,Set<T>> zipAndGroupKeysBy(final IFunction<? super T,K> keyEval) {
        return new Level0MapOperator<I,K,Set<T>>(getTarget().execute(FnSet.ofObject().zipAndGroupKeysBy((IFunction)keyEval)));
    }

    @SuppressWarnings("unchecked")
    public <V> Level0MapOperator<I,T,Set<V>> zipAndGroupValuesBy(final IFunction<? super T,V> valueEval) {
        return new Level0MapOperator<I,T,Set<V>>(getTarget().execute(FnSet.ofObject().zipAndGroupValuesBy((IFunction)valueEval)));
    }
    
    public <K> Level0MapOperator<I,K,Set<T>> zipAndGroupKeys(final K... keys) {
        return new Level0MapOperator<I,K,Set<T>>(getTarget().execute(FnSet.ofObject().zipAndGroupKeys(keys)));
    }

    public <V> Level0MapOperator<I,T,Set<V>> zipAndGroupValues(final V... values) {
        return new Level0MapOperator<I,T,Set<V>>(getTarget().execute(FnSet.ofObject().zipAndGroupValues(values)));
    }

    

    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K, V> toMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnSet.ofObject().toMap((IFunction)mapBuilder)));
    }

    @SuppressWarnings("unchecked")
    public <K, V> Level0MapOperator<I,K,Set<V>> toGroupMap(final IFunction<? super T,Map.Entry<K,V>> mapBuilder) {
        return new Level0MapOperator<I,K,Set<V>>(getTarget().execute(FnSet.ofObject().toGroupMap((IFunction)mapBuilder)));
    }


    public Function<I,Set<T>> get() {
        return new ExpressionFunction<I, Set<T>>(getTarget());
    }


    public Level0GenericUniqOperator<I,Set<T>> generic() {
        return new Level0GenericUniqOperator<I,Set<T>>(getTarget());
    }

    
    
    
    
    


    public <X> Level0SetOperator<I,X> of(final Type<X> type) {
        return generic().castToSetOf(type);
    }

    public <X> Level0SetOperator<I,X> castToSetOf(final Type<X> type) {
        return generic().castToSetOf(type);
    }


    




    public Level0SetSelectedOperator<I,T> ifTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level0SetSelectedOperator<I,T> ifFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level0SetSelectedOperator<I,T> ifNotNull() {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    public Level0SetSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetSelectedOperator<I,T> ifNull() {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNull());
    }


    public Level0SetSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super Set<T>,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0SetOperator<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetOperator<I,T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public <X> Level0SetOperator<I,X> execAsSet(final IFunction<? super Set<T>,? extends Set<X>> function) {
        return new Level0SetOperator<I,X>(getTarget().execute(function, Normalisation.SET));
    }


    


    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super Set<T>,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOperator<I,T> replaceWith(final Set<T> replacement) {
        return new Level0SetOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level0SetOperator<I,T> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    public <X> Level0SetOperator<I,X> map(final IFunction<? super T,X> function) {
        return new Level0SetOperator<I,X>(getTarget().map(Structure.SET, function, null));
    }
    

    public Level0SetOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0SetOperator<I,T>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }



    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor) {
        return new Level0GenericUniqOperator<I, T>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).reduce(reductor)));
    }



    @SuppressWarnings("unchecked")
    public <X> Level0GenericUniqOperator<I, X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue) {
        return new Level0GenericUniqOperator<I, X>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).reduce(reductor, initialValue)));
    }
    
    
    

    


    
    
    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).all(eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super T, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).any(eval)));
    }
    
    

    


    @SuppressWarnings("unchecked")
    public Level0SetOperator<I, T> sortBy(IFunction<? super T, ?> by) {
        return new Level0SetOperator<I, T>(getTarget().execute(FnSet.of((Type<T>)Types.OBJECT).sortBy(by)));
    }
    
    
    
    
    
    
    public <K> Level0MapOperator<I, K, Set<T>> zipAndGroupKeysFrom(final Collection<K> keys) {
        return new Level0MapOperator<I,K,Set<T>>(getTarget().execute(FnSet.ofObject().zipAndGroupKeysFrom(keys)));
    }

    public <K> Level0MapOperator<I, K, Set<T>> zipAndGroupKeysFrom(final K[] keys) {
        return new Level0MapOperator<I,K,Set<T>>(getTarget().execute(FnSet.ofObject().zipAndGroupKeysFrom(keys)));
    }

    public <V> Level0MapOperator<I, T, Set<V>> zipAndGroupValuesFrom(final Collection<V> values) {
        return new Level0MapOperator<I,T,Set<V>>(getTarget().execute(FnSet.ofObject().zipAndGroupValuesFrom(values)));
    }

    public <V> Level0MapOperator<I, T, Set<V>> zipAndGroupValuesFrom(final V[] values) {
        return new Level0MapOperator<I,T,Set<V>>(getTarget().execute(FnSet.ofObject().zipAndGroupValuesFrom(values)));
    }

    public <K> Level0MapOperator<I, K, T> zipKeysFrom(final Collection<K> keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnSet.ofObject().zipKeysFrom(keys)));
    }

    public <K> Level0MapOperator<I, K, T> zipKeysFrom(final K[] keys) {
        return new Level0MapOperator<I,K,T>(getTarget().execute(FnSet.ofObject().zipKeysFrom(keys)));
    }

    public <V> Level0MapOperator<I, T, V> zipValuesFrom(final Collection<V> values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnSet.ofObject().zipValuesFrom(values)));
    }

    public <V> Level0MapOperator<I, T, V> zipValuesFrom(final V[] values) {
        return new Level0MapOperator<I,T,V>(getTarget().execute(FnSet.ofObject().zipValuesFrom(values)));
    }
    
    

    public Level0SetOperator<I, T> reverse() {
        return new Level0SetOperator<I, T>(getTarget().execute(FnSet.ofObject().reverse()));
    }
    
    
}
