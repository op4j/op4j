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
package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfListElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfListElementsElementsOperator<T>  {

    
    public Level2ListOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1ListOfListElementsOperator<T> endFor() {
        return new Level1ListOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> asType(final Type<X> type) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget());
    }

    public ILevel2ListOfListElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public List<List<T>> get() {
        return endFor().endFor().get();
    }

}
