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

import org.javaruntype.type.Type;
import org.op4j.operators.qualities.INavigableMapEntryOperator;
import org.op4j.operators.qualities.INavigatingMapOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYZOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1MapOfMapEntriesOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapEntryOperator,
		        INavigatingMapOperator<K1,Map<K2,V>>,
                ITypeParameterizableXYZOperator<K1,K2,V> {

    
    public ILevel2MapOfMapEntriesKeyOperator<K1,K2,V> onKey();
    public ILevel2MapOfMapEntriesValueOperator<K1,K2,V> onValue();
    
    public ILevel0MapOfMapOperator<K1,K2,V> endFor();
    
    public <X,Y,Z> ILevel1MapOfMapEntriesOperator<X,Y,Z> of(final Type<X> ofX, final Type<Y> ofY, final Type<Z> ofZ);
        
    public ILevel1MapOfMapEntriesOperator<?,?,?> raw();
    
                                    
}
