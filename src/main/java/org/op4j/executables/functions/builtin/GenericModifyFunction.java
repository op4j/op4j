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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
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
public final class GenericModifyFunction extends FunctionImplementation<Object, Object> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.OBJECT, BuiltinNaming.OPERATION_NAME_MODIFY); 

    
    private static final FunctionArgumentScheme GEN_UNIQ_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current element (thus creating a multi-operator).",
            Types.OBJECT,
            "List<?> newElements, 'UNIQ_ADD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current elements.",
            Types.LIST_OF_UNKNOWN,
            "List<?> newElements, 'MULTI_ADD'");
    
    private static final FunctionArgumentScheme GEN_UNIQ_POSITION_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current element (thus creating a multi-operator) in the specified position.",
            Types.OBJECT,
            "List<?> newElements, Integer position, 'UNIQ_ADD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_POSITION_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current elements in the specified position.",
            Types.LIST_OF_UNKNOWN,
            "List<?> newElements, Integer position, 'MULTI_ADD'");

    
    
    private static final FunctionArgumentScheme GEN_MULTI_ELEMENTS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the specified elements from the target.",
            Types.LIST_OF_UNKNOWN,
            "List<?> elements, 'MULTI_REMOVE'");
    
    private static final FunctionArgumentScheme GEN_MULTI_POSITIONS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements at the specified positions from the target.",
            Types.LIST_OF_UNKNOWN,
            "Integer[] positions, 'MULTI_REMOVE'");
    
    private static final FunctionArgumentScheme GEN_MULTI_EXPRESSION_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified expression from the target.",
            Types.LIST_OF_UNKNOWN,
            "String expression, List<?> expParameters, 'MULTI_REMOVE'");
    
    private static final FunctionArgumentScheme GEN_MULTI_SELECTOR_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified selector from the target.",
            Types.LIST_OF_UNKNOWN,
            ISelect.class.getName() + " selector, 'MULTI_REMOVE'");
    
    private static final FunctionArgumentScheme GEN_MULTI_POSITIONS_REMOVE_NOT = 
        FunctionArgumentScheme.from(
            "It removes all but the specified elements from the target in the specified position.",
            Types.LIST_OF_UNKNOWN,
            "Integer[] positions, 'MULTI_REMOVE_NOT'");
    
    private static final FunctionArgumentScheme GEN_MULTI_NULLS_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements not matching the specified selector from the target.",
            Types.LIST_OF_UNKNOWN,
            "'MULTI_REMOVE_NULL'");
    
    private static final FunctionArgumentScheme GEN_MULTI_NOT_NULLS_AND_REMOVE = 
        FunctionArgumentScheme.from(
            "It removes the elements matching the specified expression from the target.",
            Types.LIST_OF_UNKNOWN,
            "String expression, List<?> expParameters, 'MULTI_REMOVE_NOT_NULL_AND'");
    

    
    
    
    public GenericModifyFunction() {
    	super();
    }
	

    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(GEN_UNIQ_ADD);
        matched.add(GEN_MULTI_ADD);
        matched.add(GEN_UNIQ_POSITION_ADD);
        matched.add(GEN_MULTI_POSITION_ADD);
        matched.add(GEN_MULTI_ELEMENTS_REMOVE);
        matched.add(GEN_MULTI_POSITIONS_REMOVE); 
        matched.add(GEN_MULTI_EXPRESSION_REMOVE); 
        matched.add(GEN_MULTI_SELECTOR_REMOVE); 
        matched.add(GEN_MULTI_POSITIONS_REMOVE_NOT); 
        matched.add(GEN_MULTI_NULLS_REMOVE); 
        matched.add(GEN_MULTI_NOT_NULLS_AND_REMOVE); 
        return matched;
    }


    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<Object> registerResultType() {
		return Types.OBJECT;
	}

	
	@Override
	protected Type<Object> registerTargetType() {
		return Types.OBJECT;
	}
	
	

    @Override
    @SuppressWarnings("unchecked")
    public Object execute(final FunctionArguments arguments) throws Exception {
        
        if (GEN_UNIQ_ADD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            newList.add(target);
            newList.addAll(newElements);
            return newList;
        }
        
        if (GEN_MULTI_ADD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.addAll(newElements);
            return newList;
        }
        
        if (GEN_UNIQ_POSITION_ADD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final Integer position = arguments.getIntegerParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            newList.add(target);
            newList.addAll(position.intValue(), newElements);
            return newList;
        }
        
        if (GEN_MULTI_POSITION_ADD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final Integer position = arguments.getIntegerParameter(1);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.addAll(position.intValue(), newElements);
            return newList;
        }
        
        if (GEN_MULTI_ELEMENTS_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<?> elementsToBeRemoved = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.removeAll(elementsToBeRemoved);
            return newList;
        }
        
        if (GEN_MULTI_POSITIONS_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<Integer> positions = Arrays.asList((Integer[]) arguments.getParameter(0));
            final List<Object> newList = new ArrayList<Object>();
            for (int i = 0, n = target.size(); i < n; i++) {
                final Object element = target.get(i);
                if (!positions.contains(Integer.valueOf(i))) {
                    newList.add(element);
                }
            }
            return newList;
        }
        
        if (GEN_MULTI_EXPRESSION_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final String expression = arguments.getStringParameter(0);
            final List<?> parameters = (List<?>) arguments.getParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
                if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, parameters).booleanValue()) {
                    newList.add(element);
                }
            }
            return newList;
        }
        
        if (GEN_MULTI_SELECTOR_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final ISelect<Object> selector = (ISelect<Object>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
                if (!selector.eval(element)) {
                    newList.add(element);
                }
            }
            return newList;
        }
        
        if (GEN_MULTI_POSITIONS_REMOVE_NOT.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<Integer> positions = Arrays.asList((Integer[]) arguments.getParameter(0));
            final List<Object> newList = new ArrayList<Object>();
            for (int i = 0, n = target.size(); i < n; i++) {
                final Object element = target.get(i);
                if (positions.contains(Integer.valueOf(i))) {
                    newList.add(element);
                }
            }
            return newList;
        }
        
        if (GEN_MULTI_NULLS_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
                if (element != null) {
                    newList.add(element);
                }
            }
            return newList;
        }
        
        if (GEN_MULTI_NOT_NULLS_AND_REMOVE.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
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
            return newList;
        }
        
        
        return null;
    }
	
	
	
}
