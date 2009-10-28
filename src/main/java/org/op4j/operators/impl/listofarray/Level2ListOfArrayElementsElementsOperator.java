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
package org.op4j.operators.impl.listofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.op4j.IOf;
import org.op4j.Of;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IConv;
import org.op4j.executables.IEval;
import org.op4j.executables.IExec;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfArrayElementsElementsOperator<T>  {
    
    private final IOf<T> arrayOf; 

    
    public Level2ListOfArrayElementsElementsOperator(final IOf<T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ListOfArrayElementsElementsOperator<X>(call.getResultOf(), getTarget().execute(call));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Byte>(Of.BYTE, getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Short>(Of.SHORT, getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Long>(Of.LONG, getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Float>(Of.FLOAT, getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<String>(Of.STRING, getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ListOfArrayElementsElementsOperator<X> conv(
            IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1ListOfArrayElementsOperator<T> endFor() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<X>(eval.getResultOf(), getTarget().execute(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigInteger>(Of.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Boolean>(Of.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Byte>(Of.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Calendar>(Of.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Double>(Of.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Float>(Of.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Integer>(Of.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Long>(Of.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Short>(Of.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<String>(Of.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IExec<X, ? super T> exec) {
        return new Level2ListOfArrayElementsElementsOperator<X>(exec.getResultOf(), getTarget().execute(exec));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<T[]> get() {
        return endFor().endFor().get();
    }

}
