package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfFloat extends FnReduceOf<Float> {

    private static final IFunction<ValuePair<Number,Number>,Float> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Float> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Float> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Float> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Float> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Float> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,Float> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Float> avg(final MathContext mathContext) {
        return new Avg(mathContext);
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
    
    public IFunction<ValuePair<Number,Number>,Float> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Float> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Float> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,Float> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
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

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.Remainder<Float> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
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

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }
    
    
}
