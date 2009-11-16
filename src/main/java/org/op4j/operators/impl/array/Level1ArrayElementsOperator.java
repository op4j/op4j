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
package org.op4j.operators.impl.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Of;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.Conv;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayElementsOperator<T> {
    
    private final Of<T> arrayOf; 

    
    public Level1ArrayElementsOperator(final Of<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel1ArrayElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level1ArrayElementsOperator<X>(Of.type(call.getResultType()), getTarget().execute(call));
    }

    public ILevel1ArrayElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Byte>(Of.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Short>(Of.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Long>(Of.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Float>(Of.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<String>(Of.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Character>(Of.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Number>(Of.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Date>(Of.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel1ArrayElementsOperator<X> conv(final IConv<X> conv) {
        return new Level1ArrayElementsOperator<X>(Of.type(conv.getResultType()), getTarget().execute(conv));
    }

    public <X> ILevel1ArrayElementsOperator<X> convTo(final Type<X> resultType, final Object... parameters) {
        return new Level1ArrayElementsOperator<X>(Of.type(resultType), getTarget().execute(Conv.to(resultType, parameters)));
    }

    public ILevel1ArrayElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Of.type(Types.BIG_DECIMAL), getTarget().execute(Conv.to(Types.BIG_DECIMAL, parameters)));
    }


    public ILevel1ArrayElementsOperator<BigInteger> convToBigInteger(final Object... parameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Of.type(Types.BIG_INTEGER), getTarget().execute(Conv.to(Types.BIG_INTEGER, parameters)));
    }


    public ILevel1ArrayElementsOperator<Boolean> convToBoolean(final Object... parameters) {
        return new Level1ArrayElementsOperator<Boolean>(Of.type(Types.BOOLEAN), getTarget().execute(Conv.to(Types.BOOLEAN, parameters)));
    }


    public ILevel1ArrayElementsOperator<Byte> convToByte(final Object... parameters) {
        return new Level1ArrayElementsOperator<Byte>(Of.type(Types.BYTE), getTarget().execute(Conv.to(Types.BYTE, parameters)));
    }


    public ILevel1ArrayElementsOperator<Calendar> convToCalendar(final Object... parameters) {
        return new Level1ArrayElementsOperator<Calendar>(Of.type(Types.CALENDAR), getTarget().execute(Conv.to(Types.CALENDAR, parameters)));
    }


    public ILevel1ArrayElementsOperator<Double> convToDouble(final Object... parameters) {
        return new Level1ArrayElementsOperator<Double>(Of.type(Types.DOUBLE), getTarget().execute(Conv.to(Types.DOUBLE, parameters)));
    }


    public ILevel1ArrayElementsOperator<Float> convToFloat(final Object... parameters) {
        return new Level1ArrayElementsOperator<Float>(Of.type(Types.FLOAT), getTarget().execute(Conv.to(Types.BYTE, parameters)));
    }


    public ILevel1ArrayElementsOperator<Integer> convToInteger(final Object... parameters) {
        return new Level1ArrayElementsOperator<Integer>(Of.type(Types.INTEGER), getTarget().execute(Conv.to(Types.INTEGER, parameters)));
    }


    public ILevel1ArrayElementsOperator<Long> convToLong(final Object... parameters) {
        return new Level1ArrayElementsOperator<Long>(Of.type(Types.LONG), getTarget().execute(Conv.to(Types.LONG, parameters)));
    }


    public ILevel1ArrayElementsOperator<Short> convToShort(final Object... parameters) {
        return new Level1ArrayElementsOperator<Short>(Of.type(Types.SHORT), getTarget().execute(Conv.to(Types.SHORT, parameters)));
    }


    public ILevel1ArrayElementsOperator<String> convToString(final Object... parameters) {
        return new Level1ArrayElementsOperator<String>(Of.type(Types.STRING), getTarget().execute(Conv.to(Types.STRING, parameters)));
    }

    public ILevel1ArrayElementsOperator<Character> convToCharacter(final Object... parameters) {
        return new Level1ArrayElementsOperator<Character>(Of.type(Types.CHARACTER), getTarget().execute(Conv.to(Types.CHARACTER, parameters)));
    }

    public ILevel1ArrayElementsOperator<Number> convToNumber(final Object... parameters) {
        return new Level1ArrayElementsOperator<Number>(Of.type(Types.NUMBER), getTarget().execute(Conv.to(Types.NUMBER, parameters)));
    }

    public ILevel1ArrayElementsOperator<Date> convToDate(final Object... parameters) {
        return new Level1ArrayElementsOperator<Date>(Of.type(Types.DATE), getTarget().execute(Conv.to(Types.DATE, parameters)));
    }


    public ILevel0ArrayOperator<T> endFor() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level1ArrayElementsOperator<X>(Of.type(eval.getResultType()), getTarget().execute(eval));
    }


    public ILevel1ArrayElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Byte>(Of.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Float>(Of.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Long>(Of.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Short>(Of.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<String>(Of.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Character>(Of.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Number>(Of.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Date>(Of.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level1ArrayElementsOperator<X>(Of.type(exec.getResultType()), getTarget().execute(exec));
    }


    public <X> ILevel1ArrayElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel1ArrayElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public T[] get() {
        return endFor().get();
    }

}
