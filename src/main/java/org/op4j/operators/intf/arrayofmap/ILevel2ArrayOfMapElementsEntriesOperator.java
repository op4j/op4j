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
package org.op4j.operators.intf.arrayofmap;

import java.util.Map;

import org.op4j.op.intf.parameters.IOf;
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
public interface ILevel2ArrayOfMapElementsEntriesOperator<K,V> 
		extends IUniqOperator<Map<K,V>[]>,
		        INavigableMapEntryOperator,
                INavigatingMapOperator<K,V>,
                ITypeParameterizableXYOperator<K,V> {

    
    public ILevel3ArrayOfMapElementsEntriesKeyOperator<K,V> onKey();
    public ILevel3ArrayOfMapElementsEntriesValueOperator<K,V> onValue();
    
    public ILevel1ArrayOfMapElementsOperator<K,V> endFor();
    
    public <X,Y> ILevel2ArrayOfMapElementsEntriesOperator<X,Y> of(final IOf<X> ofX, final IOf<Y> ofY);
    public <X,Y> ILevel2ArrayOfMapElementsEntriesOperator<X,Y> of(final Class<X> ofXClass, final Class<Y> ofYClass);
    
    public ILevel2ArrayOfMapElementsEntriesOperator<?,?> raw();
    
                                    
}
