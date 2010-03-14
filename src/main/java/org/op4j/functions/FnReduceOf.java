package org.op4j.functions;

import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ValuePair;

public class FnReduceOf<T> {

    
    protected final Type<T> type;


    
    public final Function<ValuePair<T,T>,T> max() {
        return new Max<T>();
    }
    
    public final Function<ValuePair<T,T>,T> min() {
        return new Min<T>();
    }
    
    public final <X extends Comparable<? super X>> Function<ValuePair<T,T>,T> maxBy(final IFunction<? super T,X> function) {
        return new MaxBy<T,X>(function);
    }
    
    public final <X extends Comparable<? super X>> Function<ValuePair<T,T>,T> minBy(final IFunction<? super T,X> function) {
        return new MinBy<T,X>(function);
    }
    

    
    
    
    
    FnReduceOf(final Type<T> type) {
        super();
        this.type = type;
    }

    

    
    
    static final class Max<T> extends Reductor<T,T,T> {

        public Max() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected T reduce(final T left, final T right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (!(left instanceof Comparable)) {
                throw new ExecutionException(
                        "Cannot apply reduction: left side of reduction is not comparable (" + left.getClass().getName() + ")");
            }
            if (!(right instanceof Comparable)) {
                throw new ExecutionException(
                        "Cannot apply reduction: right side of reduction is not comparable (" + left.getClass().getName() + ")");
            }
            final int comparison = ((Comparable)left).compareTo(right); 
            if (comparison >= 0) {
                return left;
            }
            return right;
        }
        
    }
    
    
    static final class Min<T> extends Reductor<T,T,T> {

        public Min() {
            super();
        }

        @Override
        @SuppressWarnings("unchecked")
        protected T reduce(final T left, final T right, final ExecCtx ctx) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (!(left instanceof Comparable)) {
                throw new ExecutionException(
                        "Cannot apply reduction: left side of reduction is not comparable (" + left.getClass().getName() + ")");
            }
            if (!(right instanceof Comparable)) {
                throw new ExecutionException(
                        "Cannot apply reduction: right side of reduction is not comparable (" + left.getClass().getName() + ")");
            }
            final int comparison = ((Comparable)left).compareTo(right); 
            if (comparison <= 0) {
                return left;
            }
            return right;
        }
        
    }

    
    
    
    
    static final class MaxBy<T,X extends Comparable<? super X>> extends Reductor<T,T,T> {

        private final IFunction<? super T,X> function;
        
        public MaxBy(final IFunction<? super T,X> function) {
            super();
            this.function = function;
        }

        @Override
        protected T reduce(final T left, final T right, final ExecCtx ctx) throws Exception {
            
            final X leftResult = this.function.execute(left, ctx);
            final X rightResult = this.function.execute(right, ctx);
            
            if (leftResult == null) {
                return right;
            }
            if (rightResult == null) {
                return left;
            }
            final int comparison = leftResult.compareTo(rightResult); 
            if (comparison >= 0) {
                return left;
            }
            return right;
        }
        
    }
    

    

    
    
    
    
    
    static final class MinBy<T,X extends Comparable<? super X>> extends Reductor<T,T,T> {

        private final IFunction<? super T,X> function;
        
        public MinBy(final IFunction<? super T,X> function) {
            super();
            this.function = function;
        }

        @Override
        protected T reduce(final T left, final T right, final ExecCtx ctx) throws Exception {
            
            final X leftResult = this.function.execute(left, ctx);
            final X rightResult = this.function.execute(right, ctx);
            
            if (leftResult == null) {
                return right;
            }
            if (rightResult == null) {
                return left;
            }
            final int comparison = leftResult.compareTo(rightResult); 
            if (comparison <= 0) {
                return left;
            }
            return right;
        }
        
    }
    
}
