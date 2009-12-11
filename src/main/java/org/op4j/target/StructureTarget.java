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
public class StructureTarget extends Target {

	private final List<Target> elements;
    private final List<TargetId> selectedElementIds;
	private final int actionLevel;
	private final boolean isCurrentActionLevel;
	

	
    public StructureTarget(final TargetId id, final List<TargetId> selectedElementIds, final List<Target> elements, 
            final int actionLevel) {
        
        super(id);
        this.elements = elements;
        this.selectedElementIds = selectedElementIds;
        this.actionLevel = actionLevel;
        this.isCurrentActionLevel = (actionLevel == id.getLevel());
        
    }
	
	
	public List<Target> getElements() {
		return this.elements;
	}

    
	@Override
    public Object getObject() {
        throw new IllegalStateException("Cannot get object from a structure");
    }

    
	@Override
    public int getExecutionLevel() {
	    return this.actionLevel;
	}
	

    
    @Override
    public List<NodeTarget> getExecutionNodes() {
        
        final List<NodeTarget> nodes = new ArrayList<NodeTarget>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                nodes.addAll(element.getExecutionNodes());
            }
        }
        return nodes;
        
    }
	

	
    @Override
    Target doIterate() {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterate());
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    Target doIterateIndex(final boolean desiredResult, final List<Integer> positions) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateIndex(desiredResult, positions));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateMapKeys(desiredResult, objects));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }


    @Override
    Target doIterateMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    Target doIterateNull(final boolean desiredResult) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateNull(desiredResult));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    Target doIterateNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateNullOrMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    Target doIterateNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doIterateNotNullAndMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel + 1);
        
    }

    
    @Override
    public Target endIterate(final Structure structure, final Class<?> componentClass) {
        
        Validate.notNull(structure, "Structure cannot be null");
        Validate.isTrue(!(structure.equals(Structure.ARRAY) && componentClass == null), "Arrays must specify component class");

        if (this.isCurrentActionLevel) {

            Object newObject = null;
            
            switch (structure) {
                case ARRAY:
                    final List<Object> newObjectArrayList = new ArrayList<Object>();
                    for (final Target element : this.elements) {
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
                    for (final Target element : this.elements) {
                        newObjectList.add(element.getObject());
                    }
                    newObject = newObjectList;
                    break;
                case SET:
                    final Set<Object> newObjectSet = new LinkedHashSet<Object>();
                    for (final Target element : this.elements) {
                        newObjectSet.add(element.getObject());
                    }
                    newObject = newObjectSet;
                    break;
                case MAP:
                    final Map<Object,Object> newObjectMap = new LinkedHashMap<Object,Object>();
                    for (final Target element : this.elements) {
                        final Object elementObject = element.getObject();
                        if (elementObject != null && !Map.Entry.class.isAssignableFrom(elementObject.getClass())) {
                            throw new IllegalStateException("Cannot create a map from an object of class " + elementObject.getClass().getName() +
                                    ". Map.Entry objects are needed instead.");
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
                    newObject = new MapEntry<Object,Object>(this.elements.get(0).getObject(), this.elements.get(1).getObject());
                    break;
                default:
                    break;
            }
            
            return NodeTarget.forObject(getId(), newObject);
            
        }
            
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.endIterate(structure, componentClass));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel - 1);
       
    }

    

    
    
	@Override
	Target doSelectIndex(final boolean desiredResult, final List<Integer> positions) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();

            int i = 0;
            for (final Target element : this.elements) {
            	
                if (positions.contains(Integer.valueOf(i)) == desiredResult) {
                    newSelectedElementIds.add(element.getId());
                }
                i++;
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectIndex(desiredResult, positions));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
            
	}


	

	@Override
	Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
            
            for (final Target element : this.elements) {
            	
            	final Object elementObject = element.getObject();
            	if (!(elementObject instanceof Map.Entry<?,?>)) {
            		throw new IllegalStateException("Selecting map keys can only be called on a Map");
            	}
            	final Map.Entry<?,?> elementMapEntryObject = 
            		(Map.Entry<?,?>) elementObject;
            	
                if (objects.contains(elementMapEntryObject.getKey()) == desiredResult) {
                    newSelectedElementIds.add(element.getId());
                }
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectMapKeys(desiredResult, objects));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
    	
	}

	


    @Override
    Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
            
            for (final Target element : this.elements) {
            	
                Boolean evalResult = null;
                try {
                    evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                } catch (Exception e) {
                    throw new ExecutionException(e);
                }
                if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                    newSelectedElementIds.add(element.getId());
                }
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
            
    }
    



	@Override
	Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
            
            for (final Target element : this.elements) {
            	
                if (element.getObject() != null) {
                    Boolean evalResult = null;
                    try {
                        evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                    if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                        newSelectedElementIds.add(element.getId());
                    }
                }
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectNotNullAndMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
    	
	}



	@Override
	Target doSelectNull(final boolean desiredResult) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
            
            for (final Target element : this.elements) {
            	
                if ((element.getObject() == null) == desiredResult) {
                    newSelectedElementIds.add(element.getId());
                }
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectNull(desiredResult));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
            
	}



	@Override
	Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean, Object> eval) {
        
    	if (this.isCurrentActionLevel) {
        	
            final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
            
            for (final Target element : this.elements) {
            	
                if (element.getObject() == null) {
                    newSelectedElementIds.add(element.getId());
                } else {
                    Boolean evalResult = null;
                    try {
                        evalResult = eval.execute(element.getObject(), new ExecCtxImpl(element.getId())); 
                    } catch (Exception e) {
                        throw new ExecutionException(e);
                    }
                    if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                        newSelectedElementIds.add(element.getId());
                    }
                }
                
            }
            return new StructureTarget(getId(), newSelectedElementIds, this.elements, this.actionLevel);
            
    	}
        	
        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.doSelectNullOrMatching(desiredResult, eval));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
    	
	}


    

	
    @Override
    public Target execute(final IFunction<?,?> executable) {
        
    	Validate.notNull(executable, "An executable must be specified");

        final List<Target> newElements = new ArrayList<Target>();
        for (final Target element : this.elements) {
            if (this.selectedElementIds.contains(element.getId())) {
                newElements.add(element.execute(executable));
            } else {
                newElements.add(element);
            }
        }
        return new StructureTarget(getId(), this.selectedElementIds, newElements, this.actionLevel);
        
        
    }


    
}
