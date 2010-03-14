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

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;

/**
 * 
 * @since 1.0
 * 
 * @author Soraya S&aacute;nchez
 *
 */
public final class FnBoolean {

    
    private static final ToNumber<BigDecimal> TO_BIG_DECIMAL = new ToNumber<BigDecimal>(Types.BIG_DECIMAL);
    private static final ToNumber<BigInteger> TO_BIG_INTEGER = new ToNumber<BigInteger>(Types.BIG_INTEGER);
    private static final ToNumber<Double> TO_DOUBLE = new ToNumber<Double>(Types.DOUBLE);
    private static final ToNumber<Float> TO_FLOAT = new ToNumber<Float>(Types.FLOAT);
    private static final ToNumber<Long> TO_LONG = new ToNumber<Long>(Types.LONG);
    private static final ToNumber<Integer> TO_INTEGER = new ToNumber<Integer>(Types.INTEGER);
    private static final ToNumber<Short> TO_SHORT = new ToNumber<Short>(Types.SHORT);
    private static final ToNumber<Byte> TO_BYTE = new ToNumber<Byte>(Types.BYTE);
    private static final Not NOT = new Not();

    
    
	private FnBoolean() {
		super();           
	}

	
	
	
	public static final Function<Boolean,BigDecimal> toBigDecimal() {
        return TO_BIG_DECIMAL;
    }
    
    
    public static final Function<Boolean,BigInteger> toBigInteger() {
        return TO_BIG_INTEGER;
    }
    
    
    public static final Function<Boolean,Double> toDouble() {
        return TO_DOUBLE;
    }
    
    
    public static final Function<Boolean,Float> toFloat() {
        return TO_FLOAT;
    }
    
    
    public static final Function<Boolean,Long> toLong() {
        return TO_LONG;
    }
    
    
    public static final Function<Boolean,Integer> toInteger() {
        return TO_INTEGER;
    }
    
    
    public static final Function<Boolean,Short> toShort() {
        return TO_SHORT;
    }
    
    
    public static final Function<Boolean,Byte> toByte() {
        return TO_BYTE;
    }

    public static final Function<Boolean,Boolean> not() {
        return NOT;
    }
    
	

	
	
    
    static final class ToNumber<X extends Number> extends AbstractNullAsNullFunction<Boolean,X> {

        private final Number trueValue;
        private final Number falseValue;
        
        
        protected ToNumber(final Type<X> type) {
            super();
            if (type.equals(Types.BIG_DECIMAL)) {
                this.trueValue = BigDecimal.valueOf(1);
                this.falseValue = BigDecimal.valueOf(0);
            } else if (type.equals(Types.BIG_INTEGER)) {
                this.trueValue = BigInteger.valueOf(1);
                this.falseValue = BigInteger.valueOf(0);
            } else if (type.equals(Types.DOUBLE)) {
                this.trueValue = Double.valueOf(1);
                this.falseValue = Double.valueOf(0);
            } else if (type.equals(Types.FLOAT)) {
                this.trueValue = Float.valueOf(1);
                this.falseValue = Float.valueOf(0);
            } else if (type.equals(Types.LONG)) {
                this.trueValue = Long.valueOf(1);
                this.falseValue = Long.valueOf(0);
            } else if (type.equals(Types.INTEGER)) {
                this.trueValue = Integer.valueOf(1);
                this.falseValue = Integer.valueOf(0);
            } else if (type.equals(Types.SHORT)) {
                this.trueValue = Short.valueOf((short)1);
                this.falseValue = Short.valueOf((short)0);
            } else if (type.equals(Types.BYTE)) {
                this.trueValue = Byte.valueOf((byte)1);
                this.falseValue = Byte.valueOf((byte)0);
            } else {
                throw new ExecutionException("Unsupported type \"" + type + "\"");
            }
        }

        
        @Override
        @SuppressWarnings("unchecked")
        public final X nullAsNullExecute(final Boolean number, final ExecCtx ctx) throws Exception {
            return (number.booleanValue()? (X) this.trueValue : (X) this.falseValue);
        }
        
    }

    
    
    
    
    static class Not extends AbstractNullAsNullFunction<Boolean, Boolean> {

        public Not() {
            super();
        }

        @Override
        protected Boolean nullAsNullExecute(final Boolean object, final ExecCtx ctx) throws Exception {
            return (object.booleanValue()? Boolean.FALSE : Boolean.TRUE);
        }
        
        
    }
    
}
