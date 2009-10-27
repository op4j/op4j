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
package org.op4j.operators.impl.arrayofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.commands.Call;
import org.op4j.commands.Eval;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofmap.ILevel2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.ILevel3ArrayOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3ArrayOfMapElementsEntriesValueOperator<K,V> extends Operator
        implements ILevel3ArrayOfMapElementsEntriesValueOperator<K,V>  {

    
    public Level3ArrayOfMapElementsEntriesValueOperator(final Target target) {
        super(target);
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(call));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> exec(final IExec<X, ? super V> exec) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V>[] get() {
        return endOn().endFor().endFor().get();
    }

}
