package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfDouble extends FnReduceOf<Double> {

    private static final IFunction<ValuePair<Number,Number>,Double> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Double> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Double> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Double> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Double> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Double> REMAINDER = new Remainder();

    

    public IFunction<ValuePair<Number,Number>,Double> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Double> avg(final MathContext mathContext) {
        return new Avg(mathContext);
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
    
    public IFunction<ValuePair<Number,Number>,Double> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Double> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Double> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,Double> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
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

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.Remainder<Double> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
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

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOfDouble.fromNumber(number);
        }
        
    }
    
    
}
