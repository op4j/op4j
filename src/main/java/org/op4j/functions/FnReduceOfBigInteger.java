package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigInteger extends FnReduceOf<BigInteger> {

    private static final IFunction<ValuePair<Number,Number>,BigInteger> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,BigInteger> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,BigInteger> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,BigInteger> mod() {
        return MOD;
    }
    

    
    FnReduceOfBigInteger() {
        super(Types.BIG_INTEGER);
    }

    
    
    
    
    static BigInteger fromNumber(final Number number) {
        if (number instanceof BigDecimal) {
            return ((BigDecimal) number).toBigInteger();
        }
        if (number instanceof BigInteger) {
            return (BigInteger)number;
        }
        return (BigDecimal.valueOf(number.doubleValue())).toBigInteger();
    }

    
    
    
    
    static final class Sum extends FnReduceOfNumber.Sum<BigInteger> {

        public Sum() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<BigInteger> {

        public Subt() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<BigInteger> {

        public Mult() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<BigInteger> {

        public Div() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<BigInteger> {

        public Mod() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.Avg<BigInteger> {

        public Avg() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return FnReduceOfBigInteger.fromNumber(number);
        }
        
    }
    
    
}
