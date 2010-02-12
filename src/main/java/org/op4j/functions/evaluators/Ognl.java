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
public class Ognl<R,T> implements IEvaluator<R,T> {
    
    
    
    private final Type<R> resultType;
    private final String ognlExpression;
    private final Object[] parameters;
    
    
    
    public static Ognl<?,Object> asObject(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Object,Object>(Types.OBJECT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static <R> Ognl<R,Object> asType(final Type<R> resultType, final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<R,Object>(resultType, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }

    
    
    
    public static Ognl<BigInteger,Object> asBigInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<BigInteger,Object>(Types.BIG_INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<BigDecimal,Object> asBigDecimal(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<BigDecimal,Object>(Types.BIG_DECIMAL, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Boolean,Object> asBoolean(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Boolean,Object>(Types.BOOLEAN, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Byte,Object> asByte(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Byte,Object>(Types.BYTE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Character,Object> asCharacter(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Character,Object>(Types.CHARACTER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Calendar,Object> asCalendar(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Calendar,Object>(Types.CALENDAR, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Date,Object> asDate(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Date,Object>(Types.DATE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Double,Object> asDouble(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Double,Object>(Types.DOUBLE, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Float,Object> asFloat(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Float,Object>(Types.FLOAT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Integer,Object> asInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Integer,Object>(Types.INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Long,Object> asLong(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Long,Object>(Types.LONG, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<Short,Object> asShort(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<Short,Object>(Types.SHORT, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    public static Ognl<String,Object> asString(final String ognlExpression, final Object... optionalParameters) {
        return new Ognl<String,Object>(Types.STRING, ognlExpression, VarArgsUtil.asOptionalObjectArray(Object.class, optionalParameters));
    }
    
    
    
    
    
    private Ognl(final Type<R> resultType, final String ognlExpression, final Object[] parameters) {
    	Validate.notNull(resultType, "Result type cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultType = resultType;
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    
    public R execute(final T input, final ExecCtx ctx) throws Exception {
        return OgnlExpressionUtil.evalOgnlExpression(this.resultType, this.ognlExpression, input, this.parameters, ctx);
    }
    
    
    
}
