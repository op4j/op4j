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
package org.op4j.executables;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.op4j.IOf;
import org.op4j.Of;
import org.op4j.util.OgnlExpressionUtil;
import org.op4j.util.VarArgsUtil;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Eval<X,T> implements IEval<X,T> {
    
    
    
    private final IOf<X> resultOf;
    private final String ognlExpression;
    private final List<Object> parameters;
    
    
    
    public static Eval<?,Object> exp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Object,Object>(Of.OBJECT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <X> Eval<X,Object> exp(final Of<X> of, final String ognlExpression, final Object... optionalParameters) {
        return new Eval<X,Object>(of, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static <X> Eval<X,Object> exp(final Class<X> ofClass, final String ognlExpression, final Object... optionalParameters) {
        return new Eval<X,Object>(ofClass, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }

    
    public static Eval<BigInteger,Object> bigIntegerExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<BigInteger,Object>(Of.BIG_INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<BigDecimal,Object> bigDecimalExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<BigDecimal,Object>(Of.BIG_DECIMAL, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Boolean,Object> booleanExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Boolean,Object>(Of.BOOLEAN, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Byte,Object> byteExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Byte,Object>(Of.BYTE, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Calendar,Object> calendarExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Calendar,Object>(Of.CALENDAR, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Double,Object> doubleExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Double,Object>(Of.DOUBLE, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Float,Object> floatExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Float,Object>(Of.FLOAT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Integer,Object> integerExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Integer,Object>(Of.INTEGER, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Long,Object> longExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Long,Object>(Of.LONG, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<Short,Object> shortExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<Short,Object>(Of.SHORT, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    public static Eval<String,Object> stringExp(final String ognlExpression, final Object... optionalParameters) {
        return new Eval<String,Object>(Of.STRING, ognlExpression, VarArgsUtil.asOptionalObjectList(optionalParameters));
    }
    
    
    private Eval(final IOf<X> resultOf, final String ognlExpression, final List<Object> parameters) {
    	Validate.notNull(resultOf, "Result characterization cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultOf = resultOf;
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    private Eval(final Class<X> resultOfClass, final String ognlExpression, final List<Object> parameters) {
    	Validate.notNull(resultOfClass, "Result characterization cannot be null");
    	Validate.notNull(ognlExpression, "Expression cannot be null");
        this.resultOf = Of.clazz(resultOfClass);
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    
    public IOf<X> getResultOf() {
    	return this.resultOf;
    }
    
    
	public X execute(final T input) {
        return OgnlExpressionUtil.evalOgnlExpression(this.resultOf, this.ognlExpression, input, this.parameters);
    }
    
    
    
}
