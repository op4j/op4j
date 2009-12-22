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
package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level2ArrayOfListElementsElementsOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfMapElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2ArrayOfMapElementsEntriesOperator<K,V>  {

    
    public Level2ArrayOfMapElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapElementsOperator<K, V> endFor() {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3ArrayOfMapElementsEntriesKeyOperator<K, V> onKey() {
        return new Level3ArrayOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().iterateIndex(0));
    }


    public Level3ArrayOfMapElementsEntriesValueOperator<K, V> onValue() {
        return new Level3ArrayOfMapElementsEntriesValueOperatorImpl<K, V>(getTarget().iterateIndex(1));
    }


    public Map<K, V>[] get() {
        return endFor().endFor().get();
    }

    

    
    public <X> Level2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X, ? super Entry<K, V>> converter) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter));
	}


	public <X> Level2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super Entry<K, V>> eval) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval));
	}


	public <X> Level2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super Entry<K, V>> function) {
        return new Level2ArrayOfListElementsElementsOperatorImpl<X>(getTarget().execute(function));
	}
    
    
}
