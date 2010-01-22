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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfMapEntriesValueOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl
        implements Level2MapOfMapEntriesValueOperator<K1,K2,V,I> {

    
    public Level2MapOfMapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V,I> endOn() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfSetEntriesValueOperator<K1, K2,I> extractKeys() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K1, K2,I>(getTarget().execute(new MapFuncs.ExtractKeys<K2, V>()));
    }


    public Level2MapOfListEntriesValueOperator<K1, V,I> extractValues() {
        return new Level2MapOfListEntriesValueOperatorImpl<K1, V,I>(getTarget().execute(new MapFuncs.ExtractValues<K2, V>()));
    }


    public Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V,I> forEachEntry() {
        return new Level3MapOfMapEntriesValueEntriesOperatorImpl<K1, K2, V,I>(getTarget().iterate());
    }





    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.Put<K2, V>(newKey, newValue)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.Insert<K2, V>(position, newKey, newValue)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> putAll(final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.PutAll<K2, V>(map)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> insertAll(final int position, final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.InsertAll<K2, V>(position, map)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> removeAllKeys(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K2, V>(keys)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K2, V>(eval)));
    }

    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K2, V>(eval)));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> removeAllKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K2, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> sort() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> sort(final Comparator<? super Entry<K2, V>> comparator) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    

    
    
    
	public <X,Y> Level2MapOfMapEntriesValueOperator<K1, X, Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        Validate.notNull(keyType, "A type representing the keys must be specified");
        Validate.notNull(valueType, "A type representing the values must be specified");
        NormalizationUtils.checkIsMapOfMapOfValue(keyType, valueType, get());
        return new Level2MapOfMapEntriesValueOperatorImpl<K1,X,Y,I>(getTarget());
    }


    public Level2MapOfMapEntriesValueOperator<K1, ?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifIndex(final int... indices) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNotNull() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNull() {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesValueSelectedOperator<K1, K2, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y,I> convert(final IConverter<? extends Map<X2, Y>, ? super Map<K2, V>> converter) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y,I> eval(final IEvaluator<? extends Map<X2, Y>, ? super Map<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public <X2, Y> Level2MapOfMapEntriesValueOperator<K1, X2, Y,I> exec(final IFunction<? extends Map<X2, Y>, ? super Map<K2, V>> function) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, X2, Y,I>(getTarget().execute(function, Normalization.MAP));
    }


    public <X> Level2MapEntriesValueOperator<K1, X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K2, V>> converter) {
        return new Level2MapEntriesValueOperatorImpl<K1, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K1, X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K2, V>> eval) {
        return new Level2MapEntriesValueOperatorImpl<K1, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K1, X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K2, V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K1, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> replaceWith(final Map<K2, V> replacement) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V,I> replaceIfNullWith(final Map<K2, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K1, Map<K2, V>>, I> createOperation() {
        return endOn().createOperation();
    }

    
    
}
