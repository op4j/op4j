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
package org.op4j.operators.impl.arrayofarray;

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
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Of<T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperator(final Of<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(Of.type(call.getResultType()), getTarget().execute(call));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Of.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Of.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Of.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Of.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Of.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Of.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Number>(Of.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Of.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> conv(final IConv<X> conv) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(Of.type(conv.getResultType()), getTarget().execute(conv));
    }

    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> convTo(final Type<X> resultType, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(Of.type(resultType), getTarget().execute(Conv.to(resultType, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Of.type(Types.BIG_DECIMAL), getTarget().execute(Conv.to(Types.BIG_DECIMAL, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Of.type(Types.BIG_INTEGER), getTarget().execute(Conv.to(Types.BIG_INTEGER, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> convToBoolean(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Of.type(Types.BOOLEAN), getTarget().execute(Conv.to(Types.BOOLEAN, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> convToByte(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Of.type(Types.BYTE), getTarget().execute(Conv.to(Types.BYTE, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> convToCalendar(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Of.type(Types.CALENDAR), getTarget().execute(Conv.to(Types.CALENDAR, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Double> convToDouble(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Of.type(Types.DOUBLE), getTarget().execute(Conv.to(Types.DOUBLE, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Float> convToFloat(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Of.type(Types.FLOAT), getTarget().execute(Conv.to(Types.FLOAT, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> convToInteger(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Of.type(Types.INTEGER), getTarget().execute(Conv.to(Types.INTEGER, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Long> convToLong(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Of.type(Types.LONG), getTarget().execute(Conv.to(Types.LONG, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Short> convToShort(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Of.type(Types.SHORT), getTarget().execute(Conv.to(Types.SHORT, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<String> convToString(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Of.type(Types.STRING), getTarget().execute(Conv.to(Types.STRING, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> convToCharacter(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Of.type(Types.CHARACTER), getTarget().execute(Conv.to(Types.CHARACTER, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Number> convToNumber(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Number>(Of.type(Types.NUMBER), getTarget().execute(Conv.to(Types.NUMBER, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> convToDate(final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Of.type(Types.DATE), getTarget().execute(Conv.to(Types.DATE, parameters)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(Of.type(eval.getResultType()), getTarget().execute(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Of.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Of.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Of.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Of.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Of.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Of.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Number>(Of.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Of.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(Of.type(exec.getResultType()), getTarget().execute(exec));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(
            Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public T[][] get() {
        return endFor().endFor().get();
    }

}
