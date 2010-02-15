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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesKeySelectedOperator;
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
public final class Level3ArrayOfMapElementsEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level3ArrayOfMapElementsEntriesKeyOperator<K,V>  {

    
    public Level3ArrayOfMapElementsEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> asType(final Type<X> type) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().cast(CastType.OBJECT, type));
    }

    public Level3ArrayOfMapElementsEntriesKeyOperator<?,V> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Map<K, V>[] get() {
        return endOn().endFor().endFor().get();
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNull() {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNull() {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapElementsEntriesKeySelectedOperator<K, V> ifNullOrFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ArrayOfMapElementsEntriesKeySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> execIfNotNull(final IFunction<X, ? super K> function) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level3ArrayOfMapElementsEntriesKeyOperator<X, V> exec(final IFunction<X, ? super K> function) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<X, V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsEntriesKeyOperator<K, V> replaceWith(final K replacement) {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsEntriesKeyOperator<K, V> replaceIfNullWith(final K replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
