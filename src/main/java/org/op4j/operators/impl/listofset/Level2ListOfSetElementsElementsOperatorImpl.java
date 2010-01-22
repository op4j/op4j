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
package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsSelectedOperator;
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
public class Level2ListOfSetElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2ListOfSetElementsElementsOperator<T,I>  {

    
    public Level2ListOfSetElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetElementsOperator<T,I> endFor() {
        return new Level1ListOfSetElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X,I> asType(final Type<X> type) {
    	return endFor().endFor().asListOfSetOf(type).forEach().forEach();
    }

    public Level2ListOfSetElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<Set<T>> get() {
        return endFor().endFor().get();
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfSetElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfSetElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<Set<T>>, I> createOperation() {
        return endFor().createOperation();
    }

}
