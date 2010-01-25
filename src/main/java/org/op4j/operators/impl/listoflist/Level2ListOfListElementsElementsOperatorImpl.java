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
package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsSelectedOperator;
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
public class Level2ListOfListElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2ListOfListElementsElementsOperator<T>  {

    
    public Level2ListOfListElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListElementsOperator<T> endFor() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asListOfListOf(type).forEach().forEach();
    }

    public Level2ListOfListElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<List<T>> get() {
        return endFor().endFor().get();
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfListElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfListElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfListElementsElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
