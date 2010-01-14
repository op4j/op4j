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
package org.op4j.operators.intf.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2MapEntriesSelectedValueSelectedOperator<K,V>
        extends UniqOperator<Map<K,V>>,
        		ExecutableSelectedOperator<V>,
                SelectedOperator<V> {



    public Level2MapEntriesSelectedValueOperator<K,V> endIf();

    
    public Level2MapEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V, ? super V> converter);
    
    public Level2MapEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V, ? super V> eval);

    public Level2MapEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V, ? super V> function);

    
}
