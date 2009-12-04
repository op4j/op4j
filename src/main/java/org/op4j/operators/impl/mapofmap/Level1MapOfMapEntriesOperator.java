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
package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfMapEntriesOperator<K1,K2,V> extends Operator
        implements ILevel1MapOfMapEntriesOperator<K1,K2,V> {

    
    public Level1MapOfMapEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOfMapOperator<K1, K2, V> endFor() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y, Z> ILevel1MapOfMapEntriesOperator<X, Y, Z> of(final Type<X> ofX, final Type<Y> ofY, final Type<Z> ofZ) {
        return new Level1MapOfMapEntriesOperator<X, Y, Z>(getTarget());
    }


    public ILevel2MapOfMapEntriesKeyOperator<K1, K2, V> onKey() {
        return new Level2MapOfMapEntriesKeyOperator<K1, K2, V>(getTarget().iterate(0));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> onValue() {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().iterate(1));
    }


    public ILevel1MapOfMapEntriesOperator<?, ?, ?> raw() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget());
    }


    public Map<K1, Map<K2, V>> get() {
        return endFor().get();
    }

    
    
    
    
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super Entry<K1, Map<K2,V>>> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
	}


	public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
	}


	public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super Entry<K1, Map<K2,V>>> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
	}
    
    
}
