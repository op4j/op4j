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
package org.op4j.operators.impl.arrayoflist;

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
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel2ArrayOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfListElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfListElementsElementsOperator<T>  {

    
    public Level2ArrayOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel2ArrayOfListElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ArrayOfListElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2ArrayOfListElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1ArrayOfListElementsOperator<T> endFor() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(evalExpression, parameters)));
    }

    public <X> ILevel2ArrayOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ArrayOfListElementsElementsOperator<?> raw() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget());
    }


    public List<T>[] get() {
        return endFor().endFor().get();
    }

}
