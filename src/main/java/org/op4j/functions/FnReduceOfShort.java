package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfShort extends FnReduceOf<Short> {

    private static final Function<ValuePair<Number,Number>,Short> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,Short> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,Short> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,Short> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,Short> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,Short> REMAINDER = new Remainder();

    
    public final Function<ValuePair<Number,Number>,Short> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,Short> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,Short> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Short> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Short> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,Short> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,Short> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,Short> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Short> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Short> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,Short> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    
    

    
    FnReduceOfShort() {
        super(Types.SHORT);
    }

    
    
    static Short fromNumber(final Number number) {
        return Short.valueOf(number.shortValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOfNumber.NonDecimalSum<Short> {

        public Sum() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.NonDecimalSubt<Short> {

        public Subt() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.NonDecimalMult<Short> {

        public Mult() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.NonDecimalDiv<Short> {

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
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.NonDecimalRemainder<Short> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    

    
    static final class Avg extends FnReduceOfNumber.NonDecimalAvg<Short> {

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
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }
    
    
}
