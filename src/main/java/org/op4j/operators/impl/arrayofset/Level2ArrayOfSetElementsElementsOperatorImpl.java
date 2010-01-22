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
package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsSelectedOperator;
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
public class Level2ArrayOfSetElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2ArrayOfSetElementsElementsOperator<T,I>  {

    
    public Level2ArrayOfSetElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetElementsOperator<T,I> endFor() {
        return new Level1ArrayOfSetElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level2ArrayOfSetElementsElementsOperator<X,I> asType(final Type<X> type) {
        return endFor().endFor().generic().asArrayOfSetOf(type).forEach().forEach();
    }

    public Level2ArrayOfSetElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<T>[] get() {
        return endFor().endFor().get();
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfSetElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ArrayOfSetElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ArrayOfSetElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ArrayOfSetElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfSetElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfSetElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<T>[], I> createOperation() {
        return endFor().createOperation();
    }

}
