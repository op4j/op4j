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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class BigDecimalConverter extends DecimalNumberConverter<BigDecimal> {


    private static final long serialVersionUID = 3284349862985156720L;


    
    
    public BigDecimalConverter() {
        super();
    }
    
    


    @Override
    protected Type<BigDecimal> registerResultType() {
        return Types.BIG_DECIMAL;
    }
    
    


    @Override
    protected Set<FunctionArgumentScheme<? extends Object>> registerDecimalNumberMatchedSchemes() {
        return new HashSet<FunctionArgumentScheme<? extends Object>>();
    }
    

    
    @Override
    protected BigDecimal executeDecimalNumber(final FunctionArguments arguments) throws Exception {
        return null;
    }

    
    @Override
    protected BigDecimal fromNumber(final Number number) throws Exception {
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
    protected BigDecimal fromString(final String string) throws Exception {
        return new BigDecimal(string);
    }


}
