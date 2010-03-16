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
package org.op4j.operators.impl.fn.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExpressionFunction;
import org.op4j.functions.FnMap;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.impl.fn.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.fn.list.Level0ListOperator;
import org.op4j.operators.impl.fn.set.Level0SetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.qualities.UniqFnOperator;
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
public final class Level0MapOperator<I,K,V> extends AbstractOperator
        implements UniqFnOperator<I,Map<K,V>>, ILevel0MapOperator<I,K,V> {

    
    public Level0MapOperator(final Target target) {
        super(target);
    }


    public Level0SetOperator<I,K> extractKeys() {
        return new Level0SetOperator<I,K>(getTarget().execute(FnMap.ofObjectObject().extractKeys()));
    }


    public Level0ListOperator<I,V> extractValues() {
        return new Level0ListOperator<I,V>(getTarget().execute(FnMap.ofObjectObject().extractValues()));
    }


    public Level1MapEntriesOperator<I,K, V> forEachEntry() {
        return new Level1MapEntriesOperator<I,K, V>(getTarget().iterate(Structure.MAP));
    }






    public Level0MapOperator<I,K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().put(newKey, newValue)));
    }


    public Level0MapOperator<I,K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().insert(position, newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperator<I,K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().putAll((Map)map)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperator<I,K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().insertAll(position, (Map)map)));
    }


    public Level0MapOperator<I,K, V> removeAllKeys(final K... keys) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeys(keys)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperator<I,K, V> removeAllTrue(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0MapOperator<I,K, V> removeAllFalse(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllFalse((IFunction)eval)));
    }


    public Level0MapOperator<I,K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeysNot(keys)));
    }











    public Level0MapOperator<I,K, V> sort() {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().sortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperator<I,K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperator<I,K, V>(getTarget().execute(FnMap.ofObjectObject().sortEntries((Comparator)comparator)));
    }


    public Function<I,Map<K, V>> get() {
        return new ExpressionFunction<I, Map<K, V>>(getTarget());
    }


    public Level0GenericUniqOperator<I,Map<K, V>> generic() {
        return new Level0GenericUniqOperator<I,Map<K, V>>(getTarget());
    }

    
    
    
    


    public <X, Y> Level0MapOperator<I,X, Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOf(keyType, valueType);
    }


    




    public Level0MapSelectedOperator<I,K, V> ifTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapSelectedOperator<I,K, V> ifFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapSelectedOperator<I,K, V> ifNotNull() {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNotNull());
    }


    public Level0MapSelectedOperator<I,K, V> ifNotNullAndTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapSelectedOperator<I,K, V> ifNotNullAndFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapSelectedOperator<I,K, V> ifNull() {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNull());
    }


    public Level0MapSelectedOperator<I,K, V> ifNullOrTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapSelectedOperator<I,K, V> ifNullOrFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperator<I,K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0MapOperator<I,K, V> execIfNotNullAsMap(final IFunction<? super Map<K, V>,? extends Map<? extends K, ? extends V>> function) {
        return new Level0MapOperator<I,K, V>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public <X, Y> Level0MapOperator<I,X, Y> execAsMap(final IFunction<? super Map<K, V>,? extends Map<X, Y>> function) {
        return new Level0MapOperator<I,X, Y>(getTarget().execute(function, Normalisation.MAP));
    }


    


    public <X> Level0GenericUniqOperator<I,X> exec(final IFunction<? super Map<K, V>,X> function) {
        return new Level0GenericUniqOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOperator<I,K, V> replaceWith(final Map<K, V> replacement) {
        return new Level0MapOperator<I,K, V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Level0MapOperator<I,K, V> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    


    

    


    
    
    

    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> all(final IFunction<? super Map.Entry<K,V>, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnMap.of((Type<K>)Types.OBJECT,(Type<V>)Types.OBJECT).all(eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0GenericUniqOperator<I, Boolean> any(final IFunction<? super Map.Entry<K,V>, Boolean> eval) {
        return new Level0GenericUniqOperator<I, Boolean>(getTarget().execute(FnMap.of((Type<K>)Types.OBJECT,(Type<V>)Types.OBJECT).any(eval)));
    }




    
    @SuppressWarnings("unchecked")
    public Level0MapOperator<I, K, V> sortBy(IFunction<? super Entry<K, V>, ?> by) {
        return new Level0MapOperator<I, K, V>(getTarget().execute(FnMap.of((Type<K>)Types.OBJECT,(Type<V>)Types.OBJECT).sortBy(by)));
    }
    

    
    
}
