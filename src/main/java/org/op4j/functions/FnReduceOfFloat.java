package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfFloat extends FnReduceOf<Float> {

    private static final IFunction<ValuePair<Number,Number>,Float> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Float> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Float> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Float> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Float> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Float> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,Float> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> mod() {
        return MOD;
    }
    

    
    FnReduceOfFloat() {
        super(Types.FLOAT);
    }

    

    
    static Float fromNumber(final Number number) {
        return Float.valueOf(number.floatValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOfNumber.Sum<Float> {

        public Sum() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Float> {

        public Subt() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Float> {

        public Mult() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Float> {

        public Div() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<Float> {

        public Mod() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.Avg<Float> {

        public Avg() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }
    
    
}
