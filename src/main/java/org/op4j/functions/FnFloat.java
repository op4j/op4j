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
	public static final Function<Number,String> toStr() {
        return FnNumber.toStr();
    }   
    public static final Function<Float,String> toStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(groupingUsed));
    }
    public static final Function<Float,String> toStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale));
    }
    public static final Function<Float,String> toStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale));
    }
    public static final Function<Float,String> toStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }   
    public static final Function<Float,String> toStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toStr(locale, groupingUsed));
    }
    public static final Function<Float,String> toCurrencyStr() {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr());
    }
    public static final Function<Float,String> toCurrencyStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(groupingUsed));
    }
    public static final Function<Float,String> toCurrencyStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale));
    }
    public static final Function<Float,String> toCurrencyStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale));
    }
    public static final Function<Float,String> toCurrencyStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    public static final Function<Float,String> toCurrencyStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toCurrencyStr(locale, groupingUsed));
    }
    public static final Function<Float,String> toPercentStr() {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr());
    }
    public static final Function<Float,String> toPercentStr(boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(groupingUsed));
    }
    public static final Function<Float,String> toPercentStr(Locale locale) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale));
    }
    public static final Function<Float,String> toPercentStr(String locale) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale));
    }
    public static final Function<Float,String> toPercentStr(Locale locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
    }   
    public static final Function<Float,String> toPercentStr(String locale, boolean groupingUsed) {
        return (Function<Float,String>)((Function)FnNumber.toPercentStr(locale, groupingUsed));
    }
    public static final Function<Float,Boolean> eq(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> eq(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.eq(object));
    }
    public static final Function<Float,Boolean> notEq(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> notEq(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEq(object));
    }
    public static final Function<Float,Boolean> lessThan(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }    
    public static final Function<Float,Boolean> lessThan(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }    
    public static final Function<Float,Boolean> lessThan(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }    
    public static final Function<Float,Boolean> lessThan(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }    
    public static final Function<Float,Boolean> lessThan(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }
    public static final Function<Float,Boolean> lessThan(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }   
    public static final Function<Float,Boolean> lessThan(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThan(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    public static final Function<Float,Boolean> lessOrEqTo(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }    
    public static final Function<Float,Boolean> lessOrEqTo(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterThan(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }
    public static final Function<Float,Boolean> greaterThan(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThan(object));
    }    
    public static final Function<Float,Boolean> greaterOrEqTo(final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final Function<Float,Boolean> greaterOrEqTo(final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqTo(object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> eqBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.eqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> notEqBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.notEqBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessThanBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> lessOrEqToBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.lessOrEqToBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterThanBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterThanBy(by, object));
    }
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final Number object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final float object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final double object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final byte object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final short object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final int object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }    
    public static final <X> Function<Float,Boolean> greaterOrEqToBy(final IFunction<X,?> by, final long object) {
        return (Function<Float,Boolean>)((Function)FnObject.greaterOrEqToBy(by, object));
    }
    public static final Function<Float,Boolean> isNull() {
        return (Function<Float,Boolean>)((Function)FnObject.isNull());
    }
    
    public static final Function<Float,Boolean> isNotNull() {
        return (Function<Float,Boolean>)((Function)FnObject.isNotNull());
    }
    // End From FnNumber
    
    
    
    
    
    
    
    
    
    /**
     * @return function that returns the maximum {@link Float} of an object
     *         implementing {@link Iterable}
     */
    public final static Function<Iterable<Float>, Float> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link Float} of an object
     *         implementing {@link Iterable}
     */
    public final static Function<Iterable<Float>, Float> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link Float} elements in an
     *         object implementing {@link Iterable}
     */
    public final static Function<Iterable<Float>, Float> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link Float} elements
     *         in an object implementing {@link Iterable}
     */
    public final static Function<Iterable<Float>, Float> avg() {
        return AVG_FUNC;
    }

    public final static Function<Iterable<Float>, Float> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    public final static Function<Iterable<Float>, Float> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final static Function<Float[], Float> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    public final static Function<Float[], Float> minArray() {
        return MIN_ARRAY_FUNC;
    }

    public final static Function<Float[], Float> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    public final static Function<Float[], Float> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    public final static Function<Float[], Float> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    public final static Function<Float[], Float> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    public final static Function<Float, Float> abs() {
        return ABS_FUNC;
    }

    public final static Function<Float, Float> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final static Function<Float, Float> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final static Function<Float, Float> add(short add) {
        return add(Short.valueOf(add));
    }

    public final static Function<Float, Float> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final static Function<Float, Float> add(long add) {
        return add(Long.valueOf(add));
    }

    public final static Function<Float, Float> add(float add) {
        return add(Float.valueOf(add));
    }

    public final static Function<Float, Float> add(double add) {
        return add(Double.valueOf(add));
    }


    public final static Function<Float, Float> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final static Function<Float, Float> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final static Function<Float, Float> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final static Function<Float, Float> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final static Function<Float, Float> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final static Function<Float, Float> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final static Function<Float, Float> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final static Function<Float, Float> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final static Function<Float, Float> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final static Function<Float, Float> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final static Function<Float, Float> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final static Function<Float, Float> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final static Function<Float, Float> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final static Function<Float, Float> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final static Function<Float, Float> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    public final static Function<Float, Float> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }


    public final static Function<Float, Float> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    public final static Function<Float, Float> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


    public final static Function<Float, Float> module(int module) {
        return new Module(module);
    }

    public final static Function<Float, Float> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final static Function<Float, Float> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final static Function<Float, Float> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    public final static Function<Float, Float> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }


    public final static Function<Float, Float> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    public final static Function<Float, Float> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    public final static Function<Float, Float> pow(int power) {
        return new Pow(power);
    }

    public final static Function<Float, Float> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    public final static Function<Float, Float> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
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
	
	
	static final class Module extends AbstractNullAsNullFunction<Float, Float> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Float nullAsNullExecute(final Float input, final ExecCtx ctx) throws Exception {
			return Float.valueOf(input.floatValue() % this.module);
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
