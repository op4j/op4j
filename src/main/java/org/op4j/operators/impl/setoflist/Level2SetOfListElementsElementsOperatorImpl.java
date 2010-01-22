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
package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsSelectedOperator;
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
public class Level2SetOfListElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level2SetOfListElementsElementsOperator<T,I>  {

    
    public Level2SetOfListElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListElementsOperator<T,I> endFor() {
        return new Level1SetOfListElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level2SetOfListElementsElementsOperator<X,I> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfListOf(type).forEach().forEach();
    }

    public Level2SetOfListElementsElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2SetOfListElementsElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2SetOfListElementsElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2SetOfListElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListElementsElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<List<T>>, I> createOperation() {
        return endFor().createOperation();
    }

}
