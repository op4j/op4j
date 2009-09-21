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

import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.interfaces.IteratingOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
abstract class Iter1AbstractOperator<T> 
        implements IteratingOperator<T> {

    
    private final List<Iter0AbstractOperator<T>> targets;
    

    
    Iter1AbstractOperator(final List<? extends Iter0AbstractOperator<T>> targetOps) {
        super();
        this.targets = new ArrayList<Iter0AbstractOperator<T>>(targetOps);
    }
    

    abstract List<? extends Iter0AbstractOperator<T>> getTargets();

    
    protected final List<? extends Iter0AbstractOperator<T>> getAbstractTargets() {
        return this.targets;
    }

    
    protected final List<T> getInnerUniqTargetObjects() {
        if (size() > 1) {
            throw new NonUniqueTargetException();
        }
        final List<T> result = new ArrayList<T>();
        for (Iter0AbstractOperator<T> targetOp : this.targets) {
            result.add(targetOp.getTargetObjects().get(0));
        }
        return result;
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
