package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfBoolean extends FnReduceOf<Boolean> {

    private static final Function<ValuePair<Boolean,Boolean>,Boolean> AND = new And();
    private static final Function<ValuePair<Boolean,Boolean>,Boolean> OR = new Or();

    
    public final Function<ValuePair<Boolean,Boolean>,Boolean> and() {
        return AND;
    }
    
    public final Function<ValuePair<Boolean,Boolean>,Boolean> or() {
        return OR;
    }


    
    
    FnReduceOfBoolean() {
        super(Types.BOOLEAN);
    }

    
    
    
    
    
    static final class And extends Reductor<Boolean,Boolean,Boolean> {

        public And() {
            super();
        }

        @Override
        protected Boolean reduce(final Boolean left, final Boolean right, final ExecCtx ctx) {
            if (left == null) {
                return Boolean.FALSE;
            }
            if (right == null) {
                return Boolean.FALSE;
            }
            if (left.equals(Boolean.TRUE)) {
                return Boolean.valueOf(right.equals(Boolean.TRUE));
            }
            return Boolean.valueOf(right.equals(Boolean.FALSE)); 
        }
        
    }

    
    
    static final class Or extends Reductor<Boolean,Boolean,Boolean> {

        public Or() {
            super();
        }

        @Override
        protected Boolean reduce(final Boolean left, final Boolean right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (left.equals(Boolean.TRUE)) {
                return Boolean.TRUE;
            }
            return right; 
        }
        
    }
    
    
}
