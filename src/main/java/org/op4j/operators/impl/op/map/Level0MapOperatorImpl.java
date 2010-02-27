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
package org.op4j.operators.impl.op.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.FnMap;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.op.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.op.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.op.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.qualities.UniqOpOperator;
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
public final class Level0MapOperatorImpl<I,K,V> extends AbstractOperatorImpl
        implements UniqOpOperator<I,Map<K,V>>, Level0MapOperator<I,K,V> {

    
    public Level0MapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperatorImpl<I,K> extractKeys() {
        return new Level0SetOperatorImpl<I,K>(getTarget().execute(FnMap.ofObjectObject().extractKeys()));
    }


    public Level0ListOperatorImpl<I,V> extractValues() {
        return new Level0ListOperatorImpl<I,V>(getTarget().execute(FnMap.ofObjectObject().extractValues()));
    }


    public Level1MapEntriesOperatorImpl<I,K, V> forEachEntry() {
        return new Level1MapEntriesOperatorImpl<I,K, V>(getTarget().iterate(Structure.MAP));
    }






    public Level0MapOperatorImpl<I,K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().put(newKey, newValue)));
    }


    public Level0MapOperatorImpl<I,K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().insert(position, newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperatorImpl<I,K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().putAll((Map)map)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperatorImpl<I,K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().insertAll(position, (Map)map)));
    }


    public Level0MapOperatorImpl<I,K, V> removeAllKeys(final K... keys) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeys(keys)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperatorImpl<I,K, V> removeAllTrue(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllTrue((IFunction)eval)));
    }

    @SuppressWarnings("unchecked")
    public Level0MapOperatorImpl<I,K, V> removeAllFalse(final IFunction<? super Entry<K, V>,Boolean> eval) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllFalse((IFunction)eval)));
    }


    public Level0MapOperatorImpl<I,K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().removeAllKeysNot(keys)));
    }











    public Level0MapOperatorImpl<I,K, V> sort() {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().sortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOperatorImpl<I,K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().execute(FnMap.ofObjectObject().sortEntries((Comparator)comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public Level0GenericUniqOperatorImpl<I,Map<K, V>> generic() {
        return new Level0GenericUniqOperatorImpl<I,Map<K, V>>(getTarget());
    }

    
    
    
    


    public <X, Y> Level0MapOperatorImpl<I,X, Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOf(keyType, valueType);
    }


    


    public Level0MapSelectedOperatorImpl<I,K, V> ifIndex(final int... indexes) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectIndex(indexes));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifIndexNot(final int... indexes) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNotNull() {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNotNull());
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNotNullAndTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNotNullAndFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNull() {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNull());
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNullOrTrue(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapSelectedOperatorImpl<I,K, V> ifNullOrFalse(final IFunction<? super Map<K, V>,Boolean> eval) {
        return new Level0MapSelectedOperatorImpl<I,K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0MapOperatorImpl<I,K, V> execIfNotNullAsMap(final IFunction<? super Map<K, V>,? extends Map<? extends K, ? extends V>> function) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public <X, Y> Level0MapOperatorImpl<I,X, Y> execAsMap(final IFunction<? super Map<K, V>,? extends Map<X, Y>> function) {
        return new Level0MapOperatorImpl<I,X, Y>(getTarget().execute(function, Normalisation.MAP));
    }


    


    public <X> Level0GenericUniqOperatorImpl<I,X> exec(final IFunction<? super Map<K, V>,X> function) {
        return new Level0GenericUniqOperatorImpl<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOperatorImpl<I,K, V> replaceWith(final Map<K, V> replacement) {
        return new Level0MapOperatorImpl<I,K, V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Level0MapOperatorImpl<I,K, V> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
