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
package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsElementsSelectedOperator;
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
public class Level2SetOfArrayElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2SetOfArrayElementsElementsOperator<T>  {
    
    private final Type<? extends T> type; 

    
    public Level2SetOfArrayElementsElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1SetOfArrayElementsOperator<T> endFor() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> asType(final Type<X> elementType) {
    	return endFor().endFor().generic().asSetOfArrayOf(elementType).forEach().forEach(elementType);
    }

    public Level2SetOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<T[]> get() {
        return endFor().endFor().get();
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indices));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(function.getResultType(this.type), getTarget().execute(function, Normalization.NONE));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(converter.getResultType(this.type), getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(eval.getResultType(this.type), getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfArrayElementsElementsOperator<T> replaceBy(final T replacement) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().replaceBy(replacement));
    }


    public Level2SetOfArrayElementsElementsOperator<T> replaceIfNullBy(final T replacement) {
        return ifNull().replaceBy(replacement).endIf();
    }

}
