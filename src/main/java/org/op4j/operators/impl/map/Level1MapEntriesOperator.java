/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesKeyOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapEntriesOperator<K,V> extends Operator
        implements ILevel1MapEntriesOperator<K,V> {

    
    public Level1MapEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOperator<K, V> endFor() {
        return new Level0MapOperator<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel1MapEntriesOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level1MapEntriesOperator<X, Y>(getTarget());
    }


    public ILevel2MapEntriesKeyOperator<K, V> onKey() {
        return new Level2MapEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel2MapEntriesValueOperator<K, V> onValue() {
        return new Level2MapEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel1MapEntriesOperator<?, ?> raw() {
        return new Level1MapEntriesOperator<K, V>(getTarget());
    }


    public Map<K, V> get() {
        return endFor().get();
    }



    
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super Entry<K, V>> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
	}


	public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super Entry<K, V>> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
	}


	public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super Entry<K, V>> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
	}

}
