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
package org.op4j.operation;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.op4j.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Operations {

    // TODO: Many of these methods are NEVER used...
    
    public static void addOperationImplementation(
            final Class<? extends OperationImpl> operationImplClass) {
        Validate.notNull(operationImplClass, "Class cannot be null");
        final OperationImplRegistry operationRegistry = OperationImplRegistry.getInstance();
        operationRegistry.addOperationImpl(operationImplClass);
    }
    
    
    
    public static OperationImpl getOperationImplementation(
            final String operationName, final Arguments arguments) {
        
        Validate.notNull(operationName, "Operation name cannot be null");
        Validate.notNull(arguments, "Arguments cannot be null");
        
        final OperationImplRegistry operationRegistry = OperationImplRegistry.getInstance();
        return operationRegistry.getOperationImpl(operationName, arguments);
       
    }    
    
    
    
    public static Type getResultType(final String operationName) {
        Validate.notNull(operationName, "Operation name cannot be null");
        final OperationImplRegistry operationRegistry = OperationImplRegistry.getInstance();
        return operationRegistry.getResultType(operationName);
    }

    
    public static OperationInfo getOperationInfo(final String operationName) {
        Validate.notNull(operationName, "Operation name cannot be null");
        final OperationImplRegistry operationRegistry = OperationImplRegistry.getInstance();
        return operationRegistry.getOperationInfo(operationName);
    }

    
    public static Set<OperationInfo> getAllOperationsInfo() {
        final OperationImplRegistry operationRegistry = OperationImplRegistry.getInstance();
        return operationRegistry.getAllOperationsInfo();
    }

    
    
    public static <T> Result executeOperation(
            final String operationName, 
            final List<? extends Target<? extends T>> targets, 
            final List<Object> parameters) {
        
        Validate.notNull(targets, "Target list cannot be null");
        Validate.isTrue(targets.size() > 0, "Targets size cannot be zero");
        Validate.notNull(parameters, "Parameter list cannot be null");
        Validate.isTrue(!parameters.contains(null), "No operation parameter can be null");
        
        final Arguments preparedArguments = 
            new Arguments(
                    targets.toArray(new Target<?>[targets.size()]), 
                    parameters.toArray(new Object[parameters.size()]));
        final OperationImpl operationDef = 
            Operations.getOperationImplementation(operationName, preparedArguments);
        return operationDef.execute(preparedArguments);
        
    }
    
    
    private Operations() {
        super();
    }
    
}
