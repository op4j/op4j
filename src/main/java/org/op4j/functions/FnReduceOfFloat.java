package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfFloat extends FnReduceOf<Float> {

    private static final Function<ValuePair<Number,Number>,Float> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,Float> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,Float> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,Float> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,Float> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,Float> REMAINDER = new Remainder();

    
    public final Function<ValuePair<Number,Number>,Float> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,Float> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,Float> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Float> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Float> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,Float> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,Float> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,Float> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Float> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Float> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,Float> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    

    
    FnReduceOfFloat() {
        super(Types.FLOAT);
    }

    

    
    static Float fromNumber(final Number number) {
        return Float.valueOf(number.floatValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOfNumber.DecimalSum<Float> {

        public Sum() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.DecimalSubt<Float> {

        public Subt() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.DecimalMult<Float> {

        public Mult() {
            super();
        }

        @Override
        protected Float fromNumber(final Number number) {
            return FnReduceOfFloat.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.DecimalDiv<Float> {

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

    
    static final class Remainder extends FnReduceOfNumber.DecimalRemainder<Float> {

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

    
    static final class Avg extends FnReduceOfNumber.DecimalAvg<Float> {

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
