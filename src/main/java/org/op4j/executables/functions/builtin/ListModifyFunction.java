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

import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ListModifyFunction extends StructureModifyFunction<List<?>, List<?>> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.LIST_OF_UNKNOWN, BuiltinNaming.OPERATION_NAME_MODIFY); 

    
    
    public ListModifyFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<List<?>> registerResultType() {
		return Types.LIST_OF_UNKNOWN;
	}

	
	@Override
	protected Type<List<?>> registerTargetType() {
		return Types.LIST_OF_UNKNOWN;
	}



    @Override
    protected List<?> processTarget(final Object target) {
        return (List<?>) target;
    }

    
    @Override
    protected List<?> createResultObject(final List<?> newList, final Object target) {
        return newList;
    }

	
}
