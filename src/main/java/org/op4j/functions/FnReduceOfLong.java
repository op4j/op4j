package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfLong extends FnReduceOf<Long> {

    private static final IFunction<ValuePair<Long,Long>,Long> SUM = new Sum();
    private static final IFunction<ValuePair<Long,Long>,Long> AVG = new Avg();
    private static final IFunction<ValuePair<Long,Long>,Long> SUBT = new Subt();
    private static final IFunction<ValuePair<Long,Long>,Long> MULT = new Mult();
    private static final IFunction<ValuePair<Long,Long>,Long> DIV = new Div();
    private static final IFunction<ValuePair<Long,Long>,Long> MOD = new Mod();
    private static final IFunction<ValuePair<Long,Long>,Long> POW = new Pow();

    
    public IFunction<ValuePair<Long,Long>,Long> sum() {
        return SUM;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> avg() {
        return AVG;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> subt() {
        return SUBT;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> mult() {
        return MULT;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> div() {
        return DIV;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> mod() {
        return MOD;
    }
    
    public IFunction<ValuePair<Long,Long>,Long> pow() {
        return POW;
    }
    

    
    FnReduceOfLong() {
        super(Types.LONG);
    }

    
    
    
    
    
    static final class Sum extends Reductor<Long,Long> {

        public Sum() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() + right.longValue()); 
        }
        
    }

    
    static final class Subt extends Reductor<Long,Long> {

        public Subt() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() - right.longValue()); 
        }
        
    }

    
    static final class Mult extends Reductor<Long,Long> {

        public Mult() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() * right.longValue()); 
        }
        
    }

    
    static final class Div extends Reductor<Long,Long> {

        public Div() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() / right.longValue()); 
        }
        
    }

    
    static final class Mod extends Reductor<Long,Long> {

        public Mod() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() % right.longValue()); 
        }
        
    }

    
    static final class Pow extends Reductor<Long,Long> {

        public Pow() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf(left.longValue() ^ right.longValue()); 
        }
        
    }

    
    static final class Avg extends Reductor<Long,Long> {

        public Avg() {
            super();
        }

        @Override
        protected Long reduce(final Long left, final Long right, ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return Long.valueOf((left.longValue() + right.longValue()) / 2L); 
        }
        
    }
    
    
}
