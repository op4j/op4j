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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
public abstract class StructureSortFunction<X extends Comparable<? super X>,T extends Collection<X>> extends FunctionImplementation<T,T> {
	
	
    private FunctionArgumentScheme SCH_STRUCTURE_SORT;
    private FunctionArgumentScheme SCH_STRUCTURE_COMPARATOR_SORT;

    
    
    
    public StructureSortFunction() {
    	super();
    }
	
    

	@Override
	protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
	    
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        
        matched.add(this.SCH_STRUCTURE_SORT = 
            FunctionArgumentScheme.from(
                "Sorts the target structure.",
                registerTargetType()));
        
        matched.add(this.SCH_STRUCTURE_COMPARATOR_SORT = 
            FunctionArgumentScheme.from(
                "Sorts the target structure using the specified Comparator.",
                registerTargetType(),
                "Comparator<?> comparator"));
        
        return matched;
        
	}

	
	
	
	@Override
    @SuppressWarnings("unchecked")
	public T execute(FunctionArguments arguments) throws Exception {
		
		if (arguments.isTargetNull()) {
            throw new NullPointerException("Cannot execute operation on null target");
		}
		
		if (this.SCH_STRUCTURE_SORT.matches(arguments)) {
			final List<X> target = processTarget((Collection<X>)arguments.getTarget());
			final List<X> newList = new ArrayList<X>(target);
			Collections.sort(newList);
			return createResultObject(newList);
		}
        
        if (this.SCH_STRUCTURE_COMPARATOR_SORT.matches(arguments)) {
            final List<X> target = processTarget((Collection<X>)arguments.getTarget());
            final Comparator<? super X> comparator = 
            	(Comparator<? super X>) arguments.getParameter(0);
            final List<X> newList = new ArrayList<X>(target);
			Collections.sort(newList, comparator);
            return createResultObject(newList);
        }
        
        
		return null;
		
	}
    
    
    protected abstract List<X> processTarget(final Collection<X> target);
    protected abstract T createResultObject(final List<X> newList);
    

}
