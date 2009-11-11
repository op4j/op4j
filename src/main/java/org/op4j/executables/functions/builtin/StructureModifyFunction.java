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

package org.op4j.executables.functions.builtin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Types;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.FunctionImplementation;
import org.op4j.util.OgnlExpressionUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class StructureModifyFunction<X extends Collection<?>,T extends Collection<?>> extends FunctionImplementation<X,T> {
	
	
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_ADD = 
        FunctionArgumentScheme.from(
            "It adds the specified elements to the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "List<?> newElements, 'ADD'");
    
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_POSITION_ADD = 
        FunctionArgumentScheme.from(
            "It adds the specified elements to the target list in the specified position.",
            Types.COLLECTION_OF_UNKNOWN,
            "List<?> newElements, Integer position, 'ADD'");
    
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the specified elements from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "List<?> elements, 'REMOVE'");
    
    private static final FunctionArgumentScheme SCH_LIST_POSITIONS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements at the specified positions from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "Integer[] positions, 'REMOVE'");
    
    private static final FunctionArgumentScheme SCH_LIST_EXPRESSION_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified expression from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "String expression, List<?> expParameters, 'REMOVE'");
    
    private static final FunctionArgumentScheme SCH_LIST_SELECTOR_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified selector from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            ISelect.class.getName() + " selector, 'REMOVE'");
    
    private static final FunctionArgumentScheme SCH_LIST_ELEMENTS_REMOVE_NOT = 
        FunctionArgumentScheme.from(
            "It removes all but the passed elements from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "List<?> elements, 'REMOVE_NOT'");
    
    private static final FunctionArgumentScheme SCH_LIST_POSITIONS_REMOVE_NOT = 
        FunctionArgumentScheme.from(
            "It adds all but the passed elements to the target list in the specified position.",
            Types.COLLECTION_OF_UNKNOWN,
            "Integer[] positions, 'REMOVE_NOT'");
    
    private static final FunctionArgumentScheme SCH_LIST_NULLS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements not matching the specified selector from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "'REMOVE_NULL'");
    
    private static final FunctionArgumentScheme SCH_LIST_NULLS_OR_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified expression from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "String expression, List<?> expParameters, 'REMOVE_NULL_OR'");
    
    private static final FunctionArgumentScheme SCH_LIST_NOT_NULLS_AND_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified expression from the target list.",
            Types.COLLECTION_OF_UNKNOWN,
            "String expression, List<?> expParameters, 'REMOVE_NOT_NULL_AND'");

    
    
    public StructureModifyFunction() {
    	super();
    }
	
	

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_LIST_ELEMENTS_ADD);
        matched.add(SCH_LIST_ELEMENTS_POSITION_ADD);
        matched.add(SCH_LIST_ELEMENTS_REMOVE);
        matched.add(SCH_LIST_POSITIONS_REMOVE);
        matched.add(SCH_LIST_EXPRESSION_REMOVE);
        matched.add(SCH_LIST_SELECTOR_REMOVE);
        matched.add(SCH_LIST_ELEMENTS_REMOVE_NOT);
        matched.add(SCH_LIST_POSITIONS_REMOVE_NOT);
        matched.add(SCH_LIST_NULLS_REMOVE);
        matched.add(SCH_LIST_NULLS_OR_REMOVE);
        matched.add(SCH_LIST_NOT_NULLS_AND_REMOVE);
        return matched;
	}

	
	
	
    @Override
    @SuppressWarnings("unchecked")
	public X execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
			return null;
		}
		
		if (SCH_LIST_ELEMENTS_ADD.matches(arguments)) {
			final List<?> target = processTarget(arguments.getTarget());
			final List<?> newElements = (List<?>) arguments.getParameter(0);
			final List<Object> newList = new ArrayList<Object>(target);
			newList.addAll(newElements);
			return createResultObject(newList);
		}
        
        if (SCH_LIST_ELEMENTS_POSITION_ADD.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final Integer position = arguments.getIntegerParameter(1);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.addAll(position.intValue(), newElements);
            return createResultObject(newList);
        }
        
        if (SCH_LIST_ELEMENTS_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<?> elementsToBeRemoved = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.removeAll(elementsToBeRemoved);
            return createResultObject(newList);
        }
        
        if (SCH_LIST_POSITIONS_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<Integer> positions = Arrays.asList((Integer[]) arguments.getParameter(0));
            final List<Object> newList = new ArrayList<Object>();
            for (int i = 0, n = target.size(); i < n; i++) {
            	final Object element = target.get(i);
            	if (!positions.contains(Integer.valueOf(i))) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_EXPRESSION_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final String expression = arguments.getStringParameter(0);
            final List<?> parameters = (List<?>) arguments.getParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, parameters).booleanValue()) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_SELECTOR_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final ISelect<Object> selector = (ISelect<Object>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (!selector.eval(element)) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_ELEMENTS_REMOVE_NOT.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<?> elementsNotToBeRemoved = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (elementsNotToBeRemoved.contains(element)) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_POSITIONS_REMOVE_NOT.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<Integer> positions = Arrays.asList((Integer[]) arguments.getParameter(0));
            final List<Object> newList = new ArrayList<Object>();
            for (int i = 0, n = target.size(); i < n; i++) {
            	final Object element = target.get(i);
            	if (positions.contains(Integer.valueOf(i))) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_NULLS_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (element != null) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_NULLS_OR_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final String expression = arguments.getStringParameter(0);
            final List<?> parameters = (List<?>) arguments.getParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
                if (element != null) {
                    if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, parameters).booleanValue()) {
                        newList.add(element);
                    }
                }
            }
            return createResultObject(newList);
        }
        
        if (SCH_LIST_NOT_NULLS_AND_REMOVE.matches(arguments)) {
            final List<?> target = processTarget(arguments.getTarget());
            final String expression = arguments.getStringParameter(0);
            final List<?> parameters = (List<?>) arguments.getParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
                if (element != null) {
                    if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, parameters).booleanValue()) {
                        newList.add(element);
                    }
                } else {
                    newList.add(element);
                }
            }
            return createResultObject(newList);
        }
        
        
		return null;
		
	}
    
    
    protected abstract List<?> processTarget(final Object target);
    protected abstract X createResultObject(final List<?> newList);
    

}
