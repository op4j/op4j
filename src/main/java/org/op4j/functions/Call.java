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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.util.VarArgsUtil;



/**
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
    
    
    
    public static Call<Object,Object> asObject(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Call<Object,R> asType(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<Object,R>(resultType, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    
    public static Call<Object,BigInteger> asBigInteger(final String methodName, final Object... optionalParameters) {
        return new Call<Object,BigInteger>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,BigDecimal> asBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Call<Object,BigDecimal>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Boolean> asBoolean(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Boolean>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Byte> asByte(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Byte>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Character> asCharacter(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Character>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Calendar> asCalendar(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Calendar>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Date> asDate(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Date>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Double> asDouble(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Double>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Float> asFloat(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Float>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Integer> asInteger(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Integer>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Long> asLong(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Long>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,Short> asShort(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Short>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Object,String> asString(final String methodName, final Object... optionalParameters) {
        return new Call<Object,String>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
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
