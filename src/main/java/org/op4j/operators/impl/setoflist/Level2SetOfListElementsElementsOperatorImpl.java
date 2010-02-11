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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfListElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2SetOfListElementsElementsOperator<T>  {

    
    public Level2SetOfListElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListElementsOperator<T> endFor() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfListOf(type).forEach().forEach();
    }

    public Level2SetOfListElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfListElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfListElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2SetOfListElementsElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
