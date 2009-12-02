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
package org.op4j.operators.impl.setofset;

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
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.ILevel2SetOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfSetElementsElementsOperator<T>  {

    
    public Level2SetOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel2SetOfSetElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2SetOfSetElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2SetOfSetElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1SetOfSetElementsOperator<T> endFor() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(evalExpression, parameters)));
    }

    public <X> ILevel2SetOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget());
    }


    public ILevel2SetOfSetElementsElementsOperator<?> raw() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget());
    }


    public Set<Set<T>> get() {
        return endFor().endFor().get();
    }

}
