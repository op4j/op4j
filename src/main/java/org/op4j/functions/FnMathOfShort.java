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

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnMathOfShort {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private final static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathOfShort() {
		super();           
	}

    /**
     * @return function that returns the maximum {@link Short} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<Short>, Short> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link Short} of an object
     *         implementing {@link Iterable}
     */
    public final IFunction<Iterable<Short>, Short> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link Short} elements in an
     *         object implementing {@link Iterable}
     */
    public final IFunction<Iterable<Short>, Short> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link Short} elements
     *         in an object implementing {@link Iterable}
     */
    public final IFunction<Iterable<Short>, Short> avg() {
        return AVG_FUNC;
    }

    public final IFunction<Iterable<Short>, Short> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    public final IFunction<Iterable<Short>, Short> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final IFunction<Short, Short> abs() {
        return ABS_FUNC;
    }

    public final IFunction<Short, Short> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final IFunction<Short, Short> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final IFunction<Short, Short> add(short add) {
        return add(Short.valueOf(add));
    }

    public final IFunction<Short, Short> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final IFunction<Short, Short> add(long add) {
        return add(Long.valueOf(add));
    }

    public final IFunction<Short, Short> add(float add) {
        return add(Float.valueOf(add));
    }

    public final IFunction<Short, Short> add(double add) {
        return add(Double.valueOf(add));
    }


    public final IFunction<Short, Short> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final IFunction<Short, Short> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final IFunction<Short, Short> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final IFunction<Short, Short> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final IFunction<Short, Short> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final IFunction<Short, Short> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final IFunction<Short, Short> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final IFunction<Short, Short> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final IFunction<Short, Short> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final IFunction<Short, Short> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final IFunction<Short, Short> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final IFunction<Short, Short> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final IFunction<Short, Short> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final IFunction<Short, Short> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final IFunction<Short, Short> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    public final IFunction<Short, Short> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }


    public final IFunction<Short, Short> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    public final IFunction<Short, Short> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }


    public final IFunction<Short, Short> module(int module) {
        return new Module(module);
    }

    public final IFunction<Short, Short> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final IFunction<Short, Short> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final IFunction<Short, Short> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    public final IFunction<Short, Short> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }


    public final IFunction<Short, Short> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    public final IFunction<Short, Short> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    public final IFunction<Short, Short> pow(int power) {
        return new Pow(power);
    }

    public final IFunction<Short, Short> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    public final IFunction<Short, Short> pow(int power, RoundingMode roundingMode) {
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
			return Short.valueOf(sum.divide(BigDecimal.valueOf(countNotNull)).shortValue());
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
				result = result.divide(BigDecimal.valueOf(this.divisor.shortValue()));	
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
