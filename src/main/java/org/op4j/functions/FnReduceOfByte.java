package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfByte extends FnReduceOf<Byte> {

    private static final IFunction<ValuePair<Byte,Byte>,Byte> SUM = new Sum();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> AVG = new Avg();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> SUBT = new Subt();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> MULT = new Mult();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> DIV = new Div();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> MOD = new Mod();
    private static final IFunction<ValuePair<Byte,Byte>,Byte> POW = new Pow();

    
    public IFunction<ValuePair<Byte,Byte>,Byte> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Byte,Byte>,Byte> pow() {
        return POW;
    }
    

    
    FnReduceOfByte() {
        super(Types.BYTE);
    }

    
    
    
    
    
    static final class Sum extends Reductor<Byte,Byte,Byte> {

        public Sum() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() + right.byteValue())); 
        }
        
    }

    
    static final class Subt extends Reductor<Byte,Byte,Byte> {

        public Subt() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() - right.byteValue())); 
        }
        
    }

    
    static final class Mult extends Reductor<Byte,Byte,Byte> {

        public Mult() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() * right.byteValue())); 
        }
        
    }

    
    static final class Div extends Reductor<Byte,Byte,Byte> {

        public Div() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() / right.byteValue())); 
        }
        
    }

    
    static final class Mod extends Reductor<Byte,Byte,Byte> {

        public Mod() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() % right.byteValue())); 
        }
        
    }

    
    static final class Pow extends Reductor<Byte,Byte,Byte> {

        public Pow() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Byte.valueOf((byte)(left.byteValue() ^ right.byteValue())); 
        }
        
    }

    
    static final class Avg extends Reductor<Byte,Byte,Byte> {

        public Avg() {
            super();
        }

        @Override
        protected Byte reduce(final Byte left, final Byte right, ExecCtx ctx) {
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
