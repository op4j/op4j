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
package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsSelectedOperator;
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
public class Level2SetOfSetElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2SetOfSetElementsElementsOperator<T,I>  {

    
    public Level2SetOfSetElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetElementsOperator<T,I> endFor() {
        return new Level1SetOfSetElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level2SetOfSetElementsElementsOperator<X,I> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfSetOf(type).forEach().forEach();
    }

    public Level2SetOfSetElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<Set<T>> get() {
        return endFor().endFor().get();
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2SetOfSetElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2SetOfSetElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2SetOfSetElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfSetElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfSetElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfSetElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<Set<T>>, I> createOperation() {
        return endFor().createOperation();
    }

}
