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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ArrayElementsOperatorImpl(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> Level1ArrayElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1ArrayElementsOperatorImpl<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public Level0ArrayOperator<T> endFor() {
        return new Level0ArrayOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> Level1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ArrayElementsOperatorImpl<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> Level1ArrayElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ArrayElementsOperatorImpl<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> Level1ArrayElementsOperator<X> asType(final Type<X> type) {
        return endFor().generic().asArrayOf(type).forEach();
    }

    public Level1ArrayElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1ArrayOfArrayElementsOperator<X> asArrayOf(final Type<X> type) {
        return endFor().generic().asArrayOfArrayOf(type).forEach();
    }


    public <X> Level1ArrayOfListElementsOperator<X> asListOf(final Type<X> type) {
        return endFor().generic().asArrayOfListOf(type).forEach();
    }


    public <K,V> Level1ArrayOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
        return endFor().generic().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type) {
        return endFor().generic().asArrayOfSetOf(type).forEach();
    }


    
    public Level1ArrayOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ArrayOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ArrayOfMapElementsOperator<?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    
    
    public T[] get() {
        return endFor().get();
    }


}
