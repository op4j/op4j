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
public final class FnMathLong {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private final static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathLong() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link Long} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Long>,Long> max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link Long} of an object implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Long>,Long> min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link Long} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Long>,Long> sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link Long} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final IFunction<Iterable<Long>,Long> avg() {
        return AVG_FUNC;
    }
	public static final IFunction<Iterable<Long>,Long> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }
	public static final IFunction<Iterable<Long>,Long> avg(RoundingMode roundingMode) {
		return new Avg(roundingMode);
    }
	
	public static final IFunction<Long,Long> abs() {
		return ABS_FUNC;
    }
	
	public static final IFunction<Long,Long> add(Long add) {
		return new Add(add);
    }
	
	public static final IFunction<Long,Long> subtract(Long subtract) {
		return new Subtract(subtract);
    }
	
	public static final IFunction<Long,Long> divideBy(Long divisor) {
		return new Divide(divisor);
    }
	public static final IFunction<Long,Long> divideBy(Long divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final IFunction<Long,Long> divideBy(Long divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final IFunction<Long,Long> module(int module) {
		return new Module(module);
    }	
	
	public static final IFunction<Long,Long> multiplyBy(Long multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final IFunction<Long,Long> multiplyBy(Long multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final IFunction<Long,Long> multiplyBy(Long multiplicand, RoundingMode roundingMode) {
		return new Multiply(multiplicand, roundingMode);
    }
	
	public static final IFunction<Long,Long> pow(int power) {
		return new Pow(power);
    }
	public static final IFunction<Long,Long> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }
	public static final IFunction<Long,Long> pow(int power, RoundingMode roundingMode) {
		return new Pow(power, roundingMode);
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
			return Long.valueOf(sum.divide(BigDecimal.valueOf(countNotNull)).longValue());
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
				result = result.divide(BigDecimal.valueOf(this.divisor.longValue()));	
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
			return Long.valueOf(input.longValue() % this.module);
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
