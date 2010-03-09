/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.functions;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.util.MapEntry;



/**
 * <p>
 * This is an implementation of {@link IFunction} aimed at map building, which
 * substitutes the <tt>execute(...)</tt> method by two more easily implementable
 * {@link #buildKey(Object)} and {@link #buildValue(Object)}, creating map entries
 * from the results of these two methods.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class MapBuilder<T,K,V> implements IFunction<T,Map.Entry<K,V>> {
    
    protected MapBuilder() {
        super();
    }
    

    public abstract K buildKey(final T target);
    public abstract V buildValue(final T target);


    public final Entry<K, V> execute(final T input, final ExecCtx ctx) throws Exception {
        return new MapEntry<K,V>(buildKey(input), buildValue(input));
    }
    
}
