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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;
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
abstract class ExecutionNodeTarget extends ExecutionTarget{

    
    
    static ExecutionNodeTarget forObject(final ExecutionTargetId id, final Object object) {
    	
        if (object == null) {
            return new ExecutionNullNodeTarget(id);
        } else if (object instanceof Object[]) {
            return new ExecutionArrayNodeTarget(id, (Object[]) object);
        } else if (object instanceof List<?>) {
            return new ExecutionListNodeTarget(id, (List<?>) object);
        } else if (object instanceof Set<?>) {
            return new ExecutionSetNodeTarget(id, (Set<?>) object);
        } else if (object instanceof Map<?,?>) {
            return new ExecutionMapNodeTarget(id, (Map<?,?>) object);
        } else if (object instanceof Map.Entry<?,?>) {
            return new ExecutionMapEntryNodeTarget(id, (Map.Entry<?,?>) object);
        } else if (object instanceof MapEntryPart) {
            return new ExecutionMapEntryPartNodeTarget(id, (MapEntryPart) object);
        } else {
            return new ExecutionObjectNodeTarget(id, object);
        }
        
    }

	
	protected ExecutionNodeTarget(final ExecutionTargetId id) {
		super(id);
	}



    @Override
    int getExecutionLevel() {
        throw new IllegalStateException("Cannot retrieve execution level on a node");
    }

    
    @Override
    List<ExecutionNodeTarget> getExecutionNodes() {
        return Arrays.asList(new ExecutionNodeTarget[] { this });
    }
    

    abstract Collection<?> getIterationElements();
    

    
    @Override
    ExecutionTarget doIterate() {
        
        final Collection<?> elements = getIterationElements();
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        final HashSet<ExecutionTargetId> newSelectedElementIds = new HashSet<ExecutionTargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final ExecutionTargetId elementId = new ExecutionTargetId(getId(), i);
            newSelectedElementIds.add(elementId);
            newElements.add(ExecutionNodeTarget.forObject(elementId, element));
            i++;
        }

        return new ExecutionStructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }


    
    
    
    
    @Override
    ExecutionTarget doEndIterate(final Structure structure, final Class<?> componentClass) {
        throw new IllegalStateException("Cannot end iteration on a node");
    }



    
	@Override
    @SuppressWarnings("unchecked")
    ExecutionTarget doExecute(final IFunction<?,?> executable, final Normalization normalization) {
    	Validate.notNull(executable, "An executable must be specified");
    	final IFunction<Object,Object> objectCommand = (IFunction<Object,Object>) executable;
    	try {
    	    Object result = objectCommand.execute(getObject(), new ExecCtxImpl(getId()));
    	    switch (normalization) {
                case ARRAY:
                    NormalizationUtils.checkIsArray(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeArray((Object[])result);
                    break;
                case ARRAY_OF_ARRAY:
                    NormalizationUtils.checkIsArrayOfArray(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeArrayOfArray((Object[][])result);
                    break;
                case ARRAY_OF_LIST:
                    NormalizationUtils.checkIsArrayOfList(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeArrayOfList((List<Object>[])result);
                    break;
                case ARRAY_OF_MAP:
                    NormalizationUtils.checkIsArrayOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeArrayOfMap((Map<Object,Object>[])result);
                    break;
                case ARRAY_OF_SET:
                    NormalizationUtils.checkIsArrayOfSet(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeArrayOfSet((Set<Object>[])result);
                    break;
                case LIST:
                    NormalizationUtils.checkIsList(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeList((List<Object>)result);
                    break;
                case LIST_OF_ARRAY:
                    NormalizationUtils.checkIsListOfArray(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeListOfArray((List<Object[]>)result);
                    break;
                case LIST_OF_LIST:
                    NormalizationUtils.checkIsListOfList(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeListOfList((List<List<Object>>)result);
                    break;
                case LIST_OF_MAP:
                    NormalizationUtils.checkIsListOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeListOfMap((List<Map<Object,Object>>)result);
                    break;
                case LIST_OF_SET:
                    NormalizationUtils.checkIsListOfSet(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeListOfSet((List<Set<Object>>)result);
                    break;
                case MAP:
                    NormalizationUtils.checkIsMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMap((Map<Object, Object>)result);
                    break;
                case MAPENTRY:
                    NormalizationUtils.checkIsMapEntry(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapEntry((Map.Entry<Object, Object>)result);
                    break;
                case MAPENTRY_OF_ARRAY:
                    NormalizationUtils.checkIsMapEntryOfArray(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapEntryOfArray((Map.Entry<Object, Object[]>)result);
                    break;
                case MAPENTRY_OF_LIST:
                    NormalizationUtils.checkIsMapEntryOfList(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapEntryOfList((Map.Entry<Object, List<Object>>)result);
                    break;
                case MAPENTRY_OF_MAP:
                    NormalizationUtils.checkIsMapEntryOfMap(Types.OBJECT, Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapEntryOfMap((Map.Entry<Object, Map<Object, Object>>)result);
                    break;
                case MAPENTRY_OF_SET:
                    NormalizationUtils.checkIsMapEntryOfSet(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapEntryOfSet((Map.Entry<Object, Set<Object>>)result);
                    break;
                case MAP_OF_ARRAY:
                    NormalizationUtils.checkIsMapOfArray(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapOfArray((Map<Object, Object[]>)result);
                    break;
                case MAP_OF_LIST:
                    NormalizationUtils.checkIsMapOfList(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapOfList((Map<Object, List<Object>>)result);
                    break;
                case MAP_OF_MAP:
                    NormalizationUtils.checkIsMapOfMap(Types.OBJECT, Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapOfMap((Map<Object, Map<Object, Object>>)result);
                    break;
                case MAP_OF_SET:
                    NormalizationUtils.checkIsMapOfSet(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeMapOfSet((Map<Object, Set<Object>>)result);
                    break;
                case SET:
                    NormalizationUtils.checkIsSet(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeSet((Set<Object>)result);
                    break;
                case SET_OF_ARRAY:
                    NormalizationUtils.checkIsSetOfArray(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeSetOfArray((Set<Object[]>)result);
                    break;
                case SET_OF_LIST:
                    NormalizationUtils.checkIsSetOfList(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeSetOfList((Set<List<Object>>)result);
                    break;
                case SET_OF_MAP:
                    NormalizationUtils.checkIsSetOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalizationUtils.normalizeSetOfMap((Set<Map<Object, Object>>)result);
                    break;
                case SET_OF_SET:
                    NormalizationUtils.checkIsSetOfSet(Types.OBJECT, result);
                    result = NormalizationUtils.normalizeSetOfSet((Set<Set<Object>>)result);
                    break;
            	case NONE:
    	    }
            return ExecutionNodeTarget.forObject(getId(), result);
        } catch (ExecutionException e) {
            throw e;
    	} catch (Throwable t) {
    	    throw new ExecutionException(t);
    	}
    }



    
    @Override
    ExecutionTarget doEndSelect() {
        throw new IllegalStateException("Cannot select on a node");
    }

	
	@Override
	ExecutionTarget doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	ExecutionTarget doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        throw new IllegalStateException("Cannot select on a node");
	}

	
    @Override
    ExecutionTarget doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
    }


	@Override
	ExecutionTarget doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	ExecutionTarget doSelectNull(final boolean desiredResult) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	ExecutionTarget doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
	}





    @Override
    ExecutionTarget doReplaceWith(Object replacement) {
        return ExecutionNodeTarget.forObject(getId(), replacement);
    }

    
}
