package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.lang.Validate;

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

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        public Div() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }
        
        public Div(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        public Div(final MathContext mathContext) {
            super();
            this.roundingMode = null;
            this.mathContext = mathContext;
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
            if (this.roundingMode != null) {
                return fromNumber(bLeft.divide(bRight, this.roundingMode));
            }
            if (this.mathContext != null) {
                return fromNumber(bLeft.divide(bRight, this.mathContext));
            }
            return fromNumber(bLeft.divide(bRight, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Remainder<T extends Number> extends Reductor<Number,Number,T> {

        private final MathContext mathContext;
        
        public Remainder() {
            super();
            this.mathContext = null;
        }
        
        public Remainder(final MathContext mathContext) {
            super();
            this.mathContext = mathContext;
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
            if (this.mathContext != null) {
                return fromNumber(bLeft.remainder(bRight, this.mathContext));
            }
            return fromNumber(bLeft.remainder(bRight)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class Avg<T extends Number> extends Reductor<Number,Number,T> {

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
        protected T reduce(final Number left, final Number right, final ExecCtx ctx) {
            if (left == null) {
                return fromNumber(right);
            }
            if (right == null) {
                return fromNumber(left);
            }
            BigDecimal bLeft = FnReduceOfNumber.toBigDecimal(left);
            BigDecimal bRight = FnReduceOfNumber.toBigDecimal(right);
            if (this.roundingMode != null) {
                return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), this.roundingMode));
            }
            if (this.mathContext != null) {
                return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), this.mathContext));
            }
            return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    
}
