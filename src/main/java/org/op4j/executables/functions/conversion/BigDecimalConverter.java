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
package org.op4j.executables.functions.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.type.Type;
import org.op4j.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class BigDecimalConverter extends DecimalNumberConverter {


    private static final long serialVersionUID = 3284349862985156720L;


    @Override
    public Type getResultType() {
        return Types.BIG_DECIMAL;
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerDecimalNumberMatchedArgumentTypeSchemes() {
        return new HashSet<ArgumentsTypeScheme>();
    }

    
    @Override
    protected Result doExecuteDecimalNumber(final Arguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected Number fromNumber(final Number number) throws Exception {
        if (number instanceof BigDecimal) {
            return new BigDecimal(
                    ((BigDecimal)number).unscaledValue(),
                    ((BigDecimal)number).scale());
        } else if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger)number);
        } else {
            return BigDecimal.valueOf(number.doubleValue()); 
        }
    }

    
    @Override
    protected Number fromString(final String string) throws Exception {
        return new BigDecimal(string);
    }


}
