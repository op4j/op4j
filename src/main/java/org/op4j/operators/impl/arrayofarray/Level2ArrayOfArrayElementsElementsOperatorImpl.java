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
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperatorImpl(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public Level1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperatorImpl<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> Level2ArrayOfArrayElementsElementsOperator<X> asType(final Type<X> type) {
        return endFor().endFor().asArrayOfArrayOf(type).forEach().forEach();
    }

    public Level2ArrayOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public T[][] get() {
        return endFor().endFor().get();
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }

}
