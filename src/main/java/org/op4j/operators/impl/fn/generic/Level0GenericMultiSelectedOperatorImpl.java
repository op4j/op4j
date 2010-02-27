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
package org.op4j.operators.impl.fn.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.operators.qualities.MultiFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level0GenericMultiSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements MultiFnOperator<I,T>, Level0GenericMultiSelectedOperator<I,T> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiOperatorImpl<I,T> endIf() {
        return new Level0GenericMultiOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> execIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> exec(final IFunction<? super T,? extends T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0GenericMultiSelectedOperatorImpl<I,T> replaceWith(final T replacement) {
        return new Level0GenericMultiSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,List<T>> getAsList() {
        return endIf().buildList().get();
    }


    public Function<I,T[]> getAsArrayOf(final Type<T> type) {
        return endIf().buildArrayOf(type).get();
    }


    public int size() {
        return endIf().size();
    }



}
