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
package org.op4j.operators.impl.fn.set;

import java.util.Set;

import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,Set<T>>, Level1SetSelectedElementsOperator<I,T> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifIndex(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1SetSelectedElementsSelectedOperatorImpl<I,T> ifIndexNot(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetSelectedOperatorImpl<I,T> endFor() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().endIterate(null));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,Set<T>> get() {
        return endFor().get();
    }



}
