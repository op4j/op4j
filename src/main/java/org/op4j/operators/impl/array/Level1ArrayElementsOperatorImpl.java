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
package org.op4j.operators.impl.array;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
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
public class Level1ArrayElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ArrayElementsOperator<T,I> {
    
    private final Type<? extends T> type; 

    
    public Level1ArrayElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }



    public Level0ArrayOperator<T,I> endFor() {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public <X> Level1ArrayElementsOperator<X,I> asType(final Type<X> elementType) {
        return endFor().generic().asArrayOf(elementType).forEach(elementType);
    }

    public Level1ArrayElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1ArrayOfArrayElementsOperator<X,I> asArrayOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfArrayOf(elementType).forEach(Types.arrayOf(elementType));
    }


    public <X> Level1ArrayOfListElementsOperator<X,I> asListOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfListOf(elementType).forEach();
    }


    public <K,V> Level1ArrayOfMapElementsOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return endFor().generic().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1ArrayOfSetElementsOperator<X,I> asSetOf(final Type<X> elementType) {
        return endFor().generic().asArrayOfSetOf(elementType).forEach();
    }


    
    public Level1ArrayOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ArrayOfListElementsOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ArrayOfMapElementsOperator<?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ArrayOfSetElementsOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    
    
    public T[] get() {
        return endFor().get();
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }



    public <X> Level1ArrayElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level1ArrayElementsOperatorImpl<X,I>(converter.getResultType(this.type), getTarget().execute(converter, Normalization.NONE));
    }



    public <X> Level1ArrayElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ArrayElementsOperatorImpl<X,I>(eval.getResultType(this.type), getTarget().execute(eval, Normalization.NONE));
    }



    public <X> Level1ArrayElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level1ArrayElementsOperatorImpl<X,I>(function.getResultType(this.type), getTarget().execute(function, Normalization.NONE));
    }



    public Level1ArrayElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1ArrayElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }



    public Level1ArrayElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    public Operation<T[], I> createOperation() {
        return endFor().createOperation();
    }


}
