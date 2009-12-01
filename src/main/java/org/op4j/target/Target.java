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

import org.apache.commons.lang.Validate;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.select.ISelector;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Target {

    public static enum Structure { ARRAY, LIST, SET, MAP, MAP_ENTRY }
    
    private final TargetId id;

    
    
    public static Target forObject(final Object object) {
        final TargetId id = new TargetId(TargetId.ROOT, 0);
        final NodeTarget node = NodeTarget.forObject(id, object);
        return new StructureTarget(TargetId.ROOT, Arrays.asList(new TargetId[] {id}), Arrays.asList(new Target[] {node}), 1);
    }
    
    
    public Target(final TargetId id) {
        super();
        this.id = id;
    }
    
    public TargetId getId() {
        return this.id;
    }

    
    public abstract int getExecutionLevel();
    
    public abstract List<NodeTarget> getExecutionNodes();
    
    public abstract Object getObject();

    abstract Target doIterate();
    abstract Target doIteratePositions(final boolean desiredResult, final List<Integer> positions);
    abstract Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doIterateExpression(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doIterateSelector(final boolean desiredResult, final ISelector<?> selector);
    abstract Target doIterateNull(final boolean desiredResult);
    abstract Target doIterateNullOr(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doIterateNotNullAnd(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    
    
    public Target iterate() {
        return doIterate();
    }
    
    public Target iterate(final int... positions) {
    	return doIteratePositions(true, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateForMapKeys(final Object... keys) {
    	return doIterateMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    @SuppressWarnings("unchecked")
    public Target iterate(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doIterateExpression(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    public Target iterate(final ISelector<?> selector) {
    	Validate.notNull(selector, "A selector must be specified");
        return doIterateSelector(true, selector);
    }

    
    public Target iterateNull() {
        return doIterateNull(true);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNullOr(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNullOr(true, (IEvaluator<Boolean,Object>) eval);
    }
    
    
    public Target iterateNot(final int[] positions) {
        return doIteratePositions(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateNot(final Object[] objects) {
        return doIterateMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }

    
    public Target iterateNotNull() {
        return doIterateNull(false);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNotNullAnd(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNotNullAnd(true, (IEvaluator<Boolean,Object>) eval);
    }
    

    public abstract Target endIterate(final Structure structure, final Class<?> componentClass);
    

    public abstract Target execute(final IFunction<?,?> executable);
    
    
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    
    
}
