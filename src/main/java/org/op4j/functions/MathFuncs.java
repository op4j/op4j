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

		private RoundingMode roundingMode = null;
		private MathContext mathContext = null;
		
		public RoundDouble(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.roundingMode = roundingMode;
		}
		
		public RoundDouble(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
		}
		
		@Override
		public Double notNullExecute(final Double input, final ExecCtx ctx) throws Exception {
			
			if (this.mathContext != null) {
				MathContext mc = new MathContext(0, this.roundingMode);
				return Double.valueOf(BigDecimal.valueOf(input.doubleValue()).round(mc).doubleValue());				
			}						
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
}
