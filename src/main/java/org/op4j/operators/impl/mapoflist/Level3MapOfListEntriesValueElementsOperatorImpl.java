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
package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsSelectedOperator;
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
public class Level3MapOfListEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3MapOfListEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfListEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().endIterate(null));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> asType(final Type<X> type) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level3MapOfListEntriesValueElementsOperator<K, ?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNull() {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNull() {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListEntriesValueElementsSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level3MapOfListEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfListEntriesValueElementsOperator<K, V> replaceWith(final V replacement) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3MapOfListEntriesValueElementsOperator<K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
