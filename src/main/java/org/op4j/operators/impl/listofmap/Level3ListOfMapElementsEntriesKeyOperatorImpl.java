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
package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeySelectedOperator;
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
public class Level3ListOfMapElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3ListOfMapElementsEntriesKeyOperator<K,V>  {

    
    public Level3ListOfMapElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V> asType(final Type<X> type) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level3ListOfMapElementsEntriesKeyOperator<?,V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V> convert(final IConverter<X, ? super K> converter) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V> eval(final IEvaluator<X, ? super K> eval) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level3ListOfMapElementsEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
