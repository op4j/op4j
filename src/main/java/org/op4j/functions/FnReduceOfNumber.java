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
    
    
    
    static abstract class DecimalSum<T extends Number> extends Reductor<Number,Number,T> {

        public DecimalSum() {
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

    
    static abstract class DecimalSubt<T extends Number> extends Reductor<Number,Number,T> {

        public DecimalSubt() {
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

    
    static abstract class DecimalMult<T extends Number> extends Reductor<Number,Number,T> {

        public DecimalMult() {
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

    
    static abstract class DecimalDiv<T extends Number> extends Reductor<Number,Number,T> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        public DecimalDiv() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }
        
        public DecimalDiv(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        public DecimalDiv(final MathContext mathContext) {
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

    
    static abstract class DecimalRemainder<T extends Number> extends Reductor<Number,Number,T> {

        private final MathContext mathContext;
        
        public DecimalRemainder() {
            super();
            this.mathContext = null;
        }
        
        public DecimalRemainder(final MathContext mathContext) {
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

    
    static abstract class DecimalAvg<T extends Number> extends Reductor<Number,Number,T> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        DecimalAvg() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }

        DecimalAvg(RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        DecimalAvg(MathContext mathContext) {
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


    
    
    
    
    
    
    
    
    static abstract class NonDecimalSum<T extends Number> extends Reductor<Number,Number,T> {

        public NonDecimalSum() {
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
            return fromNumber(bLeft.add(bRight).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class NonDecimalSubt<T extends Number> extends Reductor<Number,Number,T> {

        public NonDecimalSubt() {
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
            return fromNumber(bLeft.subtract(bRight).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class NonDecimalMult<T extends Number> extends Reductor<Number,Number,T> {

        public NonDecimalMult() {
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
            return fromNumber(bLeft.multiply(bRight).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class NonDecimalDiv<T extends Number> extends Reductor<Number,Number,T> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        public NonDecimalDiv() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }
        
        public NonDecimalDiv(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        public NonDecimalDiv(final MathContext mathContext) {
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
                return fromNumber(bLeft.divide(bRight, this.roundingMode).setScale(0, this.roundingMode));
            }
            if (this.mathContext != null) {
                return fromNumber(bLeft.divide(bRight, this.mathContext).setScale(0, this.mathContext.getRoundingMode()));
            }
            return fromNumber(bLeft.divide(bRight, RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class NonDecimalRemainder<T extends Number> extends Reductor<Number,Number,T> {

        private final MathContext mathContext;
        
        public NonDecimalRemainder() {
            super();
            this.mathContext = null;
        }
        
        public NonDecimalRemainder(final MathContext mathContext) {
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
                return fromNumber(bLeft.remainder(bRight, this.mathContext).setScale(0, this.mathContext.getRoundingMode()));
            }
            return fromNumber(bLeft.remainder(bRight).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }

    
    static abstract class NonDecimalAvg<T extends Number> extends Reductor<Number,Number,T> {

        private final RoundingMode roundingMode;
        private final MathContext mathContext;
        
        NonDecimalAvg() {
            super();
            this.roundingMode = null;
            this.mathContext = null;
        }

        NonDecimalAvg(RoundingMode roundingMode) {
            super();
            Validate.notNull(roundingMode, "RoundingMode can't be null");
            this.roundingMode = roundingMode;
            this.mathContext = null;
        }
        
        NonDecimalAvg(MathContext mathContext) {
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
                return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), this.roundingMode).setScale(0, this.roundingMode));
            }
            if (this.mathContext != null) {
                return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), this.mathContext).setScale(0, this.mathContext.getRoundingMode()));
            }
            return fromNumber(bLeft.add(bRight).divide(BigDecimal.valueOf(2.0d), RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR)); 
        }
        
        protected abstract T fromNumber(final Number number);
        
    }
    
    
}
