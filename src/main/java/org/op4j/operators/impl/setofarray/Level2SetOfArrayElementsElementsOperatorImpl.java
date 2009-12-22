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
import org.op4j.target.Target;
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
    
    private final Type<? super T> arrayOf; 

    
    public Level2SetOfArrayElementsElementsOperatorImpl(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public Level1SetOfArrayElementsOperator<T> endFor() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfArrayElementsElementsOperatorImpl<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> Level2SetOfArrayElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfArrayOf(type).forEach().forEach();
    }

    public Level2SetOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<T[]> get() {
        return endFor().endFor().get();
    }

}
