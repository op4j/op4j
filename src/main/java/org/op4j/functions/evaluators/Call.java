/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
package org.op4j.functions.evaluators;

import java.beans.Expression;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ExecCtx;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Call<R,T> implements IEvaluator<R,T> {
    
    
    private final Type<R> resultType;
    private final String methodName;
    private final Object[] parameters;
    
    
    
    public static Call<?,Object> asObject(final String methodName, final Object... optionalParameters) {
        return new Call<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> Call<R,Object> asType(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new Call<R,Object>(resultType, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    
    public static Call<BigInteger,Object> asBigInteger(final String methodName, final Object... optionalParameters) {
        return new Call<BigInteger,Object>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<BigDecimal,Object> asBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Call<BigDecimal,Object>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Boolean,Object> asBoolean(final String methodName, final Object... optionalParameters) {
        return new Call<Boolean,Object>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Byte,Object> asByte(final String methodName, final Object... optionalParameters) {
        return new Call<Byte,Object>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Character,Object> asCharacter(final String methodName, final Object... optionalParameters) {
        return new Call<Character,Object>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Calendar,Object> asCalendar(final String methodName, final Object... optionalParameters) {
        return new Call<Calendar,Object>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Date,Object> asDate(final String methodName, final Object... optionalParameters) {
        return new Call<Date,Object>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Double,Object> asDouble(final String methodName, final Object... optionalParameters) {
        return new Call<Double,Object>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Float,Object> asFloat(final String methodName, final Object... optionalParameters) {
        return new Call<Float,Object>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Integer,Object> asInteger(final String methodName, final Object... optionalParameters) {
        return new Call<Integer,Object>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Long,Object> asLong(final String methodName, final Object... optionalParameters) {
        return new Call<Long,Object>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<Short,Object> asShort(final String methodName, final Object... optionalParameters) {
        return new Call<Short,Object>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static Call<String,Object> asString(final String methodName, final Object... optionalParameters) {
        return new Call<String,Object>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    

    
    
    
    
    private Call(final Type<R> resultType, final String methodName, final Object[] parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
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
