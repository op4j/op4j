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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.FunctionImplementation;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class GenericModifyFunction extends FunctionImplementation<Object, Object> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.OBJECT, BuiltinNaming.OPERATION_NAME_MODIFY); 

    
    private static final FunctionArgumentScheme SCH_UNIQ_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current element (thus creating a multi-operator).",
            Types.OBJECT,
            "List<?> newElements, 'UNIQ_ADD'");
    
    private static final FunctionArgumentScheme SCH_MULTI_ADD = 
        FunctionArgumentScheme.from(
            "It adds a new element to the current elements.",
            Types.LIST_OF_UNKNOWN,
            "List<?> newElements, 'MULTI_ADD'");


    
    
    
    public GenericModifyFunction() {
    	super();
    }
	

    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_UNIQ_ADD);
        matched.add(SCH_MULTI_ADD);
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
    public Object execute(final FunctionArguments arguments) throws Exception {
        
        if (arguments.isTargetNull()) {
            throw new NullPointerException("Cannot execute operation on null target");
        }
        
        if (SCH_UNIQ_ADD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>();
            newList.add(target);
            newList.addAll(newElements);
            return newList;
        }
        
        if (SCH_MULTI_ADD.matches(arguments)) {
            final List<?> target = (List<?>) arguments.getTarget();
            final List<?> newElements = (List<?>) arguments.getParameter(0);
            final List<Object> newList = new ArrayList<Object>(target);
            newList.addAll(newElements);
            return newList;
        }
        
        
        return null;
    }
	
	
	
}
