/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
package org.op4j.functions.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.lang.Validate;
import org.op4j.functions.AbstractNotNullFunc;
import org.op4j.functions.AbstractNullAsNullFunc;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class MathShortFuncs {

	private static Max MAX_FUNC = new Max();
	
	private static Min MIN_FUNC = new Min();
	
	private static Sum SUM_FUNC = new Sum();
	
	private static Avg AVG_FUNC = new Avg();
	
	private static Abs ABS_FUNC = new Abs();
	
	
	private MathShortFuncs() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link Short} of an object implementing {@link Iterable}
	 */
	public static final Max max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link Short} of an object implementing {@link Iterable}
	 */
	public static final Min min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link Short} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Sum sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link Short} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Avg avg() {
        return AVG_FUNC;
    }
	public static final Avg avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
	public static final Avg avg(RoundingMode roundingMode) {
		return new Avg(roundingMode);
    }
	
	public static final Abs abs() {
		return ABS_FUNC;
    }
	
	public static final Add add(Short add) {
		return new Add(add);
    }
	
	public static final Subtract subtract(Short subtract) {
		return new Subtract(subtract);
    }
	
	public static final Divide divideBy(Short divisor) {
		return new Divide(divisor);
    }
	public static final Divide divideBy(Short divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final Divide divideBy(Short divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final Module module(int module) {
		return new Module(module);
    }	
	
	public static final Multiply multiplyBy(Short multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final Multiply multiplyBy(Short multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final Multiply multiplyBy(Short multiplicand, RoundingMode roundingMode) {
		return new Multiply(multiplicand, roundingMode);
    }
	
	public static final Raise raiseTo(int power) {
		return new Raise(power);
    }
	public static final Raise raiseTo(int power, MathContext mathContext) {
        return new Raise(power, mathContext);
    }
	public static final Raise raiseTo(int power, RoundingMode roundingMode) {
		return new Raise(power, roundingMode);
    }
	
	
	public static final class Max extends AbstractNotNullFunc<Short, Iterable<Short>> {

		public Max() {
			super();
		}

		@Override
		public Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
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
	
	public static final class Min extends AbstractNotNullFunc<Short, Iterable<Short>> {

		public Min() {
			super();
		}

		@Override
		public Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
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
	
	public static final class Sum extends AbstractNotNullFunc<Short, Iterable<Short>> {

		public Sum() {
			super();
		}

		@Override
		public Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Short number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
				}
			}	
			return Short.valueOf(sum.shortValue());
		}	
	}
	
	public static final class Avg extends AbstractNotNullFunc<Short, Iterable<Short>> {

		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public Avg() {
			super();
		}

		public Avg(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;			
		}
		
		public Avg(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
		}
		
		@Override
		public Short notNullExecute(final Iterable<Short> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Short number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.intValue()));
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
	
	public static final class Abs extends AbstractNullAsNullFunc<Short, Short> {

		public Abs() {
			super();
		}
		
		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(Math.abs(input.shortValue())).shortValue());
		}	
	}
	
	public static final class Add extends AbstractNullAsNullFunc<Short, Short> {

		private Short add;
		
		public Add(Short add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() + this.add.shortValue()).shortValue());
		}	
	}
	
	public static final class Subtract extends AbstractNullAsNullFunc<Short, Short> {

		private Short subtract;
		
		public Subtract(Short subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() - this.subtract.shortValue()).shortValue());
		}	
	}
	
	public static final class Divide extends AbstractNullAsNullFunc<Short, Short> {

		private Short divisor;
		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public Divide(Short divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		public Divide(Short divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
		}
		
		public Divide(Short divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.mathContext = mathContext;
		}

		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.roundingMode != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.mathContext);				
			} else {
				result = result.divide(BigDecimal.valueOf(this.divisor.doubleValue()));	
			}
			return Short.valueOf(result.shortValue());
		}		
	}
	
	
	public static final class Module extends AbstractNullAsNullFunc<Short, Short> {

		private int module;
		
		public Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			return Short.valueOf(Integer.valueOf(input.shortValue() % this.module).shortValue());
		}	
	}
	
	public static final class Multiply extends AbstractNullAsNullFunc<Short, Short> {

		private Short multiplicand;
		private MathContext mathContext = null;
		private RoundingMode roundingMode = null;
		
		public Multiply(Short multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		public Multiply(Short multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.roundingMode = roundingMode;
		}
		
		public Multiply(Short multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
		}

		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
			if (this.mathContext != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()), this.mathContext);				
			} else if (this.roundingMode != null) {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue())).setScale(0, this.roundingMode);	
			} else {
				result = result.multiply(BigDecimal.valueOf(this.multiplicand.intValue()));	
			}
			return Short.valueOf(result.shortValue());
		}
	}
	
	public static final class Raise extends AbstractNullAsNullFunc<Short, Short> {

		private int power;
		private MathContext mathContext = null;
		private RoundingMode roundingMode = null;
		
		public Raise(int power) {
			super();
			this.power = power;
		}
		
		public Raise(int power, RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.power = power;
			this.roundingMode = roundingMode;
		}
		
		public Raise(int power, MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.power = power;
			this.mathContext = mathContext;
		}

		@Override
		public Short nullAsNullExecute(final Short input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.intValue());
			
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
