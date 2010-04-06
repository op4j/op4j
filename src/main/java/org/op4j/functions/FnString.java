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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
 *
 */
/**
 * @author Soraya
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
     * (for example: "en_US", "es_ES", etc.)
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
     * equivalent number. 
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
     * (for example: "en_US", "es_ES", etc.)
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * Converts a String into a Double, using the specified decimal point
     * configuration ({@link DecimalPoint}) and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.. The target String should contain no
     * thousand separators.
     * </p>
     * 
     * @param scale the desired scale for the resulting Double object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
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
     * (for example: "en_US", "es_ES", etc.)
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
     * mode is used for setting the scale to the specified value.. The target String should contain no
     * thousand separators.
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
     * point and thousands separator configuration.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * Converts a String into a Float, using the specified decimal point
     * configuration ({@link DecimalPoint}) and establishing the specified scale. Rounding
     * mode is used for setting the scale to the specified value.. The target String should contain no
     * thousand separators.
     * </p>
     * 
     * @param scale the desired scale for the resulting Float object
     * @param roundingMode the rounding mode to be used when setting the scale
     * @param decimalPoint the decimal point being used by the String
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * point and thousands separator configuration.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * equivalent number. 
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
     * mode is used for removing the decimal part of the number. 
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
     * thousand separators.
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
     * decimal part of the number.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * Converts a String into an Integer, using the default configuration.
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
     * point and thousands separator configuration.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * equivalent number. 
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
     * mode is used for removing the decimal part of the number. 
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
     * thousand separators.
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
     * decimal part of the number.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * point and thousands separator configuration.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * equivalent number. 
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
     * mode is used for removing the decimal part of the number. 
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
     * thousand separators.
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
     * decimal part of the number.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * point and thousands separator configuration.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * thousand separators.
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
     * equivalent number. 
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
     * thousand separators.
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
     * decimal part of the number.
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
     * (for example: "en_US", "es_ES", etc.)
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
     * 
     * @return the resulting Boolean object
     */
    public static final Function<String,Boolean> toBoolean() {
        return TO_BOOLEAN;
    }
    
    
	
	
	public static final Function<String,String> escapeCSV() {
        return ESCAPE_CSV_STRING_FUNC;
    }
	public static final Function<String,String> unescapeCSV() {
        return UNESCAPE_CSV_STRING_FUNC;
    }	

	public static final Function<String,String> escapeXML() {
        return ESCAPE_XML_STRING_FUNC;
    }
	public static final Function<String,String> unescapeXML() {
        return UNESCAPE_XML_STRING_FUNC;
    }
	
	public static final Function<String,String> escapeHTML() {
        return ESCAPE_HTML_STRING_FUNC;
    }
	public static final Function<String,String> unescapeHTML() {
        return UNESCAPE_HTML_STRING_FUNC;
    }
	
	public static final Function<String,String> escapeJavaScript() {
        return ESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	public static final Function<String,String> unescapeJavaScript() {
        return UNESCAPE_JAVASCRIPT_STRING_FUNC;
    }
	
	/**
	 * It converts the given String into its Hexadecimal representation using the specified Charset
	 * 
	 * @param charset
	 * @return
	 */
	public static final Function<String,String> toHexadecimal(Charset charset) {
        return new ToHexadecimal(charset);
    }
	/**
	 * The given String is converted from its Hexadecimal representation into a String using the specified Charset
	 * 
	 * @param charset
	 * @return
	 */
	public static final Function<String,String> fromHexadecimal(Charset charset) {
        return new FromHexadecimal(charset);
    }
	
	/**
	 * It converts the given String to uppercase
	 * 
	 * @return
	 */
	public static final Function<String,String> toUpperCase() {
        return TO_UPPER_CASE_STRING_FUNC;
    }
	/**
	 * It converts the given String to lowercase
	 * 
	 * @return
	 */
	public static final Function<String,String> toLowerCase() {
        return TO_LOWER_CASE_STRING_FUNC;
    }
	
	/**
	 * It converts the first letter of the given String to lowercase
	 * 
	 * @return
	 */
	public static final Function<String,String> unCapitalize() {
        return UN_CAPITALIZE_STRING_FUNC;
    }
	/**
	 * It converts the first letter of the given String to uppercase
	 * 
	 * @return
	 */
	public static final Function<String,String> capitalize() {
        return CAPITALIZE_STRING_FUNC;
    }
	
	/**
	 * Removes control characters (char <= 32) from both ends of the given String
	 * 
	 * @return
	 */
	public static final Function<String,String> trim() {
        return TRIM_STRING_FUNC;
    }
	
	/**
	 * Strips whitespace from both sides of the given String
	 * 
	 * @return
	 */
	public static final Function<String,String> strip() {
        return STRIP_STRING_FUNC;
    }
	
	
    public static final Function<String,Calendar> toCalendar(final String pattern) {
        return new ToCalendar(pattern);
    }
    
    public static final Function<String,Calendar> toCalendar(final String pattern, final Locale locale) {
        return new ToCalendar(pattern, locale);
    }
    
    public static final Function<String,Calendar> toCalendar(final String pattern, final String locale) {
        return new ToCalendar(pattern, locale);
    }
	
    
    
	
    
    public static final Function<String,Date> toDate(final String pattern) {
        return new ToDate(pattern);
    }
    
    public static final Function<String,Date> toDate(final String pattern, final Locale locale) {
        return new ToDate(pattern, locale);
    }
    
    public static final Function<String,Date> toDate(final String pattern, final String locale) {
        return new ToDate(pattern, locale);
    }

    
    
    

    
    public static final Function<Object,Boolean> eq(final String object) {
        return FnObject.eq(object);
    }
    
    public static final Function<Object,Boolean> notEq(final String object) {
        return FnObject.notEq(object);
    }

    
    
    
    
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    
    
    
    
    

    
    public static final Function<Object,Boolean> lessThan(final String object) {
        return FnObject.lessThan(object);
    }

    
    public static final Function<Object,Boolean> lessOrEqTo(final String object) {
        return FnObject.lessOrEqTo(object);
    }
    
    
    public static final Function<Object,Boolean> greaterThan(final String object) {
        return FnObject.greaterThan(object);
    }
    
    
    public static final Function<Object,Boolean> greaterOrEqTo(final String object) {
        return FnObject.greaterOrEqTo(object);
    }
    
    
    
    
    
    
    
    public static final Function<String,Boolean> matches(final String regex) {
        return new Matches(regex);
    }
    
    public static final Function<String,Boolean> contains(final String regex) {
        return new Contains(regex);
    }



    
    
    
    public static final Function<String,String> extractFirst(final String regex) {
        return new Extract(regex, false);
    }
    
    public static final Function<String,String> extractLast(final String regex) {
        return new Extract(regex, true);
    }
    
    public static final Function<String,List<String>> extractAll(final String regex) {
        return new ExtractAll(regex);
    }
    
    public static final Function<String,String> matchAndExtract(final String regex, final int group) {
        return new MatchAndExtract(regex, group);
    }
    
    public static final Function<String,List<String>> matchAndExtractAll(final String regex, final int... groups) {
        return new MatchAndExtractAll(regex, VarArgsUtil.asRequiredIntegerList(groups));
    }

    
    
    public static final Function<String,String> replaceFirst(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.FIRST);
    }
    
    public static final Function<String,String> replaceLast(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.LAST);
    }
    
    public static final Function<String,String> replaceAll(final String regex, final String replacement) {
        return new Replace(regex, replacement, ReplaceType.ALL);
    }
    
    
    /**
     * Splits a String into a list of substrings using the whitespace as the separator
     * 
     * @return
     */
    public static final Function<String, List<String>> split() {
        return SPLIT;        
    }
    
    /**
     * Splits a String into a list of substrings using the given separator
     * as the substrings separator (the separator is not included in the
     * returned list)
     * 
     * @param separator
     * @return
     */
    public static final Function<String, List<String>> split(String separator) {
        return new Split(separator);        
    }
    
    /**
     * Splits a String into an array of substrings using the whitespace as the separator
     * 
     * @return
     */
    public static final Function<String, String[]> splitAsArray() {
        return SPLIT_AS_ARRAY;        
    }
    
    /**
     * Splits a String into an array of substrings using the given separator
     * as the substrings separator (the separator is not included in the
     * returned list)
     * 
     * @param separator
     * @return
     */
    public static final Function<String, String[]> splitAsArray(String separator) {
        return new SplitAsArray(separator);        
    }
    
    
    /**
     * Joins the string representation of the objects in the list into a single String 
     * (no separator used)
     * 
     * @return
     */
    public static final Function<List<Object>, String> join() {
        return JOIN;        
    }
    
    /**
     * Joins the string representation of the objects in the list into a single String 
     * using the given separator
     * 
     * @return
     */
    public static final Function<List<Object>, String> join(String separator) {
        return new Join(separator);        
    }
    
    /**
     * Joins the string representation of the objects in the array into a single String 
     * (no separator used)
     * 
     * @return
     */
    public static final Function<Object[], String> joinArray() {
        return JOIN_ARRAY;        
    }
    
    /**
     * Joins the string representation of the objects in the array into a single String 
     * using the given separator
     * 
     * @return
     */
    public static final Function<Object[], String> joinArray(String separator) {
        return new JoinArray(separator);        
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
            calendar.setTime(this.simpleDateFormat.parse(object));
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
            calendar.setTime(this.simpleDateFormat.parse(object));
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
}
