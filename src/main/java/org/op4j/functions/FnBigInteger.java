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
public final class FnBigInteger {

	private static final Function<Iterable<BigInteger>, BigInteger> MAX_FUNC = new Max();
	
	private static final Function<Iterable<BigInteger>, BigInteger> MIN_FUNC = new Min();
	
	private static final Function<Iterable<BigInteger>, BigInteger> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<BigInteger>, BigInteger> AVG_FUNC = new Avg();

    private static final Function<BigInteger[], BigInteger> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<BigInteger[], BigInteger> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<BigInteger[], BigInteger> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<BigInteger[], BigInteger> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<BigInteger, BigInteger> ABS_FUNC = new Abs();
	
	
	FnBigInteger() {
		super();           
	}

	
	// From FnNumber
	/**
     * <p>
     * It returns the {@link String} representation of the input number
     * </p>
     *
     * @return the {@link String} representation of the input
     */
	public static final Function<BigInteger,String> toStr() {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr());
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
	public static final Function<BigInteger,String> toStr(boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<BigInteger,String> toStr(Locale locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<BigInteger,String> toStr(String locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<BigInteger,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<BigInteger,String> toStr(String locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
	
	/**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<BigInteger,String> toCurrencyStr() {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<BigInteger,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<BigInteger,String> toCurrencyStr(Locale locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<BigInteger,String> toCurrencyStr(String locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<BigInteger,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<BigInteger,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<BigInteger,String> toPercentStr() {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr());
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
    public static final Function<BigInteger,String> toPercentStr(boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<BigInteger,String> toPercentStr(Locale locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<BigInteger,String> toPercentStr(String locale) {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<BigInteger,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<BigInteger,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<BigInteger,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<BigInteger,Boolean> eq(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<BigInteger,Boolean> eqValue(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<BigInteger,Boolean> notEq(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<BigInteger,Boolean> notEqValue(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessThan(final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> lessOrEqTo(final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final Number object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final float object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final double object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final byte object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final short object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final int object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterThan(final long object) {    
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqTo(final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<BigInteger,Boolean> eqBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<BigInteger,Boolean> eqValueBy(final IFunction<BigInteger,?> by, final Number object) {
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
    public static final Function<BigInteger,Boolean> notEqBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<BigInteger,Boolean> notEqValueBy(final IFunction<BigInteger,?> by, final Number object) {
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessThanBy(final IFunction<BigInteger,?> by, final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> lessOrEqToBy(final IFunction<BigInteger,?> by, final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterThanBy(final IFunction<BigInteger,?> by, final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final Number object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final float object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final double object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final byte object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final short object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final int object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<BigInteger,Boolean> greaterOrEqToBy(final IFunction<BigInteger,?> by, final long object) {
        return (Function<BigInteger,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<BigInteger,Boolean> isNull() {
        return (Function<BigInteger,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<BigInteger,Boolean> isNotNull() {
        return (Function<BigInteger,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
	
	
	
	
	
	
	
    /**
	 * <p>
	 * It returns the maximum number from an {@link Iterable} input object
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Iterable<BigInteger>, BigInteger> max() {
        return MAX_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from an {@link Iterable} input object
	 * </p>
	 *
	 * @return the minimum number
	 */
	public final static Function<Iterable<BigInteger>, BigInteger> min() {
        return MIN_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input {@link Iterable}
	 */
	public final static Function<Iterable<BigInteger>, BigInteger> sum() {
        return SUM_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Iterable<BigInteger>, BigInteger> avg() {
        return AVG_FUNC;
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
	public final static Function<Iterable<BigInteger>, BigInteger> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
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
	public final static Function<Iterable<BigInteger>, BigInteger> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    /**
	 * <p>
	 * It returns the maximum number from the input array
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<BigInteger[], BigInteger> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from the input array
	 * </p>
	 * 
	 * @return the minimum number
	 */
	public final static Function<BigInteger[], BigInteger> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input array
	 */
	public final static Function<BigInteger[], BigInteger> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<BigInteger[], BigInteger> avgArray() {
        return AVG_ARRAY_FUNC;
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
	public final static Function<BigInteger[], BigInteger> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
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
	public final static Function<BigInteger[], BigInteger> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    /**
	 * <p>
	 * It returns the absolute value of the input
	 * </p>
	 * 
	 * @return the absolute value of the input
	 */
	public final static Function<BigInteger, BigInteger> abs() {
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
	public final static Function<BigInteger, BigInteger> add(Number add) {
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
	public final static Function<BigInteger, BigInteger> add(byte add) {
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
	public final static Function<BigInteger, BigInteger> add(short add) {
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
	public final static Function<BigInteger, BigInteger> add(int add) {
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
	public final static Function<BigInteger, BigInteger> add(long add) {
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
	public final static Function<BigInteger, BigInteger> add(float add) {
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
	public final static Function<BigInteger, BigInteger> add(double add) {
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
	public final static Function<BigInteger, BigInteger> subtract(Number subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(byte subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(short subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(int subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(long subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(float subtract) {
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
	public final static Function<BigInteger, BigInteger> subtract(double subtract) {
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
	public final static Function<BigInteger, BigInteger> divideBy(Number divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(byte divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(short divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(int divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(long divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(float divisor) {
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
	public final static Function<BigInteger, BigInteger> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final static Function<BigInteger, BigInteger> module(Number module) {
        return new Module(fromNumber(module));
    }

    public final static Function<BigInteger, BigInteger> remainder(Number module) {
        return new Remainder(fromNumber(module));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final static Function<BigInteger, BigInteger> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final static Function<BigInteger, BigInteger> pow(int power) {
        return new Pow(power);
    }	
	
	
	
	
	
	
    
    private static BigInteger fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).toBigInteger();
        }
        if (number instanceof BigInteger) {
            return (BigInteger)number;
        }
        return (BigDecimal.valueOf(number.doubleValue())).toBigInteger();
    }
	
	
	
	
    
    
	static final class Max extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Max() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger max = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Min() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger min = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Sum() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			BigInteger sum = BigInteger.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

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
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(new BigDecimal(number));
					countNotNull++;
				}
			}
            if (this.roundingMode != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).setScale(0,this.roundingMode).toBigInteger();
            }
            if (this.mathContext != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).setScale(0,this.mathContext.getRoundingMode()).toBigInteger();
            }
			return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).setScale(0, RoundingMode.DOWN).toBigInteger();
		}		
	}

	
	
	
	
	
	
	
	
    
    static final class MaxArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        MaxArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigInteger max = input[0];
            for (BigInteger number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }
    }
    
    static final class MinArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        MinArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigInteger min = input[0];
            for (BigInteger number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

        SumArray() {
            super();
        }

        @Override
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            BigInteger sum = BigInteger.valueOf(0);
            for (BigInteger number : input) {
                if (number != null) {
                    sum = sum.add(number);
                }
            }   
            return sum;
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<BigInteger[],BigInteger> {

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
        protected BigInteger notNullExecute(final BigInteger[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (BigInteger number : input) {
                if (number != null) {
                    sum = sum.add(new BigDecimal(number));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).setScale(0,this.roundingMode).toBigInteger();
            }
            if (this.mathContext != null) {
                return sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).setScale(0,this.mathContext.getRoundingMode()).toBigInteger();
            }
            return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).setScale(0, RoundingMode.DOWN).toBigInteger();
        }       
    }
	
	
	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		Abs() {
			super();
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger add;
		
		Add(BigInteger add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger subtract;
		
		Subtract(BigInteger subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

        private final BigInteger divisor;
        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        Divide(BigInteger divisor) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            this.divisor = divisor;
            this.roundingMode = null;
            this.mathContext = null;
        }
        
        Divide(BigInteger divisor, RoundingMode roundingMode) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.divisor = divisor;
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        Divide(BigInteger divisor, MathContext mathContext) {
            super();
            Validate.notNull(divisor, "Divisor can't be null");
            Validate.notNull(mathContext, "MathContext can't be null");
            this.divisor = divisor;
            this.roundingMode = null;
            this.mathContext = mathContext;
        }
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
            BigDecimal bigInput = new BigDecimal(input);
            
            if (this.roundingMode != null) {
                return bigInput.divide(new BigDecimal(this.divisor), this.roundingMode).setScale(0, this.roundingMode).toBigInteger();                    
            } else if (this.mathContext != null) {
                return bigInput.divide(new BigDecimal(this.divisor), this.mathContext).setScale(0, this.mathContext.getRoundingMode()).toBigInteger();             
            } else {
                return bigInput.divide(new BigDecimal(this.divisor), RoundingMode.DOWN).setScale(0, RoundingMode.DOWN).toBigInteger();   
            }

		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger module;
		
		Module(BigInteger module) {
			super();
			this.module = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.mod(this.module);
		}	
	}
	
	static final class Remainder extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger divisor;
		
		Remainder(BigInteger module) {
			super();
			this.divisor = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger multiplicand;
		
		Multiply(BigInteger multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.multiply(this.multiplicand);			
			return result;
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final int power;
		
		Pow(int power) {
			super();
			this.power = power;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.pow(this.power);			
			return result;
		}		
	}
}
