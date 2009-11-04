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

import org.op4j.Of;
import org.op4j.executables.IExecutable;
import org.op4j.executables.ISelect;
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
    abstract Target doIterateExpression(final boolean desiredResult, final String expression, final List<Object> expParams);
    abstract Target doIterateSelector(final boolean desiredResult, final ISelect<?> selector);
    abstract Target doIterateNull(final boolean desiredResult);
    abstract Target doIterateNullOr(final boolean desiredResult, final String expression, final List<Object> expParams);
    abstract Target doIterateNotNullAnd(final boolean desiredResult, final String expression, final List<Object> expParams);
    
    
    public Target iterate() {
        return doIterate();
    }
    
    public Target iterate(final int... positions) {
    	return doIteratePositions(true, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateForMapKeys(final Object... keys) {
    	return doIterateMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    public Target iterate(final String expression, final Object... optionalExpParams) {
    	return doIterateExpression(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterate(final ISelect<?> selector) {
        return doIterateSelector(true, selector);
    }

    
    public Target iterateNull() {
        return doIterateNull(true);
    }

    
    public Target iterateNullOr(final String expression, final Object... optionalExpParams) {
        return doIterateNullOr(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNullOrNot(final String expression, final Object... optionalExpParams) {
        return doIterateNullOr(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }
    
    
    public Target iterateNot(final int[] positions) {
        return doIteratePositions(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public Target iterateNot(final Object[] objects) {
        return doIterateMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }

    
    public Target iterateNot(final String expression, final Object... optionalExpParams) {
        return doIterateExpression(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNot(final ISelect<?> selector) {
        return doIterateSelector(false, selector);
    }

    
    public Target iterateNotNull() {
        return doIterateNull(false);
    }

    
    public Target iterateNotNullAnd(final String expression, final Object... optionalExpParams) {
        return doIterateNotNullAnd(true, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }

    
    public Target iterateNotNullAndNot(final String expression, final Object... optionalExpParams) {
        return doIterateNotNullAnd(false, expression, VarArgsUtil.asOptionalObjectList(optionalExpParams));
    }
    

    public abstract Target endIterate(final Structure structure, final Of<?> of);
    

    public abstract Target execute(final IExecutable<?,?> command);
    
    
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    
    
}
