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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.LocaleUtils;
import org.op4j.operation.Arguments;
import org.op4j.operation.ArgumentsTypeScheme;
import org.op4j.operation.Result;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class NonDecimalNumberConverter extends NumberConverter {

    
	private static final long serialVersionUID = -1837141367740669785L;
	

	private static final TypeScheme PTS_ROUNDINGMODE = TypeSchemes.forName("java.math.RoundingMode");
    private static final TypeScheme PTS_ROUNDINGMODE_LOCALE = TypeSchemes.forName("java.math.RoundingMode, Locale");
    private static final TypeScheme PTS_ROUNDINGMODE_STRINGLOCALE = TypeSchemes.forName("java.math.RoundingMode, String");
    private static final TypeScheme PTS_ROUNDINGMODE_DECIMALISCOMMA = TypeSchemes.forName("java.math.RoundingMode, 'DECIMAL_IS_COMMA'");
    private static final TypeScheme PTS_ROUNDINGMODE_DECIMALISPOINT = TypeSchemes.forName("java.math.RoundingMode, 'DECIMAL_IS_POINT'");
    private static final TypeScheme PTS_ROUNDINGMODE_DECIMALCANBEPOINTORCOMMA = TypeSchemes.forName("java.math.RoundingMode, 'DECIMAL_CAN_BE_POINT_OR_COMMA'");
	
	
    
    
    private static final ArgumentsTypeScheme ATS_STRING_INTEGER = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            TypeSchemes.INTEGER_TYPESCHEME,
                "Conversion is performed using the corresponding " +
                "X.valueOf(string, radix) methods, so the String target is expected to be " +
                "expressed in the specified radix");  

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "A point (.) is interpreted as a decimal symbol, as this is the way XX.valueOf() methods work"); 

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE_LOCALE,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "Decimal and thousands symbols are interpreting according to the specified locale"); 

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE_STRINGLOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE_STRINGLOCALE,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "Decimal and thousands symbols are interpreting according to the specified locale"); 

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE_DECIMALISCOMMA,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "A comma (,) is interpreted as a decimal symbol"); 

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE_DECIMAL_IS_POINT = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE_DECIMALISPOINT,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "A point (.) is interpreted as a decimal symbol"); 

    private static final ArgumentsTypeScheme ATS_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME,
            PTS_ROUNDINGMODE_DECIMALCANBEPOINTORCOMMA,
                "Conversion is performed from the specified String target by rounding decimals " +
                "in the way specified the java.math.RoundingMode parameter. " +
                "Both a point (.) or a comma (,) can be interpreted as a decimal symbol, depending on " +
                "which one appears last (the last one will)"); 

    private static final ArgumentsTypeScheme ATS_FLOAT_ROUNDINGMODE = 
        new ArgumentsTypeScheme(
            TypeSchemes.FLOAT_TYPESCHEME,
            PTS_ROUNDINGMODE,
                "Conversion is performed from Float by rounding decimals in the way " +
                "specified by the java.math.RoundingMode parameter"); 

    private static final ArgumentsTypeScheme ATS_DOUBLE_ROUNDINGMODE = 
        new ArgumentsTypeScheme(
            TypeSchemes.DOUBLE_TYPESCHEME,
            PTS_ROUNDINGMODE,
                "Conversion is performed from Double by rounding decimals in the way " +
                "specified by the java.math.RoundingMode parameter"); 

    private static final ArgumentsTypeScheme ATS_BIGDECIMAL_ROUNDINGMODE = 
        new ArgumentsTypeScheme(
            TypeSchemes.BIGDECIMAL_TYPESCHEME,
            PTS_ROUNDINGMODE,
                "Conversion is performed from Double by rounding decimals in the way " +
                "specified by the java.math.RoundingMode parameter"); 
    
    
    @Override
    protected final Set<ArgumentsTypeScheme> registerNumberMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_STRING_INTEGER);
        matched.add(ATS_STRING_ROUNDINGMODE);
        matched.add(ATS_STRING_ROUNDINGMODE_LOCALE);
        matched.add(ATS_STRING_ROUNDINGMODE_STRINGLOCALE);
        matched.add(ATS_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA);
        matched.add(ATS_STRING_ROUNDINGMODE_DECIMAL_IS_POINT);
        matched.add(ATS_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA);
        matched.add(ATS_FLOAT_ROUNDINGMODE);
        matched.add(ATS_DOUBLE_ROUNDINGMODE);
        matched.add(ATS_BIGDECIMAL_ROUNDINGMODE);
        matched.addAll(registerNonDecimalNumberMatchedArgumentTypeSchemes());
        return matched;
    }
    
    
    protected abstract Set<ArgumentsTypeScheme> registerNonDecimalNumberMatchedArgumentTypeSchemes();

    
    @Override
    protected final Result doExecuteNumber(final Arguments arguments) throws Exception {

        final Result result = doExecuteNonDecimalNumber(arguments);
        if (result != null) {
            return result;
        }
        
        if (ATS_STRING_INTEGER.matches(arguments)) {
            return createUniqResult(
                    fromString(
                            arguments.getStringTarget(0),
                            arguments.getIntegerParameter(0).intValue()));
        }
        
        if (ATS_STRING_ROUNDINGMODE.matches(arguments)) {
            return createUniqResult(
                    fromString(
                            arguments.getStringTarget(0),
                            (RoundingMode) arguments.getParameter(0)));
        }
        
        if (ATS_STRING_ROUNDINGMODE_DECIMAL_IS_POINT.matches(arguments)) {
            // Like with ATS_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(
                                rebuildNumberString(arguments.getStringTarget(0), DecimalSign.POINT),
                                (RoundingMode) arguments.getParameter(0)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_ROUNDINGMODE_DECIMAL_IS_COMMA.matches(arguments)) {
            // Like with ATS_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(
                                rebuildNumberString(arguments.getStringTarget(0), DecimalSign.COMMA),
                                (RoundingMode) arguments.getParameter(0)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_ROUNDINGMODE_DECIMAL_CAN_BE_POINT_OR_COMMA.matches(arguments)) {
            // Like with ATS_STRING_ROUNDINGMODE, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(
                                rebuildNumberString(arguments.getStringTarget(0), DecimalSign.POINT_OR_COMMA),
                                (RoundingMode) arguments.getParameter(0)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_ROUNDINGMODE_LOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(arguments.getLocaleParameter(2));
            decimalFormat.setParseBigDecimal(true);
            return createUniqResult(
                    fromNumber(
                            decimalFormat.parse(arguments.getStringTarget(0)),
                            (RoundingMode) arguments.getParameter(0)));
        }
        
        if (ATS_STRING_ROUNDINGMODE_STRINGLOCALE.matches(arguments)) {
            final DecimalFormat decimalFormat = 
                (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(arguments.getStringParameter(2)));
            decimalFormat.setParseBigDecimal(true);
            return createUniqResult(
                    fromNumber(
                            decimalFormat.parse(arguments.getStringTarget(0)),
                            (RoundingMode) arguments.getParameter(0)));
        }

        if (ATS_FLOAT_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                new BigDecimal(arguments.getFloatTarget(0).doubleValue());
            bigDecimal = bigDecimal.setScale(0, (RoundingMode) arguments.getParameter(0));
            return createUniqResult(fromNumber(bigDecimal));
        }

        if (ATS_DOUBLE_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                new BigDecimal(arguments.getDoubleTarget(0).doubleValue());
            bigDecimal = bigDecimal.setScale(0, (RoundingMode) arguments.getParameter(0));
            return createUniqResult(fromNumber(bigDecimal));
        }

        if (ATS_BIGDECIMAL_ROUNDINGMODE.matches(arguments)) {
            BigDecimal bigDecimal = 
                    ((BigDecimal)arguments.getTarget(0)).setScale(
                            0, (RoundingMode) arguments.getParameter(0));
            return createUniqResult(fromNumber(bigDecimal));
        }
        
        return null;
        
    }

    
    protected abstract Result doExecuteNonDecimalNumber(final Arguments arguments)
            throws Exception;

    
    protected abstract Number fromString(final String string, final int radix) throws Exception;


    
    
    protected final Number fromNumber(
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

    
    protected final Number fromString(
            final String string, final RoundingMode roundingMode) throws Exception {
        return fromNumber(fromString(string), roundingMode);
    }
        
    
}
