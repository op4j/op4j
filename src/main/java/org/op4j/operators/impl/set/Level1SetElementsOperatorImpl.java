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
package org.op4j.operators.impl.set;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetElementsOperator<T>  {

    
    public Level1SetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public <X> Level1SetElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(converter));
    }



    public Level0SetOperator<T> endFor() {
        return new Level0SetOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level1SetElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function));
    }


    public <X> Level1SetElementsOperator<X> asType(final Type<X> type) {
    	return endFor().generic().asSetOf(type).forEach();
    }

    public Level1SetElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1SetOfArrayElementsOperator<X> asArrayOf(final Type<X> type) {
    	return endFor().generic().asSetOfArrayOf(type).forEach();
    }


    public <X> Level1SetOfListElementsOperator<X> asListOf(final Type<X> type) {
    	return endFor().generic().asSetOfListOf(type).forEach();
    }


    public <K,V> Level1SetOfMapElementsOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
    	return endFor().generic().asSetOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1SetOfSetElementsOperator<X> asSetOf(final Type<X> type) {
    	return endFor().generic().asSetOfSetOf(type).forEach();
    }
    

    
    
    public Level1SetOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1SetOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1SetOfMapElementsOperator<?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1SetOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }

    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }

    
    
}
