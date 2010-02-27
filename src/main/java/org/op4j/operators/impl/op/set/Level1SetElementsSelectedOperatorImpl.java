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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetElementsSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,Set<T>>, Level1SetElementsSelectedOperator<I,T> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsOperatorImpl<I,T> endIf() {
        return new Level1SetElementsOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetElementsSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level1SetElementsSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
