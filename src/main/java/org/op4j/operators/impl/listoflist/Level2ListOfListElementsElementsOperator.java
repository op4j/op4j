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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2ListOfListElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ListOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfListElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1ListOfListElementsOperator<T> endFor() {
        return new Level1ListOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(exec));
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
