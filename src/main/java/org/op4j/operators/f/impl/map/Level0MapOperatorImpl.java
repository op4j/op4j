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
package org.op4j.operators.f.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FMap;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.f.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.f.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.f.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.op.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.op.intf.list.Level0ListOperator;
import org.op4j.operators.op.intf.map.Level0MapOperator;
import org.op4j.operators.op.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.op.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.op.intf.set.Level0SetOperator;
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
public final class Level0MapOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level0MapOperator<K,V,I> {

    
    public Level0MapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K,I> extractKeys() {
        return new Level0SetOperatorImpl<K,I>(getTarget().execute(new FMap.ExtractKeys<K, V>()));
    }


    public Level0ListOperator<V,I> extractValues() {
        return new Level0ListOperatorImpl<V,I>(getTarget().execute(new FMap.ExtractValues<K, V>()));
    }


    public Level1MapEntriesOperator<K, V,I> forEachEntry() {
        return new Level1MapEntriesOperatorImpl<K, V,I>(getTarget().iterate(Structure.MAP));
    }






    public Level0MapOperator<K, V,I> put(final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.Put<K, V>(newKey, newValue)));
    }


    public Level0MapOperator<K, V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.Insert<K, V>(position, newKey, newValue)));
    }


    public Level0MapOperator<K, V,I> putAll(final Map<K, V> map) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.PutAll<K, V>(map)));
    }


    public Level0MapOperator<K, V,I> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.InsertAll<K, V>(position, map)));
    }


    public Level0MapOperator<K, V,I> removeAllKeys(final K... keys) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.RemoveAllKeys<K, V>(keys)));
    }


    public Level0MapOperator<K, V,I> removeAllTrue(final IFunction<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.RemoveAllTrue<K, V>(eval)));
    }

    public Level0MapOperator<K, V,I> removeAllFalse(final IFunction<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.RemoveAllFalse<K, V>(eval)));
    }


    public Level0MapOperator<K, V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.RemoveAllKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOperator<K, V,I> sort() {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.SortByKey()));
    }


    public Level0MapOperator<K, V,I> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new FMap.SortEntries<K, V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V>,I>(getTarget());
    }

    
    
    
    


    public <X, Y> Level0MapOperator<X, Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOf(keyType, valueType);
    }


    


    public Level0MapSelectedOperator<K, V,I> ifIndex(final int... indexes) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indexes));
    }


    public Level0MapSelectedOperator<K, V,I> ifIndexNot(final int... indexes) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperator<K, V,I> ifTrue(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level0MapSelectedOperator<K, V,I> ifFalse(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level0MapSelectedOperator<K, V,I> ifNotNull() {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level0MapSelectedOperator<K, V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapSelectedOperator<K, V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapSelectedOperator<K, V,I> ifNull() {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level0MapSelectedOperator<K, V,I> ifNullOrTrue(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapSelectedOperator<K, V,I> ifNullOrFalse(final IFunction<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level0MapOperator<K, V,I> execIfNotNullAsMap(final IFunction<? extends Map<? extends K, ? extends V>, ? super Map<K, V>> function) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public <X, Y> Level0MapOperator<X, Y,I> execAsMap(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level0MapOperatorImpl<X, Y,I>(getTarget().execute(function, Normalisation.MAP));
    }


    


    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super Map<K, V>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOperator<K, V,I> replaceWith(final Map<K, V> replacement) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Level0MapOperator<K, V,I> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
