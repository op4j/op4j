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
package org.op4j.operation;

import java.util.Set;

import org.op4j.op.operators.Iter0IterableSetOperator;
import org.op4j.type.Type;
import org.op4j.util.TypeAggregationUtils;

/**
 * <p>
 * Subclass of {@link Target} suitable for containing the target object
 * at {@link Iter0IterableSetOperator}, which for a <tt>SetTarget&lt;T&gt;</tt>
 * will be of type <tt>Set&lt;T&gt;</tt>.
 * </p>
 * <p>
 * <b>This class should never be used directly</b>.
 * </p>
 * 
 * @author Daniel Fern&aacute;ndez
 *
 * @param <T> the type parameter of the Set<?> type applicable to the target object.
 */
public class SetTarget<T> extends Target<Set<T>> {

    private final Type componentType;
    
    
    /**
     * <p>
     * Creates a new instance.
     * </p>
     * 
     * @param componentType the &lt;T&gt; type in <tt>Set&lt;T&gt;</tt>
     * @param object the target object
     */
    public SetTarget(final Type componentType, final Set<T> object) {
        super(TypeAggregationUtils.createSetOfType(componentType), object);
        this.componentType = componentType;
    }
    
    
    /**
     * <p>
     * Returns the component type.
     * </p>
     * 
     * @return the component type
     */
    public Type getSetComponentType() {
        return this.componentType;
    }
    
    
}
