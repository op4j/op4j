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
package org.op4j.operators.intf.mapoflist;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
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
public interface ILevel1MapOfListEntriesOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigableMapEntryOperator,
		        INavigatingMapOperator<K,List<V>>,
                ITypeParameterizableXYOperator<K,V> {

    
    public ILevel2MapOfListEntriesKeyOperator<K,V> onKey();
    public ILevel2MapOfListEntriesValueOperator<K,V> onValue();
    
    public ILevel0MapOfListOperator<K,V> endFor();
    
    public <X,Y> ILevel1MapOfListEntriesOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel1MapOfListEntriesOperator<?,?> raw();
    
                                    
}
