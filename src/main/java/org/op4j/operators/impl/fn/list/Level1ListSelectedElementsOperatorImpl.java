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
package org.op4j.operators.impl.fn.list;

import java.util.List;

import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,List<T>>, Level1ListSelectedElementsOperator<I,T> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListSelectedOperatorImpl<I,T> endFor() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,List<T>> get() {
        return endFor().get();
    }



}
