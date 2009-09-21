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
package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.op4j.op.interfaces.FilterContext;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FilterContextImpl<T> implements FilterContext<T> {
    
    private final List<T> targets;
    
    FilterContextImpl(final List<T> targets) {
        super();
        this.targets = Collections.unmodifiableList(new ArrayList<T>(targets));
    }
    
    <X extends T> FilterContextImpl(final X target) {
        super();
        final List<T> newTargets = new ArrayList<T>();
        newTargets.add(target);
        this.targets = Collections.unmodifiableList(newTargets);
    }

    
    public int getTargetCount() {
        return this.targets.size();
    }
    
    public T getTarget(final int index) {
        return this.targets.get(index);
    }

    
}
