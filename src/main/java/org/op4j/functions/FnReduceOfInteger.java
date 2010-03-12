package org.op4j.functions;


import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfInteger extends FnReduceOf<Integer> {

    private static final IFunction<ValuePair<Integer>,Integer> SUM = new Sum();
    private static final IFunction<ValuePair<Integer>,Integer> AVG = new Avg();
    private static final IFunction<ValuePair<Integer>,Integer> SUBT = new Subt();
    private static final IFunction<ValuePair<Integer>,Integer> MULT = new Mult();
    private static final IFunction<ValuePair<Integer>,Integer> DIV = new Div();
    private static final IFunction<ValuePair<Integer>,Integer> MOD = new Mod();
    private static final IFunction<ValuePair<Integer>,Integer> POW = new Pow();

    
    public IFunction<ValuePair<Integer>,Integer> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Integer>,Integer> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Integer>,Integer> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Integer>,Integer> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Integer>,Integer> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Integer>,Integer> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Integer>,Integer> pow() {
        return POW;
    }
    

    
    FnReduceOfInteger() {
        super(Types.INTEGER);
    }

    
    
    

    
    
    static final class Sum extends Reductor<Integer> {

        public Sum() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() + right.intValue()); 
        }
        
    }

    
    static final class Subt extends Reductor<Integer> {

        public Subt() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() - right.intValue()); 
        }
        
    }

    
    static final class Mult extends Reductor<Integer> {

        public Mult() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() * right.intValue()); 
        }
        
    }

    
    static final class Div extends Reductor<Integer> {

        public Div() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() / right.intValue()); 
        }
        
    }

    
    static final class Mod extends Reductor<Integer> {

        public Mod() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() % right.intValue()); 
        }
        
    }

    
    static final class Pow extends Reductor<Integer> {

        public Pow() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf(left.intValue() ^ right.intValue()); 
        }
        
    }

    
    static final class Avg extends Reductor<Integer> {

        public Avg() {
            super();
        }

        @Override
        protected Integer reduceExecute(final Integer left, final Integer right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Integer.valueOf((left.intValue() + right.intValue()) / 2); 
        }
        
    }
    
    
}
