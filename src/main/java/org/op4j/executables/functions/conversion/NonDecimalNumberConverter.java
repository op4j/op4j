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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.LocaleUtils;
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
public abstract class NonDecimalNumberConverter<T extends Number> extends NumberConverter<T> {

    
	private static final long serialVersionUID = -1837141367740669785L;
	

    
    
    private static final FunctionArgumentScheme<String> SCH_STRING_INTEGER = 
        FunctionArgumentScheme.from(
            "Conversion is performed using the corresponding " +
            "X.valueOf(string, radix) methods, so the String target is expected to be " +
            "expressed in the specified radix",
            Types.STRING,
            "Integer");  

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "A point (.) is interpreted as a decimal symbol, as this is the way XX.valueOf() methods work",
            Types.STRING,
            "RoundingMode"); 

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE_LOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "Decimal and thousands symbols are interpreting according to the specified locale",
            Types.STRING,
            "RoundingMode,Locale"); 

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE_STRINGLOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "Decimal and thousands symbols are interpreting according to the specified locale",
            Types.STRING,
            "RoundingMode,String"); 

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "A comma (,) is interpreted as a decimal symbol",
            Types.STRING,
            "RoundingMode, 'DECIMAL_IS_COMMA'"); 

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE_DECIMAL_IS_POINT = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "A point (.) is interpreted as a decimal symbol",
            Types.STRING,
            "RoundingMode, 'DECIMAL_IS_POINT'"); 

    private static final FunctionArgumentScheme<String> SCH_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals " +
            "in the way specified the java.math.RoundingMode parameter. " +
            "Both a point (.) or a comma (,) can be interpreted as a decimal symbol, depending on " +
            "which one appears last (the last one will)",
            Types.STRING,
            "RoundingMode, 'DECIMAL_CAN_BE_POINT_OR_COMMA'"); 

    private static final FunctionArgumentScheme<Float> SCH_FLOAT_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from Float by rounding decimals in the way " +
            "specified by the java.math.RoundingMode parameter",
            Types.FLOAT,
            "RoundingMode"); 

    private static final FunctionArgumentScheme<Double> SCH_DOUBLE_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from Double by rounding decimals in the way " +
            "specified by the java.math.RoundingMode parameter",
            Types.DOUBLE,
            "RoundingMode"); 

    private static final FunctionArgumentScheme<BigDecimal> SCH_BIGDECIMAL_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from Double by rounding decimals in the way " +
            "specified by the java.math.RoundingMode parameter",
            Types.BIG_DECIMAL,
            "RoundingMode"); 
    

    
    
    
    
    public NonDecimalNumberConverter() {
        super();
    }
    
    
    
    @Override
    protected Set<FunctionArgumentScheme<? extends Object>> registerNumberMatchedSchemes() {
        final Set<FunctionArgumentScheme<? extends Object>> matched = new LinkedHashSet<FunctionArgumentScheme<? extends Object>>();
        matched.add(SCH_STRING_INTEGER);
        matched.add(SCH_STRING_ROUNDINGMODE);
        matched.add(SCH_STRING_ROUNDINGMODE_LOCALE);
        matched.add(SCH_STRING_ROUNDINGMODE_STRINGLOCALE);
        matched.add(SCH_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA);
        matched.add(SCH_STRING_ROUNDINGMODE_DECIMAL_IS_POINT);
        matched.add(SCH_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA);
        matched.add(SCH_FLOAT_ROUNDINGMODE);
        matched.add(SCH_DOUBLE_ROUNDINGMODE);
        matched.add(SCH_BIGDECIMAL_ROUNDINGMODE);
        matched.addAll(registerNonDecimalNumberMatchedSchemes());
        return matched;
    }
    
    
    protected abstract Set<FunctionArgumentScheme<? extends Object>> registerNonDecimalNumberMatchedSchemes();

    


    @Override
    protected T executeNumber(final FunctionArguments arguments) throws Exception {

        final T result = executeNonDecimalNumber(arguments);
        if (result != null) {
            return result;
        }
        
        if (SCH_STRING_INTEGER.matches(arguments)) {
            return fromString(
                            arguments.getTargetAsString(),
                            arguments.getIntegerParameter(0).intValue());
        }
        
        if (SCH_STRING_ROUNDINGMODE.matches(arguments)) {
            return fromString(
                            arguments.getTargetAsString(),
                            (RoundingMode) arguments.getParameter(0));
        }
        
        if (SCH_STRING_ROUNDINGMODE_DECIMAL_IS_POINT.matches(arguments)) {
            // Like with SCH_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT),
                                (RoundingMode) arguments.getParameter(0));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA.matches(arguments)) {
            // Like with SCH_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.COMMA),
                                (RoundingMode) arguments.getParameter(0));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA.matches(arguments)) {
            // Like with SCH_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT_OR_COMMA),
                                (RoundingMode) arguments.getParameter(0));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_ROUNDINGMODE_LOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(arguments.getLocaleParameter(2));
            decimalFormat.setParseBigDecimal(true);
            return fromNumber(
                            decimalFormat.parse(arguments.getTargetAsString()),
                            (RoundingMode) arguments.getParameter(0));
        }
        
        if (SCH_STRING_ROUNDINGMODE_STRINGLOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(arguments.getStringParameter(2)));
            decimalFormat.setParseBigDecimal(true);
            return fromNumber(
                            decimalFormat.parse(arguments.getTargetAsString()),
                            (RoundingMode) arguments.getParameter(0));
        }

        if (SCH_FLOAT_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                new BigDecimal(arguments.getTargetAsFloat().doubleValue());
            bigDecimal = bigDecimal.setScale(0, (RoundingMode) arguments.getParameter(0));
            return fromNumber(bigDecimal);
        }

        if (SCH_DOUBLE_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                new BigDecimal(arguments.getTargetAsDouble().doubleValue());
            bigDecimal = bigDecimal.setScale(0, (RoundingMode) arguments.getParameter(0));
            return fromNumber(bigDecimal);
        }

        if (SCH_BIGDECIMAL_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                    ((BigDecimal)arguments.getTarget()).setScale(
                            0, (RoundingMode) arguments.getParameter(0));
            return fromNumber(bigDecimal);
        }
        
        return null;
        
    }

    
    protected abstract T executeNonDecimalNumber(final FunctionArguments arguments)
            throws Exception;


    
    protected abstract T fromString(final String string, final int radix) throws Exception;


    
    
    protected final T fromNumber(
            final Number number, final RoundingMode roundingMode) throws Exception {
        BigDecimal bigDecimal = null;
        if (number instanceof BigDecimal) {
            bigDecimal = (BigDecimal) number;
        } else if (number instanceof BigInteger) {
            bigDecimal = new BigDecimal((BigInteger) number);
        } else {
            bigDecimal = new BigDecimal(number.doubleValue());
        }
        bigDecimal = bigDecimal.setScale(0, roundingMode); // scale == 0
        return fromNumber(bigDecimal);
    }

    
    protected final T fromString(
            final String string, final RoundingMode roundingMode) throws Exception {
        return fromNumber(fromString(string), roundingMode);
    }
        
    
}
