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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.BooleanUtils;
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
public abstract class NumberConverter<T extends Number> extends ConverterImplementation<T> {



	protected static enum DecimalSign { POINT, COMMA, POINT_OR_COMMA }
    
    
    private static final String DECIMAL_IS_COMMA = "'DECIMAL_IS_COMMA'";
    private static final String DECIMAL_IS_POINT = "'DECIMAL_IS_POINT'";
    private static final String DECIMAL_CAN_BE_POINT_OR_COMMA = "'DECIMAL_CAN_BE_POINT_OR_COMMA'";
    
    
    private static final FunctionArgumentScheme SCH_NUMBER_EMPTY = 
        FunctionArgumentScheme.from(
            "Coversion is performed using the corresponding Number.xxxValue() methods. " +
            "BigDecimal and BigInteger objects are handled in a specific manner",
            Types.NUMBER);
    
    private static final FunctionArgumentScheme SCH_STRING_EMPTY = 
        FunctionArgumentScheme.from(
            "Conversion is performed using the corresponding String-parameterized " +
            "constructors or X.valueOf() methods",
            Types.STRING);
    
    private static final FunctionArgumentScheme SCH_STRING_LOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed using a java.text.NumberFormat instance for the specified locale",
            Types.STRING, 
            "Locale");
    
    private static final FunctionArgumentScheme SCH_STRING_STRINGLOCALE = 
        FunctionArgumentScheme.from(
            "Conversion is performed using a java.text.NumberFormat instance for the specified locale",
            Types.STRING, 
            "String");
    
    private static final FunctionArgumentScheme SCH_STRING_DECIMALISCOMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed using the comma (,) as a decimal symbol",
            Types.STRING, 
            DECIMAL_IS_COMMA);
    
    private static final FunctionArgumentScheme SCH_STRING_DECIMALISPOINT = 
        FunctionArgumentScheme.from(
            "Conversion is performed using the point (.) as a decimal symbol",
            Types.STRING, 
            DECIMAL_IS_POINT);
    
    private static final FunctionArgumentScheme SCH_STRING_DECIMALCANBEPOINTORCOMMA = 
        FunctionArgumentScheme.from(
            "Conversion is performed looking for the last appearance of a point (.) or a comma (,) in the " +
            "target, and using it as the decimal symbol",
            Types.STRING, 
            DECIMAL_CAN_BE_POINT_OR_COMMA);
    
    private static final FunctionArgumentScheme SCH_BOOLEAN_EMPTY = 
        FunctionArgumentScheme.from(
            "Conversion of TRUE returns 1, conversion of FALSE returns 0",
            Types.BOOLEAN);

    
    
    
    private final Map<Locale,DecimalFormat> decimalFormatsByLocale =
        new ConcurrentHashMap<Locale, DecimalFormat>();
    
    
    
    
    public NumberConverter() {
        super();
    }


    
    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(SCH_NUMBER_EMPTY);
        matched.add(SCH_STRING_EMPTY);
        matched.add(SCH_STRING_LOCALE);
        matched.add(SCH_STRING_STRINGLOCALE);
        matched.add(SCH_STRING_DECIMALISCOMMA);
        matched.add(SCH_STRING_DECIMALISPOINT);
        matched.add(SCH_STRING_DECIMALCANBEPOINTORCOMMA);
        matched.add(SCH_BOOLEAN_EMPTY);
        matched.addAll(registerNumberMatchedSchemes());
        return matched;
    }
    

    
    protected abstract Set<FunctionArgumentScheme> registerNumberMatchedSchemes();
    
    

    
    
    
    @Override
    public final T execute(final FunctionArguments arguments) throws Exception {
     
        if (arguments.isTargetNull()) {
            return null;
        }
        
        final T result = executeNumber(arguments);
        if (result != null) {
            return result;
        }
        
        if (SCH_NUMBER_EMPTY.matches(arguments)) {
            return fromNumber(arguments.getTargetAsNumber());
        }
        
        if (SCH_STRING_EMPTY.matches(arguments)) {
            return fromString(arguments.getTargetAsString());
        }
        
        if (SCH_STRING_DECIMALISPOINT.matches(arguments)) {
            // Like with SCH_STRING_EMPTY, but preprocessing decimals
            try {
                return fromString(rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_DECIMALISCOMMA.matches(arguments)) {
            // Like with SCH_STRING_EMPTY, but preprocessing decimals
            try {
                return fromString(rebuildNumberString(arguments.getTargetAsString(), DecimalSign.COMMA));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_DECIMALCANBEPOINTORCOMMA.matches(arguments)) {
            // Like with SCH_STRING_EMPTY, but preprocessing decimals
            try {
                return fromString(rebuildNumberString(arguments.getTargetAsString(), DecimalSign.POINT_OR_COMMA));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getTargetAsString() + "\"");
            }
        }
        
        if (SCH_STRING_LOCALE.matches(arguments)) {
            final Locale locale = arguments.getLocaleParameter(0);
            DecimalFormat decimalFormat = this.decimalFormatsByLocale.get(locale);
            if (decimalFormat == null) {
                decimalFormat = 
                    (DecimalFormat) NumberFormat.getNumberInstance(locale);
                decimalFormat.setParseBigDecimal(true);
                this.decimalFormatsByLocale.put(locale, decimalFormat);
            }
            return fromNumber(decimalFormat.parse(arguments.getTargetAsString()));
        }
        
        if (SCH_STRING_STRINGLOCALE.matches(arguments)) {
            final Locale locale = LocaleUtils.toLocale(arguments.getStringParameter(0));
            DecimalFormat decimalFormat = this.decimalFormatsByLocale.get(locale);
            if (decimalFormat == null) {
                decimalFormat = 
                    (DecimalFormat) NumberFormat.getNumberInstance(locale);
                decimalFormat.setParseBigDecimal(true);
                this.decimalFormatsByLocale.put(locale, decimalFormat);
            }
            return fromNumber(decimalFormat.parse(arguments.getTargetAsString()));
        }

        if (SCH_BOOLEAN_EMPTY.matches(arguments)) {
            return fromNumber(BooleanUtils.toIntegerObject(arguments.getTargetAsBoolean()));
        }

        
        return null;
        
    }

    
    
    protected abstract T executeNumber(final FunctionArguments arguments) throws Exception;

    
    
    protected abstract T fromNumber(final Number number) throws Exception;
    
    protected abstract T fromString(final String string) throws Exception;
    
    
    
    
    protected final String rebuildNumberString(final String original, final DecimalSign decimalSign) {
        
        if (DecimalSign.POINT_OR_COMMA.equals(decimalSign)) {
            final int lastPoint = original.lastIndexOf(".");
            final int lastComma = original.lastIndexOf(",");
            if (lastPoint >= lastComma) {
                return rebuildNumberString(original, DecimalSign.POINT);
            }
            return rebuildNumberString(original, DecimalSign.COMMA);
        }
        
        if (DecimalSign.POINT.equals(decimalSign)) {
            return original;
        }
        
        /*
         * Java's standard decimal point for valueOf operations is point,
         * so the decimal comma will have to be replaced by a point.
         */
        final int lastPos = original.lastIndexOf(",");
        if (lastPos == -1) {
            // This is to avoid that things like "12.34" are valid if decimal is comma
            return original + ".0";
        }
        return original.substring(0, lastPos) + "." +
                (lastPos + 1 < original.length()? original.substring(lastPos + 1) : "");
        
    }

    
}
