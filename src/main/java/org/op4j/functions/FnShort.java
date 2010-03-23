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
public final class FnShort {

	private static final Function<Iterable<Short>, Short> MAX_FUNC = new Max();
	
	private static final Function<Iterable<Short>, Short> MIN_FUNC = new Min();
	
	private static final Function<Iterable<Short>, Short> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<Short>, Short> AVG_FUNC = new Avg();

    private static final Function<Short[], Short> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<Short[], Short> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<Short[], Short> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<Short[], Short> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<Short, Short> ABS_FUNC = new Abs();
	
	
	FnShort() {
		super();           
	}

	
	
	// From FnNumber
    public static final Function<Number,String> toStr() {
        return FnNumber.toStr();
    }   
    public static final Function<Number,String> toStr(boolean groupingUsed) {
        return FnNumber.toStr(groupingUsed);
    }
    public static final Function<Number,String> toStr(Locale locale) {
        return FnNumber.toStr(locale);
    }
    public static final Function<Number,String> toStr(String locale) {
        return FnNumber.toStr(locale);
    }
    public static final Function<Number,String> toStr(Locale locale, boolean groupingUsed) {
        return FnNumber.toStr(locale, groupingUsed);
    }   
    public static final Function<Number,String> toStr(String locale, boolean groupingUsed) {
        return FnNumber.toStr(locale, groupingUsed);
    }
    public static final Function<Number,String> toCurrencyStr() {
        return FnNumber.toCurrencyStr();
    }
    public static final Function<Number,String> toCurrencyStr(boolean groupingUsed) {
        return FnNumber.toCurrencyStr(groupingUsed);
    }
    public static final Function<Number,String> toCurrencyStr(Locale locale) {
        return FnNumber.toCurrencyStr(locale);
    }
    public static final Function<Number,String> toCurrencyStr(String locale) {
        return FnNumber.toCurrencyStr(locale);
    }
    public static final Function<Number,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return FnNumber.toCurrencyStr(locale, groupingUsed);
    }
    public static final Function<Number,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return FnNumber.toCurrencyStr(locale, groupingUsed);
    }
    public static final Function<Number,String> toPercentStr() {
        return FnNumber.toPercentStr();
    }
    public static final Function<Number,String> toPercentStr(boolean groupingUsed) {
        return FnNumber.toPercentStr(groupingUsed);
    }
    public static final Function<Number,String> toPercentStr(Locale locale) {
        return FnNumber.toPercentStr(locale);
    }
    public static final Function<Number,String> toPercentStr(String locale) {
        return FnNumber.toPercentStr(locale);
    }
    public static final Function<Number,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return FnNumber.toPercentStr(locale, groupingUsed);
    }   
    public static final Function<Number,String> toPercentStr(String locale, boolean groupingUsed) {
        return FnNumber.toPercentStr(locale, groupingUsed);
    }
    public static final Function<Object,Boolean> eq(final Number object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final float object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final double object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final byte object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final short object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final int object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> eq(final long object) {
        return FnObject.eq(object);
    }
    public static final Function<Object,Boolean> notEq(final Number object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final float object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final double object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final byte object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final short object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final int object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> notEq(final long object) {
        return FnObject.notEq(object);
    }
    public static final Function<Object,Boolean> lessThan(final Number object) {
        return FnObject.lessThan(object);
    }    
    public static final Function<Object,Boolean> lessThan(final float object) {
        return FnObject.lessThan(object);
    }    
    public static final Function<Object,Boolean> lessThan(final double object) {
        return FnObject.lessThan(object);
    }    
    public static final Function<Object,Boolean> lessThan(final byte object) {
        return FnObject.lessThan(object);
    }    
    public static final Function<Object,Boolean> lessThan(final short object) {
        return FnObject.lessThan(object);
    }
    public static final Function<Object,Boolean> lessThan(final int object) {
        return FnObject.lessThan(object);
    }   
    public static final Function<Object,Boolean> lessThan(final long object) {
        return FnObject.lessThan(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final Number object) {
        return FnObject.lessOrEqTo(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final float object) {
        return FnObject.lessOrEqTo(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final double object) {
        return FnObject.lessOrEqTo(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final byte object) {
        return FnObject.lessOrEqTo(object);
    }
    public static final Function<Object,Boolean> lessOrEqTo(final short object) {
        return FnObject.lessOrEqTo(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final int object) {
        return FnObject.lessOrEqTo(object);
    }    
    public static final Function<Object,Boolean> lessOrEqTo(final long object) {
        return FnObject.lessOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterThan(final Number object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final float object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final double object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final byte object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final short object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final int object) {
        return FnObject.greaterThan(object);
    }
    public static final Function<Object,Boolean> greaterThan(final long object) {
        return FnObject.greaterThan(object);
    }    
    public static final Function<Object,Boolean> greaterOrEqTo(final Number object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final float object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final double object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final byte object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final short object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final int object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final Function<Object,Boolean> greaterOrEqTo(final long object) {
        return FnObject.greaterOrEqTo(object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final Number object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final float object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final double object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final byte object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final short object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final int object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final long object) {
        return FnObject.eqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final Number object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final float object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final double object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final byte object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final short object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final int object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final long object) {
        return FnObject.notEqBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final Number object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final float object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final double object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final byte object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final short object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final int object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessThanBy(final IFunction<X,?> by, final long object) {
        return FnObject.lessThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final Number object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final float object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final double object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final byte object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final short object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final int object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> lessOrEqToBy(final IFunction<X,?> by, final long object) {
        return FnObject.lessOrEqToBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final Number object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final float object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final double object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final byte object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final short object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final int object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterThanBy(final IFunction<X,?> by, final long object) {
        return FnObject.greaterThanBy(by, object);
    }
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final Number object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final float object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final double object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final byte object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final short object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final int object) {
        return FnObject.greaterOrEqToBy(by, object);
    }    
    public static final <X> Function<X,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final long object) {
        return FnObject.greaterOrEqToBy(by, object);
    }
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    /**
     * @return function that returns the maximum {@link Short} of an object
     *         implementing {@link Iterable}
     */
    public final static Function<Iterable<Short>, Short> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link Short} of an object
     *         implementing {@link Iterable}
     */
    public final static Function<Iterable<Short>, Short> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link Short} elements in an
     *         object implementing {@link Iterable}
     */
    public final static Function<Iterable<Short>, Short> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link Short} elements
     *         in an object implementing {@link Iterable}
     */
    public final static Function<Iterable<Short>, Short> avg() {
        return AVG_FUNC;
    }

    public final static Function<Iterable<Short>, Short> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    public final static Function<Iterable<Short>, Short> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final static Function<Short[], Short> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    public final static Function<Short[], Short> minArray() {
        return MIN_ARRAY_FUNC;
    }

    public final static Function<Short[], Short> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    public final static Function<Short[], Short> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    public final static Function<Short[], Short> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    public final static Function<Short[], Short> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    public final static Function<Short, Short> abs() {
        return ABS_FUNC;
    }

    public final static Function<Short, Short> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final static Function<Short, Short> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final static Function<Short, Short> add(short add) {
        return add(Short.valueOf(add));
    }

    public final static Function<Short, Short> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final static Function<Short, Short> add(long add) {
        return add(Long.valueOf(add));
    }

    public final static Function<Short, Short> add(float add) {
        return add(Float.valueOf(add));
    }

    public final static Function<Short, Short> add(double add) {
        return add(Double.valueOf(add));
    }


    public final static Function<Short, Short> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final static Function<Short, Short> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final static Function<Short, Short> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final static Function<Short, Short> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final static Function<Short, Short> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final static Function<Short, Short> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final static Function<Short, Short> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final static Function<Short, Short> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final static Function<Short, Short> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final static Function<Short, Short> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final static Function<Short, Short> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final static Function<Short, Short> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final static Function<Short, Short> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final static Function<Short, Short> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final static Function<Short, Short> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    public final static Function<Short, Short> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }


    public final static Function<Short, Short> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    public final static Function<Short, Short> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


    public final static Function<Short, Short> module(int module) {
        return new Module(module);
    }

    public final static Function<Short, Short> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final static Function<Short, Short> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final static Function<Short, Short> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    public final static Function<Short, Short> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }


    public final static Function<Short, Short> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Short, Short> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    public final static Function<Short, Short> pow(int power) {
        return new Pow(power);
    }

    public final static Function<Short, Short> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    public final static Function<Short, Short> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
    
    
    private static Short fromNumber(final Number number) {
        if (number == null) {
            return null;
        }
        return Short.valueOf(number.shortValue());
    }

    
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<Short>,Short> {

		Max() {
			super();
		}

		@Override
		protected Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Short max = input.iterator().next();
			for (Short number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}		
	}
	
	static final class Min extends AbstractNotNullFunction<Iterable<Short>,Short> {

		Min() {
			super();
		}

		@Override
		protected Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Short min = input.iterator().next();
			for (Short number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	static final class Sum extends AbstractNotNullFunction<Iterable<Short>,Short> {

		Sum() {
			super();
		}

		@Override
		protected Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Short number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.shortValue()));
				}
			}	
			return Short.valueOf(sum.shortValue());
		}	
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<Short>,Short> {

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
		protected Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Short number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.shortValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).shortValue());
			}
			if (this.mathContext != null) {
				return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).shortValue());
			}
			return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).shortValue());
		}	
	}

	
	
	
	
	
	
	
	
	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<Short[],Short> {

        MaxArray() {
            super();
        }

        @Override
        protected Short notNullExecute(final Short[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Short max = input[0];
            for (Short number : input) {
                if (number != null) {
                    if (number.compareTo(max) > 0) {
                        max = number;
                    }
                }
            }   
            return max;
        }       
    }
    
    static final class MinArray extends AbstractNotNullFunction<Short[],Short> {

        MinArray() {
            super();
        }

        @Override
        protected Short notNullExecute(final Short[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            Short min = input[0];
            for (Short number : input) {
                if (number != null) {
                    if (number.compareTo(min) < 0) {
                        min = number;
                    }
                }
            }   
            return min;
        }   
    }
    
    static final class SumArray extends AbstractNotNullFunction<Short[],Short> {

        SumArray() {
            super();
        }

        @Override
        protected Short notNullExecute(final Short[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Short number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.shortValue()));
                }
            }   
            return Short.valueOf(sum.shortValue());
        }   
    }
    
    static final class AvgArray extends AbstractNotNullFunction<Short[],Short> {

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
        protected Short notNullExecute(final Short[] input, final ExecCtx ctx) throws Exception {
            
            int countNotNull = 0;
            BigDecimal sum = BigDecimal.valueOf(0);
            for (Short number : input) {
                if (number != null) {
                    sum = sum.add(BigDecimal.valueOf(number.shortValue()));
                    countNotNull++;
                }
            }   
            if (this.roundingMode != null) {
                return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).shortValue());
            }
            if (this.mathContext != null) {
                return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).shortValue());
            }
            return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.DOWN).shortValue());
        }   
    }
	
	
	
	
	
	
	
	
	static final class Abs extends AbstractNullAsNullFunction<Short, Short> {

		Abs() {
			super();
		}
		
		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(Math.abs(input.shortValue())).shortValue());
		}	
	}
	
	static final class Add extends AbstractNullAsNullFunction<Short, Short> {

		private final Short add;
		
		Add(Short add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() + this.add.shortValue()).shortValue());
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<Short, Short> {

		private final Short subtract;
		
		Subtract(Short subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() - this.subtract.shortValue()).shortValue());
		}	
	}
	
	static final class Divide extends AbstractNullAsNullFunction<Short, Short> {

		private final Short divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(Short divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(Short divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(Short divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.shortValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.shortValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.shortValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.shortValue()), RoundingMode.DOWN);	
			}
			return Short.valueOf(result.shortValue());
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Short, Short> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() % this.module).shortValue());
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<Short, Short> {

		private final Short multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(Short multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(Short multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(Short multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.shortValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.shortValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.shortValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.shortValue()));	
			}
			return Short.valueOf(result.shortValue());
		}
	}
	
	static final class Pow extends AbstractNullAsNullFunction<Short, Short> {

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
		protected Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.shortValue());
			
			if (this.mathContext != null) {
				result = result.pow(this.power, this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.pow(this.power).setScale(0, this.roundingMode);	
			} else {
				result = result.pow(this.power);	
			}
			return Short.valueOf(result.shortValue());
		}	
	}
}
