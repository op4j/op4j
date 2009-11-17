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
package org.op4j.operators.impl.list;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.Conv;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListElementsOperator<T> extends Operator
        implements ILevel1ListElementsOperator<T>  {

    
    public Level1ListElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel1ListElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level1ListElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel1ListElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel1ListElementsOperator<X> conv(final IConv<X> conv) {
        return new Level1ListElementsOperator<X>(getTarget().execute(conv));
    }

    public <X> ILevel1ListElementsOperator<X> convTo(final Type<X> resultType, final Object... parameters) {
        return new Level1ListElementsOperator<X>(getTarget().execute(Conv.to(resultType, parameters)));
    }

    public ILevel1ListElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Conv.to(Types.BIG_DECIMAL, parameters)));
    }


    public ILevel1ListElementsOperator<BigInteger> convToBigInteger(final Object... parameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Conv.to(Types.BIG_INTEGER, parameters)));
    }


    public ILevel1ListElementsOperator<Boolean> convToBoolean(final Object... parameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Conv.to(Types.BOOLEAN, parameters)));
    }


    public ILevel1ListElementsOperator<Byte> convToByte(final Object... parameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Conv.to(Types.BYTE, parameters)));
    }


    public ILevel1ListElementsOperator<Calendar> convToCalendar(final Object... parameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Conv.to(Types.CALENDAR, parameters)));
    }


    public ILevel1ListElementsOperator<Double> convToDouble(final Object... parameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Conv.to(Types.DOUBLE, parameters)));
    }


    public ILevel1ListElementsOperator<Float> convToFloat(final Object... parameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Conv.to(Types.FLOAT, parameters)));
    }


    public ILevel1ListElementsOperator<Integer> convToInteger(final Object... parameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Conv.to(Types.INTEGER, parameters)));
    }


    public ILevel1ListElementsOperator<Long> convToLong(final Object... parameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Conv.to(Types.LONG, parameters)));
    }


    public ILevel1ListElementsOperator<Short> convToShort(final Object... parameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Conv.to(Types.SHORT, parameters)));
    }


    public ILevel1ListElementsOperator<String> convToString(final Object... parameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Conv.to(Types.STRING, parameters)));
    }

    public ILevel1ListElementsOperator<Character> convToCharacter(final Object... parameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Conv.to(Types.CHARACTER, parameters)));
    }

    public ILevel1ListElementsOperator<Number> convToNumber(final Object... parameters) {
        return new Level1ListElementsOperator<Number>(getTarget().execute(Conv.to(Types.NUMBER, parameters)));
    }

    public ILevel1ListElementsOperator<Date> convToDate(final Object... parameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Conv.to(Types.DATE, parameters)));
    }


    public ILevel0ListOperator<T> endFor() {
        return new Level0ListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel1ListElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1ListElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel1ListElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel1ListElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level1ListElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel1ListElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ListElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<T> get() {
        return endFor().get();
    }

}
