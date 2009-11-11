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

import java.lang.reflect.Array;
import java.util.Arrays;
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
public final class ArrayModifyFunction extends StructureModifyFunction<Object[], Object[]> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.ARRAY_OF_OBJECT, BuiltinNaming.OPERATION_NAME_MODIFY); 

    
    
    public ArrayModifyFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<Object[]> registerResultType() {
		return Types.ARRAY_OF_OBJECT;
	}

	
	@Override
	protected Type<Object[]> registerTargetType() {
		return Types.ARRAY_OF_OBJECT;
	}


    @Override
    protected List<?> processTarget(final Object target) {
        return Arrays.asList((Object[]) target);
    }
	
    @Override
    protected Object[] createResultObject(final List<?> newList, final Object target) {
        final Class<?> componentClass = target.getClass().getComponentType();
        final Object[] array = (Object[]) Array.newInstance(componentClass, newList.size());
        return newList.toArray(array);
    }
	
}
