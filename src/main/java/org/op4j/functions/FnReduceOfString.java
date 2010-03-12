package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

public final class FnReduceOfString extends FnReduceOf<String> {

    private static final IFunction<ValuePair<String>,String> JOIN = new Join();

    
    public IFunction<ValuePair<String>,String> join() {
        return JOIN;
    }
    
    public IFunction<ValuePair<String>,String> join(final String separator) {
        return new Join(separator);
    }

    

    
    FnReduceOfString() {
        super(Types.STRING);
    }

    
    
    
    

    
    static final class Join extends Reductor<String> {

        private final String separator; 
        
        public Join() {
            super();
            this.separator = null;
        }

        public Join(final String separator) {
            super();
            this.separator = separator;
        }

        @Override
        protected String reduceExecute(final String left, final String right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return left + this.separator + right; 
        }
        
    }
    
    
}
