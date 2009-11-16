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
import org.op4j.executables.IExecutable;
import org.op4j.executables.ISelect;
import org.op4j.util.OgnlExpressionUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class NodeTarget extends Target{
    

    
    public static NodeTarget forObject(final TargetId id, final Object object) {

        if (object == null) {
            return new NullNodeTarget(id);
        } else if (object instanceof Object[]) {
            return new ArrayNodeTarget(id, (Object[]) object);
        } else if (object instanceof List<?>) {
            return new ListNodeTarget(id, (List<?>) object);
        } else if (object instanceof Set<?>) {
            return new SetNodeTarget(id, (Set<?>) object);
        } else if (object instanceof Map<?,?>) {
            return new MapNodeTarget(id, (Map<?,?>) object);
        } else if (object instanceof Map.Entry<?,?>) {
            return new MapEntryNodeTarget(id, (Map.Entry<?,?>) object);
        } else {
            return new ObjectNodeTarget(id, object);
        }
        
    }

	
	protected NodeTarget(final TargetId id) {
		super(id);
	}



    @Override
    public int getExecutionLevel() {
        throw new IllegalStateException("Cannot retrieve execution level on a node");
    }

    
    @Override
    public List<NodeTarget> getExecutionNodes() {
        return Arrays.asList(new NodeTarget[] { this });
    }
    

    abstract Collection<?> getIterationElements();
    

    
    @Override
    Target doIterate() {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newSelectedElementIds.add(elementId);
            newElements.add(NodeTarget.forObject(elementId, element));
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    Target doIteratePositions(final boolean desiredResult, final List<Integer> positions) {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            if (positions.contains(Integer.valueOf(i)) == desiredResult) {
                newSelectedElementIds.add(elementId);
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects) {
        throw new IllegalStateException("Iteration by selecting map keys can only be called on a Map");
    }

    
    @Override
    Target doIterateExpression(final boolean desiredResult, final String expression, final List<Object> expParams) {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            final Boolean evalResult = 
                OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, expParams);
            if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                newSelectedElementIds.add(elementId);
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    @SuppressWarnings("unchecked")
    Target doIterateSelector(final boolean desiredResult, final ISelect<?> selector) {
        
        final ISelect<Object> objectSelector = (ISelect<Object>) selector;
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            final boolean evalResult = objectSelector.eval(element);
            if (evalResult == desiredResult) {
                newSelectedElementIds.add(elementId);
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    Target doIterateNull(final boolean desiredResult) {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            if ((element == null) == desiredResult) {
                newSelectedElementIds.add(elementId);
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    Target doIterateNullOr(final boolean desiredResult, final String expression, final List<Object> expParams) {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            if (element == null) {
                newSelectedElementIds.add(elementId);
            } else {
                final Boolean evalResult = 
                    OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, expParams);
                if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                    newSelectedElementIds.add(elementId);
                }
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    @Override
    Target doIterateNotNullAnd(final boolean desiredResult, final String expression, final List<Object> expParams) {
        
        final Collection<?> elements = getIterationElements();
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Object element : elements) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            if (element != null) {
                final Boolean evalResult = 
                    OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, expParams);
                if ((evalResult != null && evalResult.booleanValue()) == desiredResult) {
                    newSelectedElementIds.add(elementId);
                }
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }

    
    
    @Override
    public Target endIterate(final Structure structure, final Class<?> componentClass) {
        throw new IllegalStateException("Cannot end iteration on a node");
    }



    
	@Override
    @SuppressWarnings("unchecked")
    public Target execute(final IExecutable<?,?> command) {
    	final IExecutable<Object,Object> objectCommand = (IExecutable<Object,Object>) command;
        return NodeTarget.forObject(getId(), objectCommand.execute(getObject()));
    }


    
}
