package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfDouble extends FnReduceOf<Double> {

    private static final IFunction<ValuePair<Number,Number>,Double> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Double> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Double> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Double> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Double> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Double> MOD = new Mod();

    

    public IFunction<ValuePair<Number,Number>,Double> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> mod() {
        return MOD;
    }
    

    
    FnReduceOfDouble() {
        super(Types.DOUBLE);
    }

    
    
    static Double fromNumber(final Number number) {
        return Double.valueOf(number.doubleValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOfNumber.Sum<Double> {

        public Sum() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Double> {

        public Subt() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Double> {

        public Mult() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Double> {

        public Div() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<Double> {

        public Mod() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.Avg<Double> {

        public Avg() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }
    
    
}
