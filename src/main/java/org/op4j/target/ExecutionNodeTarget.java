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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;
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
    final int getExecutionLevel() {
        throw new IllegalStateException("Cannot retrieve execution level on a node");
    }

    
    @Override
    final List<ExecutionNodeTarget> getExecutionNodes() {
        return Arrays.asList(new ExecutionNodeTarget[] { this });
    }
    

    abstract Collection<?> getIterationElements();
    

    
    @Override
    final ExecutionTarget doIterate() {
        
        final Collection<?> elements = getIterationElements();
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        
        int i = 0;
        for (final Object element : elements) {
            final ExecutionTargetId elementId = new ExecutionTargetId(getId(), i);
            newElements.add(ExecutionNodeTarget.forObject(elementId, element));
            i++;
        }

        return new ExecutionStructureTarget(getId(), newElements, getId().getLevel());
        
    }


    
    
    
    
    @Override
    final ExecutionTarget doEndIterate(final Structure structure, final Class<?> componentClass) {
        throw new IllegalStateException("Cannot end iteration on a node");
    }



    
	@Override
    @SuppressWarnings("unchecked")
    final ExecutionTarget doExecute(final IFunction<?,?> executable, final Normalisation normalisation) {

    	final IFunction<Object,Object> objectCommand = (IFunction<Object,Object>) executable;
    	try {
    	    Object result = objectCommand.execute(getObject(), new ExecCtxImpl(getId()));
    	    switch (normalisation) {
                case ARRAY:
                    NormalisationUtils.checkIsArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArray((Object[])result);
                    break;
                case ARRAY_OF_ARRAY:
                    NormalisationUtils.checkIsArrayOfArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArrayOfArray((Object[][])result);
                    break;
                case ARRAY_OF_LIST:
                    NormalisationUtils.checkIsArrayOfList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArrayOfList((List<Object>[])result);
                    break;
                case ARRAY_OF_MAP:
                    NormalisationUtils.checkIsArrayOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])result);
                    break;
                case ARRAY_OF_SET:
                    NormalisationUtils.checkIsArrayOfSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArrayOfSet((Set<Object>[])result);
                    break;
                case LIST:
                    NormalisationUtils.checkIsList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseList((List<Object>)result);
                    break;
                case LIST_OF_ARRAY:
                    NormalisationUtils.checkIsListOfArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseListOfArray((List<Object[]>)result);
                    break;
                case LIST_OF_LIST:
                    NormalisationUtils.checkIsListOfList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseListOfList((List<List<Object>>)result);
                    break;
                case LIST_OF_MAP:
                    NormalisationUtils.checkIsListOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)result);
                    break;
                case LIST_OF_SET:
                    NormalisationUtils.checkIsListOfSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseListOfSet((List<Set<Object>>)result);
                    break;
                case MAP:
                    NormalisationUtils.checkIsMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMap((Map<Object, Object>)result);
                    break;
                case MAPENTRY:
                    NormalisationUtils.checkIsMapEntry(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntry((Map.Entry<Object, Object>)result);
                    break;
                case MAPENTRY_OF_ARRAY:
                    NormalisationUtils.checkIsMapEntryOfArray(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntryOfArray((Map.Entry<Object, Object[]>)result);
                    break;
                case MAPENTRY_OF_LIST:
                    NormalisationUtils.checkIsMapEntryOfList(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntryOfList((Map.Entry<Object, List<Object>>)result);
                    break;
                case MAPENTRY_OF_MAP:
                    NormalisationUtils.checkIsMapEntryOfMap(Types.OBJECT, Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntryOfMap((Map.Entry<Object, Map<Object, Object>>)result);
                    break;
                case MAPENTRY_OF_SET:
                    NormalisationUtils.checkIsMapEntryOfSet(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntryOfSet((Map.Entry<Object, Set<Object>>)result);
                    break;
                case MAP_OF_ARRAY:
                    NormalisationUtils.checkIsMapOfArray(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapOfArray((Map<Object, Object[]>)result);
                    break;
                case MAP_OF_LIST:
                    NormalisationUtils.checkIsMapOfList(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapOfList((Map<Object, List<Object>>)result);
                    break;
                case MAP_OF_MAP:
                    NormalisationUtils.checkIsMapOfMap(Types.OBJECT, Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapOfMap((Map<Object, Map<Object, Object>>)result);
                    break;
                case MAP_OF_SET:
                    NormalisationUtils.checkIsMapOfSet(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapOfSet((Map<Object, Set<Object>>)result);
                    break;
                case SET:
                    NormalisationUtils.checkIsSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSet((Set<Object>)result);
                    break;
                case SET_OF_ARRAY:
                    NormalisationUtils.checkIsSetOfArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSetOfArray((Set<Object[]>)result);
                    break;
                case SET_OF_LIST:
                    NormalisationUtils.checkIsSetOfList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSetOfList((Set<List<Object>>)result);
                    break;
                case SET_OF_MAP:
                    NormalisationUtils.checkIsSetOfMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSetOfMap((Set<Map<Object, Object>>)result);
                    break;
                case SET_OF_SET:
                    NormalisationUtils.checkIsSetOfSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSetOfSet((Set<Set<Object>>)result);
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
    final ExecutionTarget doEndSelect() {
        throw new IllegalStateException("Cannot select on a node");
    }

	
	@Override
	final ExecutionTarget doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	final ExecutionTarget doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        throw new IllegalStateException("Cannot select on a node");
	}

	
    @Override
    final ExecutionTarget doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
    }


	@Override
	final ExecutionTarget doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	final ExecutionTarget doSelectNull(final boolean desiredResult) {
        throw new IllegalStateException("Cannot select on a node");
	}


	@Override
	final ExecutionTarget doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        throw new IllegalStateException("Cannot select on a node");
	}





    @Override
    final ExecutionTarget doReplaceWith(Object replacement) {
        return ExecutionNodeTarget.forObject(getId(), replacement);
    }


    
    @Override
    final ExecutionTarget reselectExecutionTarget() {
        return this;
    }

    
    @Override
    final ExecutionTarget unselectExecutionTarget() {
        return UnselectedExecutionTargetWrapper.forExecutionTarget(this);
    }
    
}
