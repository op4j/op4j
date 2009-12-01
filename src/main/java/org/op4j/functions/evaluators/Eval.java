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
import java.util.List;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.util.OgnlExpressionUtil;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Eval<R,T> implements IEvaluator<R,T> {
    
    
    
    private final Type<R> resultType;
    private final String ognlExpression;
    private final List<Object> parameters;
    
    
    
    public static Eval<?,Object> forObject(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Object,Object>(Types.OBJECT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <R> Eval<R,Object> forObjectOfType(final Type<R> resultType, final String ognlExpression, final Object... optionalParameters) {
        return new Eval<R,Object>(resultType, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }

    
    
    
    public static Eval<BigInteger,Object> forBigInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<BigInteger,Object>(Types.BIG_INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<BigDecimal,Object> forBigDecimal(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<BigDecimal,Object>(Types.BIG_DECIMAL, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Boolean,Object> forBoolean(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Boolean,Object>(Types.BOOLEAN, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Byte,Object> forByte(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Byte,Object>(Types.BYTE, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Character,Object> forCharacter(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Character,Object>(Types.CHARACTER, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Calendar,Object> forCalendar(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Calendar,Object>(Types.CALENDAR, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Date,Object> forDate(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Date,Object>(Types.DATE, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Double,Object> forDouble(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Double,Object>(Types.DOUBLE, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Float,Object> forFloat(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Float,Object>(Types.FLOAT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Integer,Object> forInteger(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Integer,Object>(Types.INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Long,Object> forLong(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Long,Object>(Types.LONG, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Short,Object> forShort(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Short,Object>(Types.SHORT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<String,Object> forString(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<String,Object>(Types.STRING, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    
    
    
    
    private Eval(final Type<R> resultType, final String ognlExpression, final List<Object> parameters) {
    	Validate.notNull(resultType, "Result type cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultType = resultType;
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    private Eval(final Class<R> resultClass, final String ognlExpression, final List<Object> parameters) {
    	Validate.notNull(resultClass, "Result class cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultType = Types.forClass(resultClass);
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    
    public Type<? super R> getResultType() {
    	return this.resultType;
    }
    
    
	public R execute(final T input) throws Exception {
        return OgnlExpressionUtil.evalOgnlExpression(this.resultType, this.ognlExpression, input, this.parameters);
    }
    
    
    
}
