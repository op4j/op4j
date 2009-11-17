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

import java.util.Collection;
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
public final class ListSortFunction<X extends Comparable<? super X>> extends StructureSortFunction<X, List<X>> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.LIST_OF_UNKNOWN, BuiltinNaming.OPERATION_NAME_SORT); 

    
    
    public ListSortFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<? super List<X>> registerResultType() {
		return Types.LIST_OF_UNKNOWN;
	}

	
	@Override
	protected Type<? super List<X>> registerTargetType() {
		return Types.LIST_OF_UNKNOWN;
	}


    @Override
    protected List<X> processTarget(final Collection<X> target) {
        return (List<X>) target;
    }
	
    @Override
    protected List<X> createResultObject(final List<X> newList) {
        return newList;
    }
	
}
