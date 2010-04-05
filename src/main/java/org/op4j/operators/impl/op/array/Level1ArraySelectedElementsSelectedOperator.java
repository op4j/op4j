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
import org.op4j.operators.intf.array.ILevel1ArraySelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ArraySelectedElementsSelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,T[]>, ILevel1ArraySelectedElementsSelectedOperator<I,T> {


    private final Type<T> type;


    public Level1ArraySelectedElementsSelectedOperator(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperator<I,T> endIf() {
        return new Level1ArraySelectedElementsOperator<I,T>(this.type, getTarget().endSelect());
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArraySelectedElementsSelectedOperator<I,T> replaceWith(final T replacement) {
        return new Level1ArraySelectedElementsSelectedOperator<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[] get() {
        return endIf().get();
    }



}
