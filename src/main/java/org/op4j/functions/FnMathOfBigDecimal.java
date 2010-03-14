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
import java.math.BigInteger;
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
public final class FnMathOfBigDecimal {

	private static final Function<Iterable<BigDecimal>, BigDecimal> MAX_FUNC = new Max();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> MIN_FUNC = new Min();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> SUM_FUNC = new Sum();
	
	private static final Function<Iterable<BigDecimal>, BigDecimal> AVG_FUNC = new Avg();

    private static final Function<BigDecimal[], BigDecimal> MAX_ARRAY_FUNC = new MaxArray();
    
    private static final Function<BigDecimal[], BigDecimal> MIN_ARRAY_FUNC = new MinArray();
    
    private static final Function<BigDecimal[], BigDecimal> SUM_ARRAY_FUNC = new SumArray();
    
    private static final Function<BigDecimal[], BigDecimal> AVG_ARRAY_FUNC = new AvgArray();
	
	private static final Function<BigDecimal, BigDecimal> ABS_FUNC = new Abs();
	
	
	FnMathOfBigDecimal() {
		super();           
	}

    /**
     * @return function that returns the maximum {@link BigDecimal} of an object
     *         implementing {@link Iterable}
     */
    public final Function<Iterable<BigDecimal>, BigDecimal> max() {
        return MAX_FUNC;
    }

    /**
     * @return function that returns the minimum {@link BigDecimal} of an object
     *         implementing {@link Iterable}
     */
    public final Function<Iterable<BigDecimal>, BigDecimal> min() {
        return MIN_FUNC;
    }

    /**
     * @return function that returns the sum of the {@link BigDecimal} elements
     *         in an object implementing {@link Iterable}
     */
    public final Function<Iterable<BigDecimal>, BigDecimal> sum() {
        return SUM_FUNC;
    }

    /**
     * @return function that returns the average of the {@link BigDecimal}
     *         elements in an object implementing {@link Iterable}
     */
    public final Function<Iterable<BigDecimal>, BigDecimal> avg() {
        return AVG_FUNC;
    }

    public final Function<Iterable<BigDecimal>, BigDecimal> avg(MathContext mathContext) {
        return new Avg(mathContext);
    }

    public final Function<Iterable<BigDecimal>, BigDecimal> avg(RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }

    public final Function<BigDecimal[], BigDecimal> maxArray() {
        return MAX_ARRAY_FUNC;
    }

    public final Function<BigDecimal[], BigDecimal> minArray() {
        return MIN_ARRAY_FUNC;
    }

    public final Function<BigDecimal[], BigDecimal> sumArray() {
        return SUM_ARRAY_FUNC;
    }

    public final Function<BigDecimal[], BigDecimal> avgArray() {
        return AVG_ARRAY_FUNC;
    }

    public final Function<BigDecimal[], BigDecimal> avgArray(MathContext mathContext) {
        return new AvgArray(mathContext);
    }

