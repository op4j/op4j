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
package org.op4j.operators.impl.arrayofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Object>(Types.OBJECT, getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(resultType, getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Object>(Types.OBJECT, getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(resultType, getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(of, getTarget());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public T[][] get() {
        return endFor().endFor().get();
    }

}
