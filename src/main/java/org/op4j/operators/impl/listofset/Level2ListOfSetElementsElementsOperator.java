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
import java.util.List;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
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

    public ILevel2ListOfSetElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfSetElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfSetElementsElementsOperator<String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ListOfSetElementsElementsOperator<X> conv(
            IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
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


    public <X> ILevel2ListOfSetElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ListOfSetElementsElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ListOfSetElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfSetElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Set<T>> get() {
        // TODO Auto-generated method stub
        return null;
    }

}
