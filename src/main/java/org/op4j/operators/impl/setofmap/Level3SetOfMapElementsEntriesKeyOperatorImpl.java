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
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeySelectedOperator;
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
public class Level3SetOfMapElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3SetOfMapElementsEntriesKeyOperator<K,V>  {

    
    public Level3SetOfMapElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2SetOfMapElementsEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level3SetOfMapElementsEntriesKeyOperator<X, V> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().cast(CastType.SET_OF_MAP_KEY, type));
    }

    public Level3SetOfMapElementsEntriesKeyOperator<?,V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3SetOfMapElementsEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level3SetOfMapElementsEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level3SetOfMapElementsEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3SetOfMapElementsEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
