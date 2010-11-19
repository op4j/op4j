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
public final class FnInteger {

	private static final Function<Iterable<Integer>, Integer> MAX_FUNC = new Max();
	
	private static final Function<Iterable<Integer>, Integer> MIN_FUNC = new Min();
	
	private static final Function<Iterable<Integer>, Integer> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<Integer>, Integer> AVG_FUNC = new Avg();

    private static final Function<Integer[], Integer> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<Integer[], Integer> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<Integer[], Integer> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<Integer[], Integer> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<Integer, Integer> ABS_FUNC = new Abs();
	
	
	FnInteger() {
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
	public static final Function<Integer,String> toStr() {
        return (Function<Integer,String>)((Function)FnNumber.toStr());
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
	public static final Function<Integer,String> toStr(boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Integer,String> toStr(Locale locale) {
        return (Function<Integer,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Integer,String> toStr(String locale) {
        return (Function<Integer,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<Integer,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<Integer,String> toStr(String locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
	
	/**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Integer,String> toCurrencyStr() {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<Integer,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<Integer,String> toCurrencyStr(Locale locale) {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Integer,String> toCurrencyStr(String locale) {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Integer,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<Integer,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Integer,String> toPercentStr() {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr());
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
    public static final Function<Integer,String> toPercentStr(boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<Integer,String> toPercentStr(Locale locale) {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Integer,String> toPercentStr(String locale) {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Integer,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Integer,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<Integer,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link Integer} to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Integer,Boolean> eq(final Integer object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Integer,Boolean> eq(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Integer,Boolean> eqValue(final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Integer,Boolean> eqValue(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqValue(object));
    }
    
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link Integer} to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Integer,Boolean> notEq(final Integer object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Integer,Boolean> notEq(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Integer,Boolean> notEqValue(final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Integer,Boolean> notEqValue(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Integer,Boolean> lessThan(final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThan(final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThan(final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThan(final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThan(final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Integer,Boolean> lessThan(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThan(final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Integer,Boolean> lessOrEqTo(final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqTo(final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqTo(final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqTo(final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqTo(final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Integer,Boolean> lessOrEqTo(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqTo(final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Integer,Boolean> greaterThan(final Number object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThan(final float object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThan(final double object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThan(final byte object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThan(final short object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Integer,Boolean> greaterThan(final int object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThan(final long object) {    
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThan(object));
    }    
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Integer,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqTo(final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqTo(final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqTo(final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqTo(final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     */
    public static final Function<Integer,Boolean> greaterOrEqTo(final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    

    /**
     * <p>
     * Determines whether the target object is greater or equal to the specified object
     * in value, this is, whether <tt>target.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if target is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqTo(final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
     * 
     * @since 1.1
     */
    public static final Function<Integer,Boolean> eqBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> eqBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> eqBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqBy(by, object));
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
     * 
     * @since 1.1
     */
    public static final Function<Integer,Boolean> eqValueBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> eqValueBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> eqValueBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Integer,Boolean> notEqBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> notEqBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> notEqBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Integer,Boolean> notEqValueBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> notEqValueBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> notEqValueBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessThanBy(final IFunction<Integer,?> by, final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> lessOrEqToBy(final IFunction<Integer,?> by, final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterThanBy(final IFunction<Integer,?> by, final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    
    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @since 1.1
     */
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final Object object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    
    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final Number object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final float object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final double object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final byte object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final short object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final int object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    

    /**
     * <p>
     * Determines whether the result of executing the specified function
     * on the target object is greater or equal to the specified object parameter
     * in value, this is, whether <tt>functionResult.compareTo(object) &gt;= 0</tt>. Both
     * the target and the specified object have to implement {@link Comparable}.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if function result is greater or equal to the specified object, false if not
     * 
     * @deprecated use {@link FnNumber} or {@link FnObject} instead. This class will be removed in version 1.2
     */
    @Deprecated
    public static final Function<Integer,Boolean> greaterOrEqToBy(final IFunction<Integer,?> by, final long object) {
        return (Function<Integer,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Integer,Boolean> isNull() {
        return (Function<Integer,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Integer,Boolean> isNotNull() {
        return (Function<Integer,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    /**
	 * <p>
	 * It returns the maximum number from an {@link Iterable} input object
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Iterable<Integer>, Integer> max() {
        return MAX_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from an {@link Iterable} input object
	 * </p>
	 *
	 * @return the minimum number
	 */
	public final static Function<Iterable<Integer>, Integer> min() {
        return MIN_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input {@link Iterable}
	 */
	public final static Function<Iterable<Integer>, Integer> sum() {
        return SUM_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Iterable<Integer>, Integer> avg() {
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
	public final static Function<Iterable<Integer>, Integer> avg(MathContext mathContext) {
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
	public final static Function<Iterable<Integer>, Integer> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    /**
	 * <p>
	 * It returns the maximum number from the input array
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Integer[], Integer> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from the input array
	 * </p>
	 * 
	 * @return the minimum number
	 */
	public final static Function<Integer[], Integer> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input array
	 */
	public final static Function<Integer[], Integer> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Integer[], Integer> avgArray() {
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
	public final static Function<Integer[], Integer> avgArray(MathContext mathContext) {
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
	public final static Function<Integer[], Integer> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    /**
	 * <p>
	 * It returns the absolute value of the input
	 * </p>
	 * 
	 * @return the absolute value of the input
	 */
	public final static Function<Integer, Integer> abs() {
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
	public final static Function<Integer, Integer> add(Number add) {
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
	public final static Function<Integer, Integer> add(byte add) {
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
	public final static Function<Integer, Integer> add(short add) {
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
	public final static Function<Integer, Integer> add(int add) {
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
	public final static Function<Integer, Integer> add(long add) {
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
	public final static Function<Integer, Integer> add(float add) {
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
	public final static Function<Integer, Integer> add(double add) {
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
	public final static Function<Integer, Integer> subtract(Number subtract) {
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
	public final static Function<Integer, Integer> subtract(byte subtract) {
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
	public final static Function<Integer, Integer> subtract(short subtract) {
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
	public final static Function<Integer, Integer> subtract(int subtract) {
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
	public final static Function<Integer, Integer> subtract(long subtract) {
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
	public final static Function<Integer, Integer> subtract(float subtract) {
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
	public final static Function<Integer, Integer> subtract(double subtract) {
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
	public final static Function<Integer, Integer> divideBy(Number divisor) {
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
	public final static Function<Integer, Integer> divideBy(byte divisor) {
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
	public final static Function<Integer, Integer> divideBy(short divisor) {
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
	public final static Function<Integer, Integer> divideBy(int divisor) {
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
	public final static Function<Integer, Integer> divideBy(long divisor) {
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
	public final static Function<Integer, Integer> divideBy(float divisor) {
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
	public final static Function<Integer, Integer> divideBy(double divisor) {
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
	public final static Function<Integer, Integer> divideBy(Number divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(byte divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(short divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(int divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(long divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(float divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(double divisor, MathContext mathContext) {
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
	public final static Function<Integer, Integer> divideBy(Number divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(byte divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(short divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(int divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(long divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(float divisor, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> divideBy(double divisor, RoundingMode roundingMode) {
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
    public final static Function<Integer, Integer> module(byte module) {
        return new Module(BigInteger.valueOf(Byte.valueOf(module).longValue()));
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
    public final static Function<Integer, Integer> module(short module) {
        return new Module(BigInteger.valueOf(Short.valueOf(module).longValue()));
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
    public final static Function<Integer, Integer> module(int module) {
        return new Module(BigInteger.valueOf(Integer.valueOf(module).longValue()));
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
    public final static Function<Integer, Integer> module(long module) {
        return new Module(BigInteger.valueOf(Long.valueOf(module).longValue()));
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
    public final static Function<Integer, Integer> module(Byte module) {
        return new Module(BigInteger.valueOf(module.longValue()));
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
    public final static Function<Integer, Integer> module(Short module) {
        return new Module(BigInteger.valueOf(module.longValue()));
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
    public final static Function<Integer, Integer> module(Integer module) {
        return new Module(BigInteger.valueOf(module.longValue()));
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
    public final static Function<Integer, Integer> module(Long module) {
        return new Module(BigInteger.valueOf(module.longValue()));
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
    public final static Function<Integer, Integer> module(BigInteger module) {
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
    public final static Function<Integer, Integer> remainder(Number divisor) {
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
    public final static Function<Integer, Integer> remainder(byte divisor) {
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
    public final static Function<Integer, Integer> remainder(short divisor) {
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
    public final static Function<Integer, Integer> remainder(int divisor) {
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
    public final static Function<Integer, Integer> remainder(long divisor) {
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
    public final static Function<Integer, Integer> remainder(float divisor) {
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
    public final static Function<Integer, Integer> remainder(double divisor) {
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
	public final static Function<Integer, Integer> multiplyBy(Number multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(byte multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(short multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(int multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(long multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(float multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(double multiplicand) {
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
	public final static Function<Integer, Integer> multiplyBy(Number multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(byte multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(short multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(int multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(long multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(float multiplicand, MathContext mathContext) {
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
	public final static Function<Integer, Integer> multiplyBy(double multiplicand, MathContext mathContext) {
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
	 */public final static Function<Integer, Integer> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(short multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(int multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(long multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(float multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Integer, Integer> multiplyBy(double multiplicand, RoundingMode roundingMode) {
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
	public final static Function<Integer, Integer> pow(int power) {
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
	public final static Function<Integer, Integer> pow(int power, MathContext mathContext) {
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
	public final static Function<Integer, Integer> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	/**
     * <p>
     * Determines whether the target object is between min and max
     * in value, this is, whether 
     * <tt>target.compareTo(min) &gt;= 0 &amp;&amp; target.compareTo(max) &lt;= 0</tt>. 
     * The target and the specified min and max have to implement {@link Comparable}.
     * </p>
     * 
     * @param min the minimum value of the target
     * @param max the maximum value of the target
     * @return true if the target is between min and max (or it's equal to any of them)
     */
    public static final Function<Integer,Boolean> between(final Number min, final Number max) {
        return (Function<Integer,Boolean>)((Function)FnObject.between(min, max));
    }
    
    /**
     * <p>
     * Determines whether the target object is between min and max
     * in value, this is, whether 
     * <tt>target.compareTo(min) &gt;= 0 &amp;&amp; target.compareTo(max) &lt;= 0</tt>. 
     * The target and the specified min and max have to implement {@link Comparable}.
     * </p>
     * 
     * @param min the minimum value of the target
     * @param max the maximum value of the target
     * @return true if the target is between min and max (or it's equal to any of them)
     */
    public static final Function<Integer,Boolean> between(final int min, final int max) {
        return (Function<Integer,Boolean>)((Function)FnObject.between(min, max));
    }
    
	

    
    private static Integer fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Integer.valueOf(number.intValue());
    }
	
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Max() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Integer max = input.iterator().next();
			for (Integer number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}		
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Min() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Integer min = input.iterator().next();
			for (Integer number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

		Sum() {
			super();
		}

		@Override
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Integer number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
				}
			}	
			return Integer.valueOf(sum.intValue());
		}	
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Integer>,Integer> {

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
		protected Integer notNullExecute(final Iterable<Integer> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Integer number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).intValue());
			}
			if (this.mathContext != null) {
				return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).intValue());
			}
			return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).intValue());
		}	
	}
	

	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<Integer[],Integer> {

        MaxArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Integer max = input[0];
            for (Integer number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }       
    }
    
    static final class MinArray extends AbstractNotNullFunction<Integer[],Integer> {

        MinArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Integer min = input[0];
            for (Integer number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Integer[],Integer> {

        SumArray() {
            super();
        }

        @Override
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Integer number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.intValue()));
                }
            }   
            return Integer.valueOf(sum.intValue());
        }   
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Integer[],Integer> {

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
        protected Integer notNullExecute(final Integer[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Integer number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.intValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).intValue());
            }
            if (this.mathContext != null) {
                return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).intValue());
            }
            return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).intValue());
        }   
    }
	

	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<Integer, Integer> {

		Abs() {
			super();
		}
		
		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			return Integer.valueOf(Math.abs(input.intValue()));
		}	
	}
	
	static final class Add extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer add;
		
		Add(Integer add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			result = result.add(BigDecimal.valueOf(this.add.intValue()));
				
			return Integer.valueOf(result.intValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer subtract;
		
		Subtract(Integer subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			result = result.subtract(BigDecimal.valueOf(this.subtract.intValue()));
				
			return Integer.valueOf(result.intValue());
		}	
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Integer divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Integer divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Integer divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()), RoundingMode.DOWN);	
			}
			return Integer.valueOf(result.intValue());
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Integer, Integer> {

        private final BigInteger module;
        
        Module(BigInteger module) {
            super();
            this.module = module;
        }
        
        @Override
        protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
            return Integer.valueOf(BigInteger.valueOf(input.longValue())
                    .mod(this.module).intValue());
        }   
    }
	
	static final class Remainder extends AbstractNullAsNullFunction<Integer, Integer> {

        private final Integer divisor;
        
        Remainder(Integer divisor) {
            super();
            this.divisor = divisor;
        }
        
        @Override
        protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
            return Integer.valueOf(BigInteger.valueOf(input.longValue())
                    .remainder(BigInteger.valueOf(this.divisor.longValue())).intValue());
        }   
    }
	
	static final class Multiply extends AbstractNullAsNullFunction<Integer, Integer> {

		private final Integer multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Integer multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Integer multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Integer multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()));	
			}
			return Integer.valueOf(result.intValue());
		}
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Integer, Integer> {

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
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Integer.valueOf(result.intValue());
		}	
	}
}
