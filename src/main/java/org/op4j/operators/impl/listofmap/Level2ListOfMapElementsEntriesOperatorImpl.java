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
package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.listoflist.Level2ListOfListElementsElementsOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfMapElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2ListOfMapElementsEntriesOperator<K,V>  {

    
    public Level2ListOfMapElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapElementsOperator<K, V> endFor() {
        return new Level1ListOfMapElementsOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V> onKey() {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().iterateIndex(0));
    }


    public Level3ListOfMapElementsEntriesValueOperator<K, V> onValue() {
        return new Level3ListOfMapElementsEntriesValueOperatorImpl<K, V>(getTarget().iterateIndex(1));
    }


    public List<Map<K, V>> get() {
        return endFor().endFor().get();
    }

    
    

    
    public <X> Level2ListOfListElementsElementsOperator<X> convert(final IConverter<X, ? super Entry<K, V>> converter) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter));
	}


	public <X> Level2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super Entry<K, V>> eval) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval));
	}


	public <X> Level2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super Entry<K, V>> function) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(function));
	}
    
}
