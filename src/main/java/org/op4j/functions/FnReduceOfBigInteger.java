package org.op4j.functions;

import java.math.BigInteger;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigInteger extends FnReduceOf<BigInteger> {

    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> SUM = new Sum();
    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> AVG = new Avg();
    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> SUBT = new Subt();
    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> MULT = new Mult();
    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> DIV = new Div();
    private static final IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> MOD = new Mod();

    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<BigInteger,BigInteger>,BigInteger> mod() {
        return MOD;
    }
    

    
    FnReduceOfBigInteger() {
        super(Types.BIG_INTEGER);
    }

    
    
    
    
    
    static final class Sum extends Reductor<BigInteger,BigInteger> {

        public Sum() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.add(right); 
        }
        
    }

    
    static final class Subt extends Reductor<BigInteger,BigInteger> {

        public Subt() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.subtract(right); 
        }
        
    }

    
    static final class Mult extends Reductor<BigInteger,BigInteger> {

        public Mult() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.multiply(right); 
        }
        
    }

    
    static final class Div extends Reductor<BigInteger,BigInteger> {

        public Div() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.divide(right); 
        }
        
    }

    
    static final class Mod extends Reductor<BigInteger,BigInteger> {

        public Mod() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.remainder(right); 
        }
        
    }

    
    static final class Avg extends Reductor<BigInteger,BigInteger> {

        public Avg() {
            super();
        }

        @Override
        protected BigInteger reduce(final BigInteger left, final BigInteger right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.add(right).divide(BigInteger.valueOf(2L)); 
        }
        
    }
    
    
}
