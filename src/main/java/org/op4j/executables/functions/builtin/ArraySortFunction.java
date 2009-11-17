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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
public class ArraySortFunction<T extends Comparable<? super T>> extends FunctionImplementation<T[], T[]> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.ARRAY_OF_OBJECT, BuiltinNaming.OPERATION_NAME_SORT); 
	
	
    private static final FunctionArgumentScheme SCH_STRUCTURE_SORT = 
        FunctionArgumentScheme.from(
            "Sorts the target structure.",
            Types.ARRAY_OF_OBJECT);
    
    private static final FunctionArgumentScheme SCH_STRUCTURE_COMPARATOR_SORT = 
        FunctionArgumentScheme.from(
            "Sorts the target structure using the specified Comparator.",
            Types.ARRAY_OF_OBJECT,
            "Comparator<?> comparator");
    
    
    public ArraySortFunction() {
    	super();
    }
	
	
    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_STRUCTURE_SORT);
        matched.add(SCH_STRUCTURE_COMPARATOR_SORT);
        return matched;
	}

	
	
	@Override
	protected Type<? super T[]> registerResultType() {
		return Types.ARRAY_OF_OBJECT;
	}

	@Override
	protected Type<? super T[]> registerTargetType() {
		return Types.ARRAY_OF_OBJECT;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
			throw new NullPointerException("Cannot execute operation on null target");
		}
		
		if (SCH_STRUCTURE_SORT.matches(arguments)) {
			
			final T[] array = (T[]) arguments.getTarget();
            final Class<?> arrayClass = array.getClass().getComponentType();

            final List<T> list = new ArrayList<T>(Arrays.asList(array));
            Collections.sort(list);
			
            final T[] newArray = (T[]) Array.newInstance(arrayClass, new int[] {list.size()});
            return list.toArray(newArray);
				
		}
		
		if (SCH_STRUCTURE_COMPARATOR_SORT.matches(arguments)) {
			
			final T[] array = (T[]) arguments.getTarget();
            final Comparator<? super T> comparator = 
            	(Comparator<? super T>) arguments.getParameter(0);
            final Class<?> arrayClass = array.getClass().getComponentType();

            final List<T> list = new ArrayList<T>(Arrays.asList(array));
            Collections.sort(list, comparator);
			
            final T[] newArray = (T[]) Array.newInstance(arrayClass, new int[] {list.size()});
            return list.toArray(newArray);
				
		}
		
		
		return null;
	}

	

}
