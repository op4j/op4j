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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1SetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1SetElementsOperator<T>  {

    
    public Level1SetElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<T> endFor() {
        return new Level0SetOperatorImpl<T>(getTarget().endIterate(null));
    }


    public <X> Level1SetElementsOperator<X> asType(final Type<X> type) {
    	return endFor().generic().asSetOf(type).forEach();
    }

    public Level1SetElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    
    
    
    
    
    
    

    public Set<T> get() {
        return endFor().get();
    }


    public Level1SetElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1SetElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T> ifNull() {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1SetElementsOperator<X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsOperator<T> replaceWith(final T replacement) {
        return new Level1SetElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
