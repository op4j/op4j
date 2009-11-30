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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2SetOfSetElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2SetOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfSetElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1SetOfSetElementsOperator<T> endFor() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(exec));
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
