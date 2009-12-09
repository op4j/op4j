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
package org.op4j.operators.impl.list;

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListElementsOperator<T> extends Operator
        implements ILevel1ListElementsOperator<T>  {

    
    public Level1ListElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel0ListOperator<T> endFor() {
        return new Level0ListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel1ListElementsOperator<X> asType(final Type<X> type) {
        return endFor().generic().asList(type).forEach();
    }

    public ILevel1ListElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> ILevel1ListOfArrayElementsOperator<X> asArray(final Type<X> of) {
    	return endFor().generic().asListOfArray(of).forEach();
    }


    public <X> ILevel1ListOfListElementsOperator<X> asList(final Type<X> of) {
    	return endFor().generic().asListOfList(of).forEach();
    }


    public <K,V> ILevel1ListOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf) {
    	return endFor().generic().asListOfMap(keyOf, valueOf).forEach();
    }


    public <X> ILevel1ListOfSetElementsOperator<X> asSet(final Type<X> of) {
    	return endFor().generic().asListOfSet(of).forEach();
    }
    


    public ILevel1ListOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArray(Types.OBJECT);
    }


    public ILevel1ListOfListElementsOperator<?> asListOfUnknown() {
        return asList(Types.OBJECT);
    }


    public ILevel1ListOfMapElementsOperator<?, ?> asMapOfUnknown() {
        return asMap(Types.OBJECT, Types.OBJECT);
    }


    public ILevel1ListOfSetElementsOperator<?> asSetOfUnknown() {
        return asSet(Types.OBJECT);
    }

    
    
    
    
    
    
    
    public List<T> get() {
        return endFor().get();
    }
    
}
