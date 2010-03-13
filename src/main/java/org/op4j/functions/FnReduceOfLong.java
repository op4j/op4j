package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfLong extends FnReduceOf<Long> {

    private static final IFunction<ValuePair<Number,Number>,Long> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Long> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Long> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Long> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Long> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Long> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,Long> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> mod() {
        return MOD;
    }
    
    

    
    FnReduceOfLong() {
        super(Types.LONG);
    }

    
    
    
    static Long fromNumber(final Number number) {
        return Long.valueOf(number.longValue());
    }
    
    
    
    static final class Sum extends FnReduceOfNumber.Sum<Long> {

        public Sum() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Long> {

        public Subt() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Long> {

        public Mult() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Long> {

        public Div() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<Long> {

        public Mod() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    

    
    static final class Avg extends FnReduceOfNumber.Avg<Long> {

        public Avg() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }
    
    
}
