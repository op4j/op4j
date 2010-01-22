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
package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfListElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2ArrayOfListElementsElementsOperator<T,I>  {

    
    public Level2ArrayOfListElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListElementsOperator<T,I> endFor() {
        return new Level1ArrayOfListElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level2ArrayOfListElementsElementsOperator<X,I> asType(final Type<X> type) {
        return endFor().endFor().asArrayOfListOf(type).forEach().forEach();
    }

    public Level2ArrayOfListElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<T>[] get() {
        return endFor().endFor().get();
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ArrayOfListElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ArrayOfListElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ArrayOfListElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T>[], I> createOperation() {
        return endFor().createOperation();
    }

}
