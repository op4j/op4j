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
package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesKeySelectedOperator;
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
public class Level3ArrayOfMapElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3ArrayOfMapElementsEntriesKeyOperator<K,V>  {

    
    public Level3ArrayOfMapElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsArrayOfMapOfKey(type, get());
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget());
    }

    public Level3ArrayOfMapElementsEntriesKeyOperator<?,V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V>[] get() {
        return endOn().endFor().endFor().get();
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalization.NONE));
    }

}
