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
package org.op4j.operators.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0MapOperator<K,V> {

    
    public Level0MapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K> extractKeys() {
        return new Level0SetOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level0ListOperator<V> extractValues() {
        return new Level0ListOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level1MapEntriesOperator<K, V> forEachEntry() {
        return new Level1MapEntriesOperatorImpl<K, V>(getTarget().iterate());
    }






    public Level0MapOperator<K, V> put(final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level0MapOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level0MapOperator<K, V> putAll(final Map<K, V> map) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level0MapOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level0MapOperator<K, V> removeAllKeys(final K... keys) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, V>(keys)));
    }


    public Level0MapOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, V>(eval)));
    }

    public Level0MapOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, V>(eval)));
    }


    public Level0MapOperator<K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOperator<K, V> sort() {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level0MapOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K, V> get() {
        return (Map<K, V>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X, Y> Level0MapOfArrayOperator<X, Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfArrayOf(keyType, valueType);
    }


    public Level0MapOfArrayOperator<?, ?> asMapOfArrayOfUnknown() {
        return asMapOfArrayOf(Types.OBJECT, Types.OBJECT);
    }


    public <X, Y> Level0MapOfListOperator<X, Y> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfListOf(keyType, valueType);
    }


    public Level0MapOfListOperator<?, ?> asMapOfListOfUnknown() {
        return asMapOfListOf(Types.OBJECT, Types.OBJECT);
    }


    public <X1, X2, Y> Level0MapOfMapOperator<X1, X2, Y> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType) {
        return generic().asMapOfMapOf(key1Type, key2Type, valueType);
    }


    public Level0MapOfMapOperator<?, ?, ?> asMapOfMapOfUnknown() {
        return asMapOfMapOf(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }


    public <X, Y> Level0MapOfSetOperator<X, Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfSetOf(keyType, valueType);
    }


    public Level0MapOfSetOperator<?, ?> asMapOfSetOfUnknown() {
        return asMapOfSetOf(Types.OBJECT, Types.OBJECT);
    }


    public <X, Y> Level0MapOperator<X, Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOf(keyType, valueType);
    }


    public Level0MapOperator<?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0MapSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0MapSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapSelectedOperator<K, V> ifNotNull() {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0MapSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapSelectedOperator<K, V> ifNull() {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0MapSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0MapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0MapOperator<X, Y> convert(final IConverter<? extends Map<X, Y>, ? super Map<K, V>> converter) {
        return new Level0MapOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.MAP));
    }


    public <X, Y> Level0MapOperator<X, Y> eval(final IEvaluator<? extends Map<X, Y>, ? super Map<K, V>> eval) {
        return new Level0MapOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.MAP));
    }


    public <X, Y> Level0MapOperator<X, Y> exec(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level0MapOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAP));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0MapOperator<K, V> replaceWith(final Map<K, V> replacement) {
        return new Level0MapOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level0MapOperator<K, V> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
