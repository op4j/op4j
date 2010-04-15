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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;



/**
 * <p>
 * Function hub class for executing attribute getters in target objects.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Get<T,R> extends Function<T,R> {
    
    
    private final Type<R> resultType;
    private final String attributeName;
    
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Object.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Object> attrOfObject(final String attributeName) {
        return new Get<Object,Object>(Types.OBJECT, attributeName);
    }

    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns R, being
     * <tt>R</tt> the specified type.
     * </p>
     * <p>
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     *
     * @param resultType the type of the attribute
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static <R> Function<Object,R> attrOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,R>(resultType, attributeName);
    }


    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns BigInteger.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,BigInteger> attrOfBigInteger(final String attributeName) {
        return new Get<Object,BigInteger>(Types.BIG_INTEGER, attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns BigDecimal.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,BigDecimal> attrOfBigDecimal(final String attributeName) {
        return new Get<Object,BigDecimal>(Types.BIG_DECIMAL, attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Boolean.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Boolean> attrOfBoolean(final String attributeName) {
        return new Get<Object,Boolean>(Types.BOOLEAN, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Byte.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Byte> attrOfByte(final String attributeName) {
        return new Get<Object,Byte>(Types.BYTE, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Character.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Character> attrOfCharacter(final String attributeName) {
        return new Get<Object,Character>(Types.CHARACTER, attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Calendar.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Calendar> attrOfCalendar(final String attributeName) {
        return new Get<Object,Calendar>(Types.CALENDAR, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Date.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Date> attrOfDate(final String attributeName) {
        return new Get<Object,Date>(Types.DATE, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Double.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Double> attrOfDouble(final String attributeName) {
        return new Get<Object,Double>(Types.DOUBLE, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Float.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Float> attrOfFloat(final String attributeName) {
        return new Get<Object,Float>(Types.FLOAT, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Integer.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Integer> attrOfInteger(final String attributeName) {
        return new Get<Object,Integer>(Types.INTEGER, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Long.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Long> attrOfLong(final String attributeName) {
        return new Get<Object,Long>(Types.LONG, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Short.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Short> attrOfShort(final String attributeName) {
        return new Get<Object,Short>(Types.SHORT, attributeName);
    }
    
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns String.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,String> attrOfString(final String attributeName) {
        return new Get<Object,String>(Types.STRING, attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns List&lt;String&gt;.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,List<String>> attrOfListOfString(final String attributeName) {
        return new Get<Object,List<String>>(Types.LIST_OF_STRING, attributeName);
    }

    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Set&lt;String&gt;.
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,Set<String>> attrOfSetOfString(final String attributeName) {
        return new Get<Object,Set<String>>(Types.SET_OF_STRING, attributeName);
    }

    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns String[].
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     * 
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static Function<Object,String[]> attrOfArrayOfString(final String attributeName) {
        return new Get<Object,String[]>(Types.ARRAY_OF_STRING, attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns List&lt;R&gt;,
     * being <tt>R</tt> the specified type.
     * </p>
     * <p>
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     *
     * @param resultType the component type of the result list type.
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static <R> Function<Object,List<R>> attrOfListOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,List<R>>(Types.listOf(resultType), attributeName);
    }
    
    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns Set&lt;R&gt;,
     * being <tt>R</tt> the specified type.
     * </p>
     * <p>
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     *
     * @param resultType the component type of the result set type.
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static <R> Function<Object,Set<R>> attrOfSetOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,Set<R>>(Types.setOf(resultType), attributeName);
    }
    

    /**
     * <p>
     * Executes a getter (<tt>getX()</tt>) on the target object which returns R[],
     * being <tt>R</tt> the specified type.
     * </p>
     * <p>
     * If the specified attribute is, for example, "<tt>name</tt>", the called method
     * will be "<tt>getName()</tt>".
     * </p>
     *
     * @param resultType the component type of the result array type.
     * @param attributeName the name of the attribute
     * @return the result of the method execution
     */
    public static <R> Function<Object,R[]> attrOfArrayOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,R[]>(Types.arrayOf(resultType), attributeName);
    }
    
    

    
    
    
    
    private Get(final Type<R> resultType, final String attributeName) {
        Validate.notNull(attributeName, "Attribute name cannot be null");
        this.resultType = resultType;
        this.attributeName = attributeName;
    }
    
    
    
    @SuppressWarnings("unchecked")
	public R execute(final T input, final ExecCtx ctx) throws Exception {

        final Class<? super R> resultClass = this.resultType.getRawClass();
        
        final Expression expression = new Expression(input, "get" + StringUtils.capitalize(this.attributeName), null);
        final R result = (R) expression.getValue();
        
        if (result != null && resultClass != null && !Object.class.equals(resultClass)) {
            if (!(resultClass.isAssignableFrom(result.getClass()))) {
                throw new IllegalStateException("Result of calling method \"" + this.attributeName + "\" is not " +
                        "assignable from class " + resultClass.getName());
            }
        }
        
        return result;
        
    }
	
}
