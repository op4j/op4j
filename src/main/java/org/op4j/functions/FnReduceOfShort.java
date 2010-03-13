package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfShort extends FnReduceOf<Short> {

    private static final IFunction<ValuePair<Number,Number>,Short> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Short> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Short> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Short> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Short> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Short> REMAINDER = new Remainder();

    
    public IFunction<ValuePair<Number,Number>,Short> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Short> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Short> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public IFunction<ValuePair<Number,Number>,Short> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public IFunction<ValuePair<Number,Number>,Short> remainder() {
        return REMAINDER;
    }
    
    public IFunction<ValuePair<Number,Number>,Short> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    
    

    
    FnReduceOfShort() {
        super(Types.SHORT);
    }

    
    
    static Short fromNumber(final Number number) {
        return Short.valueOf(number.shortValue());
    }
    
    
    

    
    static final class Sum extends FnReduceOfNumber.Sum<Short> {

        public Sum() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Short> {

        public Subt() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Short> {

        public Mult() {
            super();
        }

        @Override
        protected Short fromNumber(final Number number) {
            return FnReduceOfShort.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Short> {

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

    
    static final class Remainder extends FnReduceOfNumber.Remainder<Short> {

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

    

    
    static final class Avg extends FnReduceOfNumber.Avg<Short> {

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
