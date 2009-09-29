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
package org.op4j.operations.conversion;

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
public final class BigIntegerConverter extends NonDecimalNumberConverter {

    private static final long serialVersionUID = -2759691669136465497L;

    
    @Override
    public Type getResultType() {
        return Types.BIG_INTEGER;
    }

    
    @Override
    protected Set<ArgumentsTypeScheme> registerNonDecimalNumberMatchedArgumentTypeSchemes() {
        return new HashSet<ArgumentsTypeScheme>();
    }

    
    @Override
    protected Result doExecuteNonDecimalNumber(final Arguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected Number fromNumber(final Number number) throws Exception {
        if (number instanceof BigInteger) {
            return new BigInteger(((BigInteger)number).toByteArray());
        } else if (number instanceof BigDecimal) {
            return ((BigDecimal)number).toBigInteger();
        } else if (number instanceof Double) {
            return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
        } else if (number instanceof Float) {
            return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
        }
        return BigInteger.valueOf(number.longValue());
    }


    @Override
    protected Number fromString(final String string) throws Exception {
        return new BigInteger(string);
    }


    @Override
    protected Number fromString(final String string, final int radix) throws Exception {
        return new BigInteger(string, radix);
    }

}
