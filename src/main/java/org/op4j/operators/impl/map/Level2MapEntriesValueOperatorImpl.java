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
import org.op4j.operations.Operation;
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
public class Level2MapEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level2MapEntriesValueOperator<K,V,I> {

    
    public Level2MapEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K, V,I> endOn() {
        return new Level1MapEntriesOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfValue(type, get());
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget());
    }

    public Level2MapEntriesValueOperator<K, ?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level2MapOfArrayEntriesValueOperator<K,X,I> asArrayOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfArrayOfValue(type, get());
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X,I>(getTarget());
    }


    public <X> Level2MapOfListEntriesValueOperator<K,X,I> asListOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfListOfValue(type, get());
        return new Level2MapOfListEntriesValueOperatorImpl<K,X,I>(getTarget());
    }


    public <K2,V2> Level2MapOfMapEntriesValueOperator<K,K2,V2,I> asMapOf(final Type<K2> keyType, final Type<V2> valueType) {
        Validate.notNull(keyType, "A type representing the keys must be specified");
        Validate.notNull(valueType, "A type representing the values must be specified");
        NormalizationUtils.checkIsMapOfMapOfValue(keyType, valueType, get());
        return new Level2MapOfMapEntriesValueOperatorImpl<K,K2,V2,I>(getTarget());
    }


    public <X> Level2MapOfSetEntriesValueOperator<K,X,I> asSetOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfSetOfValue(type, get());
        return new Level2MapOfSetEntriesValueOperatorImpl<K,X,I>(getTarget());
    }

    
    

    public Level2MapOfArrayEntriesValueOperator<K, ?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level2MapOfListEntriesValueOperator<K, ?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level2MapOfMapEntriesValueOperator<K, ?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level2MapOfSetEntriesValueOperator<K, ?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    
    
    
    
    
    
    
    
    
    

    public Map<K, V> get() {
        return endOn().endFor().get();
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNull() {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesValueSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> convert(final IConverter<X, ? super V> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> eval(final IEvaluator<X, ? super V> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> exec(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapEntriesValueOperator<K, V,I> replaceWith(final V replacement) {
        return new Level2MapEntriesValueOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapEntriesValueOperator<K, V,I> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, V>, I> createOperation() {
        return endOn().createOperation();
    }

}
