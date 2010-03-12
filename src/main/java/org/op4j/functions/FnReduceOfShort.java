package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfShort extends FnReduceOf<Short> {

    private static final IFunction<ValuePair<Short>,Short> SUM = new Sum();
    private static final IFunction<ValuePair<Short>,Short> AVG = new Avg();
    private static final IFunction<ValuePair<Short>,Short> SUBT = new Subt();
    private static final IFunction<ValuePair<Short>,Short> MULT = new Mult();
    private static final IFunction<ValuePair<Short>,Short> DIV = new Div();
    private static final IFunction<ValuePair<Short>,Short> MOD = new Mod();
    private static final IFunction<ValuePair<Short>,Short> POW = new Pow();

    
    public IFunction<ValuePair<Short>,Short> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Short>,Short> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Short>,Short> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Short>,Short> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Short>,Short> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Short>,Short> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Short>,Short> pow() {
        return POW;
    }
    

    
    FnReduceOfShort() {
        super(Types.SHORT);
    }

    
    
    
    

    
    static final class Sum extends Reductor<Short> {

        public Sum() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() + right.shortValue())); 
        }
        
    }

    
    static final class Subt extends Reductor<Short> {

        public Subt() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() - right.shortValue())); 
        }
        
    }

    
    static final class Mult extends Reductor<Short> {

        public Mult() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() * right.shortValue())); 
        }
        
    }

    
    static final class Div extends Reductor<Short> {

        public Div() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() / right.shortValue())); 
        }
        
    }

    
    static final class Mod extends Reductor<Short> {

        public Mod() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() % right.shortValue())); 
        }
        
    }

    
    static final class Pow extends Reductor<Short> {

        public Pow() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() ^ right.shortValue())); 
        }
        
    }

    
    static final class Avg extends Reductor<Short> {

        public Avg() {
            super();
        }

        @Override
        protected Short reduceExecute(final Short left, final Short right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)((left.shortValue() + right.shortValue()) / 2L)); 
        }
        
    }
    
    
}
