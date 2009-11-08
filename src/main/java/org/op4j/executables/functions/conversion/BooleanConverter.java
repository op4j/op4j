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
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.BooleanUtils;
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
public final class BooleanConverter extends ConverterImplementation<Boolean> {

    
    private static final long serialVersionUID = -6201905960716013742L;

    
    
    private static final FunctionArgumentScheme<Boolean> SCH_BOOLEAN = 
        FunctionArgumentScheme.from(
            "Boolean target is cloned",
            Types.BOOLEAN);
    
    private static final FunctionArgumentScheme<Number> SCH_NUMBER = 
        FunctionArgumentScheme.from(
            "A zero value returns false. Any other value returns true",
            Types.NUMBER);
    
    private static final FunctionArgumentScheme<String> SCH_STRING = 
        FunctionArgumentScheme.from(
            "Conversion is performed using org.apache.commons.lang.BooleanUtils.toBooleanObject(), " +
            "which admits true/false, yes/no and on/off case insensitive input",
            Types.STRING);
    
    
    
    public BooleanConverter() {
        super();
    }
    

    
    
    @Override
    protected Set<FunctionArgumentScheme<? extends Object>> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme<? extends Object>> matched = new LinkedHashSet<FunctionArgumentScheme<? extends Object>>();
        matched.add(SCH_BOOLEAN);
        matched.add(SCH_NUMBER);
        matched.add(SCH_STRING);
        return matched;
    }

    
    

    @Override
    protected Type<Boolean> registerResultType() {
        return Types.BOOLEAN;
    }



    
    @Override
    public Boolean execute(FunctionArguments arguments) throws Exception {
        
        if (arguments.isTargetNull()) {
            return null;
        }

        if (SCH_BOOLEAN.matches(arguments)) {
            return Boolean.valueOf(arguments.getTargetAsBoolean().booleanValue());
        }

        if (SCH_NUMBER.matches(arguments)) {
            final Number arg = arguments.getTargetAsNumber();
            boolean result = false;
            if (arg instanceof BigDecimal) {
                result = (((BigDecimal)arg).unscaledValue().compareTo(BigInteger.ZERO) != 0);
            } else if (arg instanceof BigInteger) {
                result = (((BigInteger)arg).compareTo(BigInteger.ZERO) != 0);
            } else {
                result = (arg.doubleValue() != 0.0);
            }
            return Boolean.valueOf(result);
        }

        if (SCH_STRING.matches(arguments)) {
            return BooleanUtils.toBooleanObject(arguments.getTargetAsString());
        }
        
        return null;
        
    }

}
