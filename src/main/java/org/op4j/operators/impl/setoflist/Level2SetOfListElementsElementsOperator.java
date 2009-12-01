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
package org.op4j.operators.impl.setoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfListElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfListElementsElementsOperator<T>  {

    
    public Level2SetOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2SetOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Number>(getTarget().execute(Call.forNumber(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1SetOfListElementsOperator<T> endFor() {
        return new Level1SetOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Number> evalForNumber(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Number>(getTarget().execute(Eval.forNumber(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2SetOfListElementsElementsOperator<?> raw() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget());
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }

}
