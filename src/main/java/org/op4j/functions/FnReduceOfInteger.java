package org.op4j.functions;


import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfInteger extends FnReduceOf<Integer> {

    private static final IFunction<ValuePair<Number,Number>,Integer> SUM = new Sum();
    private static final IFunction<ValuePair<Number,Number>,Integer> AVG = new Avg();
    private static final IFunction<ValuePair<Number,Number>,Integer> SUBT = new Subt();
    private static final IFunction<ValuePair<Number,Number>,Integer> MULT = new Mult();
    private static final IFunction<ValuePair<Number,Number>,Integer> DIV = new Div();
    private static final IFunction<ValuePair<Number,Number>,Integer> MOD = new Mod();

    
    public IFunction<ValuePair<Number,Number>,Integer> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Number,Number>,Integer> avg() {
        return AVG;
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
    
    public IFunction<ValuePair<Number,Number>,Integer> mod() {
        return MOD;
    }
    
    

    
    FnReduceOfInteger() {
        super(Types.INTEGER);
    }

    

    
    static Integer fromNumber(final Number number) {
        return Integer.valueOf(number.intValue());
    }
    
    

    
    
    static final class Sum extends FnReduceOfNumber.Sum<Integer> {

        public Sum() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Subt extends FnReduceOfNumber.Subt<Integer> {

        public Subt() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Mult extends FnReduceOfNumber.Mult<Integer> {

        public Mult() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Div extends FnReduceOfNumber.Div<Integer> {

        public Div() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    static final class Mod extends FnReduceOfNumber.Mod<Integer> {

        public Mod() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }

    
    
    static final class Avg extends FnReduceOfNumber.Avg<Integer> {

        public Avg() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return FnReduceOfInteger.fromNumber(number);
        }
        
    }
    
    
}
