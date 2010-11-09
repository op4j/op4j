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

import java.beans.Expression;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.util.VarArgsUtil;



/**
 * <p>
 * Function hub class for executing methods of target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Call<T,R> extends Function<T,R> {
    
    
    private final Type<R> resultType;
    private final String methodName;
    private final Object[] parameters;
    
    

    /**
     * <p>
     * Executes a method on the target object which returns Object. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Object> methodForObject(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForObject(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Object> obj(final String methodName, final Object... optionalParameters) {
        return methodForObject(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns an object of the <tt>resultType</tt>. 
     * Parameters must match those of the method.
     * </p>
     *
     * @param resultType the type of the result
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,R> methodFor(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<Object,R>(resultType, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodFor(Type, String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param resultType the type of the result
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,R> obj(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return methodFor(resultType, methodName, optionalParameters);
    }


    
    /**
     * <p>
     * Executes a method on the target object which returns BigInteger. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,BigInteger> methodForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Call<Object,BigInteger>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForBigInteger(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,BigInteger> bigInteger(final String methodName, final Object... optionalParameters) {
        return methodForBigInteger(methodName, optionalParameters);
    }

    
    /**
     * <p>
     * Executes a method on the target object which returns BigDecimal. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,BigDecimal> methodForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Call<Object,BigDecimal>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForBigDecimal(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,BigDecimal> bigDecimal(final String methodName, final Object... optionalParameters) {
        return methodForBigDecimal(methodName, optionalParameters);
    }

    
    /**
     * <p>
     * Executes a method on the target object which returns Boolean. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Boolean> methodForBoolean(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Boolean>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForBoolean(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Boolean> bool(final String methodName, final Object... optionalParameters) {
        return methodForBoolean(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Byte. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Byte> methodForByte(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Byte>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForByte(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Byte> b(final String methodName, final Object... optionalParameters) {
        return methodForByte(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Character. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Character> methodForCharacter(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Character>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForCharacter(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Character> c(final String methodName, final Object... optionalParameters) {
        return methodForCharacter(methodName, optionalParameters);
    }
    

    /**
     * <p>
     * Executes a method on the target object which returns Calendar. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Calendar> methodForCalendar(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Calendar>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForCalendar(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Calendar> calendar(final String methodName, final Object... optionalParameters) {
        return methodForCalendar(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Date. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Date> methodForDate(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Date>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForDate(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Date> date(final String methodName, final Object... optionalParameters) {
        return methodForDate(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Double. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Double> methodForDouble(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Double>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForDouble(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Double> d(final String methodName, final Object... optionalParameters) {
        return methodForDouble(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Float. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Float> methodForFloat(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Float>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForFloat(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Float> f(final String methodName, final Object... optionalParameters) {
        return methodForFloat(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Integer. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Integer> methodForInteger(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Integer>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForInteger(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Integer> i(final String methodName, final Object... optionalParameters) {
        return methodForInteger(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Long. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Long> methodForLong(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Long>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForLong(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Long> l(final String methodName, final Object... optionalParameters) {
        return methodForLong(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns Short. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Short> methodForShort(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Short>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForShort(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Short> shr(final String methodName, final Object... optionalParameters) {
        return methodForShort(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns String. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,String> methodForString(final String methodName, final Object... optionalParameters) {
        return new Call<Object,String>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForString(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,String> s(final String methodName, final Object... optionalParameters) {
        return methodForString(methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns List&lt;String&gt;. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,List<String>> methodForListOfString(final String methodName, final Object... optionalParameters) {
        return new Call<Object,List<String>>(Types.LIST_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForListOfString(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,List<String>> listOfString(final String methodName, final Object... optionalParameters) {
        return methodForListOfString(methodName, optionalParameters);
    }

    
    /**
     * <p>
     * Executes a method on the target object which returns Set&lt;String&gt;. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Set<String>> methodForSetOfString(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Set<String>>(Types.SET_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForSetOfString(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,Set<String>> setOfString(final String methodName, final Object... optionalParameters) {
        return methodForSetOfString(methodName, optionalParameters);
    }

    
    /**
     * <p>
     * Executes a method on the target object which returns String[]. Parameters must match
     * those of the method.
     * </p>
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,String[]> methodForArrayOfString(final String methodName, final Object... optionalParameters) {
        return new Call<Object,String[]>(Types.ARRAY_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForArrayOfString(String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static Function<Object,String[]> arrayOfString(final String methodName, final Object... optionalParameters) {
        return methodForArrayOfString(methodName, optionalParameters);
    }
    

    /**
     * <p>
     * Executes a method on the target object which returns List&lt;R&gt;, being <tt>R</tt> the
     * specified type parameter. Parameters must match those of the method.
     * </p>
     * 
     * @param resultType the type of the method's result
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,List<R>> methodForListOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<Object,List<R>>(Types.listOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForListOf(Type, String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,List<R>> listOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return methodForListOf(resultType, methodName, optionalParameters);
    }

    
    /**
     * <p>
     * Executes a method on the target object which returns Set&lt;R&gt;, being <tt>R</tt> the
     * specified type parameter. Parameters must match those of the method.
     * </p>
     * 
     * @param resultType the type of the method's result
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,Set<R>> methodForSetOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<Object,Set<R>>(Types.setOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForSetOf(Type, String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,Set<R>> setOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return methodForSetOf(resultType, methodName, optionalParameters);
    }
    
    
    /**
     * <p>
     * Executes a method on the target object which returns R[], being <tt>R</tt> the
     * specified type parameter. Parameters must match those of the method.
     * </p>
     * 
     * @param resultType the type of the method's result
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,R[]> methodForArrayOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<Object,R[]>(Types.arrayOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    /**
     * <p>
     * Abbreviation for {{@link #methodForArrayOf(Type, String, Object...)}.
     * </p>
     * 
     * @since 1.1
     * 
     * @param methodName the name of the method
     * @param optionalParameters the (optional) parameters of the method. 
     * @return the result of the method execution
     */
    public static <R> Function<Object,R[]> arrayOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return methodForArrayOf(resultType, methodName, optionalParameters);
    }
    
    

    
    
    
    
    private Call(final Type<R> resultType, final String methodName, final Object[] parameters) {
        Validate.notNull(methodName, "Method name cannot be null");
        this.resultType = resultType;
        this.methodName = methodName;
        this.parameters = parameters;
    }
    
    
    
    @SuppressWarnings("unchecked")
	public R execute(final T input, final ExecCtx ctx) throws Exception {

        final Class<? super R> resultClass = this.resultType.getRawClass();
        
        final Expression expression = new Expression(input, this.methodName, this.parameters);
        final R result = (R) expression.getValue();
        
        if (result != null && resultClass != null && !Object.class.equals(resultClass)) {
            if (!(resultClass.isAssignableFrom(result.getClass()))) {
                throw new IllegalStateException("Result of calling method \"" + this.methodName + "\" is not " +
                        "assignable from class " + resultClass.getName());
            }
        }
        
        return result;
        
    }
	
}
