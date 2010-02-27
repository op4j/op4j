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
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,List<T>>, Level1ListSelectedElementsSelectedOperator<I,T> {


    public Level1ListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> endIf() {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,List<T>> get() {
        return endIf().get();
    }



}
