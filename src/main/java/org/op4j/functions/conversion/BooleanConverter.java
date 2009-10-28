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
package org.op4j.functions.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.BooleanUtils;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.type.Type;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class BooleanConverter extends Converter {

    private static final long serialVersionUID = -6201905960716013742L;

    
    private static final ArgumentsTypeScheme ATS_BOOLEAN_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.BOOLEAN_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
            "Boolean target is cloned");
    
    private static final ArgumentsTypeScheme ATS_NUMBER_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.NUMBER_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
            "A zero value returns false. Any other value returns true");
    
    private static final ArgumentsTypeScheme ATS_STRING_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME, 
            "Conversion is performed using org.apache.commons.lang.BooleanUtils.toBooleanObject(), " +
            "which admits true/false, yes/no and on/off case insensitive input");
    
    
    public BooleanConverter() {
        super();
    }


    @Override
    protected Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_BOOLEAN_EMPTY);
        matched.add(ATS_NUMBER_EMPTY);
        matched.add(ATS_STRING_EMPTY);
        return matched;
    }

    
    @Override
    public Type getResultType() {
        return Types.BOOLEAN;
    }
    
    
    @Override
    protected Result doExecute(final Arguments arguments) throws Exception {
        
        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }

        if (ATS_BOOLEAN_EMPTY.matches(arguments)) {
            return createUniqResult(Boolean.valueOf(arguments.getBooleanTarget(0).booleanValue()));
        }

        if (ATS_NUMBER_EMPTY.matches(arguments)) {
            final Number arg = arguments.getNumberTarget(0);
            boolean result = false;
            if (arg instanceof BigDecimal) {
                result = (((BigDecimal)arg).unscaledValue().compareTo(BigInteger.ZERO) != 0);
            } else if (arg instanceof BigInteger) {
                result = (((BigInteger)arg).compareTo(BigInteger.ZERO) != 0);
            } else {
                result = (arg.doubleValue() != 0.0);
            }
            return createUniqResult(Boolean.valueOf(result));
        }

        if (ATS_STRING_EMPTY.matches(arguments)) {
            return createUniqResult(BooleanUtils.toBooleanObject(arguments.getStringTarget(0)));
        }
        
        return null;
        
    }

}
