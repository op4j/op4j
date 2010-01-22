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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class LoggingTarget extends Target {

    
    private static enum Operation {
        ITERATE, END_ITERATE,
        EXECUTE, REPLACE_WITH,
        SELECT_INDEX, SELECT_MAP_KEYS, SELECT_MATCHING, SELECT_NOT_NULL_AND_MATCHING,
        SELECT_NULL, SELECT_NULL_OR_MATCHING, END_SELECT
    }
    
    private final List<OperationStep> steps;
    private final ExecutionTarget executionTarget;
    
    
    public static LoggingTarget forObject(final Object object) {
        return new LoggingTarget(new ArrayList<OperationStep>(), null, ExecutionTarget.forObject(object));
    }
    
    
    
    LoggingTarget(final List<OperationStep> steps, final OperationStep step, final ExecutionTarget executionTarget) {
        super();
        this.steps = new ArrayList<OperationStep>(steps);
        if (step != null) {
            this.steps.add(step);
        }
        this.executionTarget = executionTarget;
    }
    
    
    
    @Override
    Target doEndIterate(final Structure structure, final Class<?> componentClass) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.END_ITERATE, structure, componentClass), this.executionTarget.doEndIterate(structure, componentClass));
    }

    
    
    @Override
    Target doEndSelect() {
        return new LoggingTarget(this.steps, new OperationStep(Operation.END_SELECT), this.executionTarget.doEndSelect());
    }


    
    @Override
    Target doExecute(final IFunction<?, ?> executable, final Normalization normalization) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.EXECUTE, executable, normalization), this.executionTarget.doExecute(executable, normalization));
    }

    
    
    @Override
    Target doIterate() {
        return new LoggingTarget(this.steps, new OperationStep(Operation.ITERATE), this.executionTarget.doIterate());
    }

    
    
    @Override
    Target doReplaceWith(final Object replacement) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.REPLACE_WITH, replacement), this.executionTarget.doReplaceWith(replacement));
    }


    
    
    @Override
    Target doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_INDEX, Boolean.valueOf(desiredResult), positions), this.executionTarget.doSelectIndex(desiredResult, positions));
    }


    
    
    @Override
    Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_MAP_KEYS, Boolean.valueOf(desiredResult), objects), this.executionTarget.doSelectMapKeys(desiredResult, objects));
    }


    
    
    @Override
    Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_MATCHING, Boolean.valueOf(desiredResult), eval), this.executionTarget.doSelectMatching(desiredResult, eval));
    }

    
    

    @Override
    Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_NOT_NULL_AND_MATCHING, Boolean.valueOf(desiredResult), eval), this.executionTarget.doSelectNotNullAndMatching(desiredResult, eval));
    }



    
    @Override
    Target doSelectNull(final boolean desiredResult) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_NULL, Boolean.valueOf(desiredResult)), this.executionTarget.doSelectNull(desiredResult));
    }


    
    
    @Override
    Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new LoggingTarget(this.steps, new OperationStep(Operation.SELECT_NULL_OR_MATCHING, Boolean.valueOf(desiredResult), eval), this.executionTarget.doSelectNullOrMatching(desiredResult, eval));
    }

    
    

    @Override
    public Object get() {
        System.out.println(StringUtils.join(this.steps, ","));
        return this.executionTarget.get();
    }

    
    
    private static class OperationStep {
        
        private final Operation operation;
        private final Object[] parameters;
        
        public OperationStep(final Operation operation, final Object... parameters) {
            super();
            this.operation = operation;
            this.parameters = parameters;
        }

        public Operation getOperation() {
            return this.operation;
        }

        public Object[] getParameters() {
            return this.parameters;
        }

        @Override
        public String toString() {
            return "OperationLog [operation=" + operation + ", parameters="
                    + Arrays.toString(parameters) + "]";
        }
        
        
    }
    
}
