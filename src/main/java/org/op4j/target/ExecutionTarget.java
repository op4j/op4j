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
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.util.NormalizationUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class ExecutionTarget extends Target {
    
    private final ExecutionTargetId id;

    
    
    @SuppressWarnings("unchecked")
    public static ExecutionTarget forObject(final Object object, final Normalization targetNormalization) {
        final ExecutionTargetId id = new ExecutionTargetId(ExecutionTargetId.ROOT, 0);
        Object normalizedObject = null;
        switch (targetNormalization) {
            case NONE:
                normalizedObject = object;
                break;
            case ARRAY:
                normalizedObject = NormalizationUtils.normalizeArray((Object[])object);
                break;
            case ARRAY_OF_ARRAY:
                normalizedObject = NormalizationUtils.normalizeArrayOfArray((Object[][])object);
                break;
            case ARRAY_OF_LIST:
                normalizedObject = NormalizationUtils.normalizeArrayOfList((List<Object>[])object);
                break;
            case ARRAY_OF_MAP:
                normalizedObject = NormalizationUtils.normalizeArrayOfMap((Map<Object,Object>[])object);
                break;
            case ARRAY_OF_SET:
                normalizedObject = NormalizationUtils.normalizeArrayOfSet((Set<Object>[])object);
                break;
            case LIST:
                normalizedObject = NormalizationUtils.normalizeList((List<Object>)object);
                break;
            case LIST_OF_ARRAY:
                normalizedObject = NormalizationUtils.normalizeListOfArray((List<Object[]>)object);
                break;
            case LIST_OF_LIST:
                normalizedObject = NormalizationUtils.normalizeListOfList((List<List<Object>>)object);
                break;
            case LIST_OF_MAP:
                normalizedObject = NormalizationUtils.normalizeListOfMap((List<Map<Object,Object>>)object);
                break;
            case LIST_OF_SET:
                normalizedObject = NormalizationUtils.normalizeListOfSet((List<Set<Object>>)object);
                break;
            case MAP:
                normalizedObject = NormalizationUtils.normalizeMap((Map<Object,Object>)object);
                break;
            case MAPENTRY:
                normalizedObject = NormalizationUtils.normalizeMapEntry((Map.Entry<Object,Object>)object);
                break;
            case MAPENTRY_OF_ARRAY:
                normalizedObject = NormalizationUtils.normalizeMapEntryOfArray((Map.Entry<Object,Object[]>)object);
                break;
            case MAPENTRY_OF_LIST:
                normalizedObject = NormalizationUtils.normalizeMapEntryOfList((Map.Entry<Object,List<Object>>)object);
                break;
            case MAPENTRY_OF_MAP:
                normalizedObject = NormalizationUtils.normalizeMapEntryOfMap((Map.Entry<Object,Map<Object,Object>>)object);
                break;
            case MAPENTRY_OF_SET:
                normalizedObject = NormalizationUtils.normalizeMapEntryOfSet((Map.Entry<Object,Set<Object>>)object);
                break;
            case MAP_OF_ARRAY:
                normalizedObject = NormalizationUtils.normalizeMapOfArray((Map<Object,Object[]>)object);
                break;
            case MAP_OF_LIST:
                normalizedObject = NormalizationUtils.normalizeMapOfList((Map<Object,List<Object>>)object);
                break;
            case MAP_OF_MAP:
                normalizedObject = NormalizationUtils.normalizeMapOfMap((Map<Object,Map<Object,Object>>)object);
                break;
            case MAP_OF_SET:
                normalizedObject = NormalizationUtils.normalizeMapOfSet((Map<Object,Set<Object>>)object);
                break;
            case SET:
                normalizedObject = NormalizationUtils.normalizeSet((Set<Object>)object);
                break;
            case SET_OF_ARRAY:
                normalizedObject = NormalizationUtils.normalizeSetOfArray((Set<Object[]>)object);
                break;
            case SET_OF_LIST:
                normalizedObject = NormalizationUtils.normalizeSetOfList((Set<List<Object>>)object);
                break;
            case SET_OF_MAP:
                normalizedObject = NormalizationUtils.normalizeSetOfMap((Set<Map<Object,Object>>)object);
                break;
            case SET_OF_SET:
                normalizedObject = NormalizationUtils.normalizeSetOfSet((Set<Set<Object>>)object);
                break;
        }
        final ExecutionNodeTarget node = ExecutionNodeTarget.forObject(id, normalizedObject);
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
