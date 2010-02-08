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
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public class MathDouble {

	private static Max MAX_FUNC = new Max();
	
	private static Min MIN_FUNC = new Min();
	
	private static Sum SUM_FUNC = new Sum();
	
	private static Avg AVG_FUNC = new Avg();
	
	private static Abs ABS_FUNC = new Abs();
	
	
	private MathDouble() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link Double} of an object implementing {@link Iterable}
	 */
	public static final Max max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link Double} of an object implementing {@link Iterable}
	 */
	public static final Min min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link Double} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Sum sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link Double} elements in an object 
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
	
	public static final Add add(Double add) {
		return new Add(add);
    }
	
	public static final Subtract subtract(Double subtract) {
		return new Subtract(subtract);
    }
	
	public static final Divide divideBy(Double divisor) {
		return new Divide(divisor);
    }
	public static final Divide divideBy(Double divisor, MathContext mathContext) {
        return new Divide(divisor, mathContext);
    }
	public static final Divide divideBy(Double divisor, RoundingMode roundingMode) {
		return new Divide(divisor, roundingMode);
    }
	
	public static final ModuleDouble module(int module) {
		return new ModuleDouble(module);
    }	
	
	public static final Multiply multiplyBy(Double multiplicand) {
		return new Multiply(multiplicand);
    }
	public static final Multiply multiplyBy(Double multiplicand, MathContext mathContext) {
        return new Multiply(multiplicand, mathContext);
    }
	public static final Multiply multiplyBy(Double multiplicand, RoundingMode roundingMode) {
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
	
	
	public static final class Max extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public Max() {
			super();
		}

		@Override
		public Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Double max = input.iterator().next();
			for (Double number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}

		public Type<? extends Double> getResultType(
				Type<? extends Iterable<Double>> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Min extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public Min() {
			super();
		}

		@Override
		public Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			Double min = input.iterator().next();
			for (Double number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}

		public Type<? extends Double> getResultType(
				Type<? extends Iterable<Double>> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Sum extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public Sum() {
			super();
		}

		@Override
		public Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Double number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
				}
			}	
			return Double.valueOf(sum.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Iterable<Double>> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Avg extends AbstractNotNullFunc<Double, Iterable<Double>> {

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
		public Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Double number : input) {
				if (number != null) {
					sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
					countNotNull++;
				}
			}	
			if (this.roundingMode != null) {
				return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.roundingMode).doubleValue());
			}
			if (this.mathContext != null) {
				return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull), this.mathContext).doubleValue());
			}
			return Double.valueOf(sum.divide(BigDecimal.valueOf(countNotNull)).doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Iterable<Double>> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Round extends AbstractNotNullFunc<Double, Double> {

		private MathContext mathContext = null;
		
		public Round(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.mathContext = new MathContext(0, roundingMode);
		}
		
		public Round(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
		}
		
		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			
			return Double.valueOf(BigDecimal.valueOf(input.doubleValue()).round(this.mathContext).doubleValue());		
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Abs extends AbstractNotNullFunc<Double, Double> {

		public Abs() {
			super();
		}
		
		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			return Double.valueOf(Math.abs(input.doubleValue()));
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Add extends AbstractNotNullFunc<Double, Double> {

		private Double add;
		
		public Add(Double add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			result.add(BigDecimal.valueOf(this.add.doubleValue()));
				
			return Double.valueOf(result.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Subtract extends AbstractNotNullFunc<Double, Double> {

		private Double subtract;
		
		public Subtract(Double subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal result = BigDecimal.valueOf(input.doubleValue());
			result.subtract(BigDecimal.valueOf(this.subtract.doubleValue()));
				
			return Double.valueOf(result.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Divide extends AbstractNotNullFunc<Double, Double> {

		private Double divisor;
		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public Divide(Double divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		public Divide(Double divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
		}
		
		public Divide(Double divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.mathContext = mathContext;
		}

		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal dividend = BigDecimal.valueOf(input.doubleValue());
			
			if (this.roundingMode != null) {
				dividend.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.roundingMode);					
			} else if (this.mathContext != null) {
				dividend.divide(BigDecimal.valueOf(this.divisor.doubleValue()), this.mathContext);				
			} else {
				dividend.divide(BigDecimal.valueOf(this.divisor.doubleValue()));	
			}
			return Double.valueOf(dividend.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	
	public static final class ModuleDouble extends AbstractNotNullFunc<Double, Double> {

		private int module;
		
		public ModuleDouble(int module) {
			super();
			this.module = module;
		}
		
		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			return Double.valueOf(input.doubleValue() % this.module);
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Multiply extends AbstractNotNullFunc<Double, Double> {

		private Double multiplicand;
		private MathContext mathContext = null;
		
		public Multiply(Double multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		public Multiply(Double multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = new MathContext(0, roundingMode);
		}
		
		public Multiply(Double multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
		}

		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal base = BigDecimal.valueOf(input.doubleValue());
			
			if (this.mathContext != null) {
				base.multiply(BigDecimal.valueOf(this.multiplicand.doubleValue()), this.mathContext);				
			} else {
				base.multiply(BigDecimal.valueOf(this.multiplicand.doubleValue()));	
			}
			return Double.valueOf(base.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class Raise extends AbstractNotNullFunc<Double, Double> {

		private int power;
		private MathContext mathContext = null;
		
		public Raise(int power) {
			super();
			this.power = power;
		}
		
		public Raise(int power, RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.power = power;
			this.mathContext = new MathContext(0, roundingMode);
		}
		
		public Raise(int power, MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.power = power;
			this.mathContext = mathContext;
		}

		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			BigDecimal base = BigDecimal.valueOf(input.doubleValue());
			
			if (this.mathContext != null) {
				base.pow(this.power, this.mathContext);				
			} else {
				base.pow(this.power);	
			}
			return Double.valueOf(base.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Double> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	
}
