package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOnDouble extends FnReduceOn<Double> {

    private static final Function<ValuePair<Number,Number>,Double> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,Double> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,Double> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,Double> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,Double> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,Double> REMAINDER = new Remainder();

    

    public final Function<ValuePair<Number,Number>,Double> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,Double> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,Double> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Double> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Double> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,Double> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,Double> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,Double> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Double> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Double> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,Double> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    

    
    FnReduceOnDouble() {
        super(Types.DOUBLE);
    }

    
    
    static Double fromNumber(final Number number) {
        return Double.valueOf(number.doubleValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOnNumber.DecimalSum<Double> {

        public Sum() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOnNumber.DecimalSubt<Double> {

        public Subt() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOnNumber.DecimalMult<Double> {

        public Mult() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOnNumber.DecimalDiv<Double> {

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
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOnNumber.DecimalRemainder<Double> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Double fromNumber(final Number number) {
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOnNumber.DecimalAvg<Double> {

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
            return FnReduceOnDouble.fromNumber(number);
        }
        
    }
    
    
}
