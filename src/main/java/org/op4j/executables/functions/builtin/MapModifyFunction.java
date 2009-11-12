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
import java.util.Map;
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
public class MapModifyFunction extends FunctionImplementation<Map<?,?>,Map<?,?>> {

    public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.MAP_OF_UNKNOWN_UNKNOWN, BuiltinNaming.OPERATION_NAME_MODIFY); 
	
	
    private static FunctionArgumentScheme SCH_MAP_ENTRIES_ADD =
            FunctionArgumentScheme.from(
                "It adds the specified entries to the target map.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                "Set<Map.Entry<?,?>> newEntries, 'ADD'");
        
    private static FunctionArgumentScheme SCH_MAP_ENTRIES_POSITION_ADD =
            FunctionArgumentScheme.from(
                "It adds the specified entries to the target map in the specified position.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                "Set<Map.Entry<?,?>> newEntries, Integer position, 'ADD'");
        
    private static FunctionArgumentScheme SCH_MAP_KEYS_REMOVE =
            FunctionArgumentScheme.from(
                "It removes the entries with the specified keys from the target map.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                "List<?> keys, 'REMOVE'");
        
    private static FunctionArgumentScheme SCH_MAP_EXPRESSION_REMOVE =
            FunctionArgumentScheme.from(
                "It removes the entries matching the specified expression from the target map.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                "String expression, List<?> expParameters, 'REMOVE'");
        
    private static FunctionArgumentScheme SCH_MAP_SELECTOR_REMOVE =
            FunctionArgumentScheme.from(
                "It removes the entries matching the specified selector from the target map.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                ISelect.class.getName() + " selector, 'REMOVE'");
        
    private static FunctionArgumentScheme SCH_MAP_KEYS_REMOVE_NOT =
            FunctionArgumentScheme.from(
                "It removes all entries but the ones with the specified from the target map.",
                Types.MAP_OF_UNKNOWN_UNKNOWN,
                "List<?> keys, 'REMOVE_NOT'");
        

    
    
    
    public MapModifyFunction() {
    	super();
    }
	
    

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_MAP_ENTRIES_ADD);
        matched.add(SCH_MAP_ENTRIES_POSITION_ADD);
        matched.add(SCH_MAP_KEYS_REMOVE);
        matched.add(SCH_MAP_EXPRESSION_REMOVE);
        matched.add(SCH_MAP_SELECTOR_REMOVE);
        matched.add(SCH_MAP_KEYS_REMOVE_NOT);
        return matched;
	}

	
	

    
    
    @Override
    protected String registerFunctionName() {
        return NAME;
    }
    
    
    @Override
    protected Type<Map<?,?>> registerResultType() {
        return Types.MAP_OF_UNKNOWN_UNKNOWN;
    }

    
    @Override
    protected Type<Map<?,?>> registerTargetType() {
        return Types.MAP_OF_UNKNOWN_UNKNOWN;
    }
	
	
	
	
	
	
    @Override
    @SuppressWarnings("unchecked")
	public Map<?,?> execute(final FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
            throw new NullPointerException("Cannot execute operation on null target");
		}
		
		if (SCH_MAP_ENTRIES_ADD.matches(arguments)) {
			final Map<?,?> target = (Map<?,?>) arguments.getTarget();
			final List<?> newElements = (List<?>) arguments.getParameter(0);
			final List<Object> newList = new ArrayList<Object>(target);
			newList.addAll(newElements);
			return createResultObject(newList, arguments.getTarget());
		}
        
        if (SCH_MAP_ENTRIES_POSITION_ADD.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final Integer position = arguments.getIntegerParameter(1);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.addAll(position.intValue(), newElements);
            return createResultObject(newList, arguments.getTarget());
        }
        
        if (SCH_MAP_KEYS_REMOVE.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final List<?> elementsToBeRemoved = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.removeAll(elementsToBeRemoved);
            return createResultObject(newList, arguments.getTarget());
        }
        
        if (SCH_MAP_POSITIONS_REMOVE.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final List<Integer> positions = Arrays.asList((Integer[]) arguments.getParameter(0));
            final List<Object> newList = new ArrayList<Object>();
            for (int i = 0, n = target.size(); i < n; i++) {
            	final Object element = target.get(i);
            	if (!positions.contains(Integer.valueOf(i))) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList, arguments.getTarget());
        }
        
        if (SCH_MAP_EXPRESSION_REMOVE.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final String expression = arguments.getStringParameter(0);
            final List<?> parameters = (List<?>) arguments.getParameter(1);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (!OgnlExpressionUtil.evalOgnlExpression(Types.BOOLEAN, expression, element, parameters).booleanValue()) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList, arguments.getTarget());
        }
        
        if (SCH_MAP_SELECTOR_REMOVE.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final ISelect<Object> selector = (ISelect<Object>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (!selector.eval(element)) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList, arguments.getTarget());
        }
        
        if (SCH_MAP_KEYS_REMOVE_NOT.matches(arguments)) {
            final Map<?,?> target = (Map<?,?>) arguments.getTarget();
            final List<?> elementsNotToBeRemoved = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            for (final Object element : target) {
            	if (elementsNotToBeRemoved.contains(element)) {
            		newList.add(element);
            	}
            }
            return createResultObject(newList, arguments.getTarget());
        }
        
        
		return null;
		
	}
    
    
    protected abstract X createResultObject(final List<?> newList, final Object target);
    

}
