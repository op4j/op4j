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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1ListElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ListElementsOperator<T>  {

    
    public Level1ListElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOperator<T> endFor() {
        return new Level0ListOperatorImpl<T>(getTarget().endIterate(null));
    }


    public <X> Level1ListElementsOperator<X> asType(final Type<X> type) {
        return endFor().generic().asListOf(type).forEach();
    }

    public Level1ListElementsOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }

    
    
    
    
    
    
    
    public List<T> get() {
        return endFor().get();
    }


    public Level1ListElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ListElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T> ifNull() {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ListElementsOperator<X> execIfNotNull(final IFunction<X, ? super T> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListElementsOperator<T> replaceWith(final T replacement) {
        return new Level1ListElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListElementsOperator<T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
}
