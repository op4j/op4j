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
import java.util.List;

import org.op4j.op.interfaces.IteratingOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter2AbstractOperator<T> 
        implements IteratingOperator<T> {

    
    private final List<Iter1AbstractOperator<T>> targets;
    

    
    Iter2AbstractOperator(final List<? extends Iter1AbstractOperator<T>> targetOps) {
        super();
        this.targets = new ArrayList<Iter1AbstractOperator<T>>(targetOps);
    }
    

    abstract List<? extends Iter1AbstractOperator<T>> getTargets();

    
    protected final List<? extends Iter1AbstractOperator<T>> getAbstractTargets() {
        return this.targets;
    }


    public final int size() {
        if (getTargets().size() > 0) {
            // All the nested ops must have the same number of 
            // targets, so we just choose the first one.
            return getTargets().get(0).size();
        }
        // Iteration is empty, no elements.
        return 0;
    }

    

    
}
