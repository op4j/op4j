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

import java.util.Arrays;
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
public abstract class ExecutionTarget extends Target {
    
    private final ExecutionTargetId id;

    
    
    public static ExecutionTarget forObject(final Object object) {
        final ExecutionTargetId id = new ExecutionTargetId(ExecutionTargetId.ROOT, 0);
        final ExecutionNodeTarget node = ExecutionNodeTarget.forObject(id, object);
        return new ExecutionStructureTarget(ExecutionTargetId.ROOT, Arrays.asList(new ExecutionTargetId[] {id}), Arrays.asList(new ExecutionTarget[] {node}), 1);
    }
    
    
    
    protected ExecutionTarget(final ExecutionTargetId id) {
        super();
        this.id = id;
    }

    
    ExecutionTargetId getId() {
        return this.id;
    }
    
    
    abstract int getExecutionLevel();
    
    abstract List<ExecutionNodeTarget> getExecutionNodes();
    
    abstract Object getObject();
    
    
    
    @Override
    abstract ExecutionTarget doIterate();

    @Override
    abstract ExecutionTarget doSelectIndex(final boolean desiredResult, final List<Integer> positions);

    @Override
    abstract ExecutionTarget doSelectMapKeys(final boolean desiredResult, final List<Object> objects);

    @Override
    abstract ExecutionTarget doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval);

    @Override
    abstract ExecutionTarget doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval);

    @Override
    abstract ExecutionTarget doSelectNull(final boolean desiredResult);

    @Override
    abstract ExecutionTarget doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval);


    @Override
    abstract ExecutionTarget doEndIterate(final Structure structure, final Class<?> componentClass);


    @Override
    abstract ExecutionTarget doEndSelect();


    @Override
    abstract ExecutionTarget doExecute(final IFunction<?, ?> executable, final Normalization normalization);


    @Override
    abstract ExecutionTarget doReplaceWith(final Object replacement);


    @Override
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    
}
