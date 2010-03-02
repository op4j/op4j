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
package org.op4j.operators.impl.op.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapEntriesSelectedOperator<I,K,V> extends AbstractOperator implements UniqOpOperator<I,Map<K,V>>, ILevel1MapEntriesSelectedOperator<I,K,V> {


    public Level1MapEntriesSelectedOperator(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<I,K,V> endIf() {
        return new Level1MapEntriesOperator<I,K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeyOperator<I,K,V> onKey() {
        return new Level2MapEntriesSelectedKeyOperator<I,K,V>(getTarget().onKey());
    }


    public Level2MapEntriesSelectedValueOperator<I,K,V> onValue() {
        return new Level2MapEntriesSelectedValueOperator<I,K,V>(getTarget().onValue());
    }


    public Level1MapEntriesSelectedOperator<I,K,V> execAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapEntriesSelectedOperator<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<I,K,V> execIfNotNullAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapEntriesSelectedOperator<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapEntriesSelectedOperator<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
