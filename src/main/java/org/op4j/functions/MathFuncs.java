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
public class MathFuncs {

//	private static EscapeCSV ESCAPE_CSV_STRING_FUNC = new EscapeCSV();
	
	private MathFuncs() {
		super();           
	}

//	public static final EscapeCSV escapeCSV() {
//        return ESCAPE_CSV_STRING_FUNC;
//    }
	
	
	
	public static final class MaxDouble extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public MaxDouble() {
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
	
	public static final class MinDouble extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public MinDouble() {
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
	
	public static final class SumDouble extends AbstractNotNullFunc<Double, Iterable<Double>> {

		public SumDouble() {
			super();
		}

		@Override
		public Double notNullExecute(final Iterable<Double> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (Double number : input) {
				if (number != null) {
					sum.add(BigDecimal.valueOf(number.doubleValue()));
				}
			}	
			return Double.valueOf(sum.doubleValue());
		}

		public Type<? extends Double> getResultType(
				Type<? extends Iterable<Double>> targetType) {
			return Types.DOUBLE;
		}		
	}
	
	public static final class AvgDouble extends AbstractNotNullFunc<Double, Iterable<Double>> {

		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public AvgDouble() {
			super();
		}

		public AvgDouble(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;			
		}
		
		public AvgDouble(MathContext mathContext) {
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
					sum.add(BigDecimal.valueOf(number.doubleValue()));
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
	
	public static final class RoundDouble extends AbstractNotNullFunc<Double, Double> {

		private MathContext mathContext = null;
		
		public RoundDouble(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.mathContext = new MathContext(0, roundingMode);
		}
		
		public RoundDouble(MathContext mathContext) {
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
	
	public static final class AbsDouble extends AbstractNotNullFunc<Double, Double> {

		public AbsDouble() {
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
	
	public static final class AddDouble extends AbstractNotNullFunc<Double, Double> {

		private Double add;
		
		public AddDouble(Double add) {
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
	
	public static final class SubtractDouble extends AbstractNotNullFunc<Double, Double> {

		private Double subtract;
		
		public SubtractDouble(Double subtract) {
			super();
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
	
	public static final class DivideByDouble extends AbstractNotNullFunc<Double, Double> {

		private Double divisor;
		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public DivideByDouble(Double divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		public DivideByDouble(Double divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
		}
		
		public DivideByDouble(Double divisor, MathContext mathContext) {
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
	
	
	
	//TODO mod, mul, 
	
	
	public static final class RaiseDouble extends AbstractNotNullFunc<Double, Double> {

		private int power;
		private MathContext mathContext = null;
		
		public RaiseDouble(int power) {
			super();
			this.power = power;
		}
		
		public RaiseDouble(int power, RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.power = power;
			this.mathContext = new MathContext(0, roundingMode);
		}
		
		public RaiseDouble(int power, MathContext mathContext) {
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
