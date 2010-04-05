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
package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel2MapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesValueSelectedOperator<I,K,V> extends AbstractOperator implements UniqFnOperator<I,Map<K,V>>, ILevel2MapSelectedEntriesValueSelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesValueSelectedOperator(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueOperator<I,K,V> endIf() {
        return new Level2MapSelectedEntriesValueOperator<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesValueSelectedOperator<I,K,V> exec(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperator<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<I,K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesValueSelectedOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Function<I,Map<K,V>> get() {
        return endIf().get();
    }



}
