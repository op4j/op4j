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
package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(of, getTarget());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public T[][] get() {
        return endFor().endFor().get();
    }

}
