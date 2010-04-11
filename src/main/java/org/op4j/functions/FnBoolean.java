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

import org.apache.commons.lang.Validate;
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
    private static final Negate NEGATE = new Negate();
    private static final Function<Object,Boolean> IS_TRUE = eq(true);
    private static final Function<Object,Boolean> IS_FALSE = eq(false); 

    
    
	private FnBoolean() {
		super();           
	}

	
	public static final Function<Number,Boolean> toBoolean() {
        return FnNumber.toBoolean();
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

    public static final Function<Boolean,Boolean> negate() {
        return NEGATE;
    }
    
	

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final Boolean object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return true if both objects are equal, false if not.
     */
    public static final Function<Object,Boolean> eq(final boolean object) {
        return FnObject.eq(object);
    }

    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final Boolean object) {
        return FnObject.notEq(object);
    }
    
    
    /**
     * <p>
     * Determines whether the target object and the specified object are NOT equal
     * by calling the <tt>equals</tt> method on the target object.
     * </p>
     * 
     * @param object the object to compare to the target
     * @return false if both objects are equal, true if not.
     */
    public static final Function<Object,Boolean> notEq(final boolean object) {
        return FnObject.notEq(object);
    }


    
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final Boolean object) {
        return FnFunc.by(by, eq(object));
    }
    
    public static final <X> Function<X,Boolean> eqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, eq(object));
    }
    
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final Boolean object) {
        return FnFunc.by(by, notEq(object));
    }
    
    public static final <X> Function<X,Boolean> notEqBy(final IFunction<X,?> by, final boolean object) {
        return FnFunc.by(by, notEq(object));
    }

    
    
    
    public static final Function<Object,Boolean> isTrue() {
        return IS_TRUE;
    }
    
    public static final Function<Object,Boolean> isFalse() {
        return IS_FALSE;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static final <X, R extends X> Function<R,Boolean> and(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return new And<X,R>(left, right);
    }
    
    public static final <X, R extends X> Function<R,Boolean> or(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return new Or<X,R>(left, right);
    }
    
    public static final <T> Function<T,Boolean> not(final IFunction<T, Boolean> function) {
        return new Not<T>(function);
    }

    
    
    public static final <X,Y> Function<X,Boolean> by(final IFunction<X,Y> by, final IFunction<? super Y, Boolean> eval) {
        return FnFunc.by(by, eval);
    }
    
    
    
    
    public static final Function<Object,Boolean> isNull() {
        return FnObject.isNull();
    }
    
    public static final Function<Object,Boolean> isNotNull() {
        return FnObject.isNotNull();
    }
    
    public static final <X> Function<X,Boolean> isNullBy(final IFunction<X,?> by) {
        return by(by, FnObject.isNull());
    }
    
    public static final <X> Function<X,Boolean> isNotNullBy(final IFunction<X,?> by) {
        return by(by, FnObject.isNotNull());
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

    
 
    
    
    

    
    
    
    static class Negate extends AbstractNullAsNullFunction<Boolean, Boolean> {

        public Negate() {
            super();
        }

        @Override
        protected Boolean nullAsNullExecute(final Boolean object, final ExecCtx ctx) throws Exception {
            return (object.booleanValue()? Boolean.FALSE : Boolean.TRUE);
        }
        
        
    }
    
    
    
    
    static class And<X,R extends X> extends Function<R, Boolean> {

        private final IFunction<X,Boolean> left;
        private final IFunction<? super R,Boolean> right;
        
        public And(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
            super();
            Validate.notNull(left, "Null function found: None of the specified functions can be null");
            Validate.notNull(right, "Null function found: None of the specified functions can be null");
            this.left = left;
            this.right = right;
        }

        public Boolean execute(final R object, final ExecCtx ctx) throws Exception {
            
            Boolean result = this.left.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"and\"");
            }
            if (!result.booleanValue()) {
                return Boolean.FALSE;
            }
            result = this.right.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"and\"");
            }
            if (!result.booleanValue()) {
                return Boolean.FALSE;
            }
                
            return Boolean.TRUE;
            
        }
        
        
    }
    
    
    
    
    static class Or<X,R extends X> extends Function<R, Boolean> {

        private final IFunction<X,Boolean> left;
        private final IFunction<? super R,Boolean> right;
        
        public Or(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
            super();
            Validate.notNull(left, "Null function found: None of the specified functions can be null");
            Validate.notNull(right, "Null function found: None of the specified functions can be null");
            this.left = left;
            this.right = right;
        }

        public Boolean execute(final R object, final ExecCtx ctx) throws Exception {
            
            Boolean result = this.left.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.TRUE;
            }
            
            result = this.right.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.TRUE;
            }
                
            return Boolean.FALSE;
            
        }
        
        
    }
    



    
    
    static class Not<T> extends Function<T, Boolean> {

        private final IFunction<T,Boolean> function;
        
        public Not(final IFunction<T,Boolean> function) {
            super();
            Validate.notNull(function, "Null function found: None of the specified functions can be null");
            this.function = function;
        }

        public Boolean execute(final T object, final ExecCtx ctx) throws Exception {
            final Boolean result = this.function.execute(object, ctx);
            if (result == null) {
                throw new ExecutionException("Evaluation function returned null, which is " +
                        "not allowed executing \"or\"");
            }
            if (result.booleanValue()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
        
        
    }


}
