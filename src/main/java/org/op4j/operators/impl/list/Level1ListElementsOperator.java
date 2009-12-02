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
package org.op4j.operators.impl.list;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListElementsOperator<T> extends Operator
        implements ILevel1ListElementsOperator<T>  {

    
    public Level1ListElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel1ListElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level1ListElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel1ListElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel1ListElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel0ListOperator<T> endFor() {
        return new Level0ListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1ListElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1ListElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel1ListElementsOperator<X> of(final Type<X> of) {
        return new Level1ListElementsOperator<X>(getTarget());
    }


    public ILevel1ListElementsOperator<?> raw() {
        return new Level1ListElementsOperator<T>(getTarget());
    }


    public List<T> get() {
        return endFor().get();
    }

}
