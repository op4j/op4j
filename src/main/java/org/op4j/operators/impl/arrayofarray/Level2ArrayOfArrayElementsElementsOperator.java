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

import org.op4j.IOf;
import org.op4j.Of;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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
    
    private final IOf<T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(call.getResultOf(), getTarget().execute(call));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Of.BYTE, getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Of.SHORT, getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Of.LONG, getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Of.FLOAT, getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Of.STRING, getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> conv(
            IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(eval.getResultOf(), getTarget().execute(eval));
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


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(exec.getResultOf(), getTarget().execute(exec));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(IOf<X> of) {
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
