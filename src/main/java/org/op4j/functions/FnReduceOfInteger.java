package org.op4j.functions;


import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfInteger extends FnReduceOf<Integer> {

    private static final IFunction<ValuePair<Number,Number>,Integer> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Integer> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Integer> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Integer> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Integer> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Integer> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,Integer> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    
    

    
    FnReduceOfInteger() {
        super(Types.INTEGER);
    }

    

    
    static Integer fromNumber(final Number number) {
        return Integer.valueOf(number.intValue());
    }
    
    

    
    
    static final class Sum extends FnReduceOfNumber.NonDecimalSum<Integer> {

        public Sum() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.NonDecimalSubt<Integer> {

        public Subt() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.NonDecimalMult<Integer> {

        public Mult() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.NonDecimalDiv<Integer> {

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
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.NonDecimalRemainder<Integer> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    
    static final class Avg extends FnReduceOfNumber.NonDecimalAvg<Integer> {

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
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }
    
    
}
