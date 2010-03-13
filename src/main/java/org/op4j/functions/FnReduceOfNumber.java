package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;

final class FnReduceOfNumber<T extends Number> {
    

    
    private FnReduceOfNumber() {
        super();
    }

    
    static BigDecimal toBigDecimal(final Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        } else if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger)number);
        }
        return BigDecimal.valueOf(number.doubleValue());
    }
    
    
    
    static abstract class Sum<T extends Number> extends Reductor<Number,Number,T> {

        public Sum() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.add(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Subt<T extends Number> extends Reductor<Number,Number,T> {

        public Subt() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.subtract(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Mult<T extends Number> extends Reductor<Number,Number,T> {

        public Mult() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.multiply(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Div<T extends Number> extends Reductor<Number,Number,T> {

        public Div() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.divide(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Mod<T extends Number> extends Reductor<Number,Number,T> {

        public Mod() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.remainder(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Avg<T extends Number> extends Reductor<Number,Number,T> {

        public Avg() {
            super();
        }

        @Override
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d))); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    
}
