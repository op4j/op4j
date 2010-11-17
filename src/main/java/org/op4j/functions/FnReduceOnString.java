package org.op4j.functions;

import org.javaruntype.type.Types;
import org.op4j.util.ValuePair;

/**
 * @deprecated This class will be removed in version 1.2 
 */
@Deprecated
public final class FnReduceOnString extends FnReduceOn<String> {

    private static final Function<ValuePair<String,String>,String> JOIN = new Join();

    
    public final Function<ValuePair<String,String>,String> join() {
        return JOIN;
    }
    
    public final Function<ValuePair<String,String>,String> join(final String separator) {
        return new Join(separator);
    }

    

    
    FnReduceOnString() {
        super(Types.STRING);
    }

    
    
    
    

    
    static final class Join extends Reductor<String,String,String> {

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
        protected String reduce(final String left, final String right, final ExecCtx ctx) {
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
