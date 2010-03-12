package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfFloat extends FnReduceOf<Float> {

    private static final IFunction<ValuePair<Float>,Float> SUM = new Sum();
    private static final IFunction<ValuePair<Float>,Float> AVG = new Avg();
    private static final IFunction<ValuePair<Float>,Float> SUBT = new Subt();
    private static final IFunction<ValuePair<Float>,Float> MULT = new Mult();
    private static final IFunction<ValuePair<Float>,Float> DIV = new Div();
    private static final IFunction<ValuePair<Float>,Float> MOD = new Mod();

    
    public IFunction<ValuePair<Float>,Float> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Float>,Float> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Float>,Float> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Float>,Float> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Float>,Float> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Float>,Float> mod() {
        return MOD;
    }
    

    
    FnReduceOfFloat() {
        super(Types.FLOAT);
    }

    
    
    
    

    
    static final class Sum extends Reductor<Float> {

        public Sum() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf(left.floatValue() + right.floatValue()); 
        }
        
    }

    
    static final class Subt extends Reductor<Float> {

        public Subt() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf(left.floatValue() - right.floatValue()); 
        }
        
    }

    
    static final class Mult extends Reductor<Float> {

        public Mult() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf(left.floatValue() * right.floatValue()); 
        }
        
    }

    
    static final class Div extends Reductor<Float> {

        public Div() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf(left.floatValue() / right.floatValue()); 
        }
        
    }

    
    static final class Mod extends Reductor<Float> {

        public Mod() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf(left.floatValue() % right.floatValue()); 
        }
        
    }

    
    static final class Avg extends Reductor<Float> {

        public Avg() {
            super();
        }

        @Override
        protected Float reduceExecute(final Float left, final Float right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Float.valueOf((left.floatValue() + right.floatValue()) / 2); 
        }
        
    }
    
    
}
