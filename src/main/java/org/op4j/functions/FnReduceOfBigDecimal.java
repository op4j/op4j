package org.op4j.functions;

import java.math.BigDecimal;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBigDecimal extends FnReduceOf<BigDecimal> {

    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> SUM = new Sum();
    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> AVG = new Avg();
    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> SUBT = new Subt();
    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> MULT = new Mult();
    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> DIV = new Div();
    private static final IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> MOD = new Mod();

    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<BigDecimal,BigDecimal>,BigDecimal> mod() {
        return MOD;
    }
    

    
    FnReduceOfBigDecimal() {
        super(Types.BIG_DECIMAL);
    }

    
    
    
    
    
    static final class Sum extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Sum() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.add(right); 
        }
        
    }

    
    static final class Subt extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Subt() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.subtract(right); 
        }
        
    }

    
    static final class Mult extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Mult() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.multiply(right); 
        }
        
    }

    
    static final class Div extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Div() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.divide(right); 
        }
        
    }

    
    static final class Mod extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Mod() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.remainder(right); 
        }
        
    }

    
    static final class Avg extends Reductor<BigDecimal,BigDecimal,BigDecimal> {

        public Avg() {
            super();
        }

        @Override
        protected BigDecimal reduce(final BigDecimal left, final BigDecimal right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left.add(right).divide(BigDecimal.valueOf(2L)); 
        }
        
    }
    
    
}
