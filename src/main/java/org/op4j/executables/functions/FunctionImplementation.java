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
import java.util.Set;

import org.javaruntype.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class FunctionImplementation<X,T>  {
	
    private final FunctionSignature<X,T> signature;
    
	private final Set<FunctionArgumentScheme<? extends T>> matchedArgumentSchemes;
    
    
    
	protected FunctionImplementation(final FunctionSignature<X,T> signature, final Set<FunctionArgumentScheme<? extends T>> matchedSchemes) {
        super();
        this.signature = signature;
        this.matchedArgumentSchemes = Collections.unmodifiableSet(matchedSchemes);
    }
    
    
	public final FunctionSignature<X,T> getFunctionSignature() {
	    return this.signature;
	}
	
    
    public final String getFunctionName() {
        return this.signature.getFunctionName();
    }
    
    
    public final Type<X> getResultType() {
        return this.signature.getResultType();
    }
    
    public final Type<T> getTargetType() {
        return this.signature.getTargetType();
    }
    
    
    public final Set<FunctionArgumentScheme<? extends T>> getMatchedArgumentTypeSchemes() {
        return this.matchedArgumentSchemes;
    }
    
        
    
    public abstract X execute(final FunctionArguments arguments) throws Exception;
    
        
}
