/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.impl.op.list;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1ListElementsOperator<I,T> extends AbstractOperator
        implements UniqOpOperator<I,List<T>>, ILevel1ListElementsOperator<I,T>  {

    
    public Level1ListElementsOperator(final Target target) {
        super(target);
    }


    public Level0ListOperator<I,T> endFor() {
        return new Level0ListOperator<I,T>(getTarget().endIterate(null));
    }


    public <X> Level1ListElementsOperator<I,X> castTo(final Type<X> type) {
        return endFor().generic().castToListOf(type).forEach();
    }

    

    
    
    
    
    
    
    
    public List<T> get() {
        return endFor().get();
    }


    public Level1ListElementsSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1ListElementsSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level1ListElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListElementsSelectedOperator<I,T> ifNotNull() {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    


    


    public Level1ListElementsSelectedOperator<I,T> ifNull() {
        return new Level1ListElementsSelectedOperator<I,T>(getTarget().selectNull());
    }


    


    



    public <X> Level1ListElementsOperator<I,X> exec(final IFunction<? super T,X> function) {
        return new Level1ListElementsOperator<I,X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListElementsOperator<I,T> replaceWith(final T replacement) {
        return new Level1ListElementsOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListElementsOperator<I,T> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
    

    public Level1ListElementsOperator<I,T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfFalse(eval, function, null, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<I,X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfFalse(eval, function, elseFunction, Normalisation.NONE));
    }


    public Level1ListElementsOperator<I,T> execIfIndex(final int[] indexes, final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfIndex(indexes, function, null, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<I,X> execIfIndex(final int[] indexes, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfIndex(indexes, function, elseFunction, Normalisation.NONE));
    }


    public Level1ListElementsOperator<I,T> execIfIndexNot(final int[] indexes, final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfIndexNot(indexes, function, null, Normalisation.NONE));
    }


    public <X> Level1ListElementsOperator<I,X> execIfIndexNot(final int[] indexes, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfIndexNot(indexes, function, elseFunction, Normalisation.NONE));
    }


    
    public Level1ListElementsOperator<I, T> execIfNotNull(final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfNotNull(function, null, Normalisation.NONE));
    }
    
    

    public <X> Level1ListElementsOperator<I,X> execIfNotNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfNotNull(function, elseFunction, Normalisation.NONE));
    }



    public Level1ListElementsOperator<I,T> execIfNull(final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfNull(function, null, Normalisation.NONE));
    }



    public <X> Level1ListElementsOperator<I,X> execIfNull(final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfNull(function, elseFunction, Normalisation.NONE));
    }



    public Level1ListElementsOperator<I,T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, ? extends T> function) {
        return new Level1ListElementsOperator<I,T>(getTarget().executeIfTrue(eval, function, null, Normalisation.NONE));
    }



    public <X> Level1ListElementsOperator<I,X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T, X> function, final IFunction<? super T, X> elseFunction) {
        return new Level1ListElementsOperator<I,X>(getTarget().executeIfTrue(eval, function, elseFunction, Normalisation.NONE));
    }


    
}
