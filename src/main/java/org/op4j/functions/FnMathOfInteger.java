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
public final class FnMathOfInteger {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private final static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathOfInteger() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link Integer} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Integer>,Integer> max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link Integer} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Integer>,Integer> min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link Integer} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Integer>,Integer> sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link Integer} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Integer>,Integer> avg() {
        return AVG_FUNC;
    }
	public static final IFunction<Iterable<Integer>,Integer> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
	public static final IFunction<Iterable<Integer>,Integer> avg(RoundingMode roundingMode) {
		return new Avg(roundingMode);
    }
	
	public static final IFunction<Integer,Integer> abs() {
		return ABS_FUNC;
    }
	
	public static final IFunction<Integer,Integer> add(Integer add) {
		return new Add(add);
    }
	
	public static final IFunction<Integer,Integer> subtract(Integer subtract) {
		return new Subtract(subtract);
    }
	
	public static final IFunction<Integer,Integer> divideBy(Integer divisor) {
		return new Divide(divisor);
    }
	public static final IFunction<Integer,Integer> divideBy(Integer divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final IFunction<Integer,Integer> divideBy(Integer divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final IFunction<Integer,Integer> module(int module) {
		return new Module(module);
    }	
	
	public static final IFunction<Integer,Integer> multiplyBy(Integer multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final IFunction<Integer,Integer> multiplyBy(Integer multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final IFunction<Integer,Integer> multiplyBy(Integer multiplicand, RoundingMode roundingMode) {
		return new Multiply(multiplicand, roundingMode);
    }
	
	public static final IFunction<Integer,Integer> pow(int power) {
		return new Pow(power);
    }
	public static final IFunction<Integer,Integer> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }
	public static final IFunction<Integer,Integer> pow(int power, RoundingMode roundingMode) {
		return new Pow(power, roundingMode);
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
			return Integer.valueOf(sum.divide(BigDecimal.valueOf(countNotNull)).intValue());
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
				result = result.divide(BigDecimal.valueOf(this.divisor.intValue()));	
			}
			return Integer.valueOf(result.intValue());
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<Integer, Integer> {

		private final int module;
		
		Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		protected Integer nullAsNullExecute(final Integer input, final ExecCtx ctx) throws Exception {
			return Integer.valueOf(input.intValue() % this.module);
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
