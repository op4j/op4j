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
public class ListDistinctFunction<T> extends FunctionImplementation<List<T>, List<T>> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.LIST_OF_UNKNOWN, BuiltinNaming.OPERATION_NAME_DISTINCT); 
	
	
    private static final FunctionArgumentScheme SCH_LIST = 
        FunctionArgumentScheme.from(
            "It returns a List containing only the non-repeated elements.",
            Types.LIST_OF_UNKNOWN);

    
    
    public ListDistinctFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_LIST);
        return matched;
	}

	
	
	@Override
	protected Type<? super List<T>> registerResultType() {
		return Types.LIST_OF_UNKNOWN;
	}

	@Override
	protected Type<? super List<T>> registerTargetType() {
		return Types.LIST_OF_UNKNOWN;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
            throw new NullPointerException("Cannot execute operation on null target");
		}
		
		if (SCH_LIST.matches(arguments)) {
			final List<T> list = (List<T>) arguments.getTarget();
			return new ArrayList<T>(new LinkedHashSet<T>(list));
		}
		
		
		return null;
	}

}
