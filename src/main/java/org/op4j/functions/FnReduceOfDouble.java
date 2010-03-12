package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfDouble extends FnReduceOf<Double> {

    private static final IFunction<ValuePair<Double>,Double> SUM = new Sum();
    private static final IFunction<ValuePair<Double>,Double> AVG = new Avg();
    private static final IFunction<ValuePair<Double>,Double> SUBT = new Subt();
    private static final IFunction<ValuePair<Double>,Double> MULT = new Mult();
    private static final IFunction<ValuePair<Double>,Double> DIV = new Div();
    private static final IFunction<ValuePair<Double>,Double> MOD = new Mod();

    

    public IFunction<ValuePair<Double>,Double> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Double>,Double> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Double>,Double> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Double>,Double> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Double>,Double> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Double>,Double> mod() {
        return MOD;
    }
    

    
    FnReduceOfDouble() {
        super(Types.DOUBLE);
    }

    
    
    
    

    
    static final class Sum extends Reductor<Double> {

        public Sum() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() + right.doubleValue()); 
        }
        
    }

    
    static final class Subt extends Reductor<Double> {

        public Subt() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() - right.doubleValue()); 
        }
        
    }

    
    static final class Mult extends Reductor<Double> {

        public Mult() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() * right.doubleValue()); 
        }
        
    }

    
    static final class Div extends Reductor<Double> {

        public Div() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() / right.doubleValue()); 
        }
        
    }

    
    static final class Mod extends Reductor<Double> {

        public Mod() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Double.valueOf(left.doubleValue() % right.doubleValue()); 
        }
        
    }

    
    static final class Avg extends Reductor<Double> {

        public Avg() {
            super();
        }

        @Override
        protected Double reduceExecute(final Double left, final Double right, ExecCtx ctx) {
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
