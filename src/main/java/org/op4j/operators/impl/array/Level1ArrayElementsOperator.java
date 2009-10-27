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
package org.op4j.op.impl.operators.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.op4j.op.commands.ICall;
import org.op4j.op.commands.IEval;
import org.op4j.op.commands.IExec;
import org.op4j.op.commands.impl.Call;
import org.op4j.op.commands.impl.Eval;
import org.op4j.op.impl.operators.Operator;
import org.op4j.op.impl.parameters.Of;
import org.op4j.op.intf.operators.array.ILevel0ArrayOperator;
import org.op4j.op.intf.operators.array.ILevel1ArrayElementsOperator;
import org.op4j.op.intf.parameters.IConv;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.qualities.IConvertibleOperator;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayElementsOperator<T> {
    
    private final IOf<T> arrayOf; 

    
    public Level1ArrayElementsOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel1ArrayElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level1ArrayElementsOperator<X>(call.getResultOf(), getTarget().execute(call));
    }

    public ILevel1ArrayElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Byte>(Of.BYTE, getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Short>(Of.SHORT, getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Long>(Of.LONG, getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Float>(Of.FLOAT, getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<String>(Of.STRING, getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> IConvertibleOperator<X> conv(IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Byte> convToByte(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Float> convToFloat(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Long> convToLong(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<Short> convToShort(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ArrayElementsOperator<String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOperator<T> endFor() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf));
    }


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultOf(), getTarget().execute(eval));
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


    public <X> ILevel1ArrayElementsOperator<X> exec(final IExec<X, ? super T> exec) {
        return new Level1ArrayElementsOperator<X>(exec.getResultOf(), getTarget().execute(exec));
    }


    public <X> ILevel1ArrayElementsOperator<X> of(IOf<X> of) {
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
