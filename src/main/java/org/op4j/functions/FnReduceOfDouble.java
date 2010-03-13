package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfDouble extends FnReduceOf<Double> {

    private static final IFunction<ValuePair<Double,Double>,Double> SUM = new Sum();
    private static final IFunction<ValuePair<Double,Double>,Double> AVG = new Avg();
    private static final IFunction<ValuePair<Double,Double>,Double> SUBT = new Subt();
    private static final IFunction<ValuePair<Double,Double>,Double> MULT = new Mult();
    private static final IFunction<ValuePair<Double,Double>,Double> DIV = new Div();
    private static final IFunction<ValuePair<Double,Double>,Double> MOD = new Mod();

    

    public IFunction<ValuePair<Double,Double>,Double> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Double,Double>,Double> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Double,Double>,Double> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Double,Double>,Double> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Double,Double>,Double> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Double,Double>,Double> mod() {
        return MOD;
    }
    

    
    FnReduceOfDouble() {
        super(Types.DOUBLE);
    }

    
    
    
    

    
    static final class Sum extends Reductor<Double,Double,Double> {

        public Sum() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() + right.doubleValue()); 
        }
        
    }

    
    static final class Subt extends Reductor<Double,Double,Double> {

        public Subt() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() - right.doubleValue()); 
        }
        
    }

    
    static final class Mult extends Reductor<Double,Double,Double> {

        public Mult() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() * right.doubleValue()); 
        }
        
    }

    
    static final class Div extends Reductor<Double,Double,Double> {

        public Div() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() / right.doubleValue()); 
        }
        
    }

    
    static final class Mod extends Reductor<Double,Double,Double> {

        public Mod() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() % right.doubleValue()); 
        }
        
    }

    
    static final class Avg extends Reductor<Double,Double,Double> {

        public Avg() {
            super();
        }

        @Override
        protected Double reduce(final Double left, final Double right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf((left.doubleValue() + right.doubleValue()) / 2); 
        }
        
    }
    
    
}
