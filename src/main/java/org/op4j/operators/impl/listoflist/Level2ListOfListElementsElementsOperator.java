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
package org.op4j.operators.impl.listoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfListElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfListElementsElementsOperator<T>  {

    
    public Level2ListOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ListOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Number>(getTarget().execute(Call.forNumber(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1ListOfListElementsOperator<T> endFor() {
        return new Level1ListOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Number> evalForNumber(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Number>(getTarget().execute(Eval.forNumber(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ListOfListElementsElementsOperator<?> raw() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget());
    }


    public List<List<T>> get() {
        return endFor().endFor().get();
    }

}
