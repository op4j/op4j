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

import java.math.BigInteger;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnMathOfBigInteger {

	private final static Max MAX_FUNC = new Max();
	
	private final static Min MIN_FUNC = new Min();
	
	private final static Sum SUM_FUNC = new Sum();
	
	private final static Avg AVG_FUNC = new Avg();
	
	private final static Abs ABS_FUNC = new Abs();
	
	
	FnMathOfBigInteger() {
		super();           
	}

	/**
	 * @return function that returns the maximum {@link BigInteger} of an object implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigInteger>,BigInteger> max() {
        return MAX_FUNC;
    }
	
	/**
	 * @return function that returns the minimum {@link BigInteger} of an object implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigInteger>,BigInteger> min() {
        return MIN_FUNC;
    }
	
	/**
	 * @return function that returns the sum of the {@link BigInteger} elements in an object 
	 * implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigInteger>,BigInteger> sum() {
        return SUM_FUNC;
    }
	
	/**
	 * @return function that returns the average of the {@link BigInteger} elements in an object 
	 * implementing {@link Iterable}
	 */
	public final IFunction<Iterable<BigInteger>,BigInteger> avg() {
        return AVG_FUNC;
    }
	
	public final IFunction<BigInteger,BigInteger> abs() {
		return ABS_FUNC;
    }
	
	public final IFunction<BigInteger,BigInteger> add(BigInteger add) {
		return new Add(add);
    }
	
	public final IFunction<BigInteger,BigInteger> subtract(BigInteger subtract) {
		return new Subtract(subtract);
    }
	
	public final IFunction<BigInteger,BigInteger> divideBy(BigInteger divisor) {
		return new Divide(divisor);
    }
	
	public final IFunction<BigInteger,BigInteger> module(BigInteger module) {
		return new Module(module);
    }
	
	public final IFunction<BigInteger,BigInteger> remainder(BigInteger module) {
		return new Remainder(module);
    }
	
	public final IFunction<BigInteger,BigInteger> multiplyBy(BigInteger multiplicand) {
		return new Multiply(multiplicand);
    }
	
	public final IFunction<BigInteger,BigInteger> pow(int power) {
		return new Pow(power);
    }
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Max() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
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
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Min() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
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
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Sum() {
			super();
		}

		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			BigInteger sum = BigInteger.valueOf(0);
			for (BigInteger number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigInteger>,BigInteger> {

		Avg() {
			super();
		}
		
		@Override
		protected BigInteger notNullExecute(final Iterable<BigInteger> input, final ExecCtx ctx) throws Exception {
			
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
	
	static final class Abs extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		Abs() {
			super();
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger add;
		
		Add(BigInteger add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger subtract;
		
		Subtract(BigInteger subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger divisor;
		
		Divide(BigInteger divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;
			
			result = result.divide(this.divisor);	
			
			return result;
		}		
	}
	
	
	static final class Module extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger module;
		
		Module(BigInteger module) {
			super();
			this.module = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.mod(this.module);
		}	
	}
	
	static final class Remainder extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger divisor;
		
		Remainder(BigInteger module) {
			super();
			this.divisor = module;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final BigInteger multiplicand;
		
		Multiply(BigInteger multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.multiply(this.multiplicand);			
			return result;
		}	
	}
	
	static final class Pow extends AbstractNullAsNullFunction<BigInteger, BigInteger> {

		private final int power;
		
		Pow(int power) {
			super();
			this.power = power;
		}
		
		@Override
		protected BigInteger nullAsNullExecute(final BigInteger input, final ExecCtx ctx) throws Exception {
			BigInteger result = input;			
			result = result.pow(this.power);			
			return result;
		}		
	}
}
