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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel0ArrayOperator<T> endFor() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel1ArrayElementsOperator<X> asType(final Type<X> type) {
        return endFor().generic().asArray(type).forEach();
    }

    public ILevel1ArrayElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> ILevel1ArrayOfArrayElementsOperator<X> asArray(final Type<X> of) {
        return endFor().generic().asArrayOfArray(of).forEach();
    }


    public <X> ILevel1ArrayOfListElementsOperator<X> asList(final Type<X> of) {
        return endFor().generic().asArrayOfList(of).forEach();
    }


    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf) {
        return endFor().generic().asArrayOfMap(keyOf, valueOf).forEach();
    }


    public <X> ILevel1ArrayOfSetElementsOperator<X> asSet(final Type<X> of) {
        return endFor().generic().asArrayOfSet(of).forEach();
    }


    
    public ILevel1ArrayOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArray(Types.OBJECT);
    }


    public ILevel1ArrayOfListElementsOperator<?> asListOfUnknown() {
        return asList(Types.OBJECT);
    }


    public ILevel1ArrayOfMapElementsOperator<?, ?> asMapOfUnknown() {
        return asMap(Types.OBJECT, Types.OBJECT);
    }


    public ILevel1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSet(Types.OBJECT);
    }
    
    
    
    
    public T[] get() {
        return endFor().get();
    }


}
