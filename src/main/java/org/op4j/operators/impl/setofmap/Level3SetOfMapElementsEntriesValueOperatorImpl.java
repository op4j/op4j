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
package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3SetOfMapElementsEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3SetOfMapElementsEntriesValueOperator<K,V>  {

    
    public Level3SetOfMapElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2SetOfMapElementsEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level3SetOfMapElementsEntriesValueOperator<K, X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsSetOfMapOfValue(type, get());
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K, X>(getTarget());
    }

    public Level3SetOfMapElementsEntriesValueOperator<K,?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3SetOfMapElementsEntriesValueOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3SetOfMapElementsEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3SetOfMapElementsEntriesValueOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3SetOfMapElementsEntriesValueOperator<K, V> replaceWith(final V replacement) {
        return new Level3SetOfMapElementsEntriesValueOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsEntriesValueOperator<K, V> replaceIfNullWith(final V replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
