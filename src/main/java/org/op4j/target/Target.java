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
    abstract Target doIterateIndex(final boolean desiredResult, final List<Integer> positions);
    abstract Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doIterateMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doIterateNull(final boolean desiredResult);
    abstract Target doIterateNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doIterateNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    
    
    abstract Target doSelectIndex(final boolean desiredResult, final List<Integer> positions);
    abstract Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doSelectNull(final boolean desiredResult);
    abstract Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    
    
    public Target iterate() {
        return doIterate();
    }
    
    public Target iterateIndex(final int... positions) {
    	return doIterateIndex(true, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateMapKeys(final Object... keys) {
    	return doIterateMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doIterateMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doIterateMatching(false, (IEvaluator<Boolean,Object>) eval);
    }

    
    public Target iterateNull() {
        return doIterateNull(true);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNullOrMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNullOrMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNullOrNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNullOrMatching(false, (IEvaluator<Boolean,Object>) eval);
    }
    
    
    public Target iterateIndexNot(final int[] positions) {
        return doIterateIndex(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateMapKeysNot(final Object[] objects) {
        return doIterateMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }

    
    public Target iterateNotNull() {
        return doIterateNull(false);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNotNullAndMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNotNullAndMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target iterateNotNullAndNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doIterateNotNullAndMatching(false, (IEvaluator<Boolean,Object>) eval);
    }
    

    public abstract Target endIterate(final Structure structure, final Class<?> componentClass);
    

    
    
    public Target selectIndex(final int... positions) {
    	return doSelectIndex(true, VarArgsUtil.asRequiredIntegerList(positions));
    }
    
    
    public Target selectIndexNot(final int... positions) {
        return doSelectIndex(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target selectMapKeys(final Object... keys) {
    	return doSelectMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    public Target selectMapKeysNot(final Object... objects) {
        return doSelectMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }
    
    
    @SuppressWarnings("unchecked")
    public Target selectMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doSelectMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target selectNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doSelectMatching(false, (IEvaluator<Boolean,Object>) eval);
    }

    
    public Target selectNull() {
        return doSelectNull(true);
    }

    
    public Target selectNotNull() {
        return doSelectNull(false);
    }

    
    @SuppressWarnings("unchecked")
    public Target selectNullOrMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNullOrMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target selectNullOrNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNullOrMatching(false, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target selectNotNullAndMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNotNullAndMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public Target selectNotNullAndNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNotNullAndMatching(false, (IEvaluator<Boolean,Object>) eval);
    }
    
    
    
    
    

    public abstract Target execute(final IFunction<?,?> executable);
    
    
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    
    
    
}
