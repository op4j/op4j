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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.BooleanUtils;
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
public abstract class NumberConverter extends UniqResultConverter {

    
	private static final long serialVersionUID = -5697885898106100776L;


	protected static enum DecimalSign { POINT, COMMA, POINT_OR_COMMA }
    
    
    private static final TypeScheme PTS_DECIMAL_IS_COMMA = 
        TypeSchemes.forName("'DECIMAL_IS_COMMA'");
    private static final TypeScheme PTS_DECIMAL_IS_POINT = 
        TypeSchemes.forName("'DECIMAL_IS_POINT'");
    private static final TypeScheme PTS_DECIMAL_CAN_BE_POINT_OR_COMMA = 
        TypeSchemes.forName("'DECIMAL_CAN_BE_POINT_OR_COMMA'");
    
    
    private static final ArgumentsTypeScheme ATS_NUMBER_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.NUMBER_TYPESCHEME,
            TypeSchemes.EMPTY_TYPESCHEME,
                "Coversion is performed using the corresponding Number.xxxValue() methods. " +
                "BigDecimal and BigInteger objects are handled in a specific manner");
    
    private static final ArgumentsTypeScheme ATS_STRING_EMPTY = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.EMPTY_TYPESCHEME,
                "Conversion is performed using the corresponding String-parameterized " +
                "constructors or X.valueOf() methods");
    
    private static final ArgumentsTypeScheme ATS_STRING_LOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.LOCALE_TYPESCHEME,
                "Conversion is performed using a java.text.NumberFormat instance for the specified locale");
    
    private static final ArgumentsTypeScheme ATS_STRING_STRINGLOCALE = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            TypeSchemes.STRING_TYPESCHEME, 
                "Conversion is performed using a java.text.NumberFormat instance for the specified locale");
    
    private static final ArgumentsTypeScheme ATS_STRING_DECIMALISCOMMA = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            PTS_DECIMAL_IS_COMMA, 
                "Conversion is performed using the comma (,) as a decimal symbol");
    
    private static final ArgumentsTypeScheme ATS_STRING_DECIMALISPOINT = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            PTS_DECIMAL_IS_POINT, 
                "Conversion is performed using the point (.) as a decimal symbol");
    
    private static final ArgumentsTypeScheme ATS_STRING_DECIMALCANBEPOINTORCOMMA = 
        new ArgumentsTypeScheme(
            TypeSchemes.STRING_TYPESCHEME, 
            PTS_DECIMAL_CAN_BE_POINT_OR_COMMA, 
                "Conversion is performed looking for the last appearance of a point (.) or a comma (,) in the " +
                "target, and using it as the decimal symbol");
    
    private static final ArgumentsTypeScheme ATS_BOOLEAN_EMPTY = 
        new ArgumentsTypeScheme(
                TypeSchemes.BOOLEAN_TYPESCHEME,
                TypeSchemes.EMPTY_TYPESCHEME, 
                    "Conversion of TRUE returns 1, conversion of FALSE returns 0");

    
    
    
    private final Map<Locale,DecimalFormat> decimalFormatsByLocale =
        new ConcurrentHashMap<Locale, DecimalFormat>();
    
    
    
    
    public NumberConverter() {
        super();
    }


    @Override
    protected final Set<ArgumentsTypeScheme> registerMatchedArgumentTypeSchemes() {
        final Set<ArgumentsTypeScheme> matched = new LinkedHashSet<ArgumentsTypeScheme>();
        matched.add(ATS_NUMBER_EMPTY);
        matched.add(ATS_STRING_EMPTY);
        matched.add(ATS_STRING_LOCALE);
        matched.add(ATS_STRING_STRINGLOCALE);
        matched.add(ATS_STRING_DECIMALISCOMMA);
        matched.add(ATS_STRING_DECIMALISPOINT);
        matched.add(ATS_STRING_DECIMALCANBEPOINTORCOMMA);
        matched.add(ATS_BOOLEAN_EMPTY);
        matched.addAll(registerNumberMatchedArgumentTypeSchemes());
        return matched;
    }

    
    protected abstract Set<ArgumentsTypeScheme> registerNumberMatchedArgumentTypeSchemes();
    
    
    
    @Override
    public final Result doExecute(final Arguments arguments) throws Exception {

        if (arguments.areAllTargetsNull()) {
            return createUniqResult((Object[])null);
        }
        
        final Result result = doExecuteNumber(arguments);
        if (result != null) {
            return result;
        }
        
        if (ATS_NUMBER_EMPTY.matches(arguments)) {
            return createUniqResult(fromNumber(arguments.getNumberTarget(0)));
        }
        
        if (ATS_STRING_EMPTY.matches(arguments)) {
            return createUniqResult(fromString(arguments.getStringTarget(0)));
        }
        
        if (ATS_STRING_DECIMALISPOINT.matches(arguments)) {
            // Like with ATS_STRING_EMPTY, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(rebuildNumberString(arguments.getStringTarget(0), DecimalSign.POINT)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_DECIMALISCOMMA.matches(arguments)) {
            // Like with ATS_STRING_EMPTY, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(rebuildNumberString(arguments.getStringTarget(0), DecimalSign.COMMA)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_DECIMALCANBEPOINTORCOMMA.matches(arguments)) {
            // Like with ATS_STRING_EMPTY, but preprocessing decimals
            try {
                return createUniqResult(
                        fromString(rebuildNumberString(arguments.getStringTarget(0), DecimalSign.POINT_OR_COMMA)));
            } catch (NumberFormatException e) {
                // original input could have been modified, so raise the right exception
                throw new NumberFormatException("For input string: \"" + arguments.getStringTarget(0) + "\"");
            }
        }
        
        if (ATS_STRING_LOCALE.matches(arguments)) {
            final Locale locale = arguments.getLocaleParameter(0);
            DecimalFormat decimalFormat = this.decimalFormatsByLocale.get(locale);
            if (decimalFormat == null) {
                decimalFormat = 
                    (DecimalFormat) NumberFormat.getNumberInstance(locale);
                decimalFormat.setParseBigDecimal(true);
                this.decimalFormatsByLocale.put(locale, decimalFormat);
            }
            return createUniqResult(
                    fromNumber(decimalFormat.parse(arguments.getStringTarget(0))));
        }
        
        if (ATS_STRING_STRINGLOCALE.matches(arguments)) {
            final Locale locale = LocaleUtils.toLocale(arguments.getStringParameter(0));
            DecimalFormat decimalFormat = this.decimalFormatsByLocale.get(locale);
            if (decimalFormat == null) {
                decimalFormat = 
                    (DecimalFormat) NumberFormat.getNumberInstance(locale);
                decimalFormat.setParseBigDecimal(true);
                this.decimalFormatsByLocale.put(locale, decimalFormat);
            }
            return createUniqResult(
                    fromNumber(decimalFormat.parse(arguments.getStringTarget(0))));
        }

        if (ATS_BOOLEAN_EMPTY.matches(arguments)) {
            return createUniqResult(
                    fromNumber(BooleanUtils.toIntegerObject(arguments.getBooleanTarget(0))));
        }

        
        return null;
        
    }

    
    
    protected abstract Result doExecuteNumber(final Arguments arguments) throws Exception;

    
    
    protected abstract Number fromNumber(final Number number) throws Exception;
    
    protected abstract Number fromString(final String string) throws Exception;
    
    
    
    
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
