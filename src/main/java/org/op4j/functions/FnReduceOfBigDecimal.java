package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigDecimal extends FnReduceOf<BigDecimal> {

    private static final IFunction<ValuePair<Number,Number>,BigDecimal> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,BigDecimal> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,BigDecimal> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> avg() {
        return AVG;
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
    
    public IFunction<ValuePair<Number,Number>,BigDecimal> mod() {
        return MOD;
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

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<BigDecimal> {

        public Mod() {
            super();
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

        @Override
        protected BigDecimal fromNumber(final Number number) {
            return FnReduceOfBigDecimal.fromNumber(number);
        }
        
    }
    
    
}
