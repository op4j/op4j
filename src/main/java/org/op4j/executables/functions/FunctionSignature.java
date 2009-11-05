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

import org.javaruntype.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class FunctionSignature<X,T> {
	
	private final Type<X> resultType;
	private final Type<T> targetType;
	private final String functionName;
	private final String stringRepresentation;


	public FunctionSignature(final Type<X> resultType, final Type<T> targetType, final String functionName) {
		super();
		this.resultType = resultType;
		this.targetType = targetType;
		this.functionName = functionName;
		this.stringRepresentation = functionName + "(" + this.targetType + ") -> " + this.resultType;
	}

    public Type<X> getResultType() {
        return this.resultType;
    }

    public Type<T> getTargetType() {
        return this.targetType;
    }

    public String getFunctionName() {
		return this.functionName;
	}

	public String getStringRepresentation() {
		return this.stringRepresentation;
	}
	

	@Override
	public String toString() {
		return this.stringRepresentation; 
	}
	

}
