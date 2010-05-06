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
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Locale;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
@SuppressWarnings({"cast", "unchecked"})
public final class FnBigDecimal {

	private static final Function<Iterable<BigDecimal>, BigDecimal> MAX_FUNC = new Max();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> MIN_FUNC = new Min();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> AVG_FUNC = new Avg();

    private static final Function<BigDecimal[], BigDecimal> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<BigDecimal[], BigDecimal> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<BigDecimal[], BigDecimal> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<BigDecimal[], BigDecimal> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<BigDecimal, BigDecimal> ABS_FUNC = new Abs();
	
	
	FnBigDecimal() {
		super();           
	}

	// From FnNumber
	public static final Function<BigDecimal,BigDecimal> roundBigDecimal(final int scale, final RoundingMode roundingMode) {
        return FnNumber.roundBigDecimal(scale, roundingMode);
	}
	/**
	 * <p>
	 * It returns the {@link String} representation of the input number
	 * </p>
	 *
	 * @return the {@link String} representation of the input
	 */
	public static final Function<BigDecimal,String> toStr() {
	    return (Function<BigDecimal,String>)((Function)FnNumber.toStr());
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
	public static final Function<BigDecimal,String> toStr(boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<BigDecimal,String> toStr(Locale locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<BigDecimal,String> toStr(String locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<BigDecimal,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<BigDecimal,String> toStr(String locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
	
	/**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, true) would return 010.00 if target number is 10</code>
     * <br />
     * <code>toStr(Locale.ENGLISH, 2, 2, 4, true) would return 00.00 if target number is 0</code>
     *    
     * @param locale the {@link Locale} to be used
     * @param minIntegerDigits minimum number of integer digits so, if not enough in the
     * target number, 0's will be added to the left of the integer part
     * @param minFractionDigits minimum number of fraction digits so, if not enough in the
     * target number, 0's will be added to the right of the decimal part
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<BigDecimal,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingUsed));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, true) would return 010.00 if target number is 10</code>
     * <br />
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
    public static final Function<BigDecimal,String> toStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingUsed));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, ',', '.', true) would return 1,000.00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given {@link Locale}. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH, 3, 2, 2, true, ',', true) would return 1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, ',', '.', true) would return 1,000.00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits, 
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target number in the given locale. 
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toStr(Locale.ENGLISH.toString(), 3, 2, 2, true, ',', true) would return 1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<BigDecimal,String> toCurrencyStr() {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<BigDecimal,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<BigDecimal,String> toCurrencyStr(Locale locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<BigDecimal,String> toCurrencyStr(String locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<BigDecimal,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<BigDecimal,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale}.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, true) would return &pound;1,000.00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingUsed));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, true) would return &pound;1,000.00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingUsed));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale} taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given {@link Locale} taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK, 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits, 
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * given locale taking into account the given parameters.
     * If necessary, it will add leading or trailing zeros to the string based on the given parameters. So,
     * </p>
     * <code>toCurrencyStr(Locale.UK.toString(), 3, 2, 2, ',', ',', true) would return &pound;1,000,00 if target number is 1000</code>
     * <br />
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
    public static final Function<BigDecimal,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toCurrencyStr(locale, 
                minIntegerDigits, 
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<BigDecimal,String> toPercentStr() {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr());
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number
     * either using grouping or not depending on the given parameter. So,
     * </p>
     * <code>toPercentStr(true) would return 100,000% if target number is 1000</code>
     * <br />
     * <code>toPercentStr(false) would return 100000% if target number is 1000</code>
     * 
     * @param groupingUsed whether or not grouping will be used
     * @return the string representation of the input number as a percentage
     */
    public static final Function<BigDecimal,String> toPercentStr(boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<BigDecimal,String> toPercentStr(Locale locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<BigDecimal,String> toPercentStr(String locale) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<BigDecimal,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<BigDecimal,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<BigDecimal,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingUsed));
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
    public static final Function<BigDecimal,String> toPercentStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingUsed));
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
    public static final Function<BigDecimal,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
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
    public static final Function<BigDecimal,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits,
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
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
    public static final Function<BigDecimal,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits, 
                groupingSeparator, decimalSeparator, 
                decimalSeparatorAlwaysShown));
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
    public static final Function<BigDecimal,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<BigDecimal,String>)((Function)FnNumber.toPercentStr(locale, 
                minIntegerDigits,  
                minFractionDigits, maxFractionDigits, 
                groupingUsed, decimalSeparator, 
                decimalSeparatorAlwaysShown));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link BigDecimal} to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<BigDecimal,Boolean> eq(final BigDecimal object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<BigDecimal,Boolean> eqValue(final BigDecimal object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.eqValue(object));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link BigDecimal} to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<BigDecimal,Boolean> notEq(final BigDecimal object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<BigDecimal,Boolean> notEqValue(final BigDecimal object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessThan(final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> lessOrEqTo(final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final Number object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final float object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final double object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final byte object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final short object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final int object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterThan(final long object) {    
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqTo(final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigDecimal,Boolean> eqBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<BigDecimal,Boolean> eqValueBy(final IFunction<BigDecimal,?> by, final Number object) {
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
    public static final Function<BigDecimal,Boolean> notEqBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<BigDecimal,Boolean> notEqValueBy(final IFunction<BigDecimal,?> by, final Number object) {
        return FnObject.notEqValueBy(by, object);
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less than the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt; 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less than the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessThanBy(final IFunction<BigDecimal,?> by, final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is less or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &lt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is less or equal to the specified object, false if not
     */
    public static final Function<BigDecimal,Boolean> lessOrEqToBy(final IFunction<BigDecimal,?> by, final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterThanBy(final IFunction<BigDecimal,?> by, final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final Number object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final float object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final double object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final byte object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final short object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final int object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigDecimal,Boolean> greaterOrEqToBy(final IFunction<BigDecimal,?> by, final long object) {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<BigDecimal,Boolean> isNull() {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<BigDecimal,Boolean> isNotNull() {
        return (Function<BigDecimal,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
    /**
     * <p>
     * It returns the maximum number from an {@link Iterable} input object
     * </p>
     * 
     * @return the maximum number
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> max() {
        return MAX_FUNC;
    }

    /**
     * <p>
     * It returns the minimum number from an {@link Iterable} input object
     * </p>
     * 
     * @return the minimum number
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> min() {
        return MIN_FUNC;
    }

    /**
     * <p>
     * It returns the sum of all the numbers in the {@link Iterable} input object
     * </p>
     * 
     * @return a number equal to the sum of all the elements in the input {@link Iterable}
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> sum() {
        return SUM_FUNC;
    }

    /**
     * <p>
     * It returns the average of all the numbers in the {@link Iterable} input object
     * </p>
     * 
     * @return a number representing the average of the input numbers
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> avg() {
        return AVG_FUNC;
    }

    /**
     * <p>
     * It returns the average of all the numbers in the {@link Iterable} input object. The
     * given {@link MathContext} will be used to round and set the output precision
     * </p>
     * 
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * of the average
     * 
     * @return a number representing the average 
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    /**
     * <p>
     * It returns the average of all the numbers in the {@link Iterable} input object. The
     * given {@link RoundingMode} will be used to round the output
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the average
     * 
     * @return a number representing the average 
     */
    public final static Function<Iterable<BigDecimal>, BigDecimal> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    /**
     * <p>
     * It returns the maximum number from the input array
     * </p>
     * 
     * @return the maximum number
     */
    public final static Function<BigDecimal[], BigDecimal> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
     * <p>
     * It returns the minimum number from the input array
     * </p>
     * 
     * @return the minimum number
     */
    public final static Function<BigDecimal[], BigDecimal> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
     * <p>
     * It returns the sum of all the numbers in the input array
     * </p>
     * 
     * @return a number equal to the sum of all the elements in the input array
     */
    public final static Function<BigDecimal[], BigDecimal> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
     * <p>
     * It returns the average of all the numbers in the input array
     * </p>
     * 
     * @return a number representing the average of the input numbers
     */
    public final static Function<BigDecimal[], BigDecimal> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    /**
     * <p>
     * It returns the average of all the numbers in the input array. The
     * given {@link MathContext} will be used to round and set the output precision
     * </p>
     * 
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * of the average
     * 
     * @return a number representing the average 
     */
    public final static Function<BigDecimal[], BigDecimal> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    /**
     * <p>
     * It returns the average of all the numbers in the input array. The
     * given {@link RoundingMode} will be used to round the output
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} to round the average
     * 
     * @return a number representing the average 
     */
    public final static Function<BigDecimal[], BigDecimal> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    /**
     * <p>
     * It rounds the input number with the given {@link MathContext}
     * </p>
     * 
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the input rounded
     */
    public final static Function<BigDecimal, BigDecimal> round(MathContext mathContext) {
        return new Round(mathContext);
    }

    /**
     * <p>
     * It rounds the input number with the given {@link RoundingMode}
     * </p>
     * 
     * @param roundingMode the {@link RoundingMode} 
     * @return the input rounded
     */
    public final static Function<BigDecimal, BigDecimal> round(RoundingMode roundingMode) {
        return new Round(roundingMode);
    }

    /**
     * <p>
     * It returns the absolute value of the input
     * </p>
     * 
     * @return the absolute value of the input
     */
    public final static Function<BigDecimal, BigDecimal> abs() {
        return ABS_FUNC;
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(Number add) {
        return new Add(fromNumber(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(byte add) {
        return add(Byte.valueOf(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(short add) {
        return add(Short.valueOf(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(int add) {
        return add(Integer.valueOf(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(long add) {
        return add(Long.valueOf(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(float add) {
        return add(Float.valueOf(add));
    }

    /**
     * <p>
     * It adds the given number to the target and returns the result
     * </p>
     * 
     * @param add value to be added to the target
     * @return the result of the addition of add to the target number
     */
    public final static Function<BigDecimal, BigDecimal> add(double add) {
        return add(Double.valueOf(add));
    }


    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    /**
     * <p>
     * It subtracts the given number from the target and returns the result
     * </p>
     * 
     * @param subtract number to be subtracted from the target
     * @return the result of the subtraction
     */
    public final static Function<BigDecimal, BigDecimal> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result
     * </p>
     * 
     * @param divisor the divisor
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result with the
     * precision and rounding mode specified by mathContext
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns its result rounded
     * based on the specified rounding mode
     * </p>
     * 
     * @param divisor the divisor
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }

    

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(Number divisor) {
        return new Remainder(fromNumber(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(byte divisor) {
        return remainder(Byte.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(short divisor) {
        return remainder(Short.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(int divisor) {
        return remainder(Integer.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(long divisor) {
        return remainder(Long.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(float divisor) {
        return remainder(Float.valueOf(divisor));
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor)
     * </p>
     * 
     * @param divisor the divisor
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(double divisor) {
        return remainder(Double.valueOf(divisor));
    }


    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(Number divisor, MathContext mathContext) {
        return new Remainder(fromNumber(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(byte divisor, MathContext mathContext) {
        return remainder(Byte.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(short divisor, MathContext mathContext) {
        return remainder(Short.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(int divisor, MathContext mathContext) {
        return remainder(Integer.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(long divisor, MathContext mathContext) {
        return remainder(Long.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(float divisor, MathContext mathContext) {
        return remainder(Float.valueOf(divisor), mathContext);
    }

    /**
     * <p>
     * It divides the target element by the given divisor and returns the
     * remainder (target % divisor). The remainder precision and {@link RoundingMode}
     * is specified by the given {@link MathContext}
     * </p>
     * 
     * @param divisor the divisor
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the remainder of target/divisor
     */
    public final static Function<BigDecimal, BigDecimal> remainder(double divisor, MathContext mathContext) {
        return remainder(Double.valueOf(divisor), mathContext);
    }


    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result precision
     * and {@link RoundingMode} is specified by the given {@link MathContext}
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param mathContext the {@link MathContext} to define {@link RoundingMode} and precision
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    /**
     * <p>
     * It multiplies target by multiplicand and returns its value. The result is 
     * rounded based on the given {@link RoundingMode} 
     * </p>
     * 
     * @param multiplicand the multiplicand
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target * multiplicand
     */
    public final static Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    /**
     * <p>
     * It performs the operation target<sup>power</sup> and returns its value
     * </p>
     * 
     * @param power the power to raise the target to
     * @return the result of target<sup>power</sup>
     */
    public final static Function<BigDecimal, BigDecimal> pow(int power) {
        return new Pow(power);
    }

    /**
     * <p>
     * It performs the operation target<sup>power</sup> and returns its value. The result
     * precision and rounding mode is specified by the given {@link MathContext}
     * </p>
     * 
     * @param power the power to raise the target to
     * @param mathContext the {@link MathContext} to specify precision and {@link RoundingMode}
     * @return the result of target<sup>power</sup>
     */
    public final static Function<BigDecimal, BigDecimal> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    /**
     * <p>
     * It performs the operation target<sup>power</sup> and returns its value. The result
     * rounding mode is specified by the given {@link RoundingMode}
     * </p>
     * 
     * @param power the power to raise the target to
     * @param roundingMode the {@link RoundingMode} 
     * @return the result of target<sup>power</sup>
     */
    public final static Function<BigDecimal, BigDecimal> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
	private static BigDecimal fromNumber(final Number number) {
	    if (number == null) {
	        return null;
	    }
	    if (number instanceof BigDecimal) {
	        return (BigDecimal) number;
	    }
	    if (number instanceof BigInteger) {
	        return new BigDecimal((BigInteger)number);
	    }
	    return BigDecimal.valueOf(number.doubleValue());
	}
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Max() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigDecimal max = input.iterator().next();
			for (BigDecimal number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Min() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigDecimal min = input.iterator().next();
			for (BigDecimal number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Sum() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Avg() {
			super();
			this.roundingMode = null;
			this.mathContext = null;
		}

		Avg(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Avg(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.roundingMode = null;
			this.mathContext = mathContext;
		}
		
		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode);
			}
			if (this.mathContext != null) {
				return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext);
			}
			return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN);
		}		
	}

	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        MaxArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigDecimal max = input[0];
            for (BigDecimal number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }
    }
    
    static final class MinArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        MinArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigDecimal min = input[0];
            for (BigDecimal number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        SumArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (BigDecimal number : input) {
                if (number != null) {
                    sum = sum.add(number);
                }
            }   
            return sum;
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        AvgArray() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }

        AvgArray(RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        AvgArray(MathContext mathContext) {
            super();
            Validate.notNull(mathContext, "MathContext can't be null");
            this.roundingMode = null;
            this.mathContext = mathContext;
        }
        
        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (BigDecimal number : input) {
                if (number != null) {
                    sum = sum.add(number);
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode);
            }
            if (this.mathContext != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext);
            }
            return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN);
        }       
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static final class Round extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Round(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Round(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
			this.roundingMode = null;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			if (this.roundingMode != null) {
				return result.setScale(0, this.roundingMode);
			}			
			return result.round(this.mathContext);
		}	
	}
	
	static final class Abs extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		Abs() {
			super();
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal add;
		
		Add(BigDecimal add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal subtract;
		
		Subtract(BigDecimal subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(BigDecimal divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.roundingMode != null) {
				result = result.divide(this.divisor, this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(this.divisor, this.mathContext);				
			} else {
				result = result.divide(this.divisor, RoundingMode.DOWN);	
			}
			return result;
		}		
	}
	
	
	static final class Remainder extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final MathContext mathContext;
		
		Remainder(BigDecimal divisor) {
			super();
			this.divisor = divisor;
			this.mathContext = null;
		}
		
		Remainder(BigDecimal divisor, MathContext mathContext) {
			super();
			this.divisor = divisor;
			this.mathContext = mathContext;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			if (this.mathContext != null) {
				return input.remainder(this.divisor, this.mathContext);
			}
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(BigDecimal multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(BigDecimal multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(BigDecimal multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.mathContext != null) {
				result = result.multiply(this.multiplicand, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(this.multiplicand).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(this.multiplicand);	
			}
			return result;
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final int power;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Pow(int power) {
			super();
			this.power = power;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Pow(int power, RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.power = power;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Pow(int power, MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.power = power;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return result;
		}		
	}
	
}
