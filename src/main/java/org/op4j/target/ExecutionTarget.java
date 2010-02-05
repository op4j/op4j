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
import org.op4j.util.NormalisationUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class ExecutionTarget extends Target {
    
    private static List<Integer> KEY_INDEX = Arrays.asList(new Integer[] { Integer.valueOf(0) });
    private static List<Integer> VALUE_INDEX = Arrays.asList(new Integer[] { Integer.valueOf(1) });
    
    private final ExecutionTargetId id;

    
    
    @SuppressWarnings("unchecked")
    public static ExecutionTarget forObject(final Object object, final Normalisation targetNormalisation) {
        final ExecutionTargetId id = new ExecutionTargetId(ExecutionTargetId.ROOT, 0);
        Object normalisedObject = null;
        switch (targetNormalisation) {
            case NONE:
                normalisedObject = object;
                break;
            case ARRAY:
                normalisedObject = NormalisationUtils.normaliseArray((Object[])object);
                break;
            case ARRAY_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseArrayOfArray((Object[][])object);
                break;
            case ARRAY_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseArrayOfList((List<Object>[])object);
                break;
            case ARRAY_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])object);
                break;
            case ARRAY_OF_SET:
                normalisedObject = NormalisationUtils.normaliseArrayOfSet((Set<Object>[])object);
                break;
            case LIST:
                normalisedObject = NormalisationUtils.normaliseList((List<Object>)object);
                break;
            case LIST_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseListOfArray((List<Object[]>)object);
                break;
            case LIST_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseListOfList((List<List<Object>>)object);
                break;
            case LIST_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)object);
                break;
            case LIST_OF_SET:
                normalisedObject = NormalisationUtils.normaliseListOfSet((List<Set<Object>>)object);
                break;
            case MAP:
                normalisedObject = NormalisationUtils.normaliseMap((Map<Object,Object>)object);
                break;
            case MAPENTRY:
                normalisedObject = NormalisationUtils.normaliseMapEntry((Map.Entry<Object,Object>)object);
                break;
            case MAPENTRY_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfArray((Map.Entry<Object,Object[]>)object);
                break;
            case MAPENTRY_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfList((Map.Entry<Object,List<Object>>)object);
                break;
            case MAPENTRY_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfMap((Map.Entry<Object,Map<Object,Object>>)object);
                break;
            case MAPENTRY_OF_SET:
                normalisedObject = NormalisationUtils.normaliseMapEntryOfSet((Map.Entry<Object,Set<Object>>)object);
                break;
            case MAP_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseMapOfArray((Map<Object,Object[]>)object);
                break;
            case MAP_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseMapOfList((Map<Object,List<Object>>)object);
                break;
            case MAP_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)object);
                break;
            case MAP_OF_SET:
                normalisedObject = NormalisationUtils.normaliseMapOfSet((Map<Object,Set<Object>>)object);
                break;
            case SET:
                normalisedObject = NormalisationUtils.normaliseSet((Set<Object>)object);
                break;
            case SET_OF_ARRAY:
                normalisedObject = NormalisationUtils.normaliseSetOfArray((Set<Object[]>)object);
                break;
            case SET_OF_LIST:
                normalisedObject = NormalisationUtils.normaliseSetOfList((Set<List<Object>>)object);
                break;
            case SET_OF_MAP:
                normalisedObject = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)object);
                break;
            case SET_OF_SET:
                normalisedObject = NormalisationUtils.normaliseSetOfSet((Set<Set<Object>>)object);
                break;
        }
        final ExecutionNodeTarget node = ExecutionNodeTarget.forObject(id, normalisedObject);
        
        return new ExecutionStructureTarget(ExecutionTargetId.ROOT, Arrays.asList(new ExecutionTarget[] {node}), 1);
        
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
    ExecutionTarget doOnKey() {
        return doIterate().doSelectIndex(true, KEY_INDEX).doIterate();
    }

    
    @Override
    ExecutionTarget doOnValue() {
        return doIterate().doSelectIndex(true, VALUE_INDEX).doIterate();
    }

    
    @Override
    ExecutionTarget doEndOn() {
        return doEndIterate(Structure.MAP_ENTRY_PART, null).doEndSelect().doEndIterate(Structure.MAP_ENTRY, null);
    }
    
    
    
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
    abstract ExecutionTarget doExecute(final IFunction<?, ?> executable, final Normalisation normalisation);


    @Override
    abstract ExecutionTarget doReplaceWith(final Object replacement);

    
    abstract ExecutionTarget reselectExecutionTarget();
    
    abstract ExecutionTarget unselectExecutionTarget();
    

    @Override
    public Object get() {
        if (getExecutionLevel() != 1) {
            throw new IllegalStateException("Cannot get result. Execution level is " + getExecutionLevel());
        }
        return getExecutionNodes().get(0).getObject();
    }
    
}
