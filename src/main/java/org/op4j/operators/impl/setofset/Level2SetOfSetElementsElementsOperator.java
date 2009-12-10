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
package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.ILevel2SetOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfSetElementsElementsOperator<T>  {

    
    public Level2SetOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1SetOfSetElementsOperator<T> endFor() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfSetOf(type).forEach().forEach();
    }

    public ILevel2SetOfSetElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<Set<T>> get() {
        return endFor().endFor().get();
    }

}
