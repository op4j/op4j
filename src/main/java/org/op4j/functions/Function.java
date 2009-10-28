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
package org.op4j.functions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.OperationExecutionException;
import org.op4j.type.Type;
import org.op4j.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Function {
	
	private final Set<ArgumentsTypeScheme> matchedArgumentTypeSchemes;
    
    
    protected Function() {
        
        super();
        
        this.matchedArgumentTypeSchemes = 
            Collections.unmodifiableSet(
                    new HashSet<ArgumentsTypeScheme>(registerMatchedArgumentTypeSchemes()));
        
    }
    
    public abstract String getOperationName();
    
    
    public abstract Type getResultType();    
    
    
    public final Set<ArgumentsTypeScheme> getMatchedArgumentTypeSchemes() {
        return this.matchedArgumentTypeSchemes;
    }
    
    protected abstract Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes();
    
    
    
    public final Result execute(final Arguments arguments) {
        
        Validate.notNull(arguments, "Operation arguments cannot be null");
        
        boolean validArguments = false;
        for (ArgumentsTypeScheme matchingTypeScheme : this.matchedArgumentTypeSchemes) {
            if ((!validArguments) && (matchingTypeScheme.matches(arguments))) {
                validArguments = true;
            }
        }
        if (!validArguments) {
            throw new IllegalArgumentException(
                    "Invalid arguments for matched type " +
                    "schemes: " + this.matchedArgumentTypeSchemes);
        }

        try {
            final Result result = doExecute(arguments);
            if (result == null) {
                throw new OperationExecutionException(
                    "Exception executing operation \"" + getOperationName() +
                    "\": execution returned null");
            }
            return result;
        } catch (OperationExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new OperationExecutionException(
                "Exception executing operation \"" + getOperationName() +"\"", e);
        }
        
    }
    
    
    protected abstract Result doExecute(final Arguments arguments) throws Exception;
    

    
    protected final Result createUniqResult(final Object resultObject) {

        /*
         * We should try to assign the most specific type we 
         * can for results, always with the condition that this type
         * is compatible with the result type declared by the 
         * Operation.
         */
        Type resultType = getResultType();
        Type resultObjectType = null;
        if (resultObject == null) {
            // As the result object is null, we trust the
            // "official" type for this result component.
            resultObjectType = resultType;
        } else {
            // We will try to get a more specific (raw) result type
            // from the result object itself and, if it is compatible
            // with the "official" one, we will use it instead.
            final Type componentRawType = 
                Types.getRawTypeForClass(resultObject.getClass());
            if (resultType.isAssignableFrom(componentRawType)) {
                resultObjectType = componentRawType;
            } else {
                resultObjectType = resultType;
            }
        }
        
        return new Result(resultObjectType, resultObject);
        
    }
        
}
