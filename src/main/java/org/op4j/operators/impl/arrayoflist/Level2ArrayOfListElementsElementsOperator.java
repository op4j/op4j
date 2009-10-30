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
import java.util.List;

import org.op4j.IOf;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
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

    public ILevel2ArrayOfListElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ArrayOfListElementsElementsOperator<X> conv(
            IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
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


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfListElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<T>[] get() {
        return endFor().endFor().get();
    }

}
