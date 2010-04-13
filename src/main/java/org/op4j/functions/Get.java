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
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Get<T,R> extends Function<T,R> {
    
    
    private final Type<R> resultType;
    private final String attributeName;
    
    
    
    public static Function<Object,Object> attrOfObject(final String attributeName) {
        return new Get<Object,Object>(Types.OBJECT, attributeName);
    }
    
    public static <R> Function<Object,R> attrOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,R>(resultType, attributeName);
    }


    
    public static Function<Object,BigInteger> attrOfBigInteger(final String attributeName) {
        return new Get<Object,BigInteger>(Types.BIG_INTEGER, attributeName);
    }
    
    public static Function<Object,BigDecimal> attrOfBigDecimal(final String attributeName) {
        return new Get<Object,BigDecimal>(Types.BIG_DECIMAL, attributeName);
    }
    
    public static Function<Object,Boolean> attrOfBoolean(final String attributeName) {
        return new Get<Object,Boolean>(Types.BOOLEAN, attributeName);
    }
    
    public static Function<Object,Byte> attrOfByte(final String attributeName) {
        return new Get<Object,Byte>(Types.BYTE, attributeName);
    }
    
    public static Function<Object,Character> attrOfCharacter(final String attributeName) {
        return new Get<Object,Character>(Types.CHARACTER, attributeName);
    }
    
    public static Function<Object,Calendar> attrOfCalendar(final String attributeName) {
        return new Get<Object,Calendar>(Types.CALENDAR, attributeName);
    }
    
    public static Function<Object,Date> attrOfDate(final String attributeName) {
        return new Get<Object,Date>(Types.DATE, attributeName);
    }
    
    public static Function<Object,Double> attrOfDouble(final String attributeName) {
        return new Get<Object,Double>(Types.DOUBLE, attributeName);
    }
    
    public static Function<Object,Float> attrOfFloat(final String attributeName) {
        return new Get<Object,Float>(Types.FLOAT, attributeName);
    }
    
    public static Function<Object,Integer> attrOfInteger(final String attributeName) {
        return new Get<Object,Integer>(Types.INTEGER, attributeName);
    }
    
    public static Function<Object,Long> attrOfLong(final String attributeName) {
        return new Get<Object,Long>(Types.LONG, attributeName);
    }
    
    public static Function<Object,Short> attrOfShort(final String attributeName) {
        return new Get<Object,Short>(Types.SHORT, attributeName);
    }
    
    public static Function<Object,String> attrOfString(final String attributeName) {
        return new Get<Object,String>(Types.STRING, attributeName);
    }
    
    public static Function<Object,List<String>> attrOfListOfString(final String attributeName) {
        return new Get<Object,List<String>>(Types.LIST_OF_STRING, attributeName);
    }
    
    public static Function<Object,Set<String>> attrOfSetOfString(final String attributeName) {
        return new Get<Object,Set<String>>(Types.SET_OF_STRING, attributeName);
    }
    
    public static Function<Object,String[]> attrOfArrayOfString(final String attributeName) {
        return new Get<Object,String[]>(Types.ARRAY_OF_STRING, attributeName);
    }
    
    public static <R> Function<Object,List<R>> attrOfListOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,List<R>>(Types.listOf(resultType), attributeName);
    }
    
    public static <R> Function<Object,Set<R>> attrOfSetOf(final Type<R> resultType, final String attributeName) {
        return new Get<Object,Set<R>>(Types.setOf(resultType), attributeName);
    }
    
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
