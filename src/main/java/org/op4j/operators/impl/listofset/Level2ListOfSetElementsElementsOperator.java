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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2ListOfSetElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ListOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1ListOfSetElementsOperator<T> endFor() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ListOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ListOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ListOfSetElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(exec));
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
