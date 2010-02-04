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
package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfArrayElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2ListOfArrayElementsElementsOperator<T>  {
    
    private final Type<? extends T> type; 

    
    public Level2ListOfArrayElementsElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ListOfArrayElementsOperator<T> endFor() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public <X> Level2ListOfArrayElementsElementsOperator<X> asType(final Type<X> elementType) {
    	return endFor().endFor().generic().asListOfArrayOf(elementType).forEach().forEach(elementType);
    }

    public Level2ListOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<T[]> get() {
        return endFor().endFor().get();
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indices));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2ListOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfArrayElementsElementsOperatorImpl<X>(converter.getResultType(this.type), getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2ListOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperatorImpl<X>(eval.getResultType(this.type), getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2ListOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfArrayElementsElementsOperatorImpl<X>(function.getResultType(this.type), getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfArrayElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfArrayElementsElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2ListOfArrayElementsElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

}
