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
package org.op4j.operators.impl.set;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetElementsOperator<T> extends Operator
        implements ILevel1SetElementsOperator<T>  {

    
    public Level1SetElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level1SetElementsOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel1SetElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level1SetElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel1SetElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel1SetElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel1SetElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level1SetElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel0SetOperator<T> endFor() {
        return new Level0SetOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1SetElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1SetElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level1SetElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel1SetElementsOperator<X> of(final Type<X> of) {
        return new Level1SetElementsOperator<X>(getTarget());
    }


    public ILevel1SetElementsOperator<?> raw() {
        return new Level1SetElementsOperator<T>(getTarget());
    }


    public Set<T> get() {
        return endFor().get();
    }

}
