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
public abstract class DecimalNumberConverter<T extends Number> extends NumberConverter<T> {

    
	private static final long serialVersionUID = -4692290976744290222L;
	
	
    

    private static final FunctionArgumentScheme SCH_NUMBER_SCALE_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified Number target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter",
            Types.NUMBER,
            "Integer,RoundingMode"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "A point (.) is interpreted as a decimal symbol, as this is the way XX.valueOf() methods work",
            Types.STRING,
            "Integer,RoundingMode"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE_LOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "Decimal and thousands symbols are interpreting according to the specified locale",
            Types.STRING,
            "Integer, RoundingMode, Locale"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE_STRINGLOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "Decimal and thousands symbols are interpreting according to the specified locale",
            Types.STRING,
            "Integer, RoundingMode, String"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_COMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "A comma (,) is interpreted as a decimal symbol",
            Types.STRING,
            "Integer scale, RoundingMode roundingMode, 'DECIMAL_IS_COMMA'"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_POINT = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "A point (.) is interpreted as a decimal symbol",
            Types.STRING,
            "Integer scale, RoundingMode roundingMode, 'DECIMAL_IS_POINT'"); 

    private static final FunctionArgumentScheme SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed from the specified String target by rounding decimals less " +
            "significant than the scale in the way specified the java.math.RoundingMode parameter. " +
            "Both a point (.) or a comma (,) can be interpreted as a decimal symbol, depending on " +
            "which one appears last (the last one will)",
            Types.STRING,
            "Integer scale, java.math.RoundingMode roundingMode, 'DECIMAL_CAN_BE_POINT_OR_COMMA'");

    
    
    
    
    public DecimalNumberConverter() {
        super();
    }
    
    
    
    @Override
    protected Set<FunctionArgumentScheme> registerNumberMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_NUMBER_SCALE_ROUNDINGMODE);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE_LOCALE);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE_STRINGLOCALE);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_COMMA);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_POINT);
        matched.add(SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA);
        matched.addAll(registerDecimalNumberMatchedSchemes());
        return matched;
    }
    
    
    
    
    protected abstract Set<FunctionArgumentScheme> registerDecimalNumberMatchedSchemes();

    
    
    
    
    @Override
    protected T executeNumber(final FunctionArguments arguments) throws Exception {

        final T result = executeDecimalNumber(arguments);
        if (result != null) {
            return result;
        }

        if (SCH_NUMBER_SCALE_ROUNDINGMODE.matches(arguments)) {
            return fromNumber(
                            arguments.getTargetAsNumber(), 
                            arguments.getIntegerParameter(0).intValue(),
                            (RoundingMode) arguments.getParameter(1));
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE.matches(arguments)) {
            return fromString(
                            arguments.getTargetAsString(),
                            arguments.getIntegerParameter(0).intValue(),
                            (RoundingMode) arguments.getParameter(1));
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_POINT.matches(arguments)) {
            // Like with SCH_STRING_SCALE_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT),
                                arguments.getIntegerParameter(0).intValue(),
                                (RoundingMode) arguments.getParameter(1));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_IS_COMMA.matches(arguments)) {
            // Like with SCH_STRING_SCALE_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.COMMA),
                                arguments.getIntegerParameter(0).intValue(),
                                (RoundingMode) arguments.getParameter(1));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA.matches(arguments)) {
            // Like with SCH_STRING_SCALE_ROUNDINGMODE, but preprocessing decimals
            try {
                return fromString(
                                rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT_OR_COMMA),
                                arguments.getIntegerParameter(0).intValue(),
                                (RoundingMode) arguments.getParameter(1));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE_LOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(arguments.getLocaleParameter(2));
            decimalFormat.setParseBigDecimal(true);
            return fromNumber(
                            decimalFormat.parse(arguments.getTargetAsString()),
                            arguments.getIntegerParameter(0).intValue(),
                            (RoundingMode) arguments.getParameter(1));
        }
        
        if (SCH_STRING_SCALE_ROUNDINGMODE_STRINGLOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(arguments.getStringParameter(2)));
            decimalFormat.setParseBigDecimal(true);
            return fromNumber(
                            decimalFormat.parse(arguments.getTargetAsString()),
                            arguments.getIntegerParameter(0).intValue(),
                            (RoundingMode) arguments.getParameter(1));
        }

        
        
        return null;
        
    }

    
    protected abstract T executeDecimalNumber(final FunctionArguments arguments)
            throws Exception;


    
    protected final T fromNumber(
            final Number number, final int scale, final RoundingMode roundingMode) throws Exception {
        BigDecimal bigDecimal = null;
        if (number instanceof BigDecimal) {
            bigDecimal = (BigDecimal) number;
        } else if (number instanceof BigInteger) {
            bigDecimal = new BigDecimal((BigInteger) number);
        } else {
            bigDecimal = new BigDecimal(number.doubleValue());
        }
        bigDecimal = bigDecimal.setScale(scale, roundingMode);
        return fromNumber(bigDecimal);
    }

    
    protected final T fromString(
            final String string, final int scale, final RoundingMode roundingMode) throws Exception {
        return fromNumber(fromString(string), scale, roundingMode);
    }
    
    
}
