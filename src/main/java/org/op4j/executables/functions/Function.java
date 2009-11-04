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
package org.op4j.executables.functions;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.Of;
import org.op4j.exceptions.OperationExecutionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Function<X,T>  {
	
    private final Of<X> resultOf;
    private final String functionName;
    private final Map<FunctionArgumentScheme<? extends T>, FunctionImplementation<X,T>> implementationsByArgumentSchemes;
    
    
    protected Function(final FunctionImplementation<X,T> functionImplementation) {
        
        super();
        
        this.resultOf = functionImplementation.getResultOf();
        this.functionName = functionImplementation.getFunctionName();
        this.implementationsByArgumentSchemes = 
            new HashMap<FunctionArgumentScheme<? extends T>,FunctionImplementation<X,T>>();
        addFunctionImplementation(functionImplementation);
    }
    
    
    public Of<X> getResultOf() {
        return this.resultOf;
    }
    
    
    public String getFunctionName() {
        return this.functionName;
    }
    
    
    
    public final Set<FunctionArgumentScheme<? extends T>> getMatchedArgumentTypeSchemes() {
        return Collections.unmodifiableSet(this.implementationsByArgumentSchemes.keySet());
    }
    
    public final Set<FunctionImplementation<X,T>> getFunctionImplementations() {
        return Collections.unmodifiableSet(new HashSet<FunctionImplementation<X,T>>(this.implementationsByArgumentSchemes.values()));
    }
    
    
    public final void addFunctionImplementation(final FunctionImplementation<X,T> functionImplementation) {
        Validate.isTrue(functionImplementation.getFunctionName().equals(this.functionName));
        Validate.isTrue(functionImplementation.getResultOf().getRawClass().equals(this.resultOf.getRawClass()));        
        for (final FunctionArgumentScheme<? extends T> argumentScheme : functionImplementation.getMatchedArgumentTypeSchemes()) {
            this.implementationsByArgumentSchemes.put(argumentScheme, functionImplementation);
        }
    }
    
    


	public final X executeFunction(final FunctionArguments arguments) {
        
        Validate.notNull(arguments, "Operation arguments cannot be null");
        
        FunctionImplementation<X,T> functionImplementation = null;
        for (FunctionArgumentScheme<? extends T> matchingTypeScheme : this.implementationsByArgumentSchemes.keySet()) {
            if ((functionImplementation != null) && (matchingTypeScheme.match(arguments))) {
                functionImplementation = this.implementationsByArgumentSchemes.get(matchingTypeScheme);
            }
        }
        if (functionImplementation == null) {
            throw new IllegalArgumentException(
                    "Invalid arguments. Valid schemes are: " +
                    this.implementationsByArgumentSchemes.keySet());
        }

        try {
            return functionImplementation.execute(arguments);
        } catch (OperationExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new OperationExecutionException(
                "Exception executing operation \"" + getFunctionName() +"\"", e);
        }
        
    }
    
        
}
