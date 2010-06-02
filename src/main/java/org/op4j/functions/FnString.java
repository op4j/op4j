/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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
package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.FnString.Replace.ReplaceType;
import org.op4j.functions.FnStringAuxNumberConverters.ToBigDecimal;
import org.op4j.functions.FnStringAuxNumberConverters.ToBigInteger;
import org.op4j.functions.FnStringAuxNumberConverters.ToByte;
import org.op4j.functions.FnStringAuxNumberConverters.ToDouble;
import org.op4j.functions.FnStringAuxNumberConverters.ToFloat;
import org.op4j.functions.FnStringAuxNumberConverters.ToInteger;
import org.op4j.functions.FnStringAuxNumberConverters.ToLong;
import org.op4j.functions.FnStringAuxNumberConverters.ToShort;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FnString {

	private static final Function<String,String> ESCAPE_CSV_STRING_FUNC = new EscapeCSV();
	private static final Function<String,String> UNESCAPE_CSV_STRING_FUNC = new UnescapeCSV();
	private static final Function<String,String> ESCAPE_XML_STRING_FUNC = new EscapeXML();
	private static final Function<String,String> UNESCAPE_XML_STRING_FUNC = new UnescapeXML();
	private static final Function<String,String> ESCAPE_HTML_STRING_FUNC = new EscapeHTML();
	private static final Function<String,String> UNESCAPE_HTML_STRING_FUNC = new UnescapeHTML();
	private static final Function<String,String> ESCAPE_JAVASCRIPT_STRING_FUNC = new EscapeJavaScript();
	private static final Function<String,String> UNESCAPE_JAVASCRIPT_STRING_FUNC = new UnescapeJavaScript();
	private static final Function<String,String> TO_UPPER_CASE_STRING_FUNC = new ToUpperCase();
	private static final Function<String,String> TO_LOWER_CASE_STRING_FUNC = new ToLowerCase();
	private static final Function<String,String> UN_CAPITALIZE_STRING_FUNC = new UnCapitalize();
	private static final Function<String,String> CAPITALIZE_STRING_FUNC = new Capitalize();
	private static final Function<String,String> TRIM_STRING_FUNC = new Trim();
	private static final Function<String,String> STRIP_STRING_FUNC = new Strip();
	
	private static final Function<String,BigDecimal> TO_BIG_DECIMAL = new ToBigDecimal();
    private static final Function<String,BigInteger> TO_BIG_INTEGER = new ToBigInteger();
    private static final Function<String,Double> TO_DOUBLE = new ToDouble();
    private static final Function<String,Float> TO_FLOAT = new ToFloat();
    private static final Function<String,Long> TO_LONG = new ToLong();
    private static final Function<String,Integer> TO_INTEGER = new ToInteger();
    private static final Function<String,Short> TO_SHORT = new ToShort();
    private static final Function<String,Byte> TO_BYTE = new ToByte();
	
    private static final Function<String,Boolean> TO_BOOLEAN = new ToBoolean();
	
    private static final Function<String,List<String>> SPLIT = new Split();
    private static final Function<String,String[]> SPLIT_AS_ARRAY = new SplitAsArray();
    
    private static final Function<List<Object>,String> JOIN = new Join();
    private static final Function<Object[],String> JOIN_ARRAY = new JoinArray();
    
    private static final Function<String,String> ASCIIFY = new Asciify();
    
    private static final Function<String, Boolean> IS_ALPHA = new IsAlpha();
    private static final Function<String, Boolean> IS_ALPHA_SPACE = new IsAlpha(true);
    private static final Function<String, Boolean> IS_NUMERIC = new IsNumeric();
    private static final Function<String, Boolean> IS_NUMERIC_SPACE = new IsNumeric(true);
    
    private static final Function<String, Boolean> IS_BIG_DECIMAL = new IsBigDecimal();
    private static final Function<String, Boolean> IS_BIG_INTEGER = new IsBigInteger();
    private static final Function<String, Boolean> IS_DOUBLE = new IsDouble();
    private static final Function<String, Boolean> IS_FLOAT = new IsFloat();
    private static final Function<String, Boolean> IS_LONG = new IsLong();
    private static final Function<String, Boolean> IS_INTEGER = new IsInteger();
    private static final Function<String, Boolean> IS_SHORT = new IsShort();
    private static final Function<String, Boolean> IS_BYTE = new IsByte();
    
	
	private FnString() {
		super();           
	}

	
    
	/**
	 * <p>
     * Converts a String into a BigDecimal, using the default configuration
     * for for decimal point and precision.
	 * </p>
	 * 
	 * @return the resulting BigDecimal object
	 */
    public static final Function<String,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified locale for decimal
     * point and thousands separator configuration.
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final Locale locale) {
        return new ToBigDecimal(locale);
    }

    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.)
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final String locale) {
        return new ToBigDecimal(locale);
    }

    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final DecimalPoint decimalPoint) {
        return new ToBigDecimal(decimalPoint);
    }

    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the default configuration
     * for for decimal point and thousands separator and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value. 
     * </p>
     * 
     * @param scale the desired scale for the resulting BigDecimal object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new ToBigDecimal(scale, roundingMode);
    }

    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.
     * </p>
     * 
     * @param scale the desired scale for the resulting BigDecimal object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToBigDecimal(scale, roundingMode, locale);
    }


    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.  Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.)
     * </p>
     * 
     * @param scale the desired scale for the resulting BigDecimal object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToBigDecimal(scale, roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a BigDecimal, using the specified decimal point
     * configuration ({@link DecimalPoint}) and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.. The target String should contain no
     * thousand separators.
     * </p>
     * 
     * @param scale the desired scale for the resulting BigDecimal object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting BigDecimal object
     */
    public static final Function<String,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToBigDecimal(scale, roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a BigInteger, using the default configuration.
     * Any fractional part of the input String will be removed. 
     * </p>
     * 
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }

    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified locale for decimal
     * point and thousands separator configuration.
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final Locale locale) {
        return new ToBigInteger(locale);
    }

    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.).
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final String locale) {
        return new ToBigInteger(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators.
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final DecimalPoint decimalPoint) {
        return new ToBigInteger(decimalPoint);
    }

    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified radix for computing the
     * equivalent number. The input String must be a valid BigInteger in the given radix
     * (i.e. if radix is 5, 34 would be a valid input whereas 34.3 wouldn't as '.' is not allowed). 
     * </p>
     * 
     * @param radix the radix in which the number is supposedly represented in the String
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final int radix) {
        return new ToBigInteger(Integer.valueOf(radix));
    }
    
    
    /**
     * <p>
     * Converts a String into a BigInteger, using the default configuration
     * for for decimal point and thousands separator. Rounding
     * mode is used for removing the decimal part of the number. 
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final RoundingMode roundingMode) {
        return new ToBigInteger(roundingMode);
    }
    
    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified decimal point
     * configuration ({@link DecimalPoint}). Rounding mode is used for removing the 
     * decimal part of the number. The target String should contain no
     * thousand separators.
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToBigInteger(roundingMode, decimalPoint);
    }

    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number.
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final Locale locale) {
        return new ToBigInteger(roundingMode, locale);
    }

    
    /**
     * <p>
     * Converts a String into a BigInteger, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.).
     * Any fractional part of the input String will be removed.
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting BigInteger object
     */
    public static final Function<String,BigInteger> toBigInteger(final RoundingMode roundingMode, final String locale) {
        return new ToBigInteger(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Double, using the default configuration
     * for for decimal point and precision. 
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    
    /**
     * <p>
     * Converts a String into a Double, using the specified locale for decimal
     * point and thousands separator configuration. 
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final Locale locale) {
        return new ToDouble(locale);
    }
    

    /**
     * <p>
     * Converts a String into a Double, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final String locale) {
        return new ToDouble(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Double, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final DecimalPoint decimalPoint) {
        return new ToDouble(decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Double, using the default configuration
     * for for decimal point and thousands separator and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value. 
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Double object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final int scale, final RoundingMode roundingMode) {
        return new ToDouble(scale, roundingMode);
    }
    
    /**
     * <p>
     * Converts a String into a Double, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value. 
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Double object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToDouble(scale, roundingMode, locale);
    }

    
    /**
     * <p>
     * Converts a String into a Double, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.  Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.).
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Double object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToDouble(scale, roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Double, using the specified decimal point
     * configuration ({@link DecimalPoint}) and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.
     * The input string must be between 
     * {@link Double#MIN_VALUE} and {@link Double#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Double object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Double object
     */
    public static final Function<String,Double> toDouble(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToDouble(scale, roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the default configuration
     * for for decimal point and precision. 
     * The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat() {
        return TO_FLOAT;
    }

    
    /**
     * <p>
     * Converts a String into a Float, using the specified locale for decimal
     * point and thousands separator configuration. The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final Locale locale) {
        return new ToFloat(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final String locale) {
        return new ToFloat(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final DecimalPoint decimalPoint) {
        return new ToFloat(decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the default configuration
     * for for decimal point and thousands separator and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value. 
     * The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Float object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final int scale, final RoundingMode roundingMode) {
        return new ToFloat(scale, roundingMode);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value. 
     * The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Float object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new ToFloat(scale, roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the specified locale for decimal
     * point and thousands separator configuration and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.  Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Float object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final String locale) {
        return new ToFloat(scale, roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Float, using the specified decimal point
     * configuration ({@link DecimalPoint}) and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.. The target String should contain no
     * thousand separators. The input string must be between 
     * {@link Float#MIN_VALUE} and {@link Float#MAX_VALUE}
     * </p>
     * 
     * @param scale the desired scale for the resulting Float object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Float object
     */
    public static final Function<String,Float> toFloat(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToFloat(scale, roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the default configuration.
     * The integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong() {
        return TO_LONG;
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the specified locale for decimal
     * point and thousands separator configuration. The 
     * integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final Locale locale) {
        return new ToLong(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final String locale) {
        return new ToLong(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final DecimalPoint decimalPoint) {
        return new ToLong(decimalPoint);
    }

    
    /**
     * <p>
     * Converts a String into a Long, using the specified radix for computing the
     * equivalent number. The input String must be a valid Long in the given radix
     * (i.e. if radix is 5, 34 would be a valid input whereas 34.3 wouldn't as '.' is not allowed) 
     * </p>
     * 
     * @param radix the radix in which the number is supposedly represented in the String
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final int radix) {
        return new ToLong(Integer.valueOf(radix));
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the default configuration
     * for for decimal point and thousands separator. Rounding
     * mode is used for removing the decimal part of the number. The 
     * integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final RoundingMode roundingMode) {
        return new ToLong(roundingMode);
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the specified decimal point
     * configuration ({@link DecimalPoint}). Rounding mode is used for removing the 
     * decimal part of the number. The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToLong(roundingMode, decimalPoint);
    }

    
    /**
     * <p>
     * Converts a String into a Long, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. The integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final RoundingMode roundingMode, final Locale locale) {
        return new ToLong(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Long, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Long#MIN_VALUE} and {@link Long#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Long object
     */
    public static final Function<String,Long> toLong(final RoundingMode roundingMode, final String locale) {
        return new ToLong(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the default 
     * configuration. The integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified locale for decimal
     * point and thousands separator configuration. The 
     * integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final Locale locale) {
        return new ToInteger(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final String locale) {
        return new ToInteger(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final DecimalPoint decimalPoint) {
        return new ToInteger(decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified radix for computing the
     * equivalent number. The input String must be a valid Integer in the given radix
     * (i.e. if radix is 5, 34 would be a valid input whereas 34.3 wouldn't as '.' is not allowed) 
     * </p>
     * 
     * @param radix the radix in which the number is supposedly represented in the String
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final int radix) {
        return new ToInteger(Integer.valueOf(radix));
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the default configuration
     * for for decimal point and thousands separator. Rounding
     * mode is used for removing the decimal part of the number. The 
     * integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final RoundingMode roundingMode) {
        return new ToInteger(roundingMode);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified decimal point
     * configuration ({@link DecimalPoint}). Rounding mode is used for removing the 
     * decimal part of the number. The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToInteger(roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. The integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final RoundingMode roundingMode, final Locale locale) {
        return new ToInteger(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into an Integer, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Integer#MIN_VALUE} and {@link Integer#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Integer object
     */
    public static final Function<String,Integer> toInteger(final RoundingMode roundingMode, final String locale) {
        return new ToInteger(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the default configuration.
     * The integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort() {
        return TO_SHORT;
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified locale for decimal
     * point and thousands separator configuration. The 
     * integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final Locale locale) {
        return new ToShort(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final String locale) {
        return new ToShort(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final DecimalPoint decimalPoint) {
        return new ToShort(decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified radix for computing the
     * equivalent number. The input String must be a valid Short in the given radix
     * (i.e. if radix is 5, 34 would be a valid input whereas 34.3 wouldn't as '.' is not allowed) 
     * </p>
     * 
     * @param radix the radix in which the number is supposedly represented in the String
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final int radix) {
        return new ToShort(Integer.valueOf(radix));
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the default configuration
     * for for decimal point and thousands separator. Rounding
     * mode is used for removing the decimal part of the number. The 
     * integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final RoundingMode roundingMode) {
        return new ToShort(roundingMode);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified decimal point
     * configuration ({@link DecimalPoint}). Rounding mode is used for removing the 
     * decimal part of the number. The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToShort(roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. The integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final RoundingMode roundingMode, final Locale locale) {
        return new ToShort(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Short, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Short#MIN_VALUE} and {@link Short#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Short object
     */
    public static final Function<String,Short> toShort(final RoundingMode roundingMode, final String locale) {
        return new ToShort(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the default configuration.
     * Any fractional part of the input String will be removed. The 
     * integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte() {
        return TO_BYTE;
    }

    
    /**
     * <p>
     * Converts a String into a Byte, using the specified locale for decimal
     * point and thousands separator configuration. The 
     * integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final Locale locale) {
        return new ToByte(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the specified locale for decimal
     * point and thousands separator configuration. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final String locale) {
        return new ToByte(locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the specified decimal point
     * configuration ({@link DecimalPoint}). The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final DecimalPoint decimalPoint) {
        return new ToByte(decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the specified radix for computing the
     * equivalent number. The input String must be a valid Byte in the given radix
     * </p>
     * 
     * @param radix the radix in which the number is supposedly represented in the String
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final int radix) {
        return new ToByte(Integer.valueOf(radix));
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the default configuration
     * for for decimal point and thousands separator. Rounding
     * mode is used for removing the decimal part of the number.
     * The integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE} 
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final RoundingMode roundingMode) {
        return new ToByte(roundingMode);
    }
    

    /**
     * <p>
     * Converts a String into a Byte, using the specified decimal point
     * configuration ({@link DecimalPoint}). Rounding mode is used for removing the 
     * decimal part of the number. The target String should contain no
     * thousand separators. The integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new ToByte(roundingMode, decimalPoint);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. The integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final RoundingMode roundingMode, final Locale locale) {
        return new ToByte(roundingMode, locale);
    }
    
    
    /**
     * <p>
     * Converts a String into a Byte, using the specified locale for determining
     * decimal point. Rounding mode is used for removing the 
     * decimal part of the number. Locale is specified as a String
     * (for example: "en_US", "es_ES", etc.). The 
     * integer part of the input string must be between 
     * {@link Byte#MIN_VALUE} and {@link Byte#MAX_VALUE}
     * </p>
     * 
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param locale the locale defining the way in which the number was written
     * @return the resulting Byte object
     */
    public static final Function<String,Byte> toByte(final RoundingMode roundingMode, final String locale) {
        return new ToByte(roundingMode, locale);
    }
	
	
    
    
    /**
     * <p>
     * Converts a String into a Boolean. Case is ignored, and all three 
     * "true"/"false", "yes"/"no" and "on"/"off" versions are 
     * supported.  
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.toBooleanObject()</tt>.
     * </p>
     * 
     * @return the resulting Boolean object
     */
    public static final Function<String,Boolean> toBoolean() {
        return TO_BOOLEAN;
    }
    
    
	
	/**
	 * <p>
	 * Turns a String into a value valid for being a CSV column value,
	 * enclosed in double quotes if needed.
	 * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.escapeCsv()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>If the value contains a comma, newline or double quote, then the
     *       String value is written enclosed in double quotes.</li>
     *   <li>Any double quote characters in the value are escaped with another double quote.</li>
     *   <li>If the value does not contain a comma, newline or double quote, then the
     *       String value is written unchanged (null values are ignored).</li>
     * </ul>
	 * 
	 * @return the resulting String.
	 */
	public static final Function<String,String> escapeCSV() {
        return ESCAPE_CSV_STRING_FUNC;
    }
	
	
	/**
     * <p>
     * Removes escaping from a String escaped for a CSV column.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.unescapeCsv()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>Returns a <code>String</code> value for an unescaped CSV column.</li>
     *   <li>If the value is enclosed in double quotes, and contains a comma, newline 
     *       or double quote, then quotes are removed.</li> 
     *   <li>Any double quote escaped characters (a pair of double quotes) are unescaped 
     *       to just one double quote.</li>
     *   <li>If the value is not enclosed in double quotes, or is and does not contain a 
     *       comma, newline or double quote, then the String value is returned unchanged.</li>
     * </ul>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> unescapeCSV() {
        return UNESCAPE_CSV_STRING_FUNC;
    }	

	
	/**
     * <p>
     * Escapes the characters in a <code>String</code> using XML entities.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.escapeXml()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>For example: <tt>"bread" &amp; "butter"</tt> =>
     *       <tt>&amp;quot;bread&amp;quot; &amp;amp; &amp;quot;butter&amp;quot;</tt>.</li>
     *   <li>Supports only the five basic XML entities (gt, lt, quot, amp, apos).
     *       Does not support DTDs or external entities.</li>
     *   <li>Note that unicode characters greater than 0x7f are currently escaped to 
     *    their numerical \\u equivalent. This may change in future releases.</li>
     * </ul>
     *    
     * @return the resulting String.
	 */
	public static final Function<String,String> escapeXML() {
        return ESCAPE_XML_STRING_FUNC;
    }
	
	
	/**
     * <p>
     * Unescapes a string containing XML entity escapes to a string
     * containing the actual Unicode characters corresponding to the
     * escapes.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.unescapeXml()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>Supports only the five basic XML entities (gt, lt, quot, amp, apos).
     *       Does not support DTDs or external entities.</li>
     *   <li>Note that numerical \\u unicode codes are unescaped to their respective 
     *       unicode characters. This may change in future releases.</li>
     * </ul>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> unescapeXML() {
        return UNESCAPE_XML_STRING_FUNC;
    }

	
	/**
     * <p>
     * Escapes the characters in a <code>String</code> using HTML entities.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.escapeHtml()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>The string <code>"bread" &amp; "butter"</code> becomes 
     *       <tt>&amp;quot;bread&amp;quot; &amp;amp; &amp;quot;butter&amp;quot;</tt>.</li>
     *   <li>Supports all known HTML 4.0 entities, including funky accents.
     *       Note that the commonly used apostrophe escape character (&amp;apos;)
     *       is not a legal entity and so is not supported).</li>
     * </ul>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> escapeHTML() {
        return ESCAPE_HTML_STRING_FUNC;
    }
	
	
	/**
     * <p>
     * Unescapes a string containing entity escapes to a string
     * containing the actual Unicode characters corresponding to the
     * escapes. Supports HTML 4.0 entities.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.unescapeHtml()</tt>.
     * From its definition:
     * </p>
     * <ul>
     *   <li>The string <tt>&amp;lt;Fran&amp;ccedil;ais&amp;gt;</tt>
     *       will become <tt>&lt;Fran&ccedil;ais&gt;</tt></li>
     *   <li>If an entity is unrecognized, it is left alone, and inserted
     *       verbatim into the result string. e.g. <tt>&amp;gt;&amp;zzzz;x</tt> will
     *       become <tt>&gt;&amp;zzzz;x</tt>.</li>
     * </ul>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> unescapeHTML() {
        return UNESCAPE_HTML_STRING_FUNC;
    }
	
	
	/**
     * <p>
     * Escapes the characters in a <code>String</code> using JavaScript String rules.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.escapeJavascript()</tt>.
     * From its definition:
     * </p>
     * <ul> 
     *   <li>Escapes any values it finds into their JavaScript String form.
     *       Deals correctly with quotes and control-chars (tab, backslash, cr, ff, etc.)</li>
     *   <li>So a tab becomes the characters <code>'\\'</code> and <code>'t'</code>.</li>
     *   <li>The only difference between Java strings and JavaScript strings
     *       is that in JavaScript, a single quote must be escaped.</li>
     * </ul>
     *
     * <p>Example:</p>
     * <ul>
     *   <li>input string: <tt>He didn't say, &quot;Stop!&quot;</tt></li>
     *   <li>output string: <tt>He didn\'t say, \&quot;Stop!\&quot;</tt></li>
     * </ul>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> escapeJavaScript() {
        return ESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	
	
	/**
     * <p>
     * Unescapes any JavaScript literals found in the <code>String</code>.
     * </p>
     *
     * <p>
     * For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code>
     * into a newline character, unless the <code>'\'</code> is preceded by another
     * <code>'\'</code>.
     * </p>
     * <p>
     * This method calls <tt>org.apache.commons.lang.StringUtils.unescapeJavascript()</tt>.
     * </p>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> unescapeJavaScript() {
        return UNESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	
	
	
	/**
     * <p>
	 * Converts the target String into the Hexadecimal representation of its bytes using the 
	 * specified Charset to obtain them (the bytes).
     * </p>
	 * 
	 * @param charset the charset to be used
     * @return the resulting String.
	 */
	public static final Function<String,String> toHexadecimal(final Charset charset) {
        return new ToHexadecimal(charset);
    }
	
	
	/**
	 * <p>
	 * Converts the target String from the Hexadecimal representation of its bytes back into 
	 * a String using the specified Charset.
	 * </p>
	 * 
	 * @param charset the charset to be used
     * @return the resulting String.
	 */
	public static final Function<String,String> fromHexadecimal(final Charset charset) {
        return new FromHexadecimal(charset);
    }
	
	
	/**
     * <p>
	 * Converts the target String to upper case.
     * </p>
	 * 
     * @return the resulting String.
	 */
	public static final Function<String,String> toUpperCase() {
        return TO_UPPER_CASE_STRING_FUNC;
    }
	
	/**
     * <p>
     * Converts the target String to lower case.
     * </p>
	 * 
	 * @return the resulting String
	 */
	public static final Function<String,String> toLowerCase() {
        return TO_LOWER_CASE_STRING_FUNC;
    }
	
	
	/**
     * <p>
	 * Converts the first letter of each word in the target String to lowercase
     * </p>
	 * 
     * @return the resulting String
	 */
	public static final Function<String,String> unCapitalize() {
        return UN_CAPITALIZE_STRING_FUNC;
    }
	
	
	/**
     * <p>
	 * Converts the first letter of each word in the target String to upper case.
	 * </p>
	 * 
     * @return the resulting String
	 */
	public static final Function<String,String> capitalize() {
        return CAPITALIZE_STRING_FUNC;
    }
	
	
	/**
     * <p>
	 * Removes control characters (char &lt;= 32) from both ends of the target String.
     * </p>
	 * 
     * @return the resulting String
	 */
	public static final Function<String,String> trim() {
        return TRIM_STRING_FUNC;
    }
	
	
	/**
     * <p>
	 * Strips whitespace from both sides of the target String.
     * </p>
	 * 
     * @return the resulting String
	 */
	public static final Function<String,String> strip() {
        return STRIP_STRING_FUNC;
    }
	
	
	/**
	 * <p>
	 * Converts the target String to a <tt>java.util.Calendar</tt> by applying the specified
	 * pattern.
	 * </p>
	 * <p>
	 * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
	 * </p>
	 * 
	 * @param pattern the pattern to be used
	 * @return the resulting Calendar
	 */
    public static final Function<String,Calendar> toCalendar(final String pattern) {
        return new ToCalendar(pattern);
    }

    
    /**
     * <p>
     * Converts the target String to a <tt>java.util.Calendar</tt> by applying the specified
     * pattern and locale. The locale is needed for correctly parsing month names.
     * </p>
     * <p>
     * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
     * </p>
     * 
     * @param pattern the pattern to be used.
     * @param locale the locale which will be used for parsing month names
     * @return the resulting Calendar
     */
    public static final Function<String,Calendar> toCalendar(final String pattern, final Locale locale) {
        return new ToCalendar(pattern, locale);
    }
    
    
    /**
     * <p>
     * Converts the target String to a <tt>java.util.Calendar</tt> by applying the specified
     * pattern and locale. The locale is needed for correctly parsing month names.
     * </p>
     * <p>
     * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
     * </p>
     * 
     * @param pattern the pattern to be used (ex: "en_US", "es_ES", etc.)
     * @param locale the locale which will be used for parsing month names
     * @return the resulting Calendar
     */
    public static final Function<String,Calendar> toCalendar(final String pattern, final String locale) {
        return new ToCalendar(pattern, locale);
    }
	
    
    
	
    
    /**
     * <p>
     * Converts the target String to a <tt>java.util.Date</tt> by applying the specified
     * pattern.
     * </p>
     * <p>
     * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
     * </p>
     * 
     * @param pattern the pattern to be used
     * @return the resulting Date
     */
    public static final Function<String,Date> toDate(final String pattern) {
        return new ToDate(pattern);
    }

    
    /**
     * <p>
     * Converts the target String to a <tt>java.util.Date</tt> by applying the specified
     * pattern and locale. The locale is needed for correctly parsing month names.
     * </p>
     * <p>
     * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
     * </p>
     * 
     * @param pattern the pattern to be used.
     * @param locale the locale which will be used for parsing month names
     * @return the resulting Date
     */
    public static final Function<String,Date> toDate(final String pattern, final Locale locale) {
        return new ToDate(pattern, locale);
    }

    
    /**
     * <p>
     * Converts the target String to a <tt>java.util.Date</tt> by applying the specified
     * pattern and locale. The locale is needed for correctly parsing month names.
     * </p>
     * <p>
     * Pattern format is that of <tt>java.text.SimpleDateFormat</tt>.
     * </p>
     * 
     * @param pattern the pattern to be used (ex: "en_US", "es_ES", etc.)
     * @param locale the locale which will be used for parsing month names
     * @return the resulting Date
     */
    public static final Function<String,Date> toDate(final String pattern, final String locale) {
        return new ToDate(pattern, locale);
    }

    

    /**
     * <p>
     * Performs an <i>equals</i> operation between the target object and the
     * specified one.
     * </p>
     * 
     * @param object the object that will be passed as a parameter to the "equals" operation.
     * @return the boolean result of the "equals" operation.
     */
    public static final Function<Object,Boolean> eq(final String object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Performs an inverse <i>equals</i> operation between the target object and the
     * specified one.
     * </p>
     * 
     * @param object the object that will be passed as a parameter to the "equals" operation.
     * @return the boolean result of the inverse of an "equals" operation.
     */
    public static final Function<Object,Boolean> notEq(final String object) {
        return FnObject.notEq(object);
    }

    
    
    
    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }

    
    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    
    
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Object,Boolean> lessThan(final String object) {
        return FnObject.lessThan(object);
    }

    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> lessOrEqTo(final String object) {
        return FnObject.lessOrEqTo(object);
    }
    
   

    /**
     * <p>
     * Determines whether the target object is greater than the specified object
     * in value, this is, whether <tt>target.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater than the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterThan(final String object) {    
        return FnObject.greaterThan(object);
    }
    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Object,Boolean> greaterOrEqTo(final String object) {
        return FnObject.greaterOrEqTo(object);
    }
    

    
    
    
    
    /**
     * <p>
     * Determines whether the target String matches the specified regular
     * expression.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @return true if the target String matches the regex, false if not.
     */
    public static final Function<String,Boolean> matches(final String regex) {
        return new Matches(regex);
    }
    

    /**
     * <p>
     * Determines whether the target String contains a fragment matching the specified regular
     * expression.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @return true if the target String contains a fragment matching the regex, false if not.
     */
    public static final Function<String,Boolean> contains(final String regex) {
        return new Contains(regex);
    }



    
    
    /**
     * <p>
     * Extracts the first substring from the target String that matches the specified
     * regular expression.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @return the matching substring.
     */
    public static final Function<String,String> extractFirst(final String regex) {
        return new Extract(regex, false);
    }

    
    /**
     * <p>
     * Extracts the last substring from the target String that matches the specified
     * regular expression.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @return the matching substring.
     */
    public static final Function<String,String> extractLast(final String regex) {
        return new Extract(regex, true);
    }
    

    /**
     * <p>
     * Extracts every substring from the target String that match the specified
     * regular expression.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @return a List with the matching substrings
     */
    public static final Function<String,List<String>> extractAll(final String regex) {
        return new ExtractAll(regex);
    }

    
    /**
     * <p>
     * Matches the entire target String against the specified regular expression and extracts
     * the specified group from it (as specified by <tt>java.util.regex.Matcher</tt>.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @param group the group number to be extracted
     * @return the substring matching the group number
     */ 
    public static final Function<String,String> matchAndExtract(final String regex, final int group) {
        return new MatchAndExtract(regex, group);
    }
  
    
    /**
     * <p>
     * Matches the entire target String against the specified regular expression and extracts
     * the specified groups from it (as specified by <tt>java.util.regex.Matcher</tt>.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @param groups the group numbers to be extracted
     * @return a List with the substrings matching the group number
     */
    public static final Function<String,List<String>> matchAndExtractAll(final String regex, final int... groups) {
        return new MatchAndExtractAll(regex, VarArgsUtil.asRequiredIntegerList(groups));
    }

    
    
    /**
     * <p>
     * Replaces in the target String the first substring matching the specified regular expression
     * with the specified replacement String.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @param replacement the replacement string
     * @return the resulting String
     */
    public static final Function<String,String> replaceFirst(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.FIRST);
    }
    
    
    /**
     * <p>
     * Replaces in the target String the last substring matching the specified regular expression
     * with the specified replacement String.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @param replacement the replacement string
     * @return the resulting String
     */
    public static final Function<String,String> replaceLast(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.LAST);
    }
    

    /**
     * <p>
     * Replaces in the target String all substrings matching the specified regular expression
     * with the specified replacement String.
     * </p>
     * <p>
     * Regular expressions must conform to the <tt>java.util.regex.Pattern</tt> format.
     * </p>
     * 
     * @param regex the regular expression to match against
     * @param replacement the replacement string
     * @return the resulting String
     */
    public static final Function<String,String> replaceAll(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.ALL);
    }
    
    
    /**
     * <p>
     * Splits a String into a list of substrings using a whitespace as a separator.
     * </p>
     * 
     * @return a List with the resulting substrings.
     */
    public static final Function<String, List<String>> split() {
        return SPLIT;        
    }
    
    
    /**
     * <p>
     * Splits a String into a list of substrings using the given separator
     * as a substrings separator (the separator is not included in the
     * elements of the returned list).
     * </p>
     * 
     * @param separator the separator to be used
     * @return a List with the resulting substrings.
     */
    public static final Function<String, List<String>> split(final String separator) {
        return new Split(separator);        
    }

    
    /**
     * <p>
     * Splits a String into an array of substrings using a whitespace as a separator.
     * </p>
     * 
     * @return an array with the resulting substrings.
     */
    public static final Function<String, String[]> splitAsArray() {
        return SPLIT_AS_ARRAY;        
    }
    
    
    /**
     * <p>
     * Splits a String into an array of substrings using the given separator
     * as a substrings separator (the separator is not included in the
     * elements of the returned array).
     * </p>
     * 
     * @param separator the separator to be used
     * @return an array with the resulting substrings.
     */
    public static final Function<String, String[]> splitAsArray(final String separator) {
        return new SplitAsArray(separator);        
    }
    
    
    /**
     * <p>
     * Joins the string representation of the objects in the list (which might be
     * Strings themselves) into a single String (no separator used).
     * </p>
     * 
     * @return the resulting String
     */
    public static final Function<List<Object>, String> join() {
        return JOIN;        
    }
    
    
    /**
     * <p>
     * Joins the string representation of the objects in the list (which might be
     * Strings themselves) into a single String using the given separator.
     * </p>
     * 
     * @return the resulting String
     */
    public static final Function<List<Object>, String> join(String separator) {
        return new Join(separator);        
    }
    
    
    /**
     * <p>
     * Joins the string representation of the objects in the array (which might be
     * Strings themselves) into a single String (no separator used).
     * </p>
     * 
     * @return the resulting String
     */
    public static final Function<Object[], String> joinArray() {
        return JOIN_ARRAY;        
    }
    
    /**
     * <p>
     * Joins the string representation of the objects in the array (which might be
     * Strings themselves) into a single String using the given separator.
     * </p>
     * 
     * @return the resulting String
     */
    public static final Function<Object[], String> joinArray(String separator) {
        return new JoinArray(separator);        
    }
    
    
    
	
    
    /**
     * <p>
     * <i>ASCIIfies</i> a String containing text in (mainly) European languages by removing a set of 
     * recognized diacritic symbols and performing a number of transformations. Calling this method
     * is equivalent to calling {@link #asciify(AsciifyMode)} using the <tt>DEFAULT</tt> mode.
     * </p>
     * 
     * 
     * @return the transformed String
     */
    public static final Function<String,String> asciify() {
        return ASCIIFY;
    }
    
    
    
    /**
     * <p>
     * <i>ASCIIfies</i> a String containing text in (mainly) European languages by removing a set of 
     * recognized diacritic symbols and performing a number of transformations, determined
     * by the <tt>{@link AsciifyMode}</tt> parameter.
     * </p>
     * <p>
     * Transformations for <tt>AsciifyMode.DEFAULT</tt> are:
     * </p>
     * <ul>
     *   <li>&#192;, &#193;, &#194;, &#195;, &#196;, &#197;, \u0100, \u0102, \u0104, \u01CD, \u01FA / &#224;, &#225;, &#226;, &#227;, &#228;, &#229;, \u0101, \u0103, \u0105, \u01CE, \u01FB = A / a</li>
     *   <li>&#198;, \u01FC / &#230;, \u01FD = AE / ae</li>
     *   <li>&#199;, \u0106, \u0108, \u010A, \u010C / &#231;, \u0107, \u0109, \u010B, \u010D = C / c</li>
     *   <li>&#208;, \u010E, \u0110 / &#240;, \u010F, \u0111 = D / d</li>
     *   <li>&#200;, &#201;, &#202;, &#203;, \u0112, \u0114, \u0116, \u0118, \u011A / &#232;, &#233;, &#234;, &#235;, \u0113, \u0115, \u0117, \u0119, \u011B = E / e</li>
     *   <li>\u011C, \u011E, \u0120, \u0122 / \u011D, \u011F, \u0121, \u0123 = G / g</li>
     *   <li>\u0124, \u0126 / \u0125, \u0127 = H / h</li>
     *   <li>&#204;, &#205;, &#206;, &#207;, \u0128, \u012A, \u012C, \u012E, \u0130, \u01CF / &#236;, &#237;, &#238;, &#239;, \u0129, \u012B, \u012D, \u012F, \u0131, \u01D0 = I / i</li>
     *   <li>\u0132 / \u0133 = IJ / ij</li>
     *   <li>\u0134 / \u0135 = J / j</li>
     *   <li>\u0136 / \u0137, \u0138  = K / k</li>
     *   <li>\u0139, \u013B, \u013D, \u013F, \u0141 / \u013A, \u013C, \u013E, \u0140, \u0142 = L / l</li>
     *   <li>&#209;, \u0143, \u0145, \u0147, \u014A / &#241;, \u0144, \u0146, \u0148, \u0149, \u014B = N / n</li>
     *   <li>&#210;, &#211;, &#212;, &#213;, &#214;, &#216;, \u014C, \u014E, \u0150, \u01A0, \u01D1, \u01FE / &#242;, &#243;, &#244;, &#245;, &#246;, &#248;, \u014D, \u014F, \u0151, \u01A1, \u01D2, \u01FF = O / o</li>
     *   <li>\u0152 / \u0153 = OE / oe</li>
     *   <li>\u0154, \u0156, \u0158 / \u0155, \u0157, \u0159 = R / r</li>
     *   <li>\u015A, \u015C, \u015E, \u0160 / \u015B, \u015D, \u015F, \u0161 = S / s</li>
     *   <li>&#223; = "ss" if the preceding character is lower case, "SS" otherwise.</li>
     *   <li>\u0162, \u0164, \u0166 / \u0163, \u0165, \u0167 = T / t</li>
     *   <li>&#222; / &#254; = TH / th</li>
     *   <li>&#217;, &#218;, &#219;, &#220;, \u0168, \u016A, \u016C, \u016E, \u0170, \u0172, \u01AF, \u01D3, \u01D5, \u01D7, \u01D9, \u01DB / &#249;, &#250;, &#251;, &#252;, \u0169, \u016B, \u016D, \u016F, \u0171, \u0173, \u01B0, \u01D4, \u01D6, \u01D8, \u01DA, \u01DC = U / u</li>
     *   <li>\u0174 / \u0175 = W / w</li>
     *   <li>&#221;, \u0178, \u0176 / &#253;, &#255;, \u0177 = Y / y</li>
     *   <li>\u0179, \u017B, \u017D / \u017A, \u017C, \u017E = Z / z</li>
     * </ul>
     * <p>
     * Transformations for <tt>AsciifyMode.UMLAUT_E</tt> are the same as <tt>DEFAULT</tt>
     * with the following differences:
     * </p>
     * <ul>
     *   <li>&#196; / &#228; = AE / ae</li>
     *   <li>&#214; / &#246; = OE / oe</li>
     *   <li>&#220; / &#252; = UE / ue</li>
     * </ul>
     * 
     * 
     * @return the transformed String
     */
    public static final Function<String,String> asciify(final AsciifyMode mode) {
        return new Asciify(mode);
    }
    
    
    /**
     * <p>
     * Checks if a String contains only unicode letters or not
     * </p>
     * 
     * @return whether the input String contains only unicode letters or not
     */
    public static final Function<String, Boolean> isAlpha() {
        return IS_ALPHA;
    }
    
    /**
     * <p>
     * Checks if a String contains only unicode letters and spaces or not
     * </p>
     * 
     * @return true if the input String contains only unicode letters and spaces. 
     * Otherwise, false
     */
    public static final Function<String, Boolean> isAlphaSpace() {
        return IS_ALPHA_SPACE;
    }
	
    /**
     * <p>
     * Checks if a String contains only unicode digits or not
     * </p>
     * 
     * @return whether the input String contains only unicode digits or not
     */
    public static final Function<String, Boolean> isNumeric() {
        return IS_NUMERIC;
    }
    
    /**
     * <p>
     * Checks if a String contains only unicode digits and spaces or not
     * </p>
     * 
     * @return true if the input String contains only unicode digits and spaces. 
     * Otherwise, false
     */
    public static final Function<String, Boolean> isNumericSpace() {
        return IS_NUMERIC_SPACE;
    }
	
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigDecimal}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link BigDecimal}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigDecimal() {
        return IS_BIG_DECIMAL;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigDecimal} in the given {@link Locale}
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link BigDecimal}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigDecimal(final Locale locale) {
        return new IsBigDecimal(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigDecimal} in the given {@link Locale} specified as a {@link String}
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link BigDecimal}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigDecimal(final String locale) {
        return new IsBigDecimal(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigDecimal} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link BigDecimal}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigDecimal(final DecimalPoint decimalPoint) {
        return new IsBigDecimal(decimalPoint);
    }

    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigInteger}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link BigInteger}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigInteger() {
        return IS_BIG_INTEGER;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigInteger} in the given {@link Locale}
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link BigInteger}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigInteger(final Locale locale) {
        return new IsBigInteger(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigInteger} in the given {@link Locale} specified as a {@link String}
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link BigInteger}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigInteger(final String locale) {
        return new IsBigInteger(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigInteger} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link BigInteger}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigInteger(final DecimalPoint decimalPoint) {
        return new IsBigInteger(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link BigInteger} in the specified radix. It uses the default
     * configuration to check the {@link String}
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link BigInteger}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isBigInteger(final int radix) {
        return new IsBigInteger(radix);
    }
        
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Double}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#toDouble()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Double}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isDouble() {
        return IS_DOUBLE;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Double} in the given {@link Locale}.
     * If this method returns false, {@link FnString#toDouble(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Double}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isDouble(final Locale locale) {
        return new IsDouble(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Double} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#toDouble(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Double}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isDouble(final String locale) {
        return new IsDouble(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Double} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#toDouble(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Double}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isDouble(final DecimalPoint decimalPoint) {
        return new IsDouble(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Float}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#isFloat()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Float}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isFloat() {
        return IS_FLOAT;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Float} in the given {@link Locale}.
     * If this method returns false, {@link FnString#isFloat(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Float}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isFloat(final Locale locale) {
        return new IsFloat(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Float} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#isFloat(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Float}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isFloat(final String locale) {
        return new IsFloat(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Float} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#isFloat(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Float}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isFloat(final DecimalPoint decimalPoint) {
        return new IsFloat(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Long}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#isLong()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Long}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isLong() {
        return IS_LONG;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Long} in the given {@link Locale}.
     * If this method returns false, {@link FnString#isLong(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Long}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isLong(final Locale locale) {
        return new IsLong(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Long} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#isLong(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Long}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isLong(final String locale) {
        return new IsLong(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Long} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#isLong(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Long}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isLong(final DecimalPoint decimalPoint) {
        return new IsLong(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Long} in the specified radix. It uses the default
     * configuration to check the {@link String}.
     * If this method returns false, {@link FnString#isLong(int)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Long}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isLong(final int radix) {
        return new IsLong(radix);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Integer}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#isInteger()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Integer}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isInteger() {
        return IS_INTEGER;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Integer} in the given {@link Locale}.
     * If this method returns false, {@link FnString#isInteger(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Integer}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isInteger(final Locale locale) {
        return new IsInteger(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Integer} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#isInteger(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Integer}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isInteger(final String locale) {
        return new IsInteger(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Integer} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#isInteger(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Integer}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isInteger(final DecimalPoint decimalPoint) {
        return new IsInteger(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Integer} in the specified radix. It uses the default
     * configuration to check the {@link String}.
     * If this method returns false, {@link FnString#isInteger(int)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Integer}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isInteger(final int radix) {
        return new IsInteger(radix);
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Short}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#isShort()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Short}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isShort() {
        return IS_SHORT;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Short} in the given {@link Locale}.
     * If this method returns false, {@link FnString#isShort(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Short}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isShort(final Locale locale) {
        return new IsShort(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Short} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#isShort(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Short}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isShort(final String locale) {
        return new IsShort(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Short} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#isShort(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Short}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isShort(final DecimalPoint decimalPoint) {
        return new IsShort(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Short} in the specified radix. It uses the default
     * configuration to check the {@link String}.
     * If this method returns false, {@link FnString#isShort(int)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Short}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isShort(final int radix) {
        return new IsShort(radix);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Byte}. It uses the default configuration from the JVM (en_US)
     * to check whether the string is valid or not.
     * If this method returns false, {@link FnString#toByte()} will throw an exception if called.
     * </p>
     * 
     * @return true if the input {@link String} represents a valid {@link Byte}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isByte() {
        return IS_BYTE;
    }
    
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Byte} in the given {@link Locale}.
     * If this method returns false, {@link FnString#toByte(Locale)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Byte}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isByte(final Locale locale) {
        return new IsByte(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Byte} in the given {@link Locale} specified as a {@link String}.
     * If this method returns false, {@link FnString#toByte(String)} will throw an exception if called.
     * </p>
     * 
     * @param locale the locale defining the way in which the number is written
     * @return true if the input {@link String} represents a valid {@link Byte}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isByte(final String locale) {
        return new IsByte(locale);
    }

    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Byte} using the specified decimal point
     * configuration ({@link DecimalPoint}). 
     * If this method returns false, {@link FnString#toByte(DecimalPoint)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Byte}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isByte(final DecimalPoint decimalPoint) {
        return new IsByte(decimalPoint);
    }
    
    /**
     * <p>
     * Returns true if the input {@link String} can be converted into a 
     * valid {@link Byte} in the specified radix. It uses the default
     * configuration to check the {@link String}.
     * If this method returns false, {@link FnString#toByte(int)} will throw an exception if called.
     * </p>
     * 
     * @param decimalPoint the decimal point being used by the String
     * @return true if the input {@link String} represents a valid {@link Byte}. 
     * Otherwise, false
     */
    public static final Function<String,Boolean> isByte(final int radix) {
        return new IsByte(radix);
    }
    
    /**
     * <p>
     * It checks whether the input {@link String} starts with the specified
     * prefix or not. If the suffix is empty, starts with or is equal to 
     * the input, it will return true.
     * </p>
     * 
     * @param prefix the prefix to be search at the beginning of the input
     * @return true if the input {@link String} starts with the specified prefix
     */
    public static final Function<String, Boolean> startsWith(final String prefix) {
        return new StartsWith(prefix);
    }
    
    /**
     * <p>
     * It checks whether the input substring after the given offset starts
     * with the given prefix or not. 
     * </p>
     * 
     * @param prefix the prefix to be search after the specified offset
     * @param offset where to begin looking for the prefix
     * @return
     */
    public static final Function<String, Boolean> startsWith(final String prefix, final int offset) {
        return new StartsWith(prefix, offset);
    }
    
    /**
     * <p>
     * Checkx whether the input {@link String} ends with the specified suffix or not.
     * If the suffix is empty, ends with or is equal to the input, it will return true.
     * </p>
     * 
     * @param suffix suffix to be search at the end of the input
     * @return true if the input {@link String} ends with the specified suffix
     */
    public static final Function<String, Boolean> endsWith(final String suffix) {
        return new EndsWith(suffix);
    }
    
    /**
     * <p>
     * Returns the substring of input from start position (null if null 
     * String input). It calls {@link StringUtils#substring(String, int)}
     * </p>
     * 
     * @param start the position to start from, negative means count back from the 
     * end of the String by this many characters
     * @return the substring
     */
    public static final Function<String, String> substring(final int start) {
        return new SubString(start);
    }
    
    /**
     * <p>
     * Returns the substring of input from start position to end position (null if null 
     * String input). It calls {@link StringUtils#substring(String, int, int)}
     * </p>
     * 
     * @param start the position to start from, negative means count back from the 
     * end of the String by this many characters
     * @param end the position to end at (exclusive), negative means count back 
     * from the end of the String by this many characters
     * @return the substring
     */
    public static final Function<String, String> substring(final int start, final int end) {
        return new SubString(start, end);
    }
    
    /**
     * <p>
     * Returns the substring before the first occurrence of the given separator. It calls 
     * {@link StringUtils#substringBefore(String, String)}
     * </p>
     * 
     * @param separator the {@link String} to search for (may be null)
     * @return the substring before the first occurrence of the separator, null 
     * if null String input
     */
    public static final Function<String, String> substringBefore(final String separator) {
        return new SubStringBefore(separator);
    }
    
    /**
     * <p>
     * Returns the substring before the last occurrence of the given separator. It calls 
     * {@link StringUtils#substringBeforeLast(String, String)}
     * </p>
     * 
     * @param separator the {@link String} to search for (may be null)
     * @return the substring before the last occurrence of the separator, null 
     * if null String input
     */
    public static final Function<String, String> substringBeforeLast(final String separator) {
        return new SubStringBeforeLast(separator);
    }
    
    /**
     * <p>
     * Returns the substring after the first occurrence of the given separator. It calls 
     * {@link StringUtils#substringAfter(String, String)}
     * </p>
     * 
     * @param separator the {@link String} to search for (may be null)
     * @return the substring after the first occurrence of the separator, null 
     * if null String input
     */
    public static final Function<String, String> substringAfter(final String separator) {
        return new SubStringAfter(separator);
    }
    
    /**
     * <p>
     * Returns the substring after the last occurrence of the given separator. It calls 
     * {@link StringUtils#substringAfterLast(String, String)}
     * </p>
     * 
     * @param separator the {@link String} to search for (may be null)
     * @return the substring after the last occurrence of the separator, null 
     * if null String input
     */
    public static final Function<String, String> substringAfterLast(final String separator) {
        return new SubStringAfterLast(separator);
    }
    
    /**
     * <p>
     * Returns the substring between tag and tag or null if there is no match. It calls 
     * {@link StringUtils#substringBetween(String, String)}
     * </p>
     * 
     * @param tag the String before and after the substring, may be null
     * @return the substring, null if no match
     */
    public static final Function<String, String> substringBetween(final String tag) {
        return new SubStringBetween(tag);
    }
    
    /**
     * <p>
     * Returns the substring between open and close or null if there is no match. It calls 
     * {@link StringUtils#substringBetween(String, String, String)}
     * </p>
     * 
     * @param open the String before the substring, may be null
     * @param close the String after the substring, may be null
     * @return the substring, null if no match
     */
    public static final Function<String, String> substringBetween(final String open, final String close) {
        return new SubStringBetween(open, close);
    }
    
    
	/**
	 * The String is returned in a way it can be used to fill in a CSV column as StringEscapeUtils does
	 *
	 */
	static final class EscapeCSV extends Function<String,String> {
		
		EscapeCSV() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeCsv(input);
		}		
	}

	/**
	 * The String is returned without the escape characters used to
	 * include it in a CSV column (i.e. no quotes enclosing it, no escaped quotes) 
	 * as StringEscapeUtils does
	 *
	 */
	static final class UnescapeCSV extends Function<String,String> {
		UnescapeCSV() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeCsv(input);
		}		
	}

	/**
	 * The String is returned with the XML characters escaped as StringEscapeUtils does
	 *
	 */
	static final class EscapeXML extends Function<String,String> {
		EscapeXML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeXml(input);
		}		
	}

	/**
	 * The String is returned without the XML escape characters as StringEscapeUtils does
	 *
	 */
	static final class UnescapeXML extends Function<String,String> {
		UnescapeXML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeXml(input);
		}		
	}

	/**
	 * It escapes the given String using HTML entities (as StringEscapeUtils does)
	 *
	 */
	static final class EscapeHTML extends Function<String,String> {
		EscapeHTML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeHtml(input);
		}		
	}

	/**
	 * It unescapes the given String and converts its HTML entity escapes into 
	 * their unicode characters (as StringEscapeUtils does)
	 *
	 */
	static final class UnescapeHTML extends Function<String,String> {
		UnescapeHTML() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeHtml(input);
		}		
	}

	/**
	 * It converts the given String into a JavaScript valid one (as StringEscapeUtils does)
	 *
	 */
	static final class EscapeJavaScript extends Function<String,String> {
		EscapeJavaScript() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.escapeJavaScript(input);
		}		
	}

	/**
	 * It unescapes the given JavaScript valid String (as StringEscapeUtils does)
	 *
	 */
	static final class UnescapeJavaScript extends Function<String,String> {
		UnescapeJavaScript() {
			super();
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringEscapeUtils.unescapeJavaScript(input);
		}		
	}

	/**
	 * It converts the given String into its Hexadecimal representation using the specified Charset
	 *
	 */
	static final class ToHexadecimal extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		ToHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
        protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final byte[] inputAsByteArray = input.getBytes(this.charset.name());
			final StringBuffer output = new StringBuffer();
			for (byte i = 0; i < inputAsByteArray.length; i++) {
				output.append(Integer.toHexString(inputAsByteArray[i]));
			}
			return output.toString();      
		}		
	}

	/**
	 * The given String is converted from its Hexadecimal representation into a String using the specified Charset
	 *
	 */
	static final class FromHexadecimal extends AbstractNullAsNullFunction<String,String> {

		private Charset charset = null;

		FromHexadecimal(Charset charset) {
			super();
			this.charset = charset;
		}

        @Override
		protected String nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
			Validate.notNull(this.charset, "Charset can't be null");

			final StringBuffer output = new StringBuffer();            
			for (int i = 0; i < input.length(); i = i + 2) {
				final byte current = 
					(byte) Integer.parseInt(String.valueOf(input.charAt(i))
							+ String.valueOf(input.charAt(i + 1)), 16);

				output.append(new String(new byte[] {current},
						this.charset.name()));
			}            
			return output.toString();       
		}		
	}

	/**
	 * It converts the given String to uppercase
	 *
	 */
	static final class ToUpperCase extends Function<String,String> {

		ToUpperCase() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.upperCase(input);
		}		
	}
	
	/**
	 * It converts the given String to lowercase
	 *
	 */
	static final class ToLowerCase extends Function<String,String> {

		ToLowerCase() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.lowerCase(input);
		}		
	}

	/**
	 * It converts the first letter of the given String to lowercase
	 *
	 */
	static final class UnCapitalize extends Function<String,String> {

		UnCapitalize() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.uncapitalize(input);
		}		
	}
	/**
	 * It converts the first letter of the given String to uppercase
	 *
	 */
	static final class Capitalize extends Function<String,String> {

		Capitalize() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.capitalize(input);
		}		
	}	

	/**
	 * Removes control characters (char <= 32) from both ends of the given String
	 *
	 */
	static final class Trim extends Function<String,String> {

		Trim() {
			super();			
		}

		public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.trim(input);
		}		
	}	
	
	/**
	 * Strips whitespace from both sides of the given String
	 *
	 */
	static final class Strip extends Function<String,String> {

		Strip() {
			super();			
		}

        public String execute(final String input, final ExecCtx ctx) throws Exception {
			return StringUtils.strip(input);
		}		
	}	
	
	
	
    
    static final class ToBoolean extends AbstractNullAsNullFunction<String,Boolean>  {
        
        ToBoolean() {
            super();
        }

        @Override
        protected Boolean nullAsNullExecute(final String string, final ExecCtx ctx) throws Exception {
            return BooleanUtils.toBooleanObject(string);
        }
        
    }
	
    
    
    
    
    
    static final class ToCalendar extends AbstractNullAsNullFunction<String,Calendar>  {

        private final SimpleDateFormat simpleDateFormat;

        
        ToCalendar(final String pattern) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            if (StringUtils.contains(pattern, "MMM")) {
                throw new IllegalArgumentException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
            if (StringUtils.contains(pattern, "EEE")) {
                throw new IllegalArgumentException("The use of EEE or EEEE as part of the date pattern requires a Locale");
            }
            this.simpleDateFormat = new SimpleDateFormat(pattern);            
        }
        
        ToCalendar(final String pattern, final Locale locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, locale);
        }
        
        ToCalendar(final String pattern, final String locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, LocaleUtils.toLocale(locale));
        }


        @Override
        protected Calendar nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            // Calendar is truncated to YEAR to ensure all fields are set to zero before 
            // parsing the string into the new calendar object
            final Calendar calendar = 
                DateUtils.truncate(Calendar.getInstance(), Calendar.YEAR);
            
            //It uses ParsePosition to make sure the whole 
            //string has been converted into a number
            ParsePosition pp = new ParsePosition(0);
            Date date = this.simpleDateFormat.parse(object, pp);
            if (pp.getIndex() != object.length()) {
                throw new ParseException("The whole input String does not represent a valid Date", 
                        pp.getIndex());
            }            
            calendar.setTime(date);
            return calendar;
        }
        
    }
    
    
    
    
    
    
    static final class ToDate extends AbstractNullAsNullFunction<String,Date>  {

        private final SimpleDateFormat simpleDateFormat;

        
        ToDate(final String pattern) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            if (StringUtils.contains(pattern, "MMM")) {
                throw new IllegalArgumentException("The use of MMM or MMMM as part of the date pattern requires a Locale");
            }
            if (StringUtils.contains(pattern, "EEE")) {
                throw new IllegalArgumentException("The use of EEE or EEEE as part of the date pattern requires a Locale");
            }
            this.simpleDateFormat = new SimpleDateFormat(pattern);            
        }
        
        ToDate(final String pattern, final Locale locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, locale);
        }
        
        ToDate(final String pattern, final String locale) {
            super();
            Validate.notNull(pattern, "A pattern must be specified");
            Validate.notNull(locale, "A locale must be specified");
            this.simpleDateFormat = new SimpleDateFormat(pattern, LocaleUtils.toLocale(locale));
        }


        @Override
        protected Date nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            // Calendar is truncated to YEAR to ensure all fields are set to zero before 
            // parsing the string into the new calendar object
            final Calendar calendar = 
                DateUtils.truncate(Calendar.getInstance(), Calendar.YEAR);
            
            //It uses ParsePosition to make sure the whole 
            //string has been converted into a number
            ParsePosition pp = new ParsePosition(0);
            Date date = this.simpleDateFormat.parse(object, pp);
            if (pp.getIndex() != object.length()) {
                throw new ParseException("The whole input String does not represent a valid Date", 
                        pp.getIndex());
            }            
            calendar.setTime(date);
            return calendar.getTime();
        }
        
    }
    
    
    

    
    
    
    static final class Matches extends AbstractNotNullFunction<String,Boolean>  {

        private final Pattern pattern;

        
        Matches(final String regex) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
        }


        @Override
        protected Boolean notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            return Boolean.valueOf(matcher.matches());
        }
        
    }
    
    
    
    
    static final class Contains extends AbstractNotNullFunction<String,Boolean>  {

        private final Pattern pattern;

        
        Contains(final String regex) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
        }


        @Override
        protected Boolean notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            return Boolean.valueOf(matcher.find());
        }
        
    }
    
    
    
    
    
    
    static final class Extract extends AbstractNotNullFunction<String,String>  {

        private final Pattern pattern;
        private final boolean last;

        
        Extract(final String regex, final boolean last) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
            this.last = last;
        }


        @Override
        protected String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            if (!this.last) {
                if (!matcher.find()) {
                    throw new ExecutionException("Cannot extract: target does not match regular expression");
                }
                return matcher.group();
            }
            String result = null;
            while (matcher.find()) {
                result = matcher.group();
            }
            if (result == null) {
                throw new ExecutionException("Cannot extract: target does not match regular expression");
            }
            return result;
        }
        
    }

  
    
    
    static final class ExtractAll extends AbstractNotNullFunction<String,List<String>>  {

        private final Pattern pattern;

        
        ExtractAll(final String regex) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
        }


        @Override
        protected List<String> notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            final List<String> result = new ArrayList<String>();
            while (matcher.find()) {
                result.add(matcher.group());
            }
            return Collections.unmodifiableList(result);
        }
        
    }

    
    
    static final class MatchAndExtract extends AbstractNotNullFunction<String,String>  {

        private final Pattern pattern;
        private final int group;

        
        MatchAndExtract(final String regex, final int group) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
            this.group = group;
        }


        @Override
        protected String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            if (!matcher.matches()) {
                throw new ExecutionException("Cannot extract: target does not match regular expression");
            }
            return matcher.group(this.group);
        }
        
    }
    



    
    static final class MatchAndExtractAll extends AbstractNotNullFunction<String,List<String>>  {

        private final Pattern pattern;
        private final List<Integer> groups;

        
        MatchAndExtractAll(final String regex, final List<Integer> groups) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            Validate.notEmpty(groups, "Groups cannot be null or empty");
            this.pattern = Pattern.compile(regex);
            this.groups = new ArrayList<Integer>(groups);
        }


        @Override
        protected List<String> notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            if (!matcher.matches()) {
                throw new ExecutionException("Cannot extract: target does not match regular expression");
            }
            final List<String> result = new ArrayList<String>();
            for (final Integer group : this.groups) {
                result.add(matcher.group(group.intValue()));
            }
            return result;
        }
        
    }



    
    
    static final class Replace extends AbstractNotNullFunction<String,String>  {

        public enum ReplaceType { ALL, FIRST, LAST }
        
        private final Pattern pattern;
        private final String replacement;
        private final ReplaceType replaceType;

        
        Replace(final String regex, String replacement, final ReplaceType replaceType) {
            super();
            Validate.notEmpty(regex, "Regular expression cannot be null or empty");
            this.pattern = Pattern.compile(regex);
            this.replacement = replacement;
            this.replaceType = replaceType;
        }


        @Override
        protected String notNullExecute(final String input, final ExecCtx ctx) throws Exception {
            final Matcher matcher = this.pattern.matcher(input);
            if (this.replaceType.equals(ReplaceType.ALL)) {
                return matcher.replaceAll(this.replacement);
            }
            if (this.replaceType.equals(ReplaceType.FIRST)) {
                return matcher.replaceFirst(this.replacement);
            }
            int regionStart = -1;
            while (matcher.find()) {
                regionStart = matcher.start();
            }
            if (regionStart == -1) {
                return input;
            }
            return
                input.substring(0, regionStart) + 
                this.pattern.matcher(input.substring(regionStart)).replaceFirst(this.replacement);
        }
        
    }
 
    static final class Split extends AbstractNullAsNullFunction<String,List<String>> {

        private final String separator;
        
        Split() {
            super();
            this.separator = null;
        }
        
        Split(String separator) {
            super(); 
            this.separator = separator;
        }

        @Override
        public List<String> nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
            if (StringUtils.isEmpty(this.separator)) {
                return Op.on(StringUtils.split(input)).toList().get();
            } 
            return Op.on(StringUtils.split(input, this.separator)).toList().get();                       
        }       
    }   
    
    static final class SplitAsArray extends AbstractNullAsNullFunction<String,String[]> {

        private final String separator;
        
        SplitAsArray() {
            super();
            this.separator = null;
        }
        
        SplitAsArray(String separator) {
            super(); 
            this.separator = separator;
        }

        @Override
        public String[] nullAsNullExecute(final String input, final ExecCtx ctx) throws Exception {
            if (StringUtils.isEmpty(this.separator)) {
                return StringUtils.split(input);
            } 
            return StringUtils.split(input, this.separator);                      
        }       
    }   
    
    static final class Join extends AbstractNullAsNullFunction<List<Object>,String> {

        private final String separator;
        
        Join() {
            super(); 
            this.separator = null;
        }

        Join(String separator) {
            super(); 
            this.separator = separator;
        }
        
        @Override
        public String nullAsNullExecute(final List<Object> input, final ExecCtx ctx) throws Exception {
            if (this.separator != null) {
                return StringUtils.join(input.toArray(), this.separator);
            }
            return StringUtils.join(input.toArray());
        }       
    }   
    
    static final class JoinArray extends AbstractNullAsNullFunction<Object[],String> {

        private final String separator;
        
        JoinArray() {
            super(); 
            this.separator = null;
        }
        
        JoinArray(String separator) {
            super(); 
            this.separator = separator;
        }

        @Override
        public String nullAsNullExecute(final Object[] input, final ExecCtx ctx) throws Exception {
            if (this.separator != null) {
                return StringUtils.join(input, this.separator);
            }
            return StringUtils.join(input);
        }       
    }
    
    

    
    
    public enum AsciifyMode { DEFAULT, UMLAUT_E }
    
    
    
    static final class Asciify extends AbstractNullAsNullFunction<String,String> {

        private final static char ESSZETT = '\u00DF'; 
        
        private static String[] defaultSearchList;
        private static String[] defaultReplacementList;
        private static String[] umlautESearchList;
        private static String[] umlautEReplacementList;
        
        private final AsciifyMode mode;
        
        static {
            
            final Map<String,String> replacements = new LinkedHashMap<String,String>();
            
            replacements.put("\u00C0", "A");
            replacements.put("\u00C1", "A");
            replacements.put("\u00C2", "A");
            replacements.put("\u00C3", "A");
            replacements.put("\u00C4", "A");
            replacements.put("\u00C5", "A");
            replacements.put("\u0100", "A");
            replacements.put("\u0102", "A");
            replacements.put("\u0104", "A");
            replacements.put("\u01CD", "A");
            replacements.put("\u01FA", "A");
            replacements.put("\u00C6", "AE");
            replacements.put("\u01FC", "AE");
            replacements.put("\u00C7", "C");
            replacements.put("\u0106", "C");
            replacements.put("\u0108", "C");
            replacements.put("\u010A", "C");
            replacements.put("\u010C", "C");
            replacements.put("\u00D0", "D");
            replacements.put("\u010E", "D");
            replacements.put("\u0110", "D");
            replacements.put("\u00C8", "E");
            replacements.put("\u00C9", "E");
            replacements.put("\u00CA", "E");
            replacements.put("\u00CB", "E");
            replacements.put("\u0112", "E");
            replacements.put("\u0114", "E");
            replacements.put("\u0116", "E");
            replacements.put("\u0118", "E");
            replacements.put("\u011A", "E");
            replacements.put("\u011C", "G");
            replacements.put("\u011E", "G");
            replacements.put("\u0120", "G");
            replacements.put("\u0122", "G");
            replacements.put("\u0124", "H");
            replacements.put("\u0126", "H");
            replacements.put("\u00CC", "I");
            replacements.put("\u00CD", "I");
            replacements.put("\u00CE", "I");
            replacements.put("\u00CF", "I");
            replacements.put("\u0128", "I");
            replacements.put("\u012A", "I");
            replacements.put("\u012C", "I");
            replacements.put("\u012E", "I");
            replacements.put("\u0130", "I");
            replacements.put("\u01CF", "I");
            replacements.put("\u0132", "IJ");
            replacements.put("\u0134", "J");
            replacements.put("\u0136", "K");
            replacements.put("\u0139", "L");
            replacements.put("\u013B", "L");
            replacements.put("\u013D", "L");
            replacements.put("\u013F", "L");
            replacements.put("\u0141", "L");
            replacements.put("\u00D1", "N");
            replacements.put("\u0143", "N");
            replacements.put("\u0145", "N");
            replacements.put("\u0147", "N");
            replacements.put("\u014A", "N");
            replacements.put("\u00D2", "O");
            replacements.put("\u00D3", "O");
            replacements.put("\u00D4", "O");
            replacements.put("\u00D5", "O");
            replacements.put("\u00D6", "O");
            replacements.put("\u00D8", "O");
            replacements.put("\u014C", "O");
            replacements.put("\u014E", "O");
            replacements.put("\u0150", "O");
            replacements.put("\u01A0", "O");
            replacements.put("\u01D1", "O");
            replacements.put("\u01FE", "O");
            replacements.put("\u0152", "OE");
            replacements.put("\u0154", "R");
            replacements.put("\u0156", "R");
            replacements.put("\u0158", "R");
            replacements.put("\u015A", "S");
            replacements.put("\u015C", "S");
            replacements.put("\u015E", "S");
            replacements.put("\u0160", "S");
            replacements.put("\u0162", "T");
            replacements.put("\u0164", "T");
            replacements.put("\u0166", "T");
            replacements.put("\u00D9", "U");
            replacements.put("\u00DA", "U");
            replacements.put("\u00DB", "U");
            replacements.put("\u00DC", "U");
            replacements.put("\u0168", "U");
            replacements.put("\u016A", "U");
            replacements.put("\u016C", "U");
            replacements.put("\u016E", "U");
            replacements.put("\u0170", "U");
            replacements.put("\u0172", "U");
            replacements.put("\u01AF", "U");
            replacements.put("\u01D3", "U");
            replacements.put("\u01D5", "U");
            replacements.put("\u01D7", "U");
            replacements.put("\u01D9", "U");
            replacements.put("\u01DB", "U");
            replacements.put("\u0174", "W");
            replacements.put("\u00DD", "Y");
            replacements.put("\u0176", "Y");
            replacements.put("\u0178", "Y");
            replacements.put("\u0179", "Z");
            replacements.put("\u017B", "Z");
            replacements.put("\u017D", "Z");
            replacements.put("\u00DE", "TH");
            replacements.put("\u00E0", "a");
            replacements.put("\u00E1", "a");
            replacements.put("\u00E2", "a");
            replacements.put("\u00E3", "a");
            replacements.put("\u00E4", "a");
            replacements.put("\u00E5", "a");
            replacements.put("\u0101", "a");
            replacements.put("\u0103", "a");
            replacements.put("\u0105", "a");
            replacements.put("\u01CE", "a");
            replacements.put("\u01FB", "a");
            replacements.put("\u00E6", "ae");
            replacements.put("\u01FD", "ae");
            replacements.put("\u00E7", "c");
            replacements.put("\u0107", "c");
            replacements.put("\u0109", "c");
            replacements.put("\u010B", "c");
            replacements.put("\u010D", "c");
            replacements.put("\u00F0", "d");
            replacements.put("\u010F", "d");
            replacements.put("\u0111", "d");
            replacements.put("\u00E8", "e");
            replacements.put("\u00E9", "e");
            replacements.put("\u00EA", "e");
            replacements.put("\u00EB", "e");
            replacements.put("\u0113", "e");
            replacements.put("\u0115", "e");
            replacements.put("\u0117", "e");
            replacements.put("\u0119", "e");
            replacements.put("\u011B", "e");
            replacements.put("\u011D", "g");
            replacements.put("\u011F", "g");
            replacements.put("\u0121", "g");
            replacements.put("\u0123", "g");
            replacements.put("\u0125", "h");
            replacements.put("\u0127", "h");
            replacements.put("\u00EC", "i");
            replacements.put("\u00ED", "i");
            replacements.put("\u00EE", "i");
            replacements.put("\u00EF", "i");
            replacements.put("\u0129", "i");
            replacements.put("\u012B", "i");
            replacements.put("\u012D", "i");
            replacements.put("\u012F", "i");
            replacements.put("\u0131", "i");
            replacements.put("\u01D0", "i");
            replacements.put("\u0133", "ij");
            replacements.put("\u0135", "j");
            replacements.put("\u0137", "k");
            replacements.put("\u0138", "k");
            replacements.put("\u013A", "l");
            replacements.put("\u013C", "l");
            replacements.put("\u013E", "l");
            replacements.put("\u0140", "l");
            replacements.put("\u0142", "l");
            replacements.put("\u00F1", "n");
            replacements.put("\u0144", "n");
            replacements.put("\u0146", "n");
            replacements.put("\u0148", "n");
            replacements.put("\u0149", "n");
            replacements.put("\u014B", "n");
            replacements.put("\u00F2", "o");
            replacements.put("\u00F3", "o");
            replacements.put("\u00F4", "o");
            replacements.put("\u00F5", "o");
            replacements.put("\u00F6", "o");
            replacements.put("\u00F8", "o");
            replacements.put("\u014D", "o");
            replacements.put("\u014F", "o");
            replacements.put("\u0151", "o");
            replacements.put("\u01A1", "o");
            replacements.put("\u01D2", "o");
            replacements.put("\u01FF", "o");
            replacements.put("\u0153", "oe");
            replacements.put("\u0155", "r");
            replacements.put("\u0157", "r");
            replacements.put("\u0159", "r");
            replacements.put("\u015B", "s");
            replacements.put("\u015D", "s");
            replacements.put("\u015F", "s");
            replacements.put("\u0161", "s");
            replacements.put("\u0163", "t");
            replacements.put("\u0165", "t");
            replacements.put("\u0167", "t");
            replacements.put("\u00F9", "u");
            replacements.put("\u00FA", "u");
            replacements.put("\u00FB", "u");
            replacements.put("\u00FC", "u");
            replacements.put("\u0169", "u");
            replacements.put("\u016B", "u");
            replacements.put("\u016D", "u");
            replacements.put("\u016F", "u");
            replacements.put("\u0171", "u");
            replacements.put("\u0173", "u");
            replacements.put("\u01B0", "u");
            replacements.put("\u01D4", "u");
            replacements.put("\u01D6", "u");
            replacements.put("\u01D8", "u");
            replacements.put("\u01DA", "u");
            replacements.put("\u01DC", "u");
            replacements.put("\u0175", "w");
            replacements.put("\u00FD", "y");
            replacements.put("\u00FE", "th");
            replacements.put("\u00FF", "y");
            replacements.put("\u0177", "y");
            replacements.put("\u017A", "z");
            replacements.put("\u017C", "z");
            replacements.put("\u017E", "z");
            defaultSearchList = replacements.keySet().toArray(new String[replacements.size()]);
            defaultReplacementList = replacements.values().toArray(new String[replacements.size()]);
            
            replacements.put("\u00C4", "AE");
            replacements.put("\u00D6", "OE");
            replacements.put("\u00DC", "UE");
            replacements.put("\u00E4", "ae");
            replacements.put("\u00F6", "oe");
            replacements.put("\u00FC", "ue");
            umlautESearchList = replacements.keySet().toArray(new String[replacements.size()]);
            umlautEReplacementList = replacements.values().toArray(new String[replacements.size()]);
            
        }
        
        
        
        public Asciify(final AsciifyMode mode) {
            super();
            this.mode = mode;
        }
        
        public Asciify() {
            this(AsciifyMode.DEFAULT);
        }





        @Override
        protected String nullAsNullExecute(final String object, final ExecCtx ctx) throws Exception {
            final String result =
                (this.mode.equals(AsciifyMode.UMLAUT_E)?
                        StringUtils.replaceEach(object, umlautESearchList, umlautEReplacementList) :
                        StringUtils.replaceEach(object, defaultSearchList, defaultReplacementList));
            int esTsetIndex;
            if ((esTsetIndex = result.indexOf(ESSZETT)) == -1) {
                return result;
            }
            int prevIndex = 0;
            final StringBuilder strBuilder = new StringBuilder();
            while (esTsetIndex != -1) {
                strBuilder.append(result.substring(prevIndex,esTsetIndex));
                if (esTsetIndex > 0) {
                    int minus = 1;
                    char lastChar = result.charAt(esTsetIndex - minus);
                    while (minus <= esTsetIndex && (Character.isWhitespace(lastChar) || lastChar == ESSZETT)) {
                        lastChar = result.charAt(esTsetIndex - minus);
                        minus++;
                    }
                    if (lastChar >= 'a' && lastChar <= 'z') {
                        strBuilder.append("ss");
                    } else {
                        strBuilder.append("SS");
                    }
                } else {
                    strBuilder.append("SS");
                }
                prevIndex = esTsetIndex + 1;
                esTsetIndex = result.indexOf(ESSZETT, prevIndex);
            }
            strBuilder.append(result.substring(prevIndex));
            return strBuilder.toString();
        }
        
    }
    
    static final class IsAlpha extends Function<String,Boolean> {
        final boolean spacesAllowed;
        
        public IsAlpha() {
            super();
            this.spacesAllowed = false;
        }

        public IsAlpha(boolean spacesAllowed) {
            super();
            this.spacesAllowed = spacesAllowed;
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.spacesAllowed) {
                return Boolean.valueOf(StringUtils.isAlphaSpace(input));
            } 
            return Boolean.valueOf(StringUtils.isAlpha(input));            
        }
    }
    
    static final class IsNumeric extends Function<String,Boolean> {
        final boolean spacesAllowed;
        
        public IsNumeric() {
            super();
            this.spacesAllowed = false;
        }
        
        public IsNumeric(boolean spacesAllowed) {
            super();
            this.spacesAllowed = spacesAllowed;
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.spacesAllowed) {
                return Boolean.valueOf(StringUtils.isNumericSpace(input));
            } 
            return Boolean.valueOf(StringUtils.isNumeric(input));            
        }
    }
    
    static final class IsBigDecimal extends Function<String,Boolean> {
         
        final Locale locale;
        final DecimalPoint decimalPoint;
        
        public IsBigDecimal() {
            super();
            this.locale = null;
            this.decimalPoint = null;
        }
        
        public IsBigDecimal(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
        }
        
        public IsBigDecimal(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
        }
        
        public IsBigDecimal(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                try {
                    Op.on(input).exec(FnString.toBigDecimal()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toBigDecimal(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toBigDecimal(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsBigInteger extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        final Integer radix;
        
        public IsBigInteger() {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsBigInteger(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsBigInteger(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsBigInteger(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
            this.radix = null;
        }
        
        public IsBigInteger(int radix) {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = Integer.valueOf(radix);
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                if (this.radix != null) {
                    try {
                        Op.on(input).exec(FnString.toBigInteger(this.radix.intValue())).get();
                        return Boolean.TRUE;
                    } catch (ExecutionException e) {
                        return Boolean.FALSE;
                    } 
                }
                try {
                    Op.on(input).exec(FnString.toBigInteger()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toBigInteger(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toBigInteger(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsDouble extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        
        public IsDouble() {
            super();
            this.locale = null;
            this.decimalPoint = null;
        }
        
        public IsDouble(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
        }
        
        public IsDouble(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
        }
        
        public IsDouble(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                try {
                    Op.on(input).exec(FnString.toDouble()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toDouble(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toDouble(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsFloat extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        
        public IsFloat() {
            super();
            this.locale = null;
            this.decimalPoint = null;
        }
        
        public IsFloat(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
        }
        
        public IsFloat(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
        }
        
        public IsFloat(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                try {
                    Op.on(input).exec(FnString.toFloat()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toFloat(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toFloat(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsLong extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        final Integer radix;
        
        public IsLong() {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsLong(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsLong(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsLong(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
            this.radix = null;
        }
        
        public IsLong(int radix) {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = Integer.valueOf(radix);
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                if (this.radix != null) {
                    try {
                        Op.on(input).exec(FnString.toLong(this.radix.intValue())).get();
                        return Boolean.TRUE;
                    } catch (ExecutionException e) {
                        return Boolean.FALSE;
                    } 
                }
                try {
                    Op.on(input).exec(FnString.toLong()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toLong(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toLong(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsInteger extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        final Integer radix;
        
        public IsInteger() {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsInteger(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsInteger(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsInteger(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
            this.radix = null;
        }
        
        public IsInteger(int radix) {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = Integer.valueOf(radix);
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                if (this.radix != null) {
                    try {
                        Op.on(input).exec(FnString.toInteger(this.radix.intValue())).get();
                        return Boolean.TRUE;
                    } catch (ExecutionException e) {
                        return Boolean.FALSE;
                    } 
                }
                try {
                    Op.on(input).exec(FnString.toInteger()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toInteger(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toInteger(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsShort extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        final Integer radix;
        
        public IsShort() {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsShort(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsShort(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsShort(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
            this.radix = null;
        }
        
        public IsShort(int radix) {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = Integer.valueOf(radix);
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                if (this.radix != null) {
                    try {
                        Op.on(input).exec(FnString.toShort(this.radix.intValue())).get();
                        return Boolean.TRUE;
                    } catch (ExecutionException e) {
                        return Boolean.FALSE;
                    } 
                }
                try {
                    Op.on(input).exec(FnString.toShort()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toShort(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toShort(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class IsByte extends Function<String,Boolean> {
        
        final Locale locale;
        final DecimalPoint decimalPoint;
        final Integer radix;
        
        public IsByte() {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsByte(Locale locale) {
            super();
            this.locale = locale;
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsByte(String locale) {
            super();
            this.locale = LocaleUtils.toLocale(locale);
            this.decimalPoint = null;
            this.radix = null;
        }
        
        public IsByte(DecimalPoint decimalPoint) {
            super();
            this.locale = null;
            this.decimalPoint = decimalPoint;
            this.radix = null;
        }
        
        public IsByte(int radix) {
            super();
            this.locale = null;
            this.decimalPoint = null;
            this.radix = Integer.valueOf(radix);
        }
        
        public Boolean execute(String input, ExecCtx ctx) throws Exception {
            if (this.locale == null && this.decimalPoint == null) {
                if (this.radix != null) {
                    try {
                        Op.on(input).exec(FnString.toByte(this.radix.intValue())).get();
                        return Boolean.TRUE;
                    } catch (ExecutionException e) {
                        return Boolean.FALSE;
                    } 
                }
                try {
                    Op.on(input).exec(FnString.toByte()).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.locale != null) {
                try {
                    Op.on(input).exec(FnString.toByte(this.locale)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }
            if (this.decimalPoint != null) {
                try {
                    Op.on(input).exec(FnString.toByte(this.decimalPoint)).get();
                    return Boolean.TRUE;
                } catch (ExecutionException e) {
                    return Boolean.FALSE;
                }
            }   
            return Boolean.FALSE;
        }
    }
    
    static final class StartsWith extends AbstractNotNullFunction<String, Boolean> {
        
        final String prefix;
        final int offset;
        
        public StartsWith(String prefix) {
            super();    
            this.prefix = prefix;
            this.offset = 0;
        }
        
        public StartsWith(String prefix, int offset) {
            super();    
            this.prefix = prefix;
            this.offset = offset;
        }
        
        @Override
        public Boolean notNullExecute(String input, ExecCtx ctx) throws Exception {
            
            Validate.notNull(input, "input can't be null");
            
            return Boolean.valueOf(input
                    .startsWith(this.prefix, 
                            this.offset));            
        }
    }
    
    static final class EndsWith extends AbstractNotNullFunction<String, Boolean> {
        
        final String suffix;
        
        public EndsWith(String suffix) {
            super();    
            this.suffix = suffix;
        }
        
        @Override
        public Boolean notNullExecute(String input, ExecCtx ctx) throws Exception {
            
            Validate.notNull(input, "input can't be null");
            
            return Boolean.valueOf(input
                    .endsWith(this.suffix));            
        }
    }
    
    static final class SubString extends Function<String, String> {
        
        final int start;
        final Integer end;
        
        public SubString(int start) {
            super(); 
            this.start = start;
            this.end = null;
        }
        
        public SubString(int start, int end) {
            super(); 
            this.start = start;
            this.end = Integer.valueOf(end);
        }
        
        public String execute(String input, ExecCtx ctx) throws Exception {           
            if (this.end == null) {
                return StringUtils.substring(input, this.start);
            }            
            return StringUtils.substring(input, this.start, this.end.intValue());                        
        }
    }
    
    static final class SubStringBefore extends Function<String, String> {
        
        final String separator;
        
        public SubStringBefore(String separator) {
            super(); 
            this.separator = separator;
        }
                
        public String execute(String input, ExecCtx ctx) throws Exception {           
            return StringUtils.substringBefore(input, this.separator);                    
        }
    }
    
    static final class SubStringBeforeLast extends Function<String, String> {
        
        final String separator;
        
        public SubStringBeforeLast(String separator) {
            super(); 
            this.separator = separator;
        }
                
        public String execute(String input, ExecCtx ctx) throws Exception {           
            return StringUtils.substringBeforeLast(input, this.separator);                    
        }
    }
    
    static final class SubStringAfter extends Function<String, String> {
        
        final String separator;
        
        public SubStringAfter(String separator) {
            super(); 
            this.separator = separator;
        }
                
        public String execute(String input, ExecCtx ctx) throws Exception {           
            return StringUtils.substringAfter(input, this.separator);                    
        }
    }
    
    static final class SubStringAfterLast extends Function<String, String> {
        
        final String separator;
        
        public SubStringAfterLast(String separator) {
            super(); 
            this.separator = separator;
        }
                
        public String execute(String input, ExecCtx ctx) throws Exception {           
            return StringUtils.substringAfterLast(input, this.separator);                    
        }
    }
    
    static final class SubStringBetween extends Function<String, String> {
        
        final String open;
        final String close;
        
        public SubStringBetween(String tag) {
            super(); 
            this.open = tag;
            this.close = null;
        }
        
        public SubStringBetween(String open, String close) {
            super(); 
            this.open = open;
            this.close = close;
        }
                
        public String execute(String input, ExecCtx ctx) throws Exception { 
            if (this.close == null) {
                return StringUtils.substringBetween(input, this.open);     
            }
            return StringUtils.substringBetween(input, this.open, this.close);  
        }
    }
}
