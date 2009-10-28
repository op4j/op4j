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

import org.op4j.exceptions.OperationImplementationRegistrationException;
import org.op4j.functions.conversion.BigDecimalConverter;
import org.op4j.functions.conversion.BigIntegerConverter;
import org.op4j.functions.conversion.BooleanConverter;
import org.op4j.functions.conversion.ByteConverter;
import org.op4j.functions.conversion.CalendarConverter;
import org.op4j.functions.conversion.DoubleConverter;
import org.op4j.functions.conversion.FloatConverter;
import org.op4j.functions.conversion.IntegerConverter;
import org.op4j.functions.conversion.LongConverter;
import org.op4j.functions.conversion.ShortConverter;
import org.op4j.functions.conversion.StringConverter;
import org.op4j.operation.Operations;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class OperationsInitialization {
    

    static synchronized void declareAndInitializeOperations() {
        // Initialize all converters
        try {

            Operations.addOperationImplementation(ByteConverter.class);
            Operations.addOperationImplementation(ShortConverter.class);
            Operations.addOperationImplementation(IntegerConverter.class);
            Operations.addOperationImplementation(LongConverter.class);
            Operations.addOperationImplementation(BigIntegerConverter.class);
            Operations.addOperationImplementation(BigDecimalConverter.class);
            Operations.addOperationImplementation(FloatConverter.class);
            Operations.addOperationImplementation(DoubleConverter.class);
            Operations.addOperationImplementation(StringConverter.class);
            Operations.addOperationImplementation(BooleanConverter.class);
            Operations.addOperationImplementation(CalendarConverter.class);
            
        } catch (Exception e) {
            // This should NEVER happen
            throw new OperationImplementationRegistrationException(e);
        }
    }
    
    
    private OperationsInitialization() {
        super();
    }
    
}
