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
package org.op4j.operators.intf.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigableMapEntryOperator;
import org.op4j.operators.qualities.INavigatingMapOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapEntryOperator,
                IExecutableOperator<Map.Entry<K2,V>>,
                IEvaluableOperator<Map.Entry<K2,V>>,
                IConvertibleOperator<Map.Entry<K2,V>>,
		        INavigatingMapOperator<K2,V> {

    public ILevel4MapOfMapEntriesValueEntriesKeyOperator<K1,K2,V> onKey();
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> onValue();
    
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> endFor();
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K1,X> exec(final IFunction<X, ? super Map.Entry<K2,V>> function);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K1,X> eval(final IEvaluator<X,? super Map.Entry<K2,V>> eval);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K1,X> convert(final IConverter<X,? super Map.Entry<K2,V>> converter);
                                            
}
