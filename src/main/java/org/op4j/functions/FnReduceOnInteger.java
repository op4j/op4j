package org.op4j.functions;


import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOnInteger extends FnReduceOn<Integer> {

    private static final Function<ValuePair<Number,Number>,Integer> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,Integer> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,Integer> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,Integer> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,Integer> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,Integer> REMAINDER = new Remainder();

    
    public final Function<ValuePair<Number,Number>,Integer> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Integer> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Integer> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Integer> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Integer> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,Integer> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    
    

    
    FnReduceOnInteger() {
        super(Types.INTEGER);
    }

    

    
    static Integer fromNumber(final Number number) {
        return Integer.valueOf(number.intValue());
    }
    
    

    
    
    static final class Sum extends FnReduceOnNumber.NonDecimalSum<Integer> {

        public Sum() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOnNumber.NonDecimalSubt<Integer> {

        public Subt() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOnNumber.NonDecimalMult<Integer> {

        public Mult() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOnNumber.NonDecimalDiv<Integer> {

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
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOnNumber.NonDecimalRemainder<Integer> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }

    
    
    static final class Avg extends FnReduceOnNumber.NonDecimalAvg<Integer> {

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
        protected Integer fromNumber(final Number number) {
            return FnReduceOnInteger.fromNumber(number);
        }
        
    }
    
    
}
