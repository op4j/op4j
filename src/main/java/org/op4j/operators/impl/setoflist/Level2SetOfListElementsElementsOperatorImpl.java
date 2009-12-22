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
package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfListElementsElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level2SetOfListElementsElementsOperator<T>  {

    
    public Level2SetOfListElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public <X> Level2SetOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter));
    }



    public Level1SetOfListElementsOperator<T> endFor() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfListElementsElementsOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level2SetOfListElementsElementsOperator<X> asType(final Type<X> type) {
    	return endFor().endFor().generic().asSetOfListOf(type).forEach().forEach();
    }

    public Level2SetOfListElementsElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }

}
