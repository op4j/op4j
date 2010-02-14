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
public final class MathBigDecimal {

	private static Max MAX_FUNC = new Max();
	
	private static Min MIN_FUNC = new Min();
	
	private static Sum SUM_FUNC = new Sum();
	
	private static Avg AVG_FUNC = new Avg();
	
	private static Abs ABS_FUNC = new Abs();
	
	
	private MathBigDecimal() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link BigDecimal} of an object implementing {@link Iterable}
	 */
	public static final Max max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link BigDecimal} of an object implementing {@link Iterable}
	 */
	public static final Min min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link BigDecimal} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Sum sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link BigDecimal} elements in an object 
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
	
	public static final Round round(MathContext mathContext) {
        return new Round(mathContext);
    }
	public static final Round round(RoundingMode roundingMode) {
		return new Round(roundingMode);
    }
	
	public static final Abs abs() {
		return ABS_FUNC;
    }
	
	public static final Add add(BigDecimal add) {
		return new Add(add);
    }
	
	public static final Subtract subtract(BigDecimal subtract) {
		return new Subtract(subtract);
    }
	
	public static final Divide divideBy(BigDecimal divisor) {
		return new Divide(divisor);
    }
	public static final Divide divideBy(BigDecimal divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final Divide divideBy(BigDecimal divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final Module module(int module) {
		return new Module(module);
    }	
	
	public static final Multiply multiplyBy(BigDecimal multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final Multiply multiplyBy(BigDecimal multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final Multiply multiplyBy(BigDecimal multiplicand, RoundingMode roundingMode) {
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
	
	
	public static final class Max extends AbstractNotNullFunc<BigDecimal, Iterable<BigDecimal>> {

		public Max() {
			super();
		}

		@Override
		public BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
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
	
	public static final class Min extends AbstractNotNullFunc<BigDecimal, Iterable<BigDecimal>> {

		public Min() {
			super();
		}

		@Override
		public BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
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
	
	public static final class Sum extends AbstractNotNullFunc<BigDecimal, Iterable<BigDecimal>> {

		public Sum() {
			super();
		}

		@Override
		public BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	public static final class Avg extends AbstractNotNullFunc<BigDecimal, Iterable<BigDecimal>> {

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
		public BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			
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
			return sum.divide(BigDecimal.valueOf(countNotNull));
		}		
	}
	
	public static final class Round extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private MathContext mathContext = null;
		private RoundingMode roundingMode = null;
		
		public Round(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;
		}
		
		public Round(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
		}
		
		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			if (this.roundingMode != null) {
				return result.setScale(0, this.roundingMode);
			}			
			return result.round(this.mathContext);
		}	
	}
	
	public static final class Abs extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		public Abs() {
			super();
		}
		
		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			return BigDecimal.valueOf(Math.abs(input.doubleValue()));
		}
	}
	
	public static final class Add extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private BigDecimal add;
		
		public Add(BigDecimal add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	public static final class Subtract extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private BigDecimal subtract;
		
		public Subtract(BigDecimal subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	public static final class Divide extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private BigDecimal divisor;
		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public Divide(BigDecimal divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		public Divide(BigDecimal divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
		}
		
		public Divide(BigDecimal divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.mathContext = mathContext;
		}

		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.roundingMode != null) {
				result = result.divide(this.divisor, this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(this.divisor, this.mathContext);				
			} else {
				result = result.divide(this.divisor);	
			}
			return result;
		}		
	}
	
	
	public static final class Module extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private int module;
		
		public Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			return BigDecimal.valueOf(input.doubleValue() % this.module);
		}	
	}
	
	public static final class Multiply extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

		private BigDecimal multiplicand;
		private MathContext mathContext = null;
		private RoundingMode roundingMode = null;
		
		public Multiply(BigDecimal multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		public Multiply(BigDecimal multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.roundingMode = roundingMode;
		}
		
		public Multiply(BigDecimal multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
		}

		@Override
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
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
	
	public static final class Raise extends AbstractNotNullFunc<BigDecimal, BigDecimal> {

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
		public BigDecimal notNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
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
