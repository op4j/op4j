package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfLong extends FnReduceOf<Long> {

    private static final IFunction<ValuePair<Number,Number>,Long> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Long> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Long> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Long> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Long> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Long> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,Long> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Long> avg(final MathContext mathContext) {
        return new Avg(mathContext);
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
    
    public IFunction<ValuePair<Number,Number>,Long> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Long> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Long> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,Long> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
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

        public Div(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Div(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOfNumber.Remainder<Long> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
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

        public Avg(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public Avg(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Long fromNumber(final Number number) {
            return FnReduceOfLong.fromNumber(number);
        }
        
    }
    
    
}
