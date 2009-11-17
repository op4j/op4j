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
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class SetModifyFunction<T> extends StructureModifyFunction<T,Set<T>> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.SET_OF_UNKNOWN, BuiltinNaming.OPERATION_NAME_MODIFY); 

    
    
    public SetModifyFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<? super Set<T>> registerResultType() {
		return Types.SET_OF_UNKNOWN;
	}

	
	@Override
	protected Type<? super Set<T>> registerTargetType() {
		return Types.SET_OF_UNKNOWN;
	}


    @Override
    @SuppressWarnings("cast")
    protected List<T> processTarget(final Collection<T> target) {
        return new ArrayList<T>((Set<T>) target);
    }
	
    @Override
    protected Set<T> createResultObject(final List<T> newList) {
        return new LinkedHashSet<T>(newList);
    }


	
}
