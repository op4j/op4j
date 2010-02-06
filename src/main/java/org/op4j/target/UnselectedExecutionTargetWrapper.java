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

package org.op4j.target;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class UnselectedExecutionTargetWrapper extends ExecutionTarget {
    

    private ExecutionTarget executionTarget;
    
    
    static UnselectedExecutionTargetWrapper forExecutionTarget(final ExecutionTarget executionTarget) {
        return new UnselectedExecutionTargetWrapper(executionTarget);
    }
    
    
    private UnselectedExecutionTargetWrapper(final ExecutionTarget executionTarget) {
        super(executionTarget.id);
        this.executionTarget = executionTarget;
    }

    
    @Override
    ExecutionTarget doEndIterate(final Structure structure, final Class<?> componentClass) {
        return this;
    }


    @Override
    ExecutionTarget doEndOn() {
        return this;
    }


    @Override
    ExecutionTarget doEndSelect() {
        return this;
    }


    @Override
    ExecutionTarget doExecute(IFunction<?, ?> executable, Normalisation normalisation) {
        return this;
    }


    @Override
    ExecutionTarget doIterate() {
        return this;
    }


    @Override
    ExecutionTarget doOnKey() {
        return this;
    }


    @Override
    ExecutionTarget doOnValue() {
        return this;
    }


    @Override
    ExecutionTarget doReplaceWith(final Object replacement) {
        return this;
    }


    @Override
    ExecutionTarget doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        return this;
    }


    @Override
    ExecutionTarget doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        return this;
    }


    @Override
    ExecutionTarget doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return this;
    }


    @Override
    ExecutionTarget doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return this;
    }


    @Override
    ExecutionTarget doSelectNull(final boolean desiredResult) {
        return this;
    }


    @Override
    ExecutionTarget doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return this;
    }


    @Override
    public Object get() {
        throw new IllegalStateException("Cannot execute get() on an unselected node");
    }


    @Override
    int getExecutionLevel() {
        return this.executionTarget.getExecutionLevel();
    }


    @Override
    List<ExecutionNodeTarget> getExecutionNodes() {
        return this.executionTarget.getExecutionNodes();
    }


    @Override
    Object getObject() {
        throw new IllegalStateException("Cannot execute getObject() on an unselected node");
    }


    @Override
    ExecutionTarget reselectExecutionTarget() {
        return this.executionTarget;
    }


    @Override
    ExecutionTarget unselectExecutionTarget() {
        throw new IllegalStateException("Cannot unselect an unselected node");
    }
    
    
}
