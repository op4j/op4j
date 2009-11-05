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

import org.op4j.exceptions.FunctionImplementationRegistrationException;
import org.op4j.executables.functions.conversion.DummyFunction;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class FunctionsInitialization {
    

    @SuppressWarnings("unchecked")
    static synchronized void declareAndInitializeOperations() {
        // Initialize all converters

//      Functions.registerFunctionImplementation(ByteConverter.class);
//      Operations.addOperationImplementation(ShortConverter.class);
//      Operations.addOperationImplementation(IntegerConverter.class);
//      Operations.addOperationImplementation(LongConverter.class);
//      Operations.addOperationImplementation(BigIntegerConverter.class);
//      Operations.addOperationImplementation(BigDecimalConverter.class);
//      Operations.addOperationImplementation(FloatConverter.class);
//      Operations.addOperationImplementation(DoubleConverter.class);
//      Operations.addOperationImplementation(StringConverter.class);
//      Operations.addOperationImplementation(BooleanConverter.class);
//      Operations.addOperationImplementation(CalendarConverter.class);
        
        final Class<?>[] implementationClasses =
            new Class<?>[] {
                DummyFunction.class
            };

        for(int i = 0; i < implementationClasses.length; i++) {
            Class<? extends FunctionImplementation<?,?>> newImplementationClass = null;
            try {
                newImplementationClass = 
                    (Class<? extends FunctionImplementation<?, ?>>) implementationClasses[i];
                Functions.registerFunctionImplementation(newImplementationClass);
            } catch (FunctionImplementationRegistrationException e) {
                throw e;
            } catch (Exception e) {
                throw new FunctionImplementationRegistrationException(newImplementationClass,e);
            }
        }
    }
    
    
    private FunctionsInitialization() {
        super();
    }
    
}
