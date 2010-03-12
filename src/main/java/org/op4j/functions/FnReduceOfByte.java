package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfByte extends FnReduceOf<Byte> {

    private static final IFunction<ValuePair<Byte>,Byte> SUM = new Sum();
    private static final IFunction<ValuePair<Byte>,Byte> AVG = new Avg();
    private static final IFunction<ValuePair<Byte>,Byte> SUBT = new Subt();
    private static final IFunction<ValuePair<Byte>,Byte> MULT = new Mult();
    private static final IFunction<ValuePair<Byte>,Byte> DIV = new Div();
    private static final IFunction<ValuePair<Byte>,Byte> MOD = new Mod();
    private static final IFunction<ValuePair<Byte>,Byte> POW = new Pow();

    
    public IFunction<ValuePair<Byte>,Byte> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Byte>,Byte> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Byte>,Byte> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Byte>,Byte> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Byte>,Byte> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Byte>,Byte> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Byte>,Byte> pow() {
        return POW;
    }
    

    
    FnReduceOfByte() {
        super(Types.BYTE);
    }

    
    
    
    
    
    static final class Sum extends Reductor<Byte> {

        public Sum() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() + right.byteValue())); 
        }
        
    }

    
    static final class Subt extends Reductor<Byte> {

        public Subt() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() - right.byteValue())); 
        }
        
    }

    
    static final class Mult extends Reductor<Byte> {

        public Mult() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() * right.byteValue())); 
        }
        
    }

    
    static final class Div extends Reductor<Byte> {

        public Div() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() / right.byteValue())); 
        }
        
    }

    
    static final class Mod extends Reductor<Byte> {

        public Mod() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() % right.byteValue())); 
        }
        
    }

    
    static final class Pow extends Reductor<Byte> {

        public Pow() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() ^ right.byteValue())); 
        }
        
    }

    
    static final class Avg extends Reductor<Byte> {

        public Avg() {
            super();
        }

        @Override
        protected Byte reduceExecute(final Byte left, final Byte right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)((left.byteValue() + right.byteValue()) / 2L)); 
        }
        
    }
    
    
}
