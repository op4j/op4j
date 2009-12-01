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
package org.op4j.operators.impl.arrayofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfSetElementsElementsOperator<T>  {

    
    public Level2ArrayOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1ArrayOfSetElementsOperator<T> endFor() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(evalExpression, parameters)));
    }

    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<?> raw() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget());
    }


    public Set<T>[] get() {
        return endFor().endFor().get();
    }

}
