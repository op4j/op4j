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
package org.op4j.operators.intf.listofmap;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigableMapEntryOperator;
import org.op4j.operators.qualities.INavigatingMapOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2ListOfMapElementsEntriesOperator<K,V> 
		extends IUniqOperator<List<Map<K,V>>>,
		        INavigableMapEntryOperator,
                INavigatingMapOperator<K,V>,
                IExecutableOperator<Map.Entry<K,V>>,
                IEvaluableOperator<Map.Entry<K,V>>,
                IConvertibleOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V> {

    
    public ILevel3ListOfMapElementsEntriesKeyOperator<K,V> onKey();
    public ILevel3ListOfMapElementsEntriesValueOperator<K,V> onValue();
    
    public ILevel1ListOfMapElementsOperator<K,V> endFor();
    
    public <X,Y> ILevel2ListOfMapElementsEntriesOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel2ListOfMapElementsEntriesOperator<?,?> raw();
    

    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super Map.Entry<K,V>> function);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super Map.Entry<K,V>> eval);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> convert(final IConverter<X,? super Map.Entry<K,V>> converter);
                                    
}
