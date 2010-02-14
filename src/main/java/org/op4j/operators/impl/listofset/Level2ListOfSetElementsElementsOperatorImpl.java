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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level2ListOfSetElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2ListOfSetElementsElementsOperator<T>  {

    
    public Level2ListOfSetElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetElementsOperator<T> endFor() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().asListOfSetOf(type).forEach().forEach();
    }

    public Level2ListOfSetElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<Set<T>> get() {
        return endFor().endFor().get();
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2ListOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfSetElementsElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfSetElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfSetElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ListOfSetElementsElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
