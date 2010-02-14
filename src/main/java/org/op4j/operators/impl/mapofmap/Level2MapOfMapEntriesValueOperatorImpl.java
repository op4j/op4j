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
package org.op4j.operators.impl.mapofmap;

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
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfMapEntriesValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level2MapOfMapEntriesValueOperator<K1,K2,V> {

    
    public Level2MapOfMapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V> endOn() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V>(getTarget().endOn());
    }


    public Level2MapOfSetEntriesValueOperator<K1, K2> extractKeys() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K1, K2>(getTarget().execute(new MapFuncs.ExtractKeys<K2, V>()));
    }


    public Level2MapOfListEntriesValueOperator<K1, V> extractValues() {
        return new Level2MapOfListEntriesValueOperatorImpl<K1, V>(getTarget().execute(new MapFuncs.ExtractValues<K2, V>()));
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V>(getTarget().iterate(Structure.MAP));
    }





    public Level2MapOfMapEntriesValueOperator<K1, K2, V> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.Put<K2, V>(newKey, newValue)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.Insert<K2, V>(position, newKey, newValue)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> putAll(final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.PutAll<K2, V>(map)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> insertAll(final int position, final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.InsertAll<K2, V>(position, map)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> removeAllKeys(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K2, V>(keys)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K2, V>(eval)));
    }

    public Level2MapOfMapEntriesValueOperator<K1, K2, V> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K2, V>(eval)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> removeAllKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K2, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesValueOperator<K1, K2, V> sort() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesValueOperator<K1, K2, V> sort(final Comparator<? super Entry<K2, V>> comparator) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    

    
    
    
	public <X,Y> Level2MapOfMapEntriesValueOperator<K1, X, Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1,X,Y>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public Level2MapOfMapEntriesValueOperator<K1, ?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifIndex(final int... indexes) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNotNull() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNull() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y> convertAsMap(final IConverter<? extends Map<X2, Y>, ? super Map<K2, V>> converter) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y>(getTarget().execute(converter, Normalisation.MAP));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y> evalAsMap(final IEvaluator<? extends Map<X2, Y>, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y>(getTarget().execute(eval, Normalisation.MAP));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y> execAsMap(final IFunction<? extends Map<X2, Y>, ? super Map<K2, V>> function) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y>(getTarget().execute(function, Normalisation.MAP));
    }


    public <X> Level2MapEntriesValueOperator<K1, X> convert(final IConverter<X, ? super Map<K2, V>> converter) {
        return new Level2MapEntriesValueOperatorImpl<K1, X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K1, X> eval(final IEvaluator<X, ? super Map<K2, V>> eval) {
        return new Level2MapEntriesValueOperatorImpl<K1, X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K1, X> exec(final IFunction<X, ? super Map<K2, V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K1, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> replaceWith(final Map<K2, V> replacement) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> replaceIfNullWith(final Map<K2, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
