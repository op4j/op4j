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
public final class FnFloat {

	private static final Function<Iterable<Float>, Float> MAX_FUNC = new Max();
	
	private static final Function<Iterable<Float>, Float> MIN_FUNC = new Min();
	
	private static final Function<Iterable<Float>, Float> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<Float>, Float> AVG_FUNC = new Avg();

    private static final Function<Float[], Float> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<Float[], Float> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<Float[], Float> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<Float[], Float> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<Float, Float> ABS_FUNC = new Abs();
	
	
	FnFloat() {
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
	public static final Function<Float,String> toStr() {
	    return (Function<Float,String>)((Function)FnNumber.toStr());
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
	public static final Function<Float,String> toStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given {@link Locale}  
	 * </p>
	 * 
	 * @param locale the {@link Locale} to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Float,String> toStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale));
    }
    /**
	 * <p>
	 * It returns the {@link String} representation of the target number in the given locale  
	 * </p>
	 * 
	 * @param locale the locale to be used
	 * @return the {@link String} representation of the input
	 */
	public static final Function<Float,String> toStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale));
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
	public static final Function<Float,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale, groupingUsed));
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
	public static final Function<Float,String> toStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
	
	/**
     * <p>
     * It returns the {@link String} representation of the target as a currency in the
     * default {@link Locale}
     * </p>
     * 
     * @return the {@link String} representation of the input as a currency
     */
    public static final Function<Float,String> toCurrencyStr() {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr());
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
    public static final Function<Float,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
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
    public static final Function<Float,String> toCurrencyStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Float,String> toCurrencyStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale));
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
    public static final Function<Float,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
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
    public static final Function<Float,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    
    /**
     * <p>
     * A {@link String} representing a percentage is created from the target number.
     * </p>
     * 
     * @return the string representation of the input number as a percentage
     */
    public static final Function<Float,String> toPercentStr() {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr());
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
    public static final Function<Float,String> toPercentStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(groupingUsed));
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
    public static final Function<Float,String> toPercentStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Float,String> toPercentStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale));
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
    public static final Function<Float,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
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
    public static final Function<Float,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link Float} to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Float,Boolean> eq(final Float object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Float,Boolean> eq(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
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
    public static final Function<Float,Boolean> eqValue(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqValue(object));
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
    public static final Function<Float,Boolean> eqValue(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqValue(object));
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the {@link Float} to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Float,Boolean> notEq(final Float object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Float,Boolean> notEq(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
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
    public static final Function<Float,Boolean> notEqValue(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Float,Boolean> notEqValue(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqValue(object));
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
    public static final Function<Float,Boolean> lessThan(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Float,Boolean> lessThan(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
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
    public static final Function<Float,Boolean> lessOrEqTo(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Float,Boolean> lessOrEqTo(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
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
    public static final Function<Float,Boolean> greaterThan(final Number object) {    
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Float,Boolean> greaterThan(final float object) {    
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
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
    public static final Function<Float,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Float,Boolean> greaterOrEqTo(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
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
    public static final Function<Float,Boolean> eqBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
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
    public static final Function<Float,Boolean> eqValueBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqValueBy(by, object));
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
     * 
     * @since 1.1
     */
    public static final Function<Float,Boolean> notEqBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
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
     * 
     * @since 1.1
     */
    public static final Function<Float,Boolean> notEqValueBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqValueBy(by, object));
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
     * 
     * @since 1.1
     */
    public static final Function<Float,Boolean> lessThanBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
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
     * 
     * @since 1.1
     */
    public static final Function<Float,Boolean> lessOrEqToBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
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
     * @since 1.1
     */
    public static final Function<Float,Boolean> greaterThanBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
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
    public static final Function<Float,Boolean> greaterOrEqToBy(final IFunction<Float,?> by, final Object object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    } 
    
    

    



    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return true if the target object is null, false if not.
     */
    public static final Function<Float,Boolean> isNull() {
        return (Function<Float,Boolean>)((Function)FnObject.isNull());
    }
    
    

    /**
     * <p>
     * Determines whether the target object is null or not.
     * </p>
     * 
     * @return false if the target object is null, true if not.
     */
    public static final Function<Float,Boolean> isNotNull() {
        return (Function<Float,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    /**
	 * <p>
	 * It returns the maximum number from an {@link Iterable} input object
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Iterable<Float>, Float> max() {
        return MAX_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from an {@link Iterable} input object
	 * </p>
	 *
	 * @return the minimum number
	 */
	public final static Function<Iterable<Float>, Float> min() {
        return MIN_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input {@link Iterable}
	 */
	public final static Function<Iterable<Float>, Float> sum() {
        return SUM_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the {@link Iterable} input object
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Iterable<Float>, Float> avg() {
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
	public final static Function<Iterable<Float>, Float> avg(MathContext mathContext) {
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
	public final static Function<Iterable<Float>, Float> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    /**
	 * <p>
	 * It returns the maximum number from the input array
	 * </p>
	 * 
	 * @return the maximum number
	 */
	public final static Function<Float[], Float> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the minimum number from the input array
	 * </p>
	 * 
	 * @return the minimum number
	 */
	public final static Function<Float[], Float> minArray() {
        return MIN_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the sum of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number equal to the sum of all the elements in the input array
	 */
	public final static Function<Float[], Float> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    /**
	 * <p>
	 * It returns the average of all the numbers in the input array
	 * </p>
	 * 
	 * @return a number representing the average of the input numbers
	 */
	public final static Function<Float[], Float> avgArray() {
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
	public final static Function<Float[], Float> avgArray(MathContext mathContext) {
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
	public final static Function<Float[], Float> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    /**
	 * <p>
	 * It returns the absolute value of the input
	 * </p>
	 * 
	 * @return the absolute value of the input
	 */
	public final static Function<Float, Float> abs() {
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
	public final static Function<Float, Float> add(Number add) {
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
	public final static Function<Float, Float> add(byte add) {
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
	public final static Function<Float, Float> add(short add) {
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
	public final static Function<Float, Float> add(int add) {
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
	public final static Function<Float, Float> add(long add) {
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
	public final static Function<Float, Float> add(float add) {
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
	public final static Function<Float, Float> add(double add) {
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
	public final static Function<Float, Float> subtract(Number subtract) {
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
	public final static Function<Float, Float> subtract(byte subtract) {
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
	public final static Function<Float, Float> subtract(short subtract) {
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
	public final static Function<Float, Float> subtract(int subtract) {
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
	public final static Function<Float, Float> subtract(long subtract) {
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
	public final static Function<Float, Float> subtract(float subtract) {
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
	public final static Function<Float, Float> subtract(double subtract) {
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
	public final static Function<Float, Float> divideBy(Number divisor) {
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
	public final static Function<Float, Float> divideBy(byte divisor) {
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
	public final static Function<Float, Float> divideBy(short divisor) {
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
	public final static Function<Float, Float> divideBy(int divisor) {
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
	public final static Function<Float, Float> divideBy(long divisor) {
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
	public final static Function<Float, Float> divideBy(float divisor) {
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
	public final static Function<Float, Float> divideBy(double divisor) {
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
	public final static Function<Float, Float> divideBy(Number divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(byte divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(short divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(int divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(long divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(float divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(double divisor, MathContext mathContext) {
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
	public final static Function<Float, Float> divideBy(Number divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(byte divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(short divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(int divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(long divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(float divisor, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> divideBy(double divisor, RoundingMode roundingMode) {
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
    public final static Function<Float, Float> remainder(Number divisor) {
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
    public final static Function<Float, Float> remainder(byte divisor) {
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
    public final static Function<Float, Float> remainder(short divisor) {
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
    public final static Function<Float, Float> remainder(int divisor) {
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
    public final static Function<Float, Float> remainder(long divisor) {
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
    public final static Function<Float, Float> remainder(float divisor) {
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
    public final static Function<Float, Float> remainder(double divisor) {
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
	public final static Function<Float, Float> multiplyBy(Number multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(byte multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(short multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(int multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(long multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(float multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(double multiplicand) {
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
	public final static Function<Float, Float> multiplyBy(Number multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(byte multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(short multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(int multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(long multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(float multiplicand, MathContext mathContext) {
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
	public final static Function<Float, Float> multiplyBy(double multiplicand, MathContext mathContext) {
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
	 */public final static Function<Float, Float> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(short multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(int multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(long multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(float multiplicand, RoundingMode roundingMode) {
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
	 */public final static Function<Float, Float> multiplyBy(double multiplicand, RoundingMode roundingMode) {
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
	public final static Function<Float, Float> pow(int power) {
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
	public final static Function<Float, Float> pow(int power, MathContext mathContext) {
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
	public final static Function<Float, Float> pow(int power, RoundingMode roundingMode) {
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
    public static final Function<Float,Boolean> between(final Number min, final Number max) {
        return (Function<Float,Boolean>)((Function)FnObject.between(min, max));
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
    public static final Function<Float,Boolean> between(final float min, final float max) {
        return (Function<Float,Boolean>)((Function)FnObject.between(min, max));
    }
    
    
    
    
    private static Float fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Float.valueOf(number.floatValue());
    }

	
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<Float>,Float> {

		Max() {
			super();
		}

		@Override
		protected Float notNullExecute(final Iterable<Float> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Float max = input.iterator().next();
			for (Float number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Float>,Float> {

		Min() {
			super();
		}

		@Override
		protected Float notNullExecute(final Iterable<Float> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Float min = input.iterator().next();
			for (Float number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Float>,Float> {

		Sum() {
			super();
		}

		@Override
		protected Float notNullExecute(final Iterable<Float> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Float number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.floatValue()));
				}
			}	
			return Float.valueOf(sum.floatValue());
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Float>,Float> {

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
		protected Float notNullExecute(final Iterable<Float> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Float number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.floatValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).floatValue());
			}
			if (this.mathContext != null) {
				return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).floatValue());
			}
			return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).floatValue());
		}		
	}

	
	
	
	
	
	
	
	
	
	
    
    
    
    static final class MaxArray extends AbstractNotNullFunction<Float[],Float> {

        MaxArray() {
            super();
        }

        @Override
        protected Float notNullExecute(final Float[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Float max = input[0];
            for (Float number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }
    }
    
    static final class MinArray extends AbstractNotNullFunction<Float[],Float> {

        MinArray() {
            super();
        }

        @Override
        protected Float notNullExecute(final Float[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Float min = input[0];
            for (Float number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Float[],Float> {

        SumArray() {
            super();
        }

        @Override
        protected Float notNullExecute(final Float[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Float number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.floatValue()));
                }
            }   
            return Float.valueOf(sum.floatValue());
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Float[],Float> {

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
        protected Float notNullExecute(final Float[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Float number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.floatValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).floatValue());
            }
            if (this.mathContext != null) {
                return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).floatValue());
            }
            return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).floatValue());
        }       
    }
	
	
	
	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<Float, Float> {

		Abs() {
			super();
		}
		
		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			return Float.valueOf(Math.abs(input.floatValue()));
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<Float, Float> {

		private final Float add;
		
		Add(Float add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.floatValue());
			result = result.add(BigDecimal.valueOf(this.add.floatValue()));
				
			return Float.valueOf(result.floatValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Float, Float> {

		private final Float subtract;
		
		Subtract(Float subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.floatValue());
			result = result.subtract(BigDecimal.valueOf(this.subtract.floatValue()));
				
			return Float.valueOf(result.floatValue());
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Float, Float> {

		private final Float divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Float divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Float divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Float divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.floatValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.floatValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.floatValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.floatValue()), RoundingMode.DOWN);	
			}
			return Float.valueOf(result.floatValue());
		}		
	}
	
	static final class Remainder extends AbstractNullAsNullFunction<Float, Float> {

        private final Float divisor;
        
        Remainder(Float divisor) {
            super();
            this.divisor = divisor;
        }
        
        @Override
        protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
            return Float.valueOf(BigDecimal.valueOf(input.doubleValue())
                    .remainder(BigDecimal.valueOf(this.divisor.doubleValue())).floatValue());
        }   
    }
	
	static final class Multiply extends AbstractNullAsNullFunction<Float, Float> {

		private final Float multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Float multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Float multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Float multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.floatValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.floatValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.floatValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.floatValue()));	
			}
			return Float.valueOf(result.floatValue());
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Float, Float> {

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
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.floatValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Float.valueOf(result.floatValue());
		}		
	}
}
