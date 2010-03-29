/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.functions;

import org.apache.commons.lang.Validate;
import org.op4j.exceptions.ExecutionException;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class FnFunc {
    

    
    
    
    private FnFunc() {
        super();
    }
    
    
    
    
    
    
    
    public static final <X,R extends X> Function<R,Boolean> and(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return FnBoolean.and(left, right);
    }
    
    public static final <X,R extends X> Function<R,Boolean> or(final IFunction<X,Boolean> left, final IFunction<? super R,Boolean> right) {
        return FnBoolean.or(left, right);
    }
    
    public static final <T> Function<T,Boolean> not(final IFunction<T, Boolean> function) {
        return FnBoolean.not(function);
    }
    
    public static final <X,Y> Function<X,Boolean> by(final IFunction<X,Y> by, final IFunction<? super Y,Boolean> eval) {
        return chain(by, eval);
    }
    
    
    public static final <X,Y,Z> Function<X,Z> chain(final IFunction<X,Y> fn1, final IFunction<? super Y,Z> fn2) {
        return new Chain<X,Y,Z>(fn1, fn2);
    }
    

    
    
    public static final <R> Function<R,R> ifTrue(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return new If<R>(true, condition, function);
    }
    
    public static final <R> Function<R,R> ifFalse(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return new If<R>(false, condition, function);
    }
    
    public static final <T> Function<T,T> ifNull(final IFunction<? super T,T> function) {
        return ifTrue(FnObject.isNull(), function);
    }
    
    // TODO This should be T,R
    public static final <T> Function<T,T> ifNotNull(final IFunction<? super T,T> function) {
        return ifTrue(FnObject.isNotNull(), function);
    }
    
    public static final <R> Function<R,R> ifNullOrTrue(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return ifTrue(FnFunc.or(FnObject.isNull(),condition), function);
    }
    
    public static final <R> Function<R,R> ifNullOrFalse(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return ifTrue(FnFunc.or(FnObject.isNull(), FnFunc.not(condition)), function);
    }
    
    public static final <R> Function<R,R> ifNotNullAndTrue(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return ifTrue(FnFunc.and(FnObject.isNotNull(),condition), function);
    }
    
    public static final <R> Function<R,R> ifNotNullAndFalse(final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
        return ifTrue(FnFunc.and(FnObject.isNotNull(), FnFunc.not(condition)), function);
    }
    
    
    
    
    public static final <T> Function<T,T> whileTrue(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
        return new While<T>(true, condition, function);
    }
    
    public static final <T> Function<T,T> whileFalse(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
        return new While<T>(false, condition, function);
    }
    
    
    
    
    
    
    
    
    private static final class Chain<X,Y,Z> extends Function<X,Z> {

        private final IFunction<X,Y> fn1;
        private final IFunction<? super Y,Z> fn2; 

        
        public Chain(final IFunction<X,Y> fn1, final IFunction<? super Y,Z> fn2) {
            super();
            Validate.notNull(fn1, "Null function received: First function in concat is null");
            Validate.notNull(fn2, "Null function received: Second function in concat is null");
            this.fn1 = fn1;
            this.fn2 = fn2;
        }

        
        public Z execute(final X input, final ExecCtx ctx) throws Exception {
            return this.fn2.execute(this.fn1.execute(input, ctx), ctx);
        }
        
    }
    
    
    
    private static final class If<R> extends Function<R,R> {
        
        private final IFunction<? super R, Boolean> condition;
        private final IFunction<? super R, R> function;
        private final boolean desiredResult;
        
        public If(final boolean desiredResult, final IFunction<? super R, Boolean> condition, final IFunction<? super R,R> function) {
            super();
            Validate.notNull(condition, "Condition cannot be null");
            Validate.notNull(function, "Function cannot be null");
            this.desiredResult = desiredResult;
            this.condition = condition;
            this.function = function;
        }

        public R execute(final R input, final ExecCtx ctx) throws Exception {
            
            final Boolean conditionResult = this.condition.execute(input, ctx);
            if (conditionResult == null) {
                throw new ExecutionException("Condition returned null, which is not allowed");
            }
            if (conditionResult.booleanValue() == this.desiredResult) {
                return this.function.execute(input, ctx);
            }
            return input;
        }
        
    }
    
    
    
    private static final class While<T> extends Function<T,T> {
        
        private final IFunction<? super T, Boolean> condition;
        private final IFunction<? super T, T> function;
        private final boolean desiredResult;
        
        public While(final boolean desiredResult, final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
            super();
            Validate.notNull(condition, "Condition cannot be null");
            Validate.notNull(function, "Function cannot be null");
            this.desiredResult = desiredResult;
            this.condition = condition;
            this.function = function;
        }

        public T execute(final T input, final ExecCtx ctx) throws Exception {
            
            T result = input;
            
            Boolean conditionResult = this.condition.execute(result, ctx);
            if (conditionResult == null) {
                throw new ExecutionException("Condition returned null, which is not allowed");
            }
            
            while (conditionResult.booleanValue() == this.desiredResult) {
                result = this.function.execute(result, ctx);
                conditionResult = this.condition.execute(result, ctx);
                if (conditionResult == null) {
                    throw new ExecutionException("Condition returned null, which is not allowed");
                }
            }
            
            return result;
            
        }
        
    }
    
    

}
