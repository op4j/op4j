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

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V>
        extends UniqOperator<List<Map<K,V>>>,
        		ExecutableSelectedOperator<V>,
                ReplaceableOperator<V>,
                SelectedOperator<V> {



    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> endIf();

    
    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V, ? super V> function);

    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> replaceWith(final V replacement);

    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V, ? super V> function);
    
        
}
