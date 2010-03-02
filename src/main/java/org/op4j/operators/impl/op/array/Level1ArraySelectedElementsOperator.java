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
package org.op4j.operators.impl.op.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.array.ILevel1ArraySelectedElementsOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,T[]>, ILevel1ArraySelectedElementsOperator<I,T> {


    private final Type<T> type;


    public Level1ArraySelectedElementsOperator(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNull() {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNotNull() {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNotNull());
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifIndex(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> ifIndexNot(final int... indexes) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level0ArraySelectedOperator<I,T> endFor() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level1ArraySelectedElementsOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1ArraySelectedElementsOperator<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ArraySelectedElementsOperator<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsOperator<I,T> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsOperator<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endFor().get();
    }



}
