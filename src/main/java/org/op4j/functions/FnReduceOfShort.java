package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfShort extends FnReduceOf<Short> {

    private static final IFunction<ValuePair<Short,Short>,Short> SUM = new Sum();
    private static final IFunction<ValuePair<Short,Short>,Short> AVG = new Avg();
    private static final IFunction<ValuePair<Short,Short>,Short> SUBT = new Subt();
    private static final IFunction<ValuePair<Short,Short>,Short> MULT = new Mult();
    private static final IFunction<ValuePair<Short,Short>,Short> DIV = new Div();
    private static final IFunction<ValuePair<Short,Short>,Short> MOD = new Mod();
    private static final IFunction<ValuePair<Short,Short>,Short> POW = new Pow();

    
    public IFunction<ValuePair<Short,Short>,Short> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Short,Short>,Short> pow() {
        return POW;
    }
    

    
    FnReduceOfShort() {
        super(Types.SHORT);
    }

    
    
    
    

    
    static final class Sum extends Reductor<Short,Short> {

        public Sum() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() + right.shortValue())); 
        }
        
    }

    
    static final class Subt extends Reductor<Short,Short> {

        public Subt() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() - right.shortValue())); 
        }
        
    }

    
    static final class Mult extends Reductor<Short,Short> {

        public Mult() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() * right.shortValue())); 
        }
        
    }

    
    static final class Div extends Reductor<Short,Short> {

        public Div() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() / right.shortValue())); 
        }
        
    }

    
    static final class Mod extends Reductor<Short,Short> {

        public Mod() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() % right.shortValue())); 
        }
        
    }

    
    static final class Pow extends Reductor<Short,Short> {

        public Pow() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Short.valueOf((short)(left.shortValue() ^ right.shortValue())); 
        }
        
    }

    
    static final class Avg extends Reductor<Short,Short> {

        public Avg() {
            super();
        }

        @Override
        protected Short reduce(final Short left, final Short right, ExecCtx ctx) {
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
