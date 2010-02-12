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

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.map.Level2MapEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapEntriesValueOperator<K,V> {

    
    public Level2MapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level2MapEntriesValueOperator<K, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level2MapEntriesValueOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level2MapOfArrayEntriesValueOperator<K,X> asArrayOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X>(type, getTarget().cast(CastType.ARRAY, type));
    }


    public <X> Level2MapOfListEntriesValueOperator<K,X> asListOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapOfListEntriesValueOperatorImpl<K,X>(getTarget().cast(CastType.LIST, type));
    }


    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2> asMapOf(final Type<K2> keyType, final Type<V2> valueType) {
        Validate.notNull(keyType, "A type representing the keys must be specified");
        Validate.notNull(valueType, "A type representing the values must be specified");
        return new Level2MapOfMapEntriesValueOperatorImpl<K,K2,V2>(getTarget().cast(CastType.MAP, keyType, valueType));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K,X> asSetOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapOfSetEntriesValueOperatorImpl<K,X>(getTarget().cast(CastType.SET, type));
    }

    
    

    public Level2MapOfArrayEntriesValueOperator<K, ?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level2MapOfListEntriesValueOperator<K, ?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level2MapOfMapEntriesValueOperator<K, ?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level2MapOfSetEntriesValueOperator<K, ?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesValueOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<K, V> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
