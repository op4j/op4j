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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1ArrayOfListElementsOperator<T> endFor() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(exec));
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
