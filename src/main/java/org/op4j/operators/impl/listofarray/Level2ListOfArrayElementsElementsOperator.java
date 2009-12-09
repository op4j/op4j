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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfArrayElementsElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ListOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfArrayElementsElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel1ListOfArrayElementsOperator<T> endFor() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfArrayElementsElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asListOfArray(type).forEach().forEach();
    }

    public ILevel2ListOfArrayElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<T[]> get() {
        return endFor().endFor().get();
    }

}
