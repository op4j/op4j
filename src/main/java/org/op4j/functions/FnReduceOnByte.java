package org.op4j.functions;

import java.math.MathContext;
import java.math.RoundingMode;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

/**
 * @deprecated This class will be removed in version 1.2 
 */
@Deprecated
public final class FnReduceOnByte extends FnReduceOn<Byte> {

    private static final Function<ValuePair<Number,Number>,Byte> SUM = new Sum();
    private static final Function<ValuePair<Number,Number>,Byte> AVG = new Avg();
    private static final Function<ValuePair<Number,Number>,Byte> SUBT = new Subt();
    private static final Function<ValuePair<Number,Number>,Byte> MULT = new Mult();
    private static final Function<ValuePair<Number,Number>,Byte> DIV = new Div();
    private static final Function<ValuePair<Number,Number>,Byte> REMAINDER = new Remainder();

    
    public final Function<ValuePair<Number,Number>,Byte> sum() {
        return SUM;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> avg() {
        return AVG;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> avg(final RoundingMode roundingMode) {
        return new Avg(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Byte> avg(final MathContext mathContext) {
        return new Avg(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Byte> subt() {
        return SUBT;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> mult() {
        return MULT;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> div() {
        return DIV;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> div(final RoundingMode roundingMode) {
        return new Div(roundingMode);
    }
    
    public final Function<ValuePair<Number,Number>,Byte> div(final MathContext mathContext) {
        return new Div(mathContext);
    }
    
    public final Function<ValuePair<Number,Number>,Byte> remainder() {
        return REMAINDER;
    }
    
    public final Function<ValuePair<Number,Number>,Byte> remainder(final MathContext mathContext) {
        return new Remainder(mathContext);
    }
    
    

    
    FnReduceOnByte() {
        super(Types.BYTE);
    }

    
    
    
    
    static Byte fromNumber(final Number number) {
        return Byte.valueOf(number.byteValue());
    }
    
    
    
    
    static final class Sum extends FnReduceOnNumber.NonDecimalSum<Byte> {

        public Sum() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOnNumber.NonDecimalSubt<Byte> {

        public Subt() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOnNumber.NonDecimalMult<Byte> {

        public Mult() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOnNumber.NonDecimalDiv<Byte> {

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
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }

    
    static final class Remainder extends FnReduceOnNumber.NonDecimalRemainder<Byte> {

        public Remainder() {
            super();
        }

        public Remainder(final MathContext mathContext) {
            super(mathContext);
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOnNumber.NonDecimalAvg<Byte> {

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
        protected Byte fromNumber(final Number number) {
            return FnReduceOnByte.fromNumber(number);
        }
        
    }
    
    
}
