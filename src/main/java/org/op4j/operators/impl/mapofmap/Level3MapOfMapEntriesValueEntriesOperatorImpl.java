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

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level3MapOfListEntriesValueElementsOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3MapOfMapEntriesValueEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl
        implements Level3MapOfMapEntriesValueEntriesOperator<K1,K2,V> {

    
    public Level3MapOfMapEntriesValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesValueOperator<K1, K2, V> endFor() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K1, K2, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level4MapOfMapEntriesValueEntriesKeyOperator<K1, K2, V> onKey() {
        return new Level4MapOfMapEntriesValueEntriesKeyOperatorImpl<K1, K2, V>(getTarget().iterateIndex(0));
    }


    public Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V> onValue() {
        return new Level4MapOfMapEntriesValueEntriesValueOperatorImpl<K1, K2, V>(getTarget().iterateIndex(1));
    }


    public Map<K1, Map<K2, V>> get() {
        return endFor().endOn().endFor().get();
    }

    
    
    
    public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> convert(final IConverter<X, ? super Entry<K2, V>> converter) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1,X>(getTarget().execute(converter));
	}


	public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> eval(final IEvaluator<X, ? super Entry<K2, V>> eval) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1,X>(getTarget().execute(eval));
	}


	public <X> Level3MapOfListEntriesValueElementsOperator<K1,X> exec(final IFunction<X, ? super Entry<K2, V>> function) {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K1,X>(getTarget().execute(function));
	}
    
    
    
}
