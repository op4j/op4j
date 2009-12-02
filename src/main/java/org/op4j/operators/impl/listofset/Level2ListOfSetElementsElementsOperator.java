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
package org.op4j.operators.impl.listofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.ILevel2ListOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfSetElementsElementsOperator<T>  {

    
    public Level2ListOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel2ListOfSetElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ListOfSetElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2ListOfSetElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1ListOfSetElementsOperator<T> endFor() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(evalExpression, parameters)));
    }

    public <X> ILevel2ListOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2ListOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ListOfSetElementsElementsOperator<?> raw() {
        return new Level2ListOfSetElementsElementsOperator<T>(getTarget());
    }


    public List<Set<T>> get() {
        return endFor().endFor().get();
    }

}
