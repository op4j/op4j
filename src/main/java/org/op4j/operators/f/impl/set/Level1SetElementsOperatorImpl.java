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
package org.op4j.operators.f.impl.set;

import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.set.Level0SetOperator;
import org.op4j.operators.op.intf.set.Level1SetElementsOperator;
import org.op4j.operators.op.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1SetElementsOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level1SetElementsOperator<T,I>  {

    
    public Level1SetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<T,I> endFor() {
        return new Level0SetOperatorImpl<T,I>(getTarget().endIterate(null));
    }


    public <X> Level1SetElementsOperator<X,I> asType(final Type<X> type) {
    	return endFor().generic().asSetOf(type).forEach();
    }

    public Level1SetElementsOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }


    public Level1SetElementsSelectedOperator<T,I> ifIndex(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level1SetElementsSelectedOperator<T,I> ifIndexNot(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetElementsOperator<X,I> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
