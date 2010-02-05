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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.util.MapEntry;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionStructureTarget extends ExecutionTarget {

	private final List<ExecutionTarget> elements;
	private final int actionLevel;
	private final boolean isCurrentActionLevel;
	

	
    protected ExecutionStructureTarget(final ExecutionTargetId id, final List<ExecutionTarget> elements, final int actionLevel) {
        
        super(id);
        this.elements = elements;
        this.actionLevel = actionLevel;
        this.isCurrentActionLevel = (actionLevel == id.getLevel());
        
    }
	
	
	List<ExecutionTarget> getElements() {
		return this.elements;
	}

    
	@Override
    Object getObject() {
        throw new IllegalStateException("Cannot get object from a structure");
    }

    
	@Override
    int getExecutionLevel() {
	    return this.actionLevel;
	}
	

    
    @Override
    List<ExecutionNodeTarget> getExecutionNodes() {
        
        final List<ExecutionNodeTarget> nodes = new ArrayList<ExecutionNodeTarget>();
        for (final ExecutionTarget element : this.elements) {
            nodes.addAll(element.getExecutionNodes());
        }
        return nodes;
        
    }
	

	
    @Override
    ExecutionTarget doIterate() {
        
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doIterate());
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel + 1);
        
    }

    
    @Override
    ExecutionTarget doEndIterate(final Structure structure, final Class<?> componentClass) {
        
        Validate.notNull(structure, "Structure cannot be null");
        Validate.isTrue(!(structure.equals(Structure.ARRAY) && componentClass == null), "Arrays must specify component class");

        if (this.isCurrentActionLevel) {

            Object newObject = null;
            
            switch (structure) {
                case ARRAY:
                    final List<Object> newObjectArrayList = new ArrayList<Object>();
                    for (final ExecutionTarget element : this.elements) {
                        final Object elementObject = element.getObject();
                        if (elementObject != null && !componentClass.isAssignableFrom(elementObject.getClass())) {
                            throw new IllegalStateException("Cannot put an object of class " + elementObject.getClass().getName() +
                                    " into an array of " + componentClass);
                        }
                        newObjectArrayList.add(elementObject);
                    }
                    final Object[] array = (Object[]) Array.newInstance(componentClass, newObjectArrayList.size());
                    newObject = newObjectArrayList.toArray(array);
                    break;
                case LIST:
                    final List<Object> newObjectList = new ArrayList<Object>();
                    for (final ExecutionTarget element : this.elements) {
                        newObjectList.add(element.getObject());
                    }
                    newObject = newObjectList;
                    break;
                case SET:
                    final Set<Object> newObjectSet = new LinkedHashSet<Object>();
                    for (final ExecutionTarget element : this.elements) {
                        newObjectSet.add(element.getObject());
                    }
                    newObject = newObjectSet;
                    break;
                case MAP:
                    final Map<Object,Object> newObjectMap = new LinkedHashMap<Object,Object>();
                    for (final ExecutionTarget element : this.elements) {
                        final Object elementObject = element.getObject();
                        if (elementObject != null && !Map.Entry.class.isAssignableFrom(elementObject.getClass())) {
                            throw new IllegalStateException("Cannot create a map from an object of class " + elementObject.getClass().getName() +
                                    ". Map.Entry objects are needed instead.");
                        }
                        if (elementObject == null) {
                            throw new IllegalStateException("Cannot create a map from null objects.");
                        }
                        final Map.Entry<?,?> mapEntryElementObject = (Map.Entry<?,?>) elementObject;
                        newObjectMap.put(mapEntryElementObject.getKey(), mapEntryElementObject.getValue());
                    }
                    newObject = newObjectMap;
                    break;
                case MAP_ENTRY:
                	if (this.elements.size() != 2) {
                		throw new IllegalStateException("Cannot create a Map.Entry structure as elements size is != 2 (" + this.elements.size() + ")");
                	}
                	final MapEntryPart keyPart = (MapEntryPart) this.elements.get(0).getObject();
                    final MapEntryPart valuePart = (MapEntryPart) this.elements.get(1).getObject();
                    newObject = new MapEntry<Object,Object>(keyPart.getPart(), valuePart.getPart());
                    break;
                case MAP_ENTRY_PART:
                    if (this.elements.size() != 1) {
                        throw new IllegalStateException("Cannot create a MapEntry part because there is more than one element");
                    }
                    newObject = new MapEntryPart(this.elements.get(0).getObject());
                    break;
                default:
                    break;
            }
            
            return ExecutionNodeTarget.forObject(getId(), newObject);
            
        }
            
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doEndIterate(structure, componentClass));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel - 1);
       
    }

    

    
    
    @Override
    ExecutionTarget doEndSelect() {
        
        if (this.isCurrentActionLevel) {
            
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();

            for (final ExecutionTarget element : this.elements) {
                newElements.add(element.reselectExecutionTarget());
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
        }
            
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doEndSelect());
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    }

    
    
    
	@Override
	ExecutionTarget doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();

            int i = 0;
            for (final ExecutionTarget element : this.elements) {
            	
                if (positions.contains(Integer.valueOf(i)) == desiredResult) {
                    newElements.add(element);
                } else {
                    newElements.add(element.unselectExecutionTarget());
                }
                i++;
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectIndex(desiredResult, positions));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
	}


	

	@Override
	ExecutionTarget doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
            
            for (final ExecutionTarget element : this.elements) {
            	
            	final Object elementObject = element.getObject();
            	if (!(elementObject instanceof Map.Entry<?,?>)) {
            		throw new IllegalStateException("Selecting map keys can only be called on a Map");
            	}
            	final Map.Entry<?,?> elementMapEntryObject = 
            		(Map.Entry<?,?>) elementObject;
            	
                if (objects.contains(elementMapEntryObject.getKey()) == desiredResult) {
                    newElements.add(element);
                } else {
                    newElements.add(element.unselectExecutionTarget());
                }
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectMapKeys(desiredResult, objects));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
    	
	}

	


    @Override
    ExecutionTarget doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
            
            for (final ExecutionTarget element : this.elements) {
            	
                Boolean evalResult = null;
                try {
                    evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                } catch (Exception e) {
                    throw new ExecutionException(e);
                }
                if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                    newElements.add(element);
                } else {
                    newElements.add(element.unselectExecutionTarget());
                }
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectMatching(desiredResult, eval));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    }
    



	@Override
	ExecutionTarget doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
            
            for (final ExecutionTarget element : this.elements) {
            	
                if (element.getObject() != null) {
                    Boolean evalResult = null;
                    try {
                        evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                    if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                        newElements.add(element);
                    } else {
                        newElements.add(UnselectedExecutionTargetWrapper.forExecutionTarget(element));
                    }
                } else {
                    newElements.add(element.unselectExecutionTarget());
                }
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectNotNullAndMatching(desiredResult, eval));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
    	
	}



	@Override
	ExecutionTarget doSelectNull(final boolean desiredResult) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
            
            for (final ExecutionTarget element : this.elements) {
            	
                if ((element.getObject() == null) == desiredResult) {
                    newElements.add(element);
                } else {
                    newElements.add(element.unselectExecutionTarget());
                }
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectNull(desiredResult));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
	}



	@Override
	ExecutionTarget doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
            
            for (final ExecutionTarget element : this.elements) {
            	
                if (element.getObject() == null) {
                    newElements.add(element);
                } else {
                    Boolean evalResult = null;
                    try {
                        evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                    if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                        newElements.add(element);
                    } else {
                        newElements.add(element.unselectExecutionTarget());
                    }
                }
                
            }
            return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
            
    	}
        	
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doSelectNullOrMatching(desiredResult, eval));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
    	
	}


    

    
    @Override
    ExecutionTarget doReplaceWith(final Object replacement) {
        
        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doReplaceWith(replacement));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
        
        
    }

    
	
    @Override
    ExecutionTarget doExecute(final IFunction<?,?> executable, final Normalisation normalisation) {

        final List<ExecutionTarget> newElements = new ArrayList<ExecutionTarget>();
        for (final ExecutionTarget element : this.elements) {
            newElements.add(element.doExecute(executable, normalisation));
        }
        return new ExecutionStructureTarget(getId(), newElements, this.actionLevel);
        
        
    }


    @Override
    ExecutionTarget reselectExecutionTarget() {
        return this;
    }


    @Override
    ExecutionTarget unselectExecutionTarget() {
        return UnselectedExecutionTargetWrapper.forExecutionTarget(this);
    }

    
}
