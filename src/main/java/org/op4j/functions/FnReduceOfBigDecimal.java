package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigDecimal extends FnReduceOf<BigDecimal> {

    private static final IFunction<ValuePair<Number,Number>,BigDecimal> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,BigDecimal> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    

    
    FnReduceOfBigDecimal() {
        super(Types.BIG_DECIMAL);
    }

    
    
    static BigDecimal fromNumber(final Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger)number);
        }
        return BigDecimal.valueOf(number.doubleValue());
    }
    
    
    
    
    
    static final class Sum extends FnReduceOfNumber.Sum<BigDecimal> {

        public Sum() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<BigDecimal> {

        public Subt() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<BigDecimal> {

        public Mult() {
            super();
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<BigDecimal> {

        public Div() {
            super();
        }

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.Remainder<BigDecimal> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.Avg<BigDecimal> {

        public Avg() {
            super();
        }

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }
    
    
}
