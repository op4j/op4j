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
package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FMap;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0MapOfSetOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0MapOfSetOperator<K,V> {

    
    public Level0MapOfSetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K> extractKeys() {
        return new Level0SetOperatorImpl<K>(getTarget().execute(new FMap.ExtractKeys<K, V>()));
    }


    public Level0ListOperator<Set<V>> extractValues() {
        return new Level0ListOperatorImpl<Set<V>>(getTarget().execute(new FMap.ExtractValues<K, V>()));
    }


    public Level1MapOfSetEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfSetEntriesOperatorImpl<K, V>(getTarget().iterate(Structure.MAP));
    }








    public Level0MapOfSetOperator<K, V> put(final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.Put<K, Set<V>>(newKey, NormalisationUtils.normaliseSet(newValue))));
    }


    public Level0MapOfSetOperator<K, V> insert(final int position, final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.Insert<K, Set<V>>(position, newKey, NormalisationUtils.normaliseSet(newValue))));
    }


    public Level0MapOfSetOperator<K, V> putAll(final Map<K, Set<V>> map) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.PutAll<K, Set<V>>(NormalisationUtils.normaliseMapOfSet(map))));
    }


    public Level0MapOfSetOperator<K, V> insertAll(final int position, final Map<K, Set<V>> map) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.InsertAll<K, Set<V>>(position, NormalisationUtils.normaliseMapOfSet(map))));
    }


    public Level0MapOfSetOperator<K, V> removeAllKeys(final K... keys) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.RemoveAllKeys<K, Set<V>>(keys)));
    }


    public Level0MapOfSetOperator<K, V> removeAllTrue(final IFunction<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.RemoveAllTrue<K, Set<V>>(eval)));
    }

    public Level0MapOfSetOperator<K, V> removeAllFalse(final IFunction<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.RemoveAllFalse<K, Set<V>>(eval)));
    }


    public Level0MapOfSetOperator<K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.RemoveAllKeysNot<K, Set<V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOfSetOperator<K, V> sort() {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.SortByKey()));
    }


    public Level0MapOfSetOperator<K, V> sort(final Comparator<? super Entry<K, Set<V>>> comparator) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new FMap.SortEntries<K, Set<V>>(comparator)));
    }


    public Level0MapOfArrayOperator<K, V> toMapOfArrayOf(final Type<V> type) {
        return forEachEntry().onValue().toArrayOf(type).endOn().endFor();
    }


    public Level0MapOfListOperator<K, V> toMapOfList() {
        return forEachEntry().onValue().toList().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, Set<V>> get() {
        return (Map<K,Set<V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, Set<V>>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, Set<V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfSetOf(keyType, valueType);
    }


    


    public Level0MapOfSetSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNull() {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNull() {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNullOrTrue(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNullOrFalse(final IFunction<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0MapOfSetOperator<K, V> execIfNotNullAsMapOfSet(final IFunction<? extends Map<? extends K, ? extends Set<? extends V>>, ? super Map<K, Set<V>>> function) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().executeIfNotNull(function, Normalisation.MAP_OF_SET));
    }


    public <X, Y> Level0MapOfSetOperator<X, Y> execAsMapOfSet(final IFunction<? extends Map<X, ? extends Set<Y>>, ? super Map<K, Set<V>>> function) {
        return new Level0MapOfSetOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAP_OF_SET));
    }


    


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K, Set<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOfSetOperator<K, V> replaceWith(final Map<K, Set<V>> replacement) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_SET));
    }


    public Level0MapOfSetOperator<K, V> replaceIfNullWith(final Map<K, Set<V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    

}
