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
public final class FnMathFloat {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathFloat() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link Float} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Float>,Float> max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link Float} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Float>,Float> min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link Float} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Float>,Float> sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link Float} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Float>,Float> avg() {
        return AVG_FUNC;
    }
	public static final IFunction<Iterable<Float>,Float> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
	public static final IFunction<Iterable<Float>,Float> avg(RoundingMode roundingMode) {
		return new Avg(roundingMode);
    }
	
	public static final IFunction<Float,Float> abs() {
		return ABS_FUNC;
    }
	
	public static final IFunction<Float,Float> add(Float add) {
		return new Add(add);
    }
	
	public static final IFunction<Float,Float> subtract(Float subtract) {
		return new Subtract(subtract);
    }
	
	public static final IFunction<Float,Float> divideBy(Float divisor) {
		return new Divide(divisor);
    }
	public static final IFunction<Float,Float> divideBy(Float divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final IFunction<Float,Float> divideBy(Float divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final IFunction<Float,Float> module(int module) {
		return new Module(module);
    }	
	
	public static final IFunction<Float,Float> multiplyBy(Float multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final IFunction<Float,Float> multiplyBy(Float multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final IFunction<Float,Float> multiplyBy(Float multiplicand, RoundingMode roundingMode) {
		return new Multiply(multiplicand, roundingMode);
    }
	
	public static final IFunction<Float,Float> pow(int power) {
		return new Pow(power);
    }
	public static final IFunction<Float,Float> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }
	public static final IFunction<Float,Float> pow(int power, RoundingMode roundingMode) {
		return new Pow(power, roundingMode);
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
			return Float.valueOf(sum.divide(BigDecimal.valueOf(countNotNull)).floatValue());
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
				result = result.divide(BigDecimal.valueOf(this.divisor.floatValue()));	
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
