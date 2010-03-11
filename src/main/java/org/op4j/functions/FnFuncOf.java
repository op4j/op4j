package org.op4j.functions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.ExecCtxImpl;
import org.op4j.util.ValuePair;

public class FnFuncOf<T> {


    
    protected final Type<T> type;

    

    
    public final IFunction<T[],T> foldLeftArray(final IFunction<ValuePair<T>,T> function) {
        return new FoldLeftArray<T>(function);
    }
    
    public final IFunction<T[],T> foldRightArray(final IFunction<ValuePair<T>,T> function) {
        return new FoldRightArray<T>(function);
    }
    
    
    
    
    protected FnFuncOf(final Type<T> type) {
        super();
        this.type = type;
    }

    
    
    
    
    
    static final class FoldLeftArray<T> extends AbstractNotNullFunction<T[],T> {
        
        private final IFunction<ValuePair<T>,T> function;

        
        public FoldLeftArray(final IFunction<ValuePair<T>, T> function) {
            super();
            Validate.notNull(function, "Fold function cannot be null");
            this.function = function;
        }

        @Override
        public T notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                throw new ExecutionException("Cannot fold: array contains no elements");
            }
            if (input.length == 1) {
                return input[0];
            }
            T result = input[0];
            for (int i = 1, z = input.length; i < z; i++) {
                final ValuePair<T> currentPair = new ValuePair<T>(result, input[i]);
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i - 1));
                result = this.function.execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }
    


    
    static final class FoldRightArray<T> extends AbstractNotNullFunction<T[],T> {
        
        private final IFunction<ValuePair<T>,T> function;

        
        public FoldRightArray(final IFunction<ValuePair<T>, T> function) {
            super();
            Validate.notNull(function, "Fold function cannot be null");
            this.function = function;
        }

        @Override
        public T notNullExecute(final T[] input, final ExecCtx ctx) throws Exception {
            if (input.length == 0) {
                throw new ExecutionException("Cannot fold: array contains no elements");
            }
            if (input.length == 1) {
                return input[0];
            }
            T result = input[input.length - 1];
            for (int i = input.length - 2, z = 0; i >= z; i--) {
                final ValuePair<T> currentPair = new ValuePair<T>(input[i], result);
                final ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(i - 1));
                result = this.function.execute(currentPair, currentCtx);
            }
            return result;
        }
        
    }

    
    
    static final class UnfoldArray<T> extends AbstractNotNullFunction<T,T[]> {
        
        private final IFunction<T,ValuePair<T>> function;
        private final IFunction<T,Boolean> finish;

        
        public UnfoldArray(final IFunction<T,ValuePair<T>> function, final IFunction<T,Boolean> finish) {
            super();
            Validate.notNull(function, "Unfold function cannot be null");
            this.function = function;
            this.finish = finish;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T[] notNullExecute(final T input, final ExecCtx ctx) throws Exception {
            
            final Class<T> inputClass = (Class<T>) input.getClass();
            final List<T> resultList = new ArrayList<T>();
            int index = 0;
            
            T currentTarget = input;
            ExecCtx currentCtx = new ExecCtxImpl(Integer.valueOf(index));
            
            while (!stop(currentTarget, currentCtx)) {
                final ValuePair<T> currentResult = 
                    this.function.execute(currentTarget, currentCtx);
                resultList.add(currentResult.getLeft());
                currentTarget = currentResult.getRight();
                index++;
            }
            resultList.add(currentTarget);
            
            return (T[]) resultList.toArray((T[])Array.newInstance(inputClass, resultList.size()));
            
        }
        
        
        public boolean stop(final T input, final ExecCtx ctx) throws Exception {
            if (this.finish == null) {
                return this.finish.execute(input, ctx).booleanValue();
            }
            return (input == null);
        }
        
    }
    
    
}
