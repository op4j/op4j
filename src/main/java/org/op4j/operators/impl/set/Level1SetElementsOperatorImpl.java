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
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public class Level1SetElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1SetElementsOperator<T,I>  {

    
    public Level1SetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<T,I> endFor() {
        return new Level0SetOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> Level1SetElementsOperator<X,I> asType(final Type<X> type) {
    	return endFor().generic().asSetOf(type).forEach();
    }

    public Level1SetElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public <X> Level1SetOfArrayElementsOperator<X,I> asArrayOf(final Type<X> type) {
    	return endFor().generic().asSetOfArrayOf(type).forEach();
    }


    public <X> Level1SetOfListElementsOperator<X,I> asListOf(final Type<X> type) {
    	return endFor().generic().asSetOfListOf(type).forEach();
    }


    public <K,V> Level1SetOfMapElementsOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType) {
    	return endFor().generic().asSetOfMapOf(keyType, valueType).forEach();
    }


    public <X> Level1SetOfSetElementsOperator<X,I> asSetOf(final Type<X> type) {
    	return endFor().generic().asSetOfSetOf(type).forEach();
    }
    

    
    
    public Level1SetOfArrayElementsOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level1SetOfListElementsOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level1SetOfMapElementsOperator<?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1SetOfSetElementsOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }

    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }


    public Level1SetElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetElementsOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<T>, I> createOperation() {
        return endFor().createOperation();
    }

    
    
}
