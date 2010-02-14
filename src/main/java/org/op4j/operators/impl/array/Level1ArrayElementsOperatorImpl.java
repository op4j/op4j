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
package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1ArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayElementsOperator<T> {
    
    private final Type<T> type; 

    
    public Level1ArrayElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }



    public Level0ArrayOperator<T> endFor() {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public <X> Level1ArrayElementsOperator<X> asType(final Type<X> elementType) {
        return endFor().generic().asArrayOf(elementType).forEach();
    }

    public Level1ArrayElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1ArrayOfArrayElementsOperator<X> asArrayOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfArrayOf(elementType).forEach();
    }


    public <X> Level1ArrayOfListElementsOperator<X> asListOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfListOf(elementType).forEach();
    }


    public <K,V> Level1ArrayOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return endFor().generic().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfSetOf(elementType).forEach();
    }


    
    public Level1ArrayOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ArrayOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ArrayOfMapElementsOperator<?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    
    
    public T[] get() {
        return endFor().get();
    }


    public Level1ArrayElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArrayElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1ArrayElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }



    public Level1ArrayElementsOperator<T> convert(final IConverter<? extends T, ? super T> converter) {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }



    public Level1ArrayElementsOperator<T> eval(final IEvaluator<? extends T, ? super T> eval) {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }



    public Level1ArrayElementsOperator<T> exec(final IFunction<? extends T, ? super T> function) {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> convert(final Type<X> newType, final IConverter<X, ? super T> converter) {
        return new Level1ArrayElementsOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.NONE));
    }



    public <X> Level1ArrayElementsOperator<X> eval(final Type<X> newType, final IEvaluator<X, ? super T> eval) {
        return new Level1ArrayElementsOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.NONE));
    }



    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level1ArrayElementsOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.NONE));
    }



    public Level1ArrayElementsOperator<T> replaceWith(final T replacement) {
        return new Level1ArrayElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }



    public Level1ArrayElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    


}
