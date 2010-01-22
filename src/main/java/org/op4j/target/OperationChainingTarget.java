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
import java.util.List;

import org.op4j.exceptions.EmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class OperationChainingTarget extends Target {

    
    private static enum Operation {
        ITERATE, END_ITERATE,
        EXECUTE, REPLACE_WITH,
        SELECT_INDEX, SELECT_MAP_KEYS, SELECT_MATCHING, SELECT_NOT_NULL_AND_MATCHING,
        SELECT_NULL, SELECT_NULL_OR_MATCHING, END_SELECT
    }
    
    private final List<OperationStep> steps;
    private final boolean empty;
    private final Object target;
    
    
    public static OperationChainingTarget createEmpty() {
        return new OperationChainingTarget(new ArrayList<OperationStep>(), null, true, null);
    }
    
    public static OperationChainingTarget forObject(final Object object) {
        return new OperationChainingTarget(new ArrayList<OperationStep>(), null, false, object);
    }
    
    
    
    OperationChainingTarget(final List<OperationStep> steps, final OperationStep step, final boolean empty, final Object target) {
        super();
        this.steps = new ArrayList<OperationStep>(steps);
        this.empty = empty;
        if (step != null) {
            this.steps.add(step);
        }
        this.target = target;
    }
    
    
    
    @Override
    Target doEndIterate(final Structure structure, final Class<?> componentClass) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.END_ITERATE, structure, componentClass), this.empty, this.target);
    }

    
    
    @Override
    Target doEndSelect() {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.END_SELECT), this.empty, this.target);
    }


    
    @Override
    Target doExecute(final IFunction<?, ?> executable, final Normalization normalization) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.EXECUTE, executable, normalization), this.empty, this.target);
    }

    
    
    @Override
    Target doIterate() {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.ITERATE), this.empty, this.target);
    }

    
    
    @Override
    Target doReplaceWith(final Object replacement) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.REPLACE_WITH, replacement), this.empty, this.target);
    }


    
    
    @Override
    Target doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_INDEX, Boolean.valueOf(desiredResult), positions), this.empty, this.target);
    }


    
    
    @Override
    Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_MAP_KEYS, Boolean.valueOf(desiredResult), objects), this.empty, this.target);
    }


    
    
    @Override
    Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_MATCHING, Boolean.valueOf(desiredResult), eval), this.empty, this.target);
    }

    
    

    @Override
    Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_NOT_NULL_AND_MATCHING, Boolean.valueOf(desiredResult), eval), this.empty, this.target);
    }



    
    @Override
    Target doSelectNull(final boolean desiredResult) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_NULL, Boolean.valueOf(desiredResult)), this.empty, this.target);
    }


    
    
    @Override
    Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        return new OperationChainingTarget(this.steps, new OperationStep(Operation.SELECT_NULL_OR_MATCHING, Boolean.valueOf(desiredResult), eval), this.empty, this.target);
    }

    
    

    @Override
    public Object get() {
        if (this.empty) {
            throw new EmptyTargetException();
        }
        return executeChain(this.target);
    }
    
    

    
    @SuppressWarnings("unchecked")
    public Object executeChain(final Object object) {

        ExecutionTarget executionTarget = ExecutionTarget.forObject(object);

        for (final OperationStep step : this.steps) {
            
            final Operation operation = step.getOperation();
            switch(operation) {
                case EXECUTE:
                    executionTarget = executionTarget.doExecute((IFunction<?,?>)step.getParameters()[0], (Normalization)step.getParameters()[1]);
                    break;
                case ITERATE: 
                    executionTarget = executionTarget.doIterate();
                    break;
                case END_ITERATE:
                    executionTarget = executionTarget.doEndIterate((Structure)step.getParameters()[0], (Class<?>)step.getParameters()[1]);
                    break;
                case REPLACE_WITH:
                    executionTarget = executionTarget.doReplaceWith(step.getParameters()[0]);
                    break;
                case SELECT_INDEX:
                    executionTarget = executionTarget.doSelectIndex(((Boolean)step.getParameters()[0]).booleanValue(), (List<Integer>)step.getParameters()[1]);
                    break;
                case SELECT_MAP_KEYS:
                    executionTarget = executionTarget.doSelectMapKeys(((Boolean)step.getParameters()[0]).booleanValue(), (List<Object>)step.getParameters()[1]);
                    break;
                case SELECT_MATCHING:
                    executionTarget = executionTarget.doSelectMatching(((Boolean)step.getParameters()[0]).booleanValue(), (IEvaluator<Boolean,Object>)step.getParameters()[1]);
                    break;
                case SELECT_NOT_NULL_AND_MATCHING:
                    executionTarget = executionTarget.doSelectNotNullAndMatching(((Boolean)step.getParameters()[0]).booleanValue(), (IEvaluator<Boolean,Object>)step.getParameters()[1]);
                    break;
                case SELECT_NULL:
                    executionTarget = executionTarget.doSelectNull(((Boolean)step.getParameters()[0]).booleanValue());
                    break;
                case SELECT_NULL_OR_MATCHING:
                    executionTarget = executionTarget.doSelectNullOrMatching(((Boolean)step.getParameters()[0]).booleanValue(), (IEvaluator<Boolean,Object>)step.getParameters()[1]);
                    break; 
                case END_SELECT:
                    executionTarget = executionTarget.doEndSelect();
                    break;
            }
            
        }
        
        return executionTarget.get();
        
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
        
        
    }
    
}
