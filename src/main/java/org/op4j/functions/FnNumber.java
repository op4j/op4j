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
import java.math.BigInteger;
import java.math.RoundingMode;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FnNumber {

    
    private static final ToBigDecimal TO_BIG_DECIMAL = new ToBigDecimal();
    private static final ToBigInteger TO_BIG_INTEGER = new ToBigInteger();
    private static final ToDouble TO_DOUBLE = new ToDouble();
    private static final ToFloat TO_FLOAT = new ToFloat();
    private static final ToLong TO_LONG = new ToLong();
    private static final ToInteger TO_INTEGER = new ToInteger();
    private static final ToShort TO_SHORT = new ToShort();
    private static final ToByte TO_BYTE = new ToByte();
    private static final ToBoolean TO_BOOLEAN = new ToBoolean();

    
    
	private FnNumber() {
		super();           
	}

	
	
	
	public static final IFunction<Number,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    public static final IFunction<Number,BigDecimal> toBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new ToBigDecimal(scale, roundingMode);
    }
    
    
    public static final IFunction<Number,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }
    
    public static final IFunction<Number,BigInteger> toBigInteger(final RoundingMode roundingMode) {
        return new ToBigInteger(roundingMode);
    }
    
    
    public static final IFunction<Number,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    public static final IFunction<Number,Double> toDouble(final int scale, final RoundingMode roundingMode) {
        return new ToDouble(scale, roundingMode);
    }
    
    
    public static final IFunction<Number,Float> toFloat() {
        return TO_FLOAT;
    }
    
    public static final IFunction<Number,Float> toFloat(final int scale, final RoundingMode roundingMode) {
        return new ToFloat(scale, roundingMode);
    }
    
    
    public static final IFunction<Number,Long> toLong() {
        return TO_LONG;
    }
    
    public static final IFunction<Number,Long> toLong(final RoundingMode roundingMode) {
        return new ToLong(roundingMode);
    }
    
    
    public static final IFunction<Number,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    public static final IFunction<Number,Integer> toInteger(final RoundingMode roundingMode) {
        return new ToInteger(roundingMode);
    }
    
    
    public static final IFunction<Number,Short> toShort() {
        return TO_SHORT;
    }
    
    public static final IFunction<Number,Short> toShort(final RoundingMode roundingMode) {
        return new ToShort(roundingMode);
    }
    
    
    public static final IFunction<Number,Byte> toByte() {
        return TO_BYTE;
    }
    
    public static final IFunction<Number,Byte> toByte(final RoundingMode roundingMode) {
        return new ToByte(roundingMode);
    }
    
    
    
    public static final IFunction<Number,Boolean> toBoolean() {
        return TO_BOOLEAN;
    }
	

    
    
    public static final IFunction<BigDecimal,BigDecimal> roundBigDecimal(final int scale, final RoundingMode roundingMode) {
        return new RoundBigDecimal(scale, roundingMode);
    }
    
    public static final IFunction<Float,Float> roundFloat(final int scale, final RoundingMode roundingMode) {
        return new RoundFloat(scale, roundingMode);
    }
    
    public static final IFunction<Double,Double> roundDouble(final int scale, final RoundingMode roundingMode) {
        return new RoundDouble(scale, roundingMode);
    }
    
	

	
	
    
    private static abstract class ToNumber<X extends Number> extends AbstractNullAsNullFunction<Number,X> {

        protected ToNumber() {
            super();
        }

        @Override
        public final X nullAsNullExecute(final Number number, final ExecCtx ctx) throws Exception {
            return fromNumber(number);
        }
        
        abstract X fromNumber(final Number number);
        
    }
    
    

    
    private static abstract class ToNonDecimalNumber<X extends Number> extends ToNumber<X> {
        
        private final RoundingMode roundingMode;

        
        ToNonDecimalNumber() {
            super();
            this.roundingMode = null;
        }

        
        ToNonDecimalNumber(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
        }
        
        
        @Override
        final X fromNumber(final Number number) {
            
            if (this.roundingMode == null) {
                return fromNumberToNonDecimal(number);
            }
            
            BigDecimal bigDecimal = 
                new BigDecimal(number.doubleValue());
            bigDecimal = bigDecimal.setScale(0, this.roundingMode);
            return fromNumberToNonDecimal(bigDecimal);

        }
        
        abstract X fromNumberToNonDecimal(final Number number);
        
    }
    

    
    
    private static abstract class ToDecimalNumber<X extends Number> extends ToNumber<X> {

        private final int scale;
        private final RoundingMode roundingMode;
        
        
        ToDecimalNumber() {
            super();
            this.scale = 0;
            this.roundingMode = null;
        }

        
        ToDecimalNumber(final int scale, final RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "A rounding mode must be specified");
            this.scale = scale;
            this.roundingMode = roundingMode;
        }
        
        
        @Override
        final X fromNumber(final Number number) {
            
            if (this.roundingMode == null) {
                return fromNumberToDecimal(number);
            }
            
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(this.scale, this.roundingMode);
            return fromNumberToDecimal(bigDecimal);
            
        }
        
        abstract X fromNumberToDecimal(final Number number);
        
    }
    
    
    
    
	
	static final class ToBigDecimal extends ToDecimalNumber<BigDecimal> {

	    
        ToBigDecimal() {
            super();
        }

        ToBigDecimal(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        BigDecimal fromNumberToDecimal(final Number number) {
            if (number instanceof BigDecimal) {
                return new BigDecimal(
                        ((BigDecimal)number).unscaledValue(),
                        ((BigDecimal)number).scale());
            } else if (number instanceof BigInteger) {
                return new BigDecimal((BigInteger)number);
            } else {
                return BigDecimal.valueOf(number.doubleValue()); 
            }
        }

	}
    
    
    
    static final class ToDouble extends ToDecimalNumber<Double> {

        
        ToDouble() {
            super();
        }

        ToDouble(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        Double fromNumberToDecimal(final Number number) {
            return Double.valueOf(number.doubleValue());
        }

    }
    
    
    
    static final class ToFloat extends ToDecimalNumber<Float> {

        
        ToFloat() {
            super();
        }

        ToFloat(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        
        @Override
        Float fromNumberToDecimal(final Number number) {
            return Float.valueOf(number.floatValue());
        }

    }
    
    
    
    static final class ToBigInteger extends ToNonDecimalNumber<BigInteger> {

        
        ToBigInteger() {
            super();
        }

        ToBigInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        
        @Override
        BigInteger fromNumberToNonDecimal(final Number number) {
            if (number instanceof BigInteger) {
                return new BigInteger(((BigInteger)number).toByteArray());
            } else if (number instanceof BigDecimal) {
                return ((BigDecimal)number).toBigInteger();
            } else if (number instanceof Double) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            } else if (number instanceof Float) {
                return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
            }
            return BigInteger.valueOf(number.longValue());
        }

    }
    
    
    
    static final class ToLong extends ToNonDecimalNumber<Long> {
        
        ToLong() {
            super();
        }

        ToLong(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Long fromNumberToNonDecimal(final Number number) {
            return Long.valueOf(number.longValue());
        }

    }
    
    
    
    static final class ToInteger extends ToNonDecimalNumber<Integer> {
        
        ToInteger() {
            super();
        }

        ToInteger(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Integer fromNumberToNonDecimal(final Number number) {
            return Integer.valueOf(number.intValue());
        }

    }
    
    
    
    static final class ToShort extends ToNonDecimalNumber<Short> {
        
        ToShort() {
            super();
        }

        ToShort(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Short fromNumberToNonDecimal(final Number number) {
            return Short.valueOf(number.shortValue());
        }

    }
	
    
    
    static final class ToByte extends ToNonDecimalNumber<Byte> {
        
        ToByte() {
            super();
        }

        ToByte(final RoundingMode roundingMode) {
            super(roundingMode);
        }
        
        @Override
        Byte fromNumberToNonDecimal(final Number number) {
            return Byte.valueOf(number.byteValue());
        }

    }


    
    
    static final class ToBoolean extends AbstractNullAsNullFunction<Number,Boolean> {
        
        ToBoolean() {
            super();
        }

        
        @Override
        protected Boolean nullAsNullExecute(final Number number, final ExecCtx ctx) throws Exception {
            return Boolean.valueOf((number.doubleValue() != 0.0));
        }

    }
    
    
    
    
    
    static final class RoundBigDecimal extends AbstractNullAsNullFunction<BigDecimal,BigDecimal> {

        private final ToBigDecimal toBigDecimal;
        
        RoundBigDecimal(final int scale, final RoundingMode roundingMode) {
            super();
            this.toBigDecimal = new ToBigDecimal(scale, roundingMode);
        }

        
        @Override
        protected BigDecimal nullAsNullExecute(final BigDecimal object, final ExecCtx ctx) throws Exception {
            return this.toBigDecimal.execute(object, ctx);
        }

    }
    
    
    
    static final class RoundDouble extends AbstractNullAsNullFunction<Double,Double> {

        private final ToDouble toDouble;
        
        RoundDouble(final int scale, final RoundingMode roundingMode) {
            super();
            this.toDouble = new ToDouble(scale, roundingMode);
        }

        
        @Override
        protected Double nullAsNullExecute(final Double object, final ExecCtx ctx) throws Exception {
            return this.toDouble.execute(object, ctx);
        }

    }
    
    
    
    static final class RoundFloat extends AbstractNullAsNullFunction<Float,Float> {

        private final ToFloat toFloat;
        
        RoundFloat(final int scale, final RoundingMode roundingMode) {
            super();
            this.toFloat = new ToFloat(scale, roundingMode);
        }

        
        @Override
        protected Float nullAsNullExecute(final Float object, final ExecCtx ctx) throws Exception {
            return this.toFloat.execute(object, ctx);
        }

    }
    
}
