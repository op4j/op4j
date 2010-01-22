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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1ListElementsOperator<T,I>  {

    
    public Level1ListElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOperator<T,I> endFor() {
        return new Level0ListOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> Level1ListElementsOperator<X,I> asType(final Type<X> type) {
        return endFor().generic().asListOf(type).forEach();
    }

    public Level1ListElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1ListOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type) {
    	return endFor().generic().asListOfArrayOf(type).forEach();
    }


    public <X> Level1ListOfListElementsOperator<X,I> asListOf(final Type<X> type) {
    	return endFor().generic().asListOfListOf(type).forEach();
    }


    public <K,V> Level1ListOfMapElementsOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType) {
    	return endFor().generic().asListOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1ListOfSetElementsOperator<X,I> asSetOf(final Type<X> type) {
    	return endFor().generic().asListOfSetOf(type).forEach();
    }
    


    public Level1ListOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1ListOfListElementsOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1ListOfMapElementsOperator<?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ListOfSetElementsOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }

    
    
    
    
    
    
    
    public List<T> get() {
        return endFor().get();
    }


    public Level1ListElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ListElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1ListElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1ListElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T>, I> createOperation() {
        return endFor().createOperation();
    }
    
}
