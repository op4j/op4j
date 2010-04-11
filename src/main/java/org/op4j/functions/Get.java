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

import com.sun.xml.internal.ws.util.StringUtils;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Get<T,R> extends Function<T,R> {
    
    
    private final Type<R> resultType;
    private final String methodName;
    private final Object[] parameters;
    
    
    
    public static Function<Object,Object> attrOfObject(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Function<Object,R> attrOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Get<Object,R>(resultType, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    
    public static Function<Object,BigInteger> attrOfBigInteger(final String methodName, final Object... optionalParameters) {
        return new Get<Object,BigInteger>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,BigDecimal> attrOfBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Get<Object,BigDecimal>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Boolean> attrOfBoolean(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Boolean>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Byte> attrOfByte(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Byte>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Character> attrOfCharacter(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Character>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Calendar> attrOfCalendar(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Calendar>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Date> attrOfDate(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Date>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Double> attrOfDouble(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Double>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Float> attrOfFloat(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Float>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Integer> attrOfInteger(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Integer>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Long> attrOfLong(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Long>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Short> attrOfShort(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Short>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,String> attrOfString(final String methodName, final Object... optionalParameters) {
        return new Get<Object,String>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,List<String>> attrOfListOfString(final String methodName, final Object... optionalParameters) {
        return new Get<Object,List<String>>(Types.LIST_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,Set<String>> attrOfSetOfString(final String methodName, final Object... optionalParameters) {
        return new Get<Object,Set<String>>(Types.SET_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Function<Object,String[]> attrOfArrayOfString(final String methodName, final Object... optionalParameters) {
        return new Get<Object,String[]>(Types.ARRAY_OF_STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Function<Object,List<R>> attrOfListOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Get<Object,List<R>>(Types.listOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Function<Object,Set<R>> attrOfSetOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Get<Object,Set<R>>(Types.setOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Function<Object,R[]> attrOfArrayOf(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Get<Object,R[]>(Types.arrayOf(resultType), methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    

    
    
    
    
    private Get(final Type<R> resultType, final String attributeName, final Object[] parameters) {
        Validate.notNull(attributeName, "Attribute name cannot be null");
        this.resultType = resultType;
        this.methodName = attributeName;
        this.parameters = parameters;
    }
    
    
    
    @SuppressWarnings("unchecked")
	public R execute(final T input, final ExecCtx ctx) throws Exception {

        final Class<? super R> resultClass = this.resultType.getRawClass();
        
        final Expression expression = new Expression(input, "get" + StringUtils.capitalize(this.methodName), this.parameters);
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
