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

import java.math.BigInteger;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public class MathBigInteger {

	private static Max MAX_FUNC = new Max();
	
	private static Min MIN_FUNC = new Min();
	
	private static Sum SUM_FUNC = new Sum();
	
	private static Avg AVG_FUNC = new Avg();
	
	private static Abs ABS_FUNC = new Abs();
	
	
	private MathBigInteger() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link BigInteger} of an object implementing {@link Iterable}
	 */
	public static final Max max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link BigInteger} of an object implementing {@link Iterable}
	 */
	public static final Min min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link BigInteger} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Sum sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link BigInteger} elements in an object 
	 * implementing {@link Iterable}
	 */
	public static final Avg avg() {
        return AVG_FUNC;
    }
	
	public static final Abs abs() {
		return ABS_FUNC;
    }
	
	public static final Add add(BigInteger add) {
		return new Add(add);
    }
	
	public static final Subtract subtract(BigInteger subtract) {
		return new Subtract(subtract);
    }
	
	public static final Divide divideBy(BigInteger divisor) {
		return new Divide(divisor);
    }
	
	public static final Module module(int module) {
		return new Module(module);
    }	
	
	public static final Multiply multiplyBy(BigInteger multiplicand) {
		return new Multiply(multiplicand);
    }
	
	public static final Raise raiseTo(int power) {
		return new Raise(power);
    }
	
	
	public static final class Max extends AbstractNotNullFunc<BigInteger, Iterable<BigInteger>> {

		public Max() {
			super();
		}

		@Override
		public BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger max = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(max) > 0) {
						max = number;
					}
				}
			}	
			return max;
		}
	}
	
	public static final class Min extends AbstractNotNullFunc<BigInteger, Iterable<BigInteger>> {

		public Min() {
			super();
		}

		@Override
		public BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			if (input.iterator().hasNext() == false) {
				return null;
			}
			BigInteger min = input.iterator().next();
			for (BigInteger number : input) {
				if (number != null) {
					if (number.compareTo(min) < 0) {
						min = number;
					}
				}
			}	
			return min;
		}	
	}
	
	public static final class Sum extends AbstractNotNullFunc<BigInteger, Iterable<BigInteger>> {

		public Sum() {
			super();
		}

		@Override
		public BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			BigInteger sum = BigInteger.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	public static final class Avg extends AbstractNotNullFunc<BigInteger, Iterable<BigInteger>> {

		public Avg() {
			super();
		}
		
		@Override
		public BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			
			int countNotNull = 0;
			BigInteger sum = BigInteger.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(number);
					countNotNull++;
				}
			}	
			return sum.divide(BigInteger.valueOf(countNotNull));
		}		
	}
	
	public static final class Abs extends AbstractNotNullFunc<BigInteger, BigInteger> {

		public Abs() {
			super();
		}
		
		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return BigInteger.valueOf(Math.abs(input.longValue()));
		}
	}
	
	public static final class Add extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private BigInteger add;
		
		public Add(BigInteger add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	public static final class Subtract extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private BigInteger subtract;
		
		public Subtract(BigInteger subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	public static final class Divide extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private BigInteger divisor;
		
		public Divide(BigInteger divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			
			result = result.divide(this.divisor);	
			
			return result;
		}		
	}
	
	
	public static final class Module extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private int module;
		
		public Module(int module) {
			super();
			this.module = module;
		}
		
		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return BigInteger.valueOf(input.longValue() % this.module);
		}	
	}
	
	public static final class Multiply extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private BigInteger multiplicand;
		
		public Multiply(BigInteger multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			
			result = result.multiply(this.multiplicand);	
			
			return result;
		}	
	}
	
	public static final class Raise extends AbstractNotNullFunc<BigInteger, BigInteger> {

		private int power;
		
		public Raise(int power) {
			super();
			this.power = power;
		}
		
		@Override
		public BigInteger notNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			
			result = result.pow(this.power);	
			
			return result;
		}		
	}
}
