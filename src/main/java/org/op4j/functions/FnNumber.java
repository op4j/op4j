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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.Validate;
import org.op4j.functions.FnNumber.ToString.NumberFormatType;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * @author Soraya S&aacute;nchez
 *
 */
@SuppressWarnings({"cast", "unchecked"})
public final class FnNumber {

    
    private static final ToBigDecimal TO_BIG_DECIMAL = new ToBigDecimal();
    private static final ToBigInteger TO_BIG_INTEGER = new ToBigInteger();
    private static final ToDouble TO_DOUBLE = new ToDouble();
    private static final ToFloat TO_FLOAT = new ToFloat();
    private static final ToLong TO_LONG = new ToLong();
    private static final ToInteger TO_INTEGER = new ToInteger();
    private static final ToShort TO_SHORT = new ToShort();
    private static final ToByte TO_BYTE = new ToByte();
    private static final ToBoolean TO_BOOLEAN = new ToBoolean();

    
    
	private FnNumber() {
		super();           
	}

	
	
	
	/**
	 * <p>
	 * It converts the input into a {@link BigDecimal}
	 * </p>
	 * 
	 * @return the {@link BigDecimal}
	 */
	public static final Function<Number,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    /**
     * <p>
     * It converts the input into a {@link BigDecimal} using the given scale and {@link RoundingMode}
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link BigDecimal}
     */
    public static final Function<Number,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new ToBigDecimal(scale, roundingMode);
    }
    
    
    /**
     * <p>
     * It converts the input into a {@link BigInteger}
     * </p>
     * 
     * @return the {@link BigInteger}
     */
    public static final Function<Number,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }
    
    /**
     * <p>
     * It converts the input into a {@link BigInteger} using the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link BigInteger}
     */
    public static final Function<Number,BigInteger> toBigInteger(final RoundingMode roundingMode) {
        return new ToBigInteger(roundingMode);
    }
    
    /**
     * <p>
     * It converts the target into a {@link Double}
     * </p>
     * 
     * @return the {@link Double}
     */
    public static final Function<Number,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    /**
     * <p>
     * It converts the input into a {@link Double} using the given scale and {@link RoundingMode}
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Double}
     */
    public static final Function<Number,Double> toDouble(final int scale, final RoundingMode roundingMode) {
        return new ToDouble(scale, roundingMode);
    }
    
    /**
     * <p>
     * It converts the input into a {@link Float}
     * </p>
     * 
     * @return the {@link Float}
     */
    public static final Function<Number,Float> toFloat() {
        return TO_FLOAT;
    }
    
    /**
     * <p>
     * It converts the target object into a {@link Float} using the given scale and {@link RoundingMode}
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Float}
     */
    public static final Function<Number,Float> toFloat(final int scale, final RoundingMode roundingMode) {
        return new ToFloat(scale, roundingMode);
    }
    
    /**
     * <p>
     * It converts the input into a {@link Long}
     * </p>
     * 
     * @return the {@link Long}
     */
    public static final Function<Number,Long> toLong() {
        return TO_LONG;
    }
    
    /**
     * <p>
     * It converts the input into a {@link Long} using the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Long}
     */
    public static final Function<Number,Long> toLong(final RoundingMode roundingMode) {
        return new ToLong(roundingMode);
    }
    
    /**
     * <p>
     * It converts the target into an {@link Integer}
     * </p>
     * 
     * @return the {@link Integer}
     */
    public static final Function<Number,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    /**
     * <p>
     * It converts the input into an {@link Integer} using the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Integer}
     */
    public static final Function<Number,Integer> toInteger(final RoundingMode roundingMode) {
        return new ToInteger(roundingMode);
    }
    
    /**
     * <p>
     * It converts the input into a {@link Short}
     * </p>
     * 
     * @return the {@link Short}
     */
    public static final Function<Number,Short> toShort() {
        return TO_SHORT;
    }
    
    /**
     * <p>
     * It converts the target into a {@link Short} using the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Short}
     */
    public static final Function<Number,Short> toShort(final RoundingMode roundingMode) {
        return new ToShort(roundingMode);
    }
    
    /**
     * <p>
     * It converts the input into a {@link Byte}
     * </p>
     * 
     * @return the {@link Byte}
     */
    public static final Function<Number,Byte> toByte() {
        return TO_BYTE;
    }
    
    /**
     * <p>
     * It converts the input into a {@link Byte} using the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the input with
     * @return the {@link Byte}
     */
    public static final Function<Number,Byte> toByte(final RoundingMode roundingMode) {
        return new ToByte(roundingMode);
    }
    
    
    /**
     * <p>
     * It converts the input into a {@link Boolean}
     * </p>
     * 
     * @return the {@link Boolean}
     */
    public static final Function<Number,Boolean> toBoolean() {
        return TO_BOOLEAN;
    }
	

    
    
    /**
     * <p>
     * It rounds the target object with the specified scale and rounding mode
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * 
     * @return the {@link BigDecimal}
     */
    public static final Function<BigDecimal,BigDecimal> roundBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new RoundBigDecimal(scale, roundingMode);
    }
    
    /**
     * <p>
     * It rounds the target with the specified scale and rounding mode
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * 
     * @return the {@link Float}
     */
    public static final Function<Float,Float> roundFloat(final int scale, final RoundingMode roundingMode) {
        return new RoundFloat(scale, roundingMode);
    }
    
    /**
     * <p>
     * It rounds the target object with the specified scale and rounding mode
     * </p>
     * 
     * @param scale the scale to be used
     * @param roundingMode the {@link RoundingMode} to round the input with
     * 
     * @return the {@link Double}
     */
    public static final Function<Double,Double> roundDouble(final int scale, final RoundingMode roundingMode) {
        return new RoundDouble(scale, roundingMode);
    }
    
	
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the input number 
     * </p>
     * 
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr() {
        return new ToString();
    }   
    /**
     * <p>
     * It returns the {@link String} representation of the input number either
     * using or not using grouping
     * </p>
     * 
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(boolean groupingUsed) {
        return new ToString(groupingUsed);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}  
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(Locale locale) {
        return new ToString(locale);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale  
     * </p>
     * 
     * @param locale the locale to be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(String locale) {
        return new ToString(locale);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. Grouping 
     * will be used depending on the value of the groupingUsed parameter  
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(Locale locale, boolean groupingUsed) {
        return new ToString(locale, groupingUsed);
    }   
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. Grouping 
     * will be used depending on the value of the groupingUsed parameter  
     * </p>
     * 
     * @param locale the locale to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(String locale, boolean groupingUsed) {
        return new ToString(locale, groupingUsed);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, true) would return 010.00 if target number is 10</code>
     * <br>
     * <code>toStr(Locale.ENGLISH, 2, 2, 4, true) would return 00.00 if target number is 0</code>
     *    
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, true) would return 010.00 if target number is 10</code>
     * <br>
     * <code>toStr(Locale.ENGLISH.toString(), 2, 2, 4, true) would return 00.00 if target number is 0</code>
     *    
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, ',', '.', true) would return 1,000.00 if target number is 1000</code>
     * <br>
     * <code>toStr(Locale.ENGLISH, 2, 2, 4, ',', '.', true) would return 00.00 if target number is 0</code>
     *        
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, true, ',', true) would return 1,000,00 if target number is 1000</code>
     * <br>
     * <code>toStr(Locale.ENGLISH, 2, 2, 4, true, ',', true) would return 00,00 if target number is 0</code>
     *  
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, ',', '.', true) would return 1,000.00 if target number is 1000</code>
     * <br>
     * <code>toStr(Locale.ENGLISH.toString(), 2, 2, 4, ',', '.', true) would return 00.00 if target number is 0</code>
     *        
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, true, ',', true) would return 1,000,00 if target number is 1000</code>
     * <br>
     * <code>toStr(Locale.ENGLISH.toString(), 2, 2, 4, true, ',', true) would return 00,00 if target number is 0</code>
     *  
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the {@link String} representation of the input
     */
    public static final Function<Number,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.NUMBER, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr() {
        return new ToString(NumberFormatType.CURRENCY);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(boolean groupingUsed) {
        return new ToString(NumberFormatType.CURRENCY, groupingUsed);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale}
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(Locale locale) {
        return new ToString(NumberFormatType.CURRENCY, locale);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale
     * </p>
     * 
     * @param locale the locale to be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(String locale) {
        return new ToString(NumberFormatType.CURRENCY, locale);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale}
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return new ToString(NumberFormatType.CURRENCY, locale, groupingUsed);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale
     * </p>
     * 
     * @param locale the locale to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return new ToString(NumberFormatType.CURRENCY, locale, groupingUsed);
    }
    
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale}.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, true) would return &pound;1,000.00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK, 2, 2, 4, true) would return &pound;00.00 if target number is 0</code>
     * 
     * 
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, true) would return &pound;1,000.00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK.toString(), 2, 2, 4, true) would return &pound;00.00 if target number is 0</code>
     * 
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale} taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK, 2, 2, 4, ',', ',', true) would return &pound;00,00 if target number is 0</code>
     * 
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale} taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK.toString(), 2, 2, 4, ',', ',', true) would return &pound;00,00 if target number is 0</code>
     * 
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK, 2, 2, 4, ',', ',', true) would return &pound;00,00 if target number is 0</code>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br>
     * <code>toCurrencyStr(Locale.UK.toString(), 2, 2, 4, ',', ',', true) would return &pound;00,00 if target number is 0</code>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Number,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.CURRENCY, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr() {
        return new ToString(NumberFormatType.PERCENT);
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number
     * either using grouping or not depending on the given parameter. So,
     * </p>
     * <code>toPercentStr(true) would return 100,000% if target number is 1000</code>
     * <br>
     * <code>toPercentStr(false) would return 100000% if target number is 1000</code>
     * 
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(boolean groupingUsed) {
        return new ToString(NumberFormatType.PERCENT, groupingUsed);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given {@link Locale}
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(Locale locale) {
        return new ToString(NumberFormatType.PERCENT, locale);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale
     * </p>
     * 
     * @param locale the locale to be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(String locale) {
        return new ToString(NumberFormatType.PERCENT, locale);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given {@link Locale}. Grouping will be used depending on the value of the
     * groupingUsed parameter.
     * </p>
     *  
     * @param locale the {@link Locale} to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return new ToString(NumberFormatType.PERCENT, locale, groupingUsed);
    }   
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale. Grouping will be used depending on the value of the
     * groupingUsed parameter.
     * </p>
     * 
     * @param locale the locale to be used
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(String locale, boolean groupingUsed) {
        return new ToString(NumberFormatType.PERCENT, locale, groupingUsed);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given {@link Locale} and using the other given parameters as well. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale and using the other given parameters as well. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale and using the other given parameters as well. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingSeparator grouping separator to be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                true, groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number 
     * in the given locale and using the other given parameters as well. 
     * If necessary, it will add leading or trailing zeros to the string 
     * based on the given parameters. 
     * </p>
     * 
     * @param locale the locale to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @param decimalSeparator decimal separator to be used 
     * @param decimalSeparatorAlwaysShown whether decimal separator should be shown 
     * even if the decimal part is zero or not
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Number,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return new ToString(NumberFormatType.PERCENT, locale, 
                minIntegerDigits, Integer.MAX_VALUE, 
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown);
    }
    
    
    
    

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }
    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eq(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.eq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * in value, this is, whether <tt>target.compareTo(object) == 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValue(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.eqValue(object));
    }
    
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEq(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEq(object));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }
    

    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * in value, this is, whether <tt>target.compareTo(object) != 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValue(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.notEqValue(object));
    }
    
        
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less than the specified object
     * in value, this is, whether <tt>target.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThan(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessThan(object));
    }

    
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    
    

    /**
     * <p>
     * Determines whether the target object is less or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqTo(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterThan(final Number object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final float object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final double object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final byte object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final short object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final int object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterThan(final long object) {    
        return (Function<Number,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final float object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final double object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final byte object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final short object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final int object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Number,Boolean> greaterOrEqTo(final long object) {
        return (Function<Number,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
        
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final float object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final double object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final short object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final int object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Number,Boolean> eqBy(final IFunction<Number,?> by, final long object) {
        return FnObject.eqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final float object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final double object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final short object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final int object) {
        return FnObject.eqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are equal
     * in value, this is, whether <tt>functionResult.compareTo(object) == 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal according to "compareTo", false if not.
     */
    public static final Function<Number,Boolean> eqValueBy(final IFunction<Number,?> by, final long object) {
        return FnObject.eqValueBy(by, object);
    }
    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final float object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final double object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final short object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final int object) {
        return FnObject.notEqBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function 
     * on the target object and the specified object parameter are NOT equal
     * by calling the <tt>equals</tt> method.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Number,Boolean> notEqBy(final IFunction<Number,?> by, final long object) {
        return FnObject.notEqBy(by, object);
    }
        
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final float object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final double object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final short object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final int object) {
        return FnObject.notEqValueBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object and the specified object parameter are NOT equal
     * in value, this is, whether <tt>functionResult.compareTo(object) != 0</tt>. 
     * Both the function result and the specified object have to implement 
     * {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal according to "compareTo", true if not.
     */
    public static final Function<Number,Boolean> notEqValueBy(final IFunction<Number,?> by, final long object) {
        return FnObject.notEqValueBy(by, object);
    }

    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final float object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final double object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final short object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final int object) {
        return FnObject.lessThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) < 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<Number,Boolean> lessThanBy(final IFunction<Number,?> by, final long object) {
        return FnObject.lessThanBy(by, object);
    }

    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final float object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final double object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final short object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final int object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) <= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> lessOrEqToBy(final IFunction<Number,?> by, final long object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    
    

    

    


    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final float object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final double object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final short object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final int object) {
        return FnObject.greaterThanBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) > 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater than the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterThanBy(final IFunction<Number,?> by, final long object) {
        return FnObject.greaterThanBy(by, object);
    }

    
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final Number object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final float object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final double object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final byte object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final short object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final int object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) >= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     */
    public static final Function<Number,Boolean> greaterOrEqToBy(final IFunction<Number,?> by, final long object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Number,Boolean> isNull() {
        return (Function<Number,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Number,Boolean> isNotNull() {
        return (Function<Number,Boolean>)((Function)FnObject.isNotNull());
    }
    
    
    
    
    

	
	
    
    private static abstract class ToNumber<X extends Number> extends AbstractNullAsNullFunction<Number,X> {

        protected ToNumber() {
            super();
        }

        @Override
        public final X nullAsNullExecute(final Number number, final ExecCtx ctx) throws Exception {
            return fromNumber(number);
        }
        
        abstract X fromNumber(final Number number);
        
    }
    
    

    
    private static abstract class ToNonDecimalNumber<X extends Number> extends ToNumber<X> {
        
        private final RoundingMode roundingMode;

        
        ToNonDecimalNumber() {
            super();
            this.roundingMode = null;
        }

        
        ToNonDecimalNumber(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
        }
        
        
        @Override
        final X fromNumber(final Number number) {
            
            if (this.roundingMode == null) {
                return fromNumberToNonDecimal(number);
            }
            
            BigDecimal bigDecimal = 
                new BigDecimal(number.doubleValue());
            bigDecimal = bigDecimal.setScale(0, this.roundingMode);
            return fromNumberToNonDecimal(bigDecimal);

        }
        
        abstract X fromNumberToNonDecimal(final Number number);
        
    }
    

    
    
    private static abstract class ToDecimalNumber<X extends Number> extends ToNumber<X> {

        private final int scale;
        private final RoundingMode roundingMode;
        
        
        ToDecimalNumber() {
            super();
            this.scale = 0;
            this.roundingMode = null;
        }

        
        ToDecimalNumber(final int scale, final RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            this.scale = scale;
            this.roundingMode = roundingMode;
        }
        
        
        @Override
        final X fromNumber(final Number number) {
            
            if (this.roundingMode == null) {
                return fromNumberToDecimal(number);
            }
            
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(this.scale, this.roundingMode);
            return fromNumberToDecimal(bigDecimal);
            
        }
        
        abstract X fromNumberToDecimal(final Number number);
        
    }
    
    
    
    
	
	static final class ToBigDecimal extends ToDecimalNumber<BigDecimal> {

	    
        ToBigDecimal() {
            super();
        }

        ToBigDecimal(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        BigDecimal fromNumberToDecimal(final Number number) {
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

	}
    
    
    
    static final class ToDouble extends ToDecimalNumber<Double> {

        
        ToDouble() {
            super();
        }

        ToDouble(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        Double fromNumberToDecimal(final Number number) {
            return Double.valueOf(number.doubleValue());
        }

    }
    
    
    
    static final class ToFloat extends ToDecimalNumber<Float> {

        
        ToFloat() {
            super();
        }

        ToFloat(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        Float fromNumberToDecimal(final Number number) {
            return Float.valueOf(number.floatValue());
        }

    }
    
    
    
    static final class ToBigInteger extends ToNonDecimalNumber<BigInteger> {

        
        ToBigInteger() {
            super();
        }

        ToBigInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        
        @Override
        BigInteger fromNumberToNonDecimal(final Number number) {
            if (number instanceof BigInteger) {
                return new BigInteger(((BigInteger)number).toByteArray());
            } else if (number instanceof BigDecimal) {
                return ((BigDecimal)number).toBigInteger();
            } else if (number instanceof Double) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            } else if (number instanceof Float) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            }
            return BigInteger.valueOf(number.longValue());
        }

    }
    
    
    
    static final class ToLong extends ToNonDecimalNumber<Long> {
        
        ToLong() {
            super();
        }

        ToLong(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Long fromNumberToNonDecimal(final Number number) {
            return Long.valueOf(number.longValue());
        }

    }
    
    
    
    static final class ToInteger extends ToNonDecimalNumber<Integer> {
        
        ToInteger() {
            super();
        }

        ToInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Integer fromNumberToNonDecimal(final Number number) {
            return Integer.valueOf(number.intValue());
        }

    }
    
    
    
    static final class ToShort extends ToNonDecimalNumber<Short> {
        
        ToShort() {
            super();
        }

        ToShort(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Short fromNumberToNonDecimal(final Number number) {
            return Short.valueOf(number.shortValue());
        }

    }
	
    
    
    static final class ToByte extends ToNonDecimalNumber<Byte> {
        
        ToByte() {
            super();
        }

        ToByte(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Byte fromNumberToNonDecimal(final Number number) {
            return Byte.valueOf(number.byteValue());
        }

    }


    
    
    static final class ToBoolean extends AbstractNullAsNullFunction<Number,Boolean> {
        
        ToBoolean() {
            super();
        }

        
        @Override
        protected Boolean nullAsNullExecute(final Number number, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf((number.doubleValue() != 0.0));
        }

    }
    
    
    
    
    
    static final class RoundBigDecimal extends AbstractNullAsNullFunction<BigDecimal,BigDecimal> {

        private final ToBigDecimal toBigDecimal;
        
        RoundBigDecimal(final int scale, final RoundingMode roundingMode) {
            super();
            this.toBigDecimal = new ToBigDecimal(scale, roundingMode);
        }

        
        @Override
        protected BigDecimal nullAsNullExecute(final BigDecimal object, final ExecCtx ctx) throws Exception {
            return this.toBigDecimal.execute(object, ctx);
        }

    }
    
    
    
    static final class RoundDouble extends AbstractNullAsNullFunction<Double,Double> {

        private final ToDouble toDouble;
        
        RoundDouble(final int scale, final RoundingMode roundingMode) {
            super();
            this.toDouble = new ToDouble(scale, roundingMode);
        }

        
        @Override
        protected Double nullAsNullExecute(final Double object, final ExecCtx ctx) throws Exception {
            return this.toDouble.execute(object, ctx);
        }

    }
    
    
    
    static final class RoundFloat extends AbstractNullAsNullFunction<Float,Float> {

        private final ToFloat toFloat;
        
        RoundFloat(final int scale, final RoundingMode roundingMode) {
            super();
            this.toFloat = new ToFloat(scale, roundingMode);
        }

        
        @Override
        protected Float nullAsNullExecute(final Float object, final ExecCtx ctx) throws Exception {
            return this.toFloat.execute(object, ctx);
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    static final class ToString extends AbstractNullAsNullFunction<Number,String>  {

        private final NumberFormat numberFormat;
        
        ToString() {
            super();
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, null);
        }
        
        ToString(NumberFormatType numberFormatType, boolean groupingUsed) {
            super();    
            
            this.numberFormat = getNumberFormat(numberFormatType, null);
            setGroupingUsed(groupingUsed);          
        }
        
        ToString(boolean groupingUsed) {
            super();    
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, null);
            setGroupingUsed(groupingUsed);
        }
        
        ToString(Locale locale) {
            super();
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, locale);
        }
        
        ToString(NumberFormatType numberFormatType, Locale locale) {
            super();    
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(numberFormatType, locale);
        }
        
        ToString(NumberFormatType numberFormatType, String locale) {
            super();    
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
        }
        
        ToString(NumberFormatType numberFormatType, Locale locale, boolean groupingUsed) {
            super();    
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(numberFormatType, locale);
            setGroupingUsed(groupingUsed);
        }
        
        ToString(NumberFormatType numberFormatType, String locale, boolean groupingUsed) {
            super();    
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
            setGroupingUsed(groupingUsed);
        }
        
        ToString(Locale locale, boolean groupingUsed) {
            super();
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, locale);
            setGroupingUsed(groupingUsed);
        }
        
        ToString(String locale) {
            super();
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, LocaleUtils.toLocale(locale));
        }
        
        ToString(String locale, boolean groupingUsed) {
            super();
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(NumberFormatType.NUMBER, LocaleUtils.toLocale(locale));
            setGroupingUsed(groupingUsed);
        }
        
        ToString(NumberFormatType numberFormatType) {
            super();
            
            this.numberFormat = getNumberFormat(numberFormatType, null);
        }       
        
        ToString(NumberFormatType numberFormatType, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
            super();
            
            this.numberFormat = getNumberFormat(numberFormatType, null);
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
        }
        
        ToString(NumberFormatType numberFormatType, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
                char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
            super();
            
            this.numberFormat = getNumberFormat(numberFormatType, null);
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
            setGroupingSeparator(groupingSeparator);
            setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
        }
        
        ToString(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
            super();
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(numberFormatType, locale);
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
        }
        
        ToString(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
                char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
            super();
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(numberFormatType, locale);
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
            setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
        }
        
        ToString(NumberFormatType numberFormatType, Locale locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
                char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
            super();
            
            Validate.notNull(locale, "locale can't be null");
            
            this.numberFormat = getNumberFormat(numberFormatType, locale);
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
            setGroupingSeparator(groupingSeparator);
            setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
        }
        
        ToString(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
            super();
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);          
        }
        
        ToString(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
                char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
            super();
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
            setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
        }
            
        ToString(NumberFormatType numberFormatType, String locale, int minIntegerDigits, int maxIntegerDigits,
                int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
                char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
            super();
            
            Validate.notEmpty(locale, "locale can't be neither empty nor null");
            
            this.numberFormat = getNumberFormat(numberFormatType, LocaleUtils.toLocale(locale));
            setMinAndMaxDigits(minIntegerDigits, maxIntegerDigits, minFractionDigits, maxFractionDigits);
            setGroupingUsed(groupingUsed);
            setGroupingSeparator(groupingSeparator);
            setDecimalSeparator(decimalSeparator, decimalSeparatorAlwaysShown);
        }

        
        @Override
        protected String nullAsNullExecute(final Number number, final ExecCtx ctx) throws Exception {
            return fromNumber(number);                      
        }
        
        private NumberFormat getNumberFormat(NumberFormatType numberFormatType, Locale locale) {
            Validate.notNull(numberFormatType, "numberFormatType can't be null");
            
            NumberFormat nf = null;
            switch (numberFormatType) {
                case CURRENCY :
                    nf = NumberFormat.getCurrencyInstance((locale != null) ? locale : Locale.getDefault());
                    break;
                case PERCENT :
                    nf = NumberFormat.getPercentInstance((locale != null) ? locale : Locale.getDefault());
                    break;
                case NUMBER :
                    nf = NumberFormat.getNumberInstance((locale != null) ? locale : Locale.getDefault());
                    break;
                default :
                    nf = NumberFormat.getNumberInstance((locale != null) ? locale : Locale.getDefault());                   
            }
            return nf;
        }
        
        private void setMinAndMaxDigits(int minIntegerDigits, int maxIntegerDigits, 
                int minFractionDigits, int maxFractionDigits) {
            this.numberFormat.setMinimumIntegerDigits(minIntegerDigits);
            this.numberFormat.setMaximumIntegerDigits(maxIntegerDigits);
            this.numberFormat.setMinimumFractionDigits(minFractionDigits);
            this.numberFormat.setMaximumFractionDigits(maxFractionDigits);
        }
        
        private void setDecimalSeparator(char decimalSeparator, 
                boolean decimalSeparatorAlwaysShown) {
            if (this.numberFormat instanceof DecimalFormat) {
                DecimalFormat asDecimalFormat = (DecimalFormat) this.numberFormat;
                // It returns a clone of decimalFormatSymbols
                DecimalFormatSymbols decimalFormatSymbols = asDecimalFormat.getDecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator(decimalSeparator); 
                decimalFormatSymbols.setMonetaryDecimalSeparator(decimalSeparator); 
                asDecimalFormat.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);
                // Update decimalFormatSymbols
                asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                
            }
        }
        
        private boolean setGroupingSeparator(char groupingSeparator) {
            if (this.numberFormat instanceof DecimalFormat) {
                DecimalFormat asDecimalFormat = (DecimalFormat) this.numberFormat;
                // It returns a clone of decimalFormatSymbols
                DecimalFormatSymbols decimalFormatSymbols = asDecimalFormat.getDecimalFormatSymbols();
                decimalFormatSymbols.setGroupingSeparator(groupingSeparator);   
                // Update decimalFormatSymbols
                asDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                return true;
            }   
            return false;
        }
        
        private void setGroupingUsed(boolean groupingUsed) {
            this.numberFormat.setGroupingUsed(groupingUsed);
        }
        
        private String fromNumber(final Number number) {    
            return this.numberFormat.format(number);
        }       
        
        static enum NumberFormatType {
            CURRENCY,
            NUMBER,
            PERCENT         
        }
    }
    
    
}
