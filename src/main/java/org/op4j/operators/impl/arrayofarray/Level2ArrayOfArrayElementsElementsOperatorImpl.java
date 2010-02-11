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
package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Type<T> type; 

    
    public Level2ArrayOfArrayElementsElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> asType(final Type<X> elementType) {
        return endFor().endFor().asArrayOfArrayOf(elementType).forEach().forEach();
    }

    public Level2ArrayOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public T[][] get() {
        return endFor().endFor().get();
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> convert(final IConverter<? extends T, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> eval(final IEvaluator<? extends T, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> exec(final IFunction<? extends T, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> convert(final Type<X> newType, final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(newType, getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> eval(final Type<X> newType, final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(newType, getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> exec(final Type<X> newType, final IFunction<X, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(newType, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ArrayOfArrayElementsElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
