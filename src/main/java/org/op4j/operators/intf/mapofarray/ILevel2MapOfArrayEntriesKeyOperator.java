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
package org.op4j.op.intf.operators.mapofarray;

import java.util.Map;

import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.qualities.INavigatingMapEntryOperator;
import org.op4j.op.intf.qualities.ITypeParameterizableXOperator;
import org.op4j.op.intf.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapOfArrayEntriesKeyOperator<K,V>
		extends IUniqOperator<Map<K,V[]>>,
				INavigatingMapEntryOperator,
                ITypeParameterizableXOperator<K> {
    
    public ILevel1MapOfArrayEntriesOperator<K,V> endOn();
    
    public <X> ILevel2MapOfArrayEntriesKeyOperator<X,V> of(final IOf<X> of);
    
    public <X> ILevel2MapOfArrayEntriesKeyOperator<X,V> of(final Class<X> classOf);
    
    public ILevel2MapOfArrayEntriesKeyOperator<?,V> raw();
    
                                    
}