    public final Function<BigDecimal[], BigDecimal> avgArray(RoundingMode roundingMode) {
        return new AvgArray(roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> round(MathContext mathContext) {
        return new Round(mathContext);
    }

    public final Function<BigDecimal, BigDecimal> round(RoundingMode roundingMode) {
        return new Round(roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> abs() {
        return ABS_FUNC;
    }

    public final Function<BigDecimal, BigDecimal> add(Number add) {
        return new Add(fromNumber(add));
    }

    public final Function<BigDecimal, BigDecimal> add(byte add) {
        return add(Byte.valueOf(add));
    }

    public final Function<BigDecimal, BigDecimal> add(short add) {
        return add(Short.valueOf(add));
    }

    public final Function<BigDecimal, BigDecimal> add(int add) {
        return add(Integer.valueOf(add));
    }

    public final Function<BigDecimal, BigDecimal> add(long add) {
        return add(Long.valueOf(add));
    }

    public final Function<BigDecimal, BigDecimal> add(float add) {
        return add(Float.valueOf(add));
    }

    public final Function<BigDecimal, BigDecimal> add(double add) {
        return add(Double.valueOf(add));
    }


    public final Function<BigDecimal, BigDecimal> subtract(Number subtract) {
        return new Subtract(fromNumber(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(byte subtract) {
        return subtract(Byte.valueOf(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(short subtract) {
        return subtract(Short.valueOf(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(int subtract) {
        return subtract(Integer.valueOf(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(long subtract) {
        return subtract(Long.valueOf(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(float subtract) {
        return subtract(Float.valueOf(subtract));
    }

    public final Function<BigDecimal, BigDecimal> subtract(double subtract) {
        return subtract(Double.valueOf(subtract));
    }


    public final Function<BigDecimal, BigDecimal> divideBy(Number divisor) {
        return new Divide(fromNumber(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(byte divisor) {
        return divideBy(Byte.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(short divisor) {
        return divideBy(Short.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(int divisor) {
        return divideBy(Integer.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(long divisor) {
        return divideBy(Long.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(float divisor) {
        return divideBy(Float.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> divideBy(double divisor) {
        return divideBy(Double.valueOf(divisor));
    }


    public final Function<BigDecimal, BigDecimal> divideBy(Number divisor, MathContext mathContext) {
        return new Divide(fromNumber(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(byte divisor, MathContext mathContext) {
        return divideBy(Byte.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(short divisor, MathContext mathContext) {
        return divideBy(Short.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(int divisor, MathContext mathContext) {
        return divideBy(Integer.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(long divisor, MathContext mathContext) {
        return divideBy(Long.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(float divisor, MathContext mathContext) {
        return divideBy(Float.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(double divisor, MathContext mathContext) {
        return divideBy(Double.valueOf(divisor), mathContext);
    }


    public final Function<BigDecimal, BigDecimal> divideBy(Number divisor, RoundingMode roundingMode) {
        return new Divide(fromNumber(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(byte divisor, RoundingMode roundingMode) {
        return divideBy(Byte.valueOf(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(short divisor, RoundingMode roundingMode) {
        return divideBy(Short.valueOf(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(int divisor, RoundingMode roundingMode) {
        return divideBy(Integer.valueOf(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(long divisor, RoundingMode roundingMode) {
        return divideBy(Long.valueOf(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(float divisor, RoundingMode roundingMode) {
        return divideBy(Float.valueOf(divisor), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> divideBy(double divisor, RoundingMode roundingMode) {
        return divideBy(Double.valueOf(divisor), roundingMode);
    }

    

    public final Function<BigDecimal, BigDecimal> remainder(Number divisor) {
        return new Remainder(fromNumber(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(byte divisor) {
        return remainder(Byte.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(short divisor) {
        return remainder(Short.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(int divisor) {
        return remainder(Integer.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(long divisor) {
        return remainder(Long.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(float divisor) {
        return remainder(Float.valueOf(divisor));
    }

    public final Function<BigDecimal, BigDecimal> remainder(double divisor) {
        return remainder(Double.valueOf(divisor));
    }


    public final Function<BigDecimal, BigDecimal> remainder(Number divisor, MathContext mathContext) {
        return new Remainder(fromNumber(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(byte divisor, MathContext mathContext) {
        return remainder(Byte.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(short divisor, MathContext mathContext) {
        return remainder(Short.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(int divisor, MathContext mathContext) {
        return remainder(Integer.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(long divisor, MathContext mathContext) {
        return remainder(Long.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(float divisor, MathContext mathContext) {
        return remainder(Float.valueOf(divisor), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> remainder(double divisor, MathContext mathContext) {
        return remainder(Double.valueOf(divisor), mathContext);
    }


    public final Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand) {
        return new Multiply(fromNumber(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand) {
        return multiplyBy(Byte.valueOf(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand) {
        return multiplyBy(Short.valueOf(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand) {
        return multiplyBy(Integer.valueOf(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand) {
        return multiplyBy(Long.valueOf(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand) {
        return multiplyBy(Float.valueOf(multiplicand));
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand) {
        return multiplyBy(Double.valueOf(multiplicand));
    }


    public final Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand, MathContext mathContext) {
        return new Multiply(fromNumber(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand, MathContext mathContext) {
        return multiplyBy(Byte.valueOf(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand, MathContext mathContext) {
        return multiplyBy(Short.valueOf(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand, MathContext mathContext) {
        return multiplyBy(Integer.valueOf(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand, MathContext mathContext) {
        return multiplyBy(Long.valueOf(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand, MathContext mathContext) {
        return multiplyBy(Float.valueOf(multiplicand), mathContext);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand, MathContext mathContext) {
        return multiplyBy(Double.valueOf(multiplicand), mathContext);
    }


    public final Function<BigDecimal, BigDecimal> multiplyBy(Number multiplicand, RoundingMode roundingMode) {
        return new Multiply(fromNumber(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(byte multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Byte.valueOf(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(short multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Short.valueOf(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(int multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Integer.valueOf(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(long multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Long.valueOf(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(float multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Float.valueOf(multiplicand), roundingMode);
    }

    public final Function<BigDecimal, BigDecimal> multiplyBy(double multiplicand, RoundingMode roundingMode) {
        return multiplyBy(Double.valueOf(multiplicand), roundingMode);
    }


    public final Function<BigDecimal, BigDecimal> pow(int power) {
        return new Pow(power);
    }

    public final Function<BigDecimal, BigDecimal> pow(int power, MathContext mathContext) {
        return new Pow(power, mathContext);
    }

    public final Function<BigDecimal, BigDecimal> pow(int power, RoundingMode roundingMode) {
        return new Pow(power, roundingMode);
    }	
	
	
	
	private static BigDecimal fromNumber(final Number number) {
	    if (number == null) {
	        return null;
	    }
	    if (number instanceof BigDecimal) {
	        return (BigDecimal) number;
	    }
	    if (number instanceof BigInteger) {
	        return new BigDecimal((BigInteger)number);
	    }
	    return BigDecimal.valueOf(number.doubleValue());
	}
	
	
	
	
	static final class Max extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Max() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
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
	
	static final class Min extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Min() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
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
	
	static final class Sum extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

		Sum() {
			super();
		}

		@Override
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			BigDecimal sum = BigDecimal.valueOf(0);
			for (BigDecimal number : input) {
				if (number != null) {
					sum = sum.add(number);
				}
			}	
			return sum;
		}		
	}
	
	static final class Avg extends AbstractNotNullFunction<Iterable<BigDecimal>,BigDecimal> {

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
		protected BigDecimal notNullExecute(final Iterable<BigDecimal> input, final ExecCtx ctx) throws Exception {
			
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
			return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR);
		}		
	}

	
	
	
	
    
    
    static final class MaxArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        MaxArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigDecimal max = input[0];
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
    
    static final class MinArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        MinArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                return null;
            }
            BigDecimal min = input[0];
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
    
    static final class SumArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        SumArray() {
            super();
        }

        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            BigDecimal sum = BigDecimal.valueOf(0);
            for (BigDecimal number : input) {
                if (number != null) {
                    sum = sum.add(number);
                }
            }   
            return sum;
        }       
    }
    
    static final class AvgArray extends AbstractNotNullFunction<BigDecimal[],BigDecimal> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        AvgArray() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }

        AvgArray(RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        AvgArray(MathContext mathContext) {
            super();
            Validate.notNull(mathContext, "MathContext can't be null");
            this.roundingMode = null;
            this.mathContext = mathContext;
        }
        
        @Override
        protected BigDecimal notNullExecute(final BigDecimal[] input, final ExecCtx ctx) throws Exception {
            
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
            return sum.divide(BigDecimal.valueOf(countNotNull), RoundingMode.FLOOR);
        }       
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static final class Round extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Round(RoundingMode roundingMode) {
			super();
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Round(MathContext mathContext) {
			super();
			Validate.notNull(mathContext, "MathContext can't be null");
			this.mathContext = mathContext;
			this.roundingMode = null;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			if (this.roundingMode != null) {
				return result.setScale(0, this.roundingMode);
			}			
			return result.round(this.mathContext);
		}	
	}
	
	static final class Abs extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		Abs() {
			super();
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			return input.abs();
		}
	}
	
	static final class Add extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal add;
		
		Add(BigDecimal add) {
			super();
			Validate.notNull(add, "Number to be added can't be null");
			this.add = add;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.add(this.add);
				
			return result;
		}	
	}
	
	static final class Subtract extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal subtract;
		
		Subtract(BigDecimal subtract) {
			super();
			Validate.notNull(subtract, "Number to be subtracted can't be null");
			Validate.notNull(subtract, "Number to be added can't be null");
			this.subtract = subtract;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			result = result.subtract(this.subtract);
				
			return result;
		}		
	}
	
	static final class Divide extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final RoundingMode roundingMode;
		private final MathContext mathContext;
		
		Divide(BigDecimal divisor) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, RoundingMode roundingMode) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.divisor = divisor;
			this.roundingMode = roundingMode;
			this.mathContext = null;
		}
		
		Divide(BigDecimal divisor, MathContext mathContext) {
			super();
			Validate.notNull(divisor, "Divisor can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.divisor = divisor;
			this.roundingMode = null;
			this.mathContext = mathContext;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			BigDecimal result = input;
			
			if (this.roundingMode != null) {
				result = result.divide(this.divisor, this.roundingMode);					
			} else if (this.mathContext != null) {
				result = result.divide(this.divisor, this.mathContext);				
			} else {
				result = result.divide(this.divisor, RoundingMode.FLOOR);	
			}
			return result;
		}		
	}
	
	
	static final class Remainder extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal divisor;
		private final MathContext mathContext;
		
		Remainder(BigDecimal divisor) {
			super();
			this.divisor = divisor;
			this.mathContext = null;
		}
		
		Remainder(BigDecimal divisor, MathContext mathContext) {
			super();
			this.divisor = divisor;
			this.mathContext = mathContext;
		}
		
		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
			if (this.mathContext != null) {
				return input.remainder(this.divisor, this.mathContext);
			}
			return input.remainder(this.divisor);
		}	
	}
	
	static final class Multiply extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

		private final BigDecimal multiplicand;
		private final MathContext mathContext;
		private final RoundingMode roundingMode;
		
		Multiply(BigDecimal multiplicand) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = null;
		}
		
		Multiply(BigDecimal multiplicand, RoundingMode roundingMode) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(roundingMode, "RoundingMode can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = null;
			this.roundingMode = roundingMode;
		}
		
		Multiply(BigDecimal multiplicand, MathContext mathContext) {
			super();
			Validate.notNull(multiplicand, "Multiplicand can't be null");
			Validate.notNull(mathContext, "MathContext can't be null");
			this.multiplicand = multiplicand;
			this.mathContext = mathContext;
			this.roundingMode = null;
		}

		@Override
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
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
	
	static final class Pow extends AbstractNullAsNullFunction<BigDecimal, BigDecimal> {

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
		protected BigDecimal nullAsNullExecute(final BigDecimal input, final ExecCtx ctx) throws Exception {
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
