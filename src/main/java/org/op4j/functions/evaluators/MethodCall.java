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
public class MethodCall<R,T> implements IEvaluator<R,T> {
    
    
    private final Type<R> resultType;
    private final String methodName;
    private final Object[] parameters;
    
    
    
    public static MethodCall<?,Object> forObject(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Object,Object>(Types.OBJECT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static <R> MethodCall<R,Object> forObjectOfType(final Type<R> resultType, final String methodName, final Object... optionalParameters) {
        return new MethodCall<R,Object>(resultType, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }


    
    public static MethodCall<BigInteger,Object> forBigInteger(final String methodName, final Object... optionalParameters) {
        return new MethodCall<BigInteger,Object>(Types.BIG_INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<BigDecimal,Object> forBigDecimal(final String methodName, final Object... optionalParameters) {
        return new MethodCall<BigDecimal,Object>(Types.BIG_DECIMAL, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Boolean,Object> forBoolean(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Boolean,Object>(Types.BOOLEAN, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Byte,Object> forByte(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Byte,Object>(Types.BYTE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Character,Object> forCharacter(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Character,Object>(Types.CHARACTER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Calendar,Object> forCalendar(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Calendar,Object>(Types.CALENDAR, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Date,Object> forDate(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Date,Object>(Types.DATE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Double,Object> forDouble(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Double,Object>(Types.DOUBLE, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Float,Object> forFloat(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Float,Object>(Types.FLOAT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Integer,Object> forInteger(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Integer,Object>(Types.INTEGER, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Long,Object> forLong(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Long,Object>(Types.LONG, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<Short,Object> forShort(final String methodName, final Object... optionalParameters) {
        return new MethodCall<Short,Object>(Types.SHORT, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    public static MethodCall<String,Object> forString(final String methodName, final Object... optionalParameters) {
        return new MethodCall<String,Object>(Types.STRING, methodName, VarArgsUtil.asOptionalObjectArray(Object.class,optionalParameters));
    }
    
    

    
    
    
    
    private MethodCall(final Type<R> resultType, final String methodName, final Object[] parameters) {
        Validate.notNull(resultType, "Result type cannot be null");
        Validate.notNull(methodName, "Method name cannot be null");
        this.resultType = resultType;
        this.methodName = methodName;
        this.parameters = parameters;
    }
    
    
    
    public Type<? extends R> getResultType(final Type<? extends T> targetType) {
    	return this.resultType;
    }

    
	
    @SuppressWarnings("unchecked")
	public R execute(final T input, final ExecCtx ctx) throws Exception {

        final Expression expression = new Expression(input, this.methodName, this.parameters);
        return (R) expression.getValue();
        
    }
	
}
