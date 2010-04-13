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
    
    
    
    
    /**
     * <p>
     * Chains two functions together. The returned function executes the specified
     * functions in sequence, being <tt>fn2</tt> executed on the results of <tt>fn1</tt>.
     * </p>
     * 
     * @param fn1 the first function to be executed
     * @param fn2 the second function to be executed
     * @return a function that executes first fn1, then fn2 on the results of fn1.
     */
    public static final <X,Y,Z> Function<X,Z> chain(final IFunction<X,Y> fn1, final IFunction<? super Y,Z> fn2) {
        return new Chain<X,Y,Z>(fn1, fn2);
    }
    

    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the result of executing <tt>condition</tt> on the target object is true.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if condition is true
     * @return a function that executes the "thenFunction" if "condition" is true.
     */
    public static final <T> Function<T,T> ifTrueThen(
            final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return new IfThen<T>(true, targetType, condition, thenFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the result of executing <tt>condition</tt> on the target object is true,
     * and will execute the specified function <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if condition is true
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if "condition" is true and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifTrueThenElse(
            final Type<T> targetType,
            final IFunction<? super T, Boolean> condition,  final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return new IfThenElse<T,R>(true, targetType, condition, thenFunction, elseFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the result of executing <tt>condition</tt> on the target object is false.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if condition is false
     * @return a function that executes the "thenFunction" if "condition" is false.
     */
    public static final <T> Function<T,T> ifFalseThen(
            final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return new IfThen<T>(false, targetType, condition, thenFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the result of executing <tt>condition</tt> on the target object is false,
     * and will execute the specified function <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if condition is false
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if "condition" is false and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifFalseThenElse(
            final Type<T> targetType,
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return new IfThenElse<T,R>(false, targetType, condition, thenFunction, elseFunction);
    }
    
    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type.
     * @param thenFunction the function to be executed on the target object if it is null.
     * @return a function that executes the "thenFunction" if the target object is null.
     */
    public static final <T> Function<T,T> ifNullThen(final Type<T> targetType, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnObject.isNull(), thenFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param thenFunction the function to be executed on the target object is null
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if the target object is null and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNullThenElse(
            final Type<T> targetType, 
            final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnObject.isNull(), thenFunction, elseFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type.
     * @param thenFunction the function to be executed on the target object if it is not null.
     * @return a function that executes the "thenFunction" if the target object is not null.
     */
    public static final <T> Function<T,T> ifNotNullThen(final Type<T> targetType, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnObject.isNotNull(), thenFunction);
    }
    
    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param thenFunction the function to be executed on the target object is not null
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if the target object is not null and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNotNullThenElse(
            final Type<T> targetType, 
            final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnObject.isNotNull(), thenFunction, elseFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null or the result of executing <tt>condition</tt> on 
     * it is true.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is null or the result of executing condition on it is true
     * @return a function that executes the "thenFunction" if target is null or "condition" is true.
     */
    public static final <T> Function<T,T> ifNullOrTrueThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.or(FnObject.isNull(),condition), thenFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null or the result of executing <tt>condition</tt> 
     * on the target object is true, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is null or the result of executing condition on it is true
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if target is null or "condition" is true, and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNullOrTrueThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.or(FnObject.isNull(),condition), thenFunction, elseFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null or the result of executing <tt>condition</tt> on 
     * it is false.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is null or the result of executing condition on it is false
     * @return a function that executes the "thenFunction" if target is null or "condition" is false.
     */
    public static final <T> Function<T,T> ifNullOrFalseThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.or(FnObject.isNull(), FnBoolean.not(condition)), thenFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is null or the result of executing <tt>condition</tt> 
     * on the target object is false, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is null or the result of executing condition on it is false
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if target is null or "condition" is false, and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNullOrFalseThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.or(FnObject.isNull(), FnBoolean.not(condition)), thenFunction, elseFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null and the result of executing <tt>condition</tt> on 
     * it is true.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is not null and the result of executing condition on it is true
     * @return a function that executes the "thenFunction" if target is not null and "condition" is true.
     */
    public static final <T> Function<T,T> ifNotNullAndTrueThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.and(FnObject.isNotNull(),condition), thenFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null and the result of executing <tt>condition</tt> 
     * on the target object is true, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is not null and the result of executing condition on it is true
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if target is not null and "condition" is true, and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNotNullAndTrueThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.and(FnObject.isNotNull(),condition), thenFunction, elseFunction);
    }
    

    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null and the result of executing <tt>condition</tt> on 
     * it is false.
     * </p>
     * <p>
     * The built function cannot change the return type (receives <tt>T</tt> and returns <tt>T</tt>)
     * because the <tt>thenFunction</tt> could remain unexecuted, and so the type returned by
     * <tt>thenFunction</tt> must be the same as the type required as input, in order to keep
     * consistency.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is not null and the result of executing condition on it is false
     * @return a function that executes the "thenFunction" if target is not null and "condition" is false.
     */
    public static final <T> Function<T,T> ifNotNullAndFalseThen(final Type<T> targetType, final IFunction<? super T, Boolean> condition, final IFunction<? super T,? extends T> thenFunction) {
        return ifTrueThen(targetType, FnBoolean.and(FnObject.isNotNull(), FnBoolean.not(condition)), thenFunction);
    }

    
    /**
     * <p>
     * Builds a function that will execute the specified function <tt>thenFunction</tt> 
     * only if the target object is not null and the result of executing <tt>condition</tt> 
     * on the target object is false, and will execute the specified function 
     * <tt>elseFunction</tt> otherwise.
     * </p>
     * <p>
     * The built function can effectively change the target type (receive <tt>T</tt> and 
     * return <tt>R</tt>) if both <tt>thenFunction</tt> and <tt>elseFunction</tt> return
     * the same type, and this is different than the target type <tt>T</tt>.
     * </p>
     * 
     * @param targetType the target type
     * @param condition the condition to be executed on the target object
     * @param thenFunction the function to be executed on the target object if 
     *        target is not null and the result of executing condition on it is false
     * @param elseFunction the function to be executed on the target object otherwise
     * @return a function that executes the "thenFunction" if target is not null and "condition" is false, and "elseFunction" otherwise.
     */
    public static final <T,R> Function<T,R> ifNotNullAndFalseThenElse(
            final Type<T> targetType, 
            final IFunction<? super T, Boolean> condition, final IFunction<? super T,R> thenFunction, final IFunction<? super T,R> elseFunction) {
        return ifTrueThenElse(targetType, FnBoolean.and(FnObject.isNotNull(), FnBoolean.not(condition)), thenFunction, elseFunction);
    }
    
    
    

    /**
     * <p>
     * Executes the specified <tt>function</tt> iteratively (first on the target, then 
     * on the result of the previous iteration) while the result of executing the 
     * <tt>condition</tt> function on the target object (or the result of the previous
     * <tt>function</tt> iteration) is true.
     * </p>
     * 
     * @param condition the condition function to be applied
     * @param function the function to be executed iteratively
     * @return a function executing the specified function iteratively while the condition is true.
     */
    public static final <T> Function<T,T> whileTrue(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
        return new WhileDo<T>(true, condition, function);
    }

    
    /**
     * <p>
     * Executes the specified <tt>function</tt> iteratively (first on the target, then 
     * on the result of the previous iteration) while the result of executing the 
     * <tt>condition</tt> function on the target object (or the result of the previous
     * <tt>function</tt> iteration) is false.
     * </p>
     * 
     * @param condition the condition function to be applied
     * @param function the function to be executed iteratively
     * @return a function executing the specified function iteratively while the condition is false.
     */
    public static final <T> Function<T,T> whileFalse(final IFunction<? super T, Boolean> condition, final IFunction<? super T, T> function) {
        return new WhileDo<T>(false, condition, function);
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
