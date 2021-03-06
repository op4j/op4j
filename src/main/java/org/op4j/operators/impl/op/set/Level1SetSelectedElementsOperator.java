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
package org.op4j.operators.impl.op.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.set.ILevel1SetSelectedElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,Set<T>>, ILevel1SetSelectedElementsOperator<I,T> {


    public Level1SetSelectedElementsOperator(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNull() {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectIndex(indexes));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetSelectedOperator<I,T> endFor() {
        return new Level0SetSelectedOperator<I,T>(getTarget().endIterate(null));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1SetSelectedElementsSelectedOperator<I,T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetSelectedElementsOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1SetSelectedElementsOperator<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperator<I,T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }



}
