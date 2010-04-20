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
public final class FnLong {

	private static final Function<Iterable<Long>, Long> MAX_FUNC = new Max();
	
	private static final Function<Iterable<Long>, Long> MIN_FUNC = new Min();
	
	private static final Function<Iterable<Long>, Long> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<Long>, Long> AVG_FUNC = new Avg();

    private static final Function<Long[], Long> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<Long[], Long> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<Long[], Long> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<Long[], Long> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<Long, Long> ABS_FUNC = new Abs();
	
	
	FnLong() {
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
	public static final Function<Long,String> toStr() {
        return (Function<Long,String>)((Function)FnNumber.toStr());
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
	public static final Function<Long,String> toStr(boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Long,String> toStr(Locale locale) {
        return (Function<Long,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Long,String> toStr(String locale) {
        return (Function<Long,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<Long,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<Long,String> toStr(String locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
	
	/**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Long,String> toCurrencyStr() {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<Long,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<Long,String> toCurrencyStr(Locale locale) {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Long,String> toCurrencyStr(String locale) {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Long,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<Long,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Long,String> toPercentStr() {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr());
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
    public static final Function<Long,String> toPercentStr(boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<Long,String> toPercentStr(Locale locale) {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Long,String> toPercentStr(String locale) {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Long,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Long,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<Long,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Long,Boolean> eq(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Long,Boolean> eq(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Long,Boolean> eqValue(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Long,Boolean> eqValue(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Long,Boolean> notEq(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Long,Boolean> notEq(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Long,Boolean> notEqValue(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Long,Boolean> notEqValue(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Long,Boolean> lessThan(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessThan(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> lessOrEqTo(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterThan(final Number object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final float object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final double object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final byte object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final short object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final int object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterThan(final long object) {    
        return (Function<Long,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> greaterOrEqTo(final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Long,Boolean> eqBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<Long,Boolean> eqBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<Long,Boolean> eqValueBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
    public static final Function<Long,Boolean> eqValueBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
    public static final Function<Long,Boolean> notEqBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<Long,Boolean> notEqBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqBy(by, object));
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
    public static final Function<Long,Boolean> notEqValueBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
    public static final Function<Long,Boolean> notEqValueBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessThanBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> lessOrEqToBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterThanBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final Number object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final float object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final double object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final byte object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final short object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final int object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
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
    public static final Function<Long,Boolean> greaterOrEqToBy(final IFunction<Long,?> by, final long object) {
        return (Function<Long,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Long,Boolean> isNull() {
        return (Function<Long,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Long,Boolean> isNotNull() {
        return (Function<Long,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    /**
	 * <p>
	 * It returns the maximum number from an {@link Iterable} input object
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Iterable<Long>, Long> max() {
        return MAX_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from an {@link Iterable} input object
	 * </p>
	 *
	 * @return the minimum number
	 */
	public final static Function<Iterable<Long>, Long> min() {
        return MIN_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input {@link Iterable}
	 */
	public final static Function<Iterable<Long>, Long> sum() {
        return SUM_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Iterable<Long>, Long> avg() {
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
	public final static Function<Iterable<Long>, Long> avg(MathContext mathContext) {
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
	public final static Function<Iterable<Long>, Long> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    /**
	 * <p>
	 * It returns the maximum number from the input array
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Long[], Long> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from the input array
	 * </p>
	 * 
	 * @return the minimum number
	 */
	public final static Function<Long[], Long> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input array
	 */
	public final static Function<Long[], Long> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Long[], Long> avgArray() {
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
	public final static Function<Long[], Long> avgArray(MathContext mathContext) {
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
	public final static Function<Long[], Long> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    /**
	 * <p>
	 * It returns the absolute value of the input
	 * </p>
	 * 
	 * @return the absolute value of the input
	 */
	public final static Function<Long, Long> abs() {
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
	public final static Function<Long, Long> add(Number add) {
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
	public final static Function<Long, Long> add(byte add) {
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
	public final static Function<Long, Long> add(short add) {
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
	public final static Function<Long, Long> add(int add) {
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
	public final static Function<Long, Long> add(long add) {
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
	public final static Function<Long, Long> add(float add) {
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
	public final static Function<Long, Long> add(double add) {
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
	public final static Function<Long, Long> subtract(Number subtract) {
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
	public final static Function<Long, Long> subtract(byte subtract) {
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
	public final static Function<Long, Long> subtract(short subtract) {
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
	public final static Function<Long, Long> subtract(int subtract) {
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
	public final static Function<Long, Long> subtract(long subtract) {
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
	public final static Function<Long, Long> subtract(float subtract) {
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
	public final static Function<Long, Long> subtract(double subtract) {
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
	public final static Function<Long, Long> divideBy(Number divisor) {
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
	public final static Function<Long, Long> divideBy(byte divisor) {
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
	public final static Function<Long, Long> divideBy(short divisor) {
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
	public final static Function<Long, Long> divideBy(int divisor) {
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
	public final static Function<Long, Long> divideBy(long divisor) {
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
	public final static Function<Long, Long> divideBy(float divisor) {
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
	public final static Function<Long, Long> divideBy(double divisor) {
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
	public final static Function<Long, Long> divideBy(Number divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(byte divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(short divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(int divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(long divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(float divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(double divisor, MathContext mathContext) {
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
	public final static Function<Long, Long> divideBy(Number divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(byte divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(short divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(int divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(long divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(float divisor, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


	/**
     * <p>
     * It performs a module operation and returns the value
     * of (input mod module) which is always positive 
     * (whereas remainder is not)
     * </p>
     * 
     * @param module the module
     * @return the result of (input mod module)
     */
    public final static Function<Long, Long> module(int module) {
        return new Module(module);
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
    public final static Function<Long, Long> remainder(Number divisor) {
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
    public final static Function<Long, Long> remainder(byte divisor) {
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
    public final static Function<Long, Long> remainder(short divisor) {
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
    public final static Function<Long, Long> remainder(int divisor) {
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
    public final static Function<Long, Long> remainder(long divisor) {
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
    public final static Function<Long, Long> remainder(float divisor) {
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
    public final static Function<Long, Long> remainder(double divisor) {
        return remainder(Double.valueOf(divisor));
    }
        
    /**
	 * <p>
	 * It multiplies target by multiplicand and returns its value
	 * </p>
	 * 
	 * @param multiplicand the multiplicand
	 * @return the result of target * multiplicand
	 */
	public final static Function<Long, Long> multiplyBy(Number multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(byte multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(short multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(int multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(long multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(float multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(double multiplicand) {
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
	public final static Function<Long, Long> multiplyBy(Number multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(byte multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(short multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(int multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(long multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(float multiplicand, MathContext mathContext) {
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
	public final static Function<Long, Long> multiplyBy(double multiplicand, MathContext mathContext) {
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
	 */public final static Function<Long, Long> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(short multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(int multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(long multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(float multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Long, Long> multiplyBy(double multiplicand, RoundingMode roundingMode) {
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
	public final static Function<Long, Long> pow(int power) {
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
	public final static Function<Long, Long> pow(int power, MathContext mathContext) {
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
	public final static Function<Long, Long> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
	
	
    
    private static Long fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Long.valueOf(number.longValue());
    }
    
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<Long>,Long> {

		Max() {
			super();
		}

		@Override
		protected Long notNullExecute(final Iterable<Long> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Long max = input.iterator().next();
			for (Long number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}	
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Long>,Long> {

		Min() {
			super();
		}

		@Override
		protected Long notNullExecute(final Iterable<Long> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Long min = input.iterator().next();
			for (Long number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Long>,Long> {

		Sum() {
			super();
		}

		@Override
		protected Long notNullExecute(final Iterable<Long> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Long number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.longValue()));
				}
			}	
			return Long.valueOf(sum.longValue());
		}	
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Long>,Long> {

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
		protected Long notNullExecute(final Iterable<Long> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Long number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.longValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).longValue());
			}
			if (this.mathContext != null) {
				return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).longValue());
			}
			return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).longValue());
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<Long[],Long> {

        MaxArray() {
            super();
        }

        @Override
        protected Long notNullExecute(final Long[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Long max = input[0];
            for (Long number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }   
    }
    
    static final class MinArray extends AbstractNotNullFunction<Long[],Long> {

        MinArray() {
            super();
        }

        @Override
        protected Long notNullExecute(final Long[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Long min = input[0];
            for (Long number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Long[],Long> {

        SumArray() {
            super();
        }

        @Override
        protected Long notNullExecute(final Long[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Long number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.longValue()));
                }
            }   
            return Long.valueOf(sum.longValue());
        }   
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Long[],Long> {

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
        protected Long notNullExecute(final Long[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Long number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.longValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).longValue());
            }
            if (this.mathContext != null) {
                return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).longValue());
            }
            return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).longValue());
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<Long, Long> {

		Abs() {
			super();
		}
		
		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			return Long.valueOf(Math.abs(input.longValue()));
		}		
	}
	
	static final class Add extends AbstractNullAsNullFunction<Long, Long> {

		private final Long add;
		
		Add(Long add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.longValue());
			result = result.add(BigDecimal.valueOf(this.add.longValue()));
				
			return Long.valueOf(result.longValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Long, Long> {

		private final Long subtract;
		
		Subtract(Long subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.longValue());
			result = result.subtract(BigDecimal.valueOf(this.subtract.longValue()));
				
			return Long.valueOf(result.longValue());
		}	
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Long, Long> {

		private final Long divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Long divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Long divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Long divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.longValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.longValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.longValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.longValue()), RoundingMode.DOWN);	
			}
			return Long.valueOf(result.longValue());
		}	
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Long, Long> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
		    return Long.valueOf(BigInteger.valueOf(input.longValue())
                    .mod(BigInteger.valueOf(this.module)).longValue());
		}		
	}
	
	static final class Remainder extends AbstractNullAsNullFunction<Long, Long> {

        private final Long divisor;
        
        Remainder(Long divisor) {
            super();
            this.divisor = divisor;
        }
        
        @Override
        protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
            return Long.valueOf(BigInteger.valueOf(input.longValue())
                    .remainder(BigInteger.valueOf(this.divisor.longValue())).longValue());
        }   
    }
	
	static final class Multiply extends AbstractNullAsNullFunction<Long, Long> {

		private final Long multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Long multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Long multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Long multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.longValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.longValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.longValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.longValue()));	
			}
			return Long.valueOf(result.longValue());
		}		
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Long, Long> {

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
		protected Long nullAsNullExecute(final Long input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.longValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Long.valueOf(result.longValue());
		}	
	}
}
