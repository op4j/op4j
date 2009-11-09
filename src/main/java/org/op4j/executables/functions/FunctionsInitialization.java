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
import org.op4j.executables.functions.conversion.BigDecimalConverter;
import org.op4j.executables.functions.conversion.BigIntegerConverter;
import org.op4j.executables.functions.conversion.BooleanConverter;
import org.op4j.executables.functions.conversion.ByteConverter;
import org.op4j.executables.functions.conversion.CalendarConverter;
import org.op4j.executables.functions.conversion.DoubleConverter;
import org.op4j.executables.functions.conversion.FloatConverter;
import org.op4j.executables.functions.conversion.IntegerConverter;
import org.op4j.executables.functions.conversion.LongConverter;
import org.op4j.executables.functions.conversion.ShortConverter;
import org.op4j.executables.functions.conversion.StringConverter;
import org.op4j.executables.functions.util.ArrayDistinctFunction;
import org.op4j.executables.functions.util.ListDistinctFunction;

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

        final Class<?>[] implementationClasses =
            new Class<?>[] {
                ByteConverter.class,
                ShortConverter.class,
                IntegerConverter.class,
                LongConverter.class,
                BigIntegerConverter.class,
                FloatConverter.class,
                DoubleConverter.class,
                BigDecimalConverter.class,
                StringConverter.class,
                BooleanConverter.class,
                CalendarConverter.class,
                ListDistinctFunction.class,
                ArrayDistinctFunction.class
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
