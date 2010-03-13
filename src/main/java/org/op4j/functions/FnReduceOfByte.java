package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfByte extends FnReduceOf<Byte> {

    private static final IFunction<ValuePair<Number,Number>,Byte> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Byte> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Byte> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Byte> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Byte> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Byte> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,Byte> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Byte> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Number,Number>,Byte> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Number,Number>,Byte> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Number,Number>,Byte> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Number,Number>,Byte> mod() {
        return MOD;
    }
    
    

    
    FnReduceOfByte() {
        super(Types.BYTE);
    }

    
    
    
    
    static Byte fromNumber(final Number number) {
        return Byte.valueOf(number.byteValue());
    }
    
    
    
    
    static final class Sum extends FnReduceOfNumber.Sum<Byte> {

        public Sum() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Byte> {

        public Subt() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Byte> {

        public Mult() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Byte> {

        public Div() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<Byte> {

        public Mod() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }

    
    static final class Avg extends FnReduceOfNumber.Avg<Byte> {

        public Avg() {
            super();
        }

        @Override
        protected Byte fromNumber(final Number number) {
            return FnReduceOfByte.fromNumber(number);
        }
        
    }
    
    
}
