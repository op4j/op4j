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
public final class FnDouble {

	private static final Function<Iterable<Double>, Double> MAX_FUNC = new Max();
	
	private static final Function<Iterable<Double>, Double> MIN_FUNC = new Min();
	
	private static final Function<Iterable<Double>, Double> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<Double>, Double> AVG_FUNC = new Avg();

    private static final Function<Double[], Double> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<Double[], Double> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<Double[], Double> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<Double[], Double> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<Double, Double> ABS_FUNC = new Abs();
	
	
	FnDouble() {
		super();           
	}
	
	
	// From FnNumber
	
	public static final Function<Double,Double> roundDouble(final int scale, final RoundingMode roundingMode) {
        return FnNumber.roundDouble(scale, roundingMode);
	}
	/**
	 * <p>
	 * It returns the {@link String} representation of the input number
	 * </p>
	 *
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Double,String> toStr() {
        return (Function<Double,String>)((Function)FnNumber.toStr());
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
	public static final Function<Double,String> toStr(boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Double,String> toStr(Locale locale) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Double,String> toStr(String locale) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<Double,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<Double,String> toStr(String locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
     * @param maxFractionDigits maximum number of fraction digits
     * @param groupingUsed whether or not grouping will be used
     * @return the {@link String} representation of the input
     */
    public static final Function<Double,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr() {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<Double,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<Double,String> toCurrencyStr(Locale locale) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Double,String> toCurrencyStr(String locale) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Double,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<Double,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<Double,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toCurrencyStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toCurrencyStr(locale, 
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
    public static final Function<Double,String> toPercentStr() {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr());
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
    public static final Function<Double,String> toPercentStr(boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<Double,String> toPercentStr(Locale locale) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Double,String> toPercentStr(String locale) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Double,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Double,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Double,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
    public static final Function<Double,String> toPercentStr(String locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
    public static final Function<Double,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
    public static final Function<Double,String> toPercentStr(Locale locale, int minIntegerDigits,
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
    public static final Function<Double,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, 
            char groupingSeparator, char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
    public static final Function<Double,String> toPercentStr(String locale, int minIntegerDigits, 
            int minFractionDigits, int maxFractionDigits, boolean groupingUsed,
            char decimalSeparator, boolean decimalSeparatorAlwaysShown) {
        return (Function<Double,String>)((Function)FnNumber.toPercentStr(locale, 
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
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Double,Boolean> eq(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Double,Boolean> eq(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Double,Boolean> eqValue(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Double,Boolean> eqValue(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Double,Boolean> notEq(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Double,Boolean> notEq(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Double,Boolean> notEqValue(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Double,Boolean> notEqValue(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Double,Boolean> lessThan(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessThan(final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> lessOrEqTo(final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterThan(final Number object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final float object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final double object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final byte object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final short object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final int object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterThan(final long object) {    
        return (Function<Double,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> greaterOrEqTo(final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Double,Boolean> eqBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<Double,Boolean> eqBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<Double,Boolean> eqValueBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
    public static final Function<Double,Boolean> eqValueBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
    public static final Function<Double,Boolean> notEqBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<Double,Boolean> notEqBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<Double,Boolean> notEqValueBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
    public static final Function<Double,Boolean> notEqValueBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessThanBy(final IFunction<Double,?> by, final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> lessOrEqToBy(final IFunction<Double,?> by, final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterThanBy(final IFunction<Double,?> by, final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final Number object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final float object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final double object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final byte object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final short object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final int object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Double,Boolean> greaterOrEqToBy(final IFunction<Double,?> by, final long object) {
        return (Function<Double,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Double,Boolean> isNull() {
        return (Function<Double,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Double,Boolean> isNotNull() {
        return (Function<Double,Boolean>)((Function)FnObject.isNotNull());
    }
    
    // End From FnNumber
    
    
    
    
    
    
    
	

    /**
	 * <p>
	 * It returns the maximum number from an {@link Iterable} input object
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Iterable<Double>, Double> max() {
        return MAX_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from an {@link Iterable} input object
	 * </p>
	 *
	 * @return the minimum number
	 */
	public final static Function<Iterable<Double>, Double> min() {
        return MIN_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input {@link Iterable}
	 */
	public final static Function<Iterable<Double>, Double> sum() {
        return SUM_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Iterable<Double>, Double> avg() {
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
	public final static Function<Iterable<Double>, Double> avg(MathContext mathContext) {
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
	public final static Function<Iterable<Double>, Double> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    /**
	 * <p>
	 * It returns the maximum number from the input array
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Double[], Double> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from the input array
	 * </p>
	 * 
	 * @return the minimum number
	 */
	public final static Function<Double[], Double> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input array
	 */
	public final static Function<Double[], Double> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Double[], Double> avgArray() {
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
	public final static Function<Double[], Double> avgArray(MathContext mathContext) {
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
	public final static Function<Double[], Double> avgArray(RoundingMode roundingMode) {
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
	public final static Function<Double, Double> round(MathContext mathContext) {
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
	public final static Function<Double, Double> round(RoundingMode roundingMode) {
        return new Round(roundingMode);
    }

    /**
	 * <p>
	 * It returns the absolute value of the input
	 * </p>
	 * 
	 * @return the absolute value of the input
	 */
	public final static Function<Double, Double> abs() {
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
	public final static Function<Double, Double> add(Number add) {
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
	public final static Function<Double, Double> add(byte add) {
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
	public final static Function<Double, Double> add(short add) {
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
	public final static Function<Double, Double> add(int add) {
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
	public final static Function<Double, Double> add(long add) {
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
	public final static Function<Double, Double> add(float add) {
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
	public final static Function<Double, Double> add(double add) {
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
	public final static Function<Double, Double> subtract(Number subtract) {
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
	public final static Function<Double, Double> subtract(byte subtract) {
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
	public final static Function<Double, Double> subtract(short subtract) {
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
	public final static Function<Double, Double> subtract(int subtract) {
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
	public final static Function<Double, Double> subtract(long subtract) {
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
	public final static Function<Double, Double> subtract(float subtract) {
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
	public final static Function<Double, Double> subtract(double subtract) {
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
	public final static Function<Double, Double> divideBy(Number divisor) {
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
	public final static Function<Double, Double> divideBy(byte divisor) {
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
	public final static Function<Double, Double> divideBy(short divisor) {
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
	public final static Function<Double, Double> divideBy(int divisor) {
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
	public final static Function<Double, Double> divideBy(long divisor) {
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
	public final static Function<Double, Double> divideBy(float divisor) {
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
	public final static Function<Double, Double> divideBy(double divisor) {
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
	public final static Function<Double, Double> divideBy(Number divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(byte divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(short divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(int divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(long divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(float divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(double divisor, MathContext mathContext) {
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
	public final static Function<Double, Double> divideBy(Number divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(byte divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(short divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(int divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(long divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(float divisor, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


    public final static Function<Double, Double> module(int module) {
        return new Module(module);
    }

    /**
	 * <p>
	 * It multiplies target by multiplicand and returns its value
	 * </p>
	 * 
	 * @param multiplicand the multiplicand
	 * @return the result of target * multiplicand
	 */
	public final static Function<Double, Double> multiplyBy(Number multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(byte multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(short multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(int multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(long multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(float multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(double multiplicand) {
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
	public final static Function<Double, Double> multiplyBy(Number multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(byte multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(short multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(int multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(long multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(float multiplicand, MathContext mathContext) {
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
	public final static Function<Double, Double> multiplyBy(double multiplicand, MathContext mathContext) {
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
	 */public final static Function<Double, Double> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(short multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(int multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(long multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(float multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Double, Double> multiplyBy(double multiplicand, RoundingMode roundingMode) {
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
	public final static Function<Double, Double> pow(int power) {
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
	public final static Function<Double, Double> pow(int power, MathContext mathContext) {
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
	public final static Function<Double, Double> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
	
    
    private static Double fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Double.valueOf(number.doubleValue());
    }
	

    
    
    
	
	static final class Max extends AbstractNotNullFunction<Iterable<Double>,Double> {

		Max() {
			super();
		}

		@Override
		protected Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Double max = input.iterator().next();
			for (Double number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Double>,Double> {

		Min() {
			super();
		}

		@Override
		protected Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Double min = input.iterator().next();
			for (Double number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Double>,Double> {

		Sum() {
			super();
		}

		@Override
		protected Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Double number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
				}
			}	
			return Double.valueOf(sum.doubleValue());
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Double>,Double> {

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
		protected Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Double number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).doubleValue());
			}
			if (this.mathContext != null) {
				return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).doubleValue());
			}
			return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).doubleValue());
		}		
	}

	
	
	
	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<Double[],Double> {

        MaxArray() {
            super();
        }

        @Override
        protected Double notNullExecute(final Double[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Double max = input[0];
            for (Double number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }
    }
    
    static final class MinArray extends AbstractNotNullFunction<Double[],Double> {

        MinArray() {
            super();
        }

        @Override
        protected Double notNullExecute(final Double[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Double min = input[0];
            for (Double number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Double[],Double> {

        SumArray() {
            super();
        }

        @Override
        protected Double notNullExecute(final Double[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Double number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
                }
            }   
            return Double.valueOf(sum.doubleValue());
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Double[],Double> {

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
        protected Double notNullExecute(final Double[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Double number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).doubleValue());
            }
            if (this.mathContext != null) {
                return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).doubleValue());
            }
            return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).doubleValue());
        }       
    }
	
	
	
	
	
	
	
	
	
	
	
	static final class Round extends AbstractNullAsNullFunction<Double, Double> {

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
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			if (this.roundingMode != null) {
				return Double.valueOf(BigDecimal.valueOf(input.doubleValue()).setScale(0, this.roundingMode).doubleValue());
			}			
			return Double.valueOf(BigDecimal.valueOf(input.doubleValue()).round(this.mathContext).doubleValue());
		}	
	}
	
	static final class Abs extends AbstractNullAsNullFunction<Double, Double> {

		Abs() {
			super();
		}
		
		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			return Double.valueOf(Math.abs(input.doubleValue()));
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<Double, Double> {

		private final Double add;
		
		Add(Double add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			result = result.add(BigDecimal.valueOf(this.add.doubleValue()));				
			return Double.valueOf(result.doubleValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Double, Double> {

		private final Double subtract;
		
		Subtract(Double subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			result = result.subtract(BigDecimal.valueOf(this.subtract.doubleValue()));			
			return Double.valueOf(result.doubleValue());
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Double, Double> {

		private final Double divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Double divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Double divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Double divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()), RoundingMode.DOWN);	
			}
			return Double.valueOf(result.doubleValue());
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Double, Double> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			return Double.valueOf(input.doubleValue() % this.module);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<Double, Double> {

		private final Double multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Double multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Double multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Double multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.doubleValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.doubleValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.doubleValue()));	
			}
			return Double.valueOf(result.doubleValue());
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Double, Double> {

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
		protected Double nullAsNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Double.valueOf(result.doubleValue());
		}		
	}
}
