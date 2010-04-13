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
import org.javaruntype.type.Type;
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
    
    
    
    
    
    public static final <X,Y,Z> Function<X,Z> chain(final IFunction<X,Y> fn1, final IFunction<? super Y,Z> fn2) {
        return new Chain<X,Y,Z>(fn1, fn2);
    }
    

    
    
    public static final <T> Function<T,T> ifTrueThen(
            final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return new IfThen<T>(true, targetType, condition, thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifTrueThenElse(
            final Type<T> targetType,
            final IFunction<? super T, Boolean> condition,  final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return new IfThenElse<T,R>(true, targetType, condition, thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifFalseThen(
            final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return new IfThen<T>(false, targetType, condition, thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifFalseThenElse(
            final Type<T> targetType,
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return new IfThenElse<T,R>(false, targetType, condition, thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNullThen(final Type<T> targetType, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnObject.isNull(), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNullThenElse(
            final Type<T> targetType, 
            final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnObject.isNull(), thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNotNullThen(final Type<T> targetType, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnObject.isNotNull(), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNotNullThenElse(
            final Type<T> targetType, 
            final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnObject.isNotNull(), thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNullOrTrueThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.or(FnObject.isNull(),condition), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNullOrTrueThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.or(FnObject.isNull(),condition), thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNullOrFalseThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.or(FnObject.isNull(), FnBoolean.not(condition)), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNullOrFalseThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.or(FnObject.isNull(), FnBoolean.not(condition)), thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNotNullAndTrueThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.and(FnObject.isNotNull(),condition), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNotNullAndTrueThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.and(FnObject.isNotNull(),condition), thenFunction, elseFunction);
    }
    
    public static final <T> Function<T,T> ifNotNullAndFalseThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.and(FnObject.isNotNull(), FnBoolean.not(condition)), thenFunction);
    }
    
    public static final <T,R> Function<T,R> ifNotNullAndFalseThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.and(FnObject.isNotNull(), FnBoolean.not(condition)), thenFunction, elseFunction);
    }
    
    
    
    
    public static final <T> Function<T,T> whileTrue(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> thenFunction) {
        return new WhileDo<T>(true, condition, thenFunction);
    }
    
    public static final <T> Function<T,T> whileFalse(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> thenFunction) {
        return new WhileDo<T>(false, condition, thenFunction);
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

    
    
    
    private static final class IfThen<T> extends Function<T,T> {
        
        private final IFunction<? super T, Boolean> condition;
        private final IFunction<? super T, ? extends T> thenFunction;
        private final boolean desiredResult;
        
        public IfThen(final boolean desiredResult,
                final Type<T> targetType, 
                final IFunction<? super T, Boolean> condition, 
                final IFunction<? super T,? extends T> thenFunction) {
            super();
            Validate.notNull(condition, "Condition cannot be null");
            Validate.notNull(thenFunction, "Then function cannot be null");
            this.desiredResult = desiredResult;
            this.condition = condition;
            this.thenFunction = thenFunction;
        }

        public T execute(final T input, final ExecCtx ctx) throws Exception {
            
            final Boolean conditionResult = this.condition.execute(input, ctx);
            if (conditionResult == null) {
                throw new ExecutionException("Condition returned null, which is not allowed");
            }
            if (conditionResult.booleanValue() == this.desiredResult) {
                return this.thenFunction.execute(input, ctx);
            }
            return input;
        }
        
    }
    
    

    
    
    private static final class IfThenElse<T,R> extends Function<T,R> {
        
        private final IFunction<? super T, Boolean> condition;
        private final IFunction<? super T, R> thenFunction;
        private final IFunction<? super T, R> elseFunction;
        private final boolean desiredResult;
        
        public IfThenElse(final boolean desiredResult, 
                final Type<T> targetType,
                final IFunction<? super T, Boolean> condition, 
                final IFunction<? super T, R> thenFunction,
                final IFunction<? super T, R> elseFunction) {
            super();
            Validate.notNull(condition, "Condition cannot be null");
            Validate.notNull(thenFunction, "Then function cannot be null");
            Validate.notNull(elseFunction, "Else function cannot be null");
            this.desiredResult = desiredResult;
            this.condition = condition;
            this.thenFunction = thenFunction;
            this.elseFunction = elseFunction;
        }

        public R execute(final T input, final ExecCtx ctx) throws Exception {
            
            final Boolean conditionResult = this.condition.execute(input, ctx);
            if (conditionResult == null) {
                throw new ExecutionException("Condition returned null, which is not allowed");
            }
            if (conditionResult.booleanValue() == this.desiredResult) {
                return this.thenFunction.execute(input, ctx);
            }
            return this.elseFunction.execute(input, ctx);
        }
        
    }
    
    
    
    private static final class WhileDo<T> extends Function<T,T> {
        
        private final IFunction<? super T, Boolean> condition;
        private final IFunction<? super T, T> function;
        private final boolean desiredResult;
        
        public WhileDo(final boolean desiredResult, final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
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
