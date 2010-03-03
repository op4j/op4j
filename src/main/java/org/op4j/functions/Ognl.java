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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ognl.OgnlException;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;
import org.op4j.util.VarArgsUtil;


/** 
 * @author Daniel Fern&aacute;ndez
 *
 * @since 1.0
 */
public final class Ognl<T,R> implements IFunction<T,R> {
    
    @SuppressWarnings("unchecked")
    private static final Map<String,Object> parsedExpressionsByExpression =
        Collections.synchronizedMap(new LRUMap(100));
    
    
    public static final String TARGET_VARIABLE_NAME = "target";
    public static final String PARAM_VARIABLE_NAME = "param";
    public static final String INDEX_VARIABLE_NAME = "index";


    
    
    
    private final Type<R> resultType;
    private final String ognlExpression;
    private final Object[] parameters;
    
    
    
    public static Ognl<Object,Object> asObject(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Object>(Types.OBJECT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static <R> Ognl<Object,R> asType(final Type<R> resultType, final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,R>(resultType, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }

    
    
    
    public static Ognl<Object,BigInteger> asBigInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,BigInteger>(Types.BIG_INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,BigDecimal> asBigDecimal(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,BigDecimal>(Types.BIG_DECIMAL, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Boolean> asBoolean(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Boolean>(Types.BOOLEAN, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Byte> asByte(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Byte>(Types.BYTE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Character> asCharacter(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Character>(Types.CHARACTER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Calendar> asCalendar(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Calendar>(Types.CALENDAR, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Date> asDate(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Date>(Types.DATE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Double> asDouble(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Double>(Types.DOUBLE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Float> asFloat(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Float>(Types.FLOAT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Integer> asInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Integer>(Types.INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Long> asLong(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Long>(Types.LONG, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,Short> asShort(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Short>(Types.SHORT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Object,String> asString(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,String>(Types.STRING, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    
    
    
    
    private Ognl(final Type<R> resultType, final String ognlExpression, final Object[] parameters) {
    	Validate.notNull(resultType, "Result type cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultType = resultType;
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    
    public R execute(final T input, final ExecCtx ctx) throws Exception {
        return evalOgnlExpression(this.resultType, this.ognlExpression, input, this.parameters, ctx);
    }
    




    
    
    @SuppressWarnings("unchecked")
    public static <X> X evalOgnlExpression(
            final Type<X> resultType, final String ognlExpression, final Object targetObject, final Object parametersObject, 
            final ExecCtx execCtx) {
        
        Object parsedExpression = parsedExpressionsByExpression.get(ognlExpression);
        
        final Class<? super X> resultClass = resultType.getRawClass();
        
        if (parsedExpression == null) {
            try {
                parsedExpression = ognl.Ognl.parseExpression(ognlExpression);
            } catch (OgnlException e) {
                throw new ExecutionException(e);
            }
            parsedExpressionsByExpression.put(ognlExpression,parsedExpression);
        }
        
        try {
            final Map<String,Object> ctx = new HashMap<String,Object>();
            ctx.put(TARGET_VARIABLE_NAME, targetObject);
            ctx.put(PARAM_VARIABLE_NAME, parametersObject);
            ctx.put(INDEX_VARIABLE_NAME, execCtx.getIndex());
            final Object result = ognl.Ognl.getValue(parsedExpression, ctx, targetObject);
            if (result != null && resultClass != null && !Object.class.equals(resultClass)) {
                if (!(resultClass.isAssignableFrom(result.getClass()))) {
                    throw new IllegalStateException("Result of expression \"" + ognlExpression + "\" is not " +
                            "assignable from class " + resultClass.getName());
                }
            }
            return (X) result;
        } catch (OgnlException e) {
            throw new ExecutionException(e);
        }
        
    }
    
    
    
}
