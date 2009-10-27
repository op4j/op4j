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
package org.op4j.operators.impl.mapofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.Of;
import org.op4j.commands.Call;
import org.op4j.commands.Eval;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel3MapOfArrayEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3MapOfArrayEntriesValueElementsOperator<K,V> extends Operator
        implements ILevel3MapOfArrayEntriesValueElementsOperator<K,V> {
    
    private final IOf<V> arrayOf; 

    
    public Level3MapOfArrayEntriesValueElementsOperator(final IOf<V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(call.getResultOf(), getTarget().execute(call));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Byte>(Of.BYTE, getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Short>(Of.SHORT, getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Integer>(Of.INTEGER, getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Long>(Of.LONG, getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Float>(Of.FLOAT, getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Double>(Of.DOUBLE, getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigInteger>(Of.BIG_INTEGER, getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Boolean>(Of.BOOLEAN, getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Calendar>(Of.CALENDAR, getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, String>(Of.STRING, getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(eval.getResultOf(), getTarget().execute(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigDecimal>(Of.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigInteger>(Of.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Boolean>(Of.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Byte>(Of.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Calendar>(Of.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Double>(Of.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Float>(Of.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Integer>(Of.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Long>(Of.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Short>(Of.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, String>(Of.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> exec(final IExec<X, ? super V> exec) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(exec.getResultOf(), getTarget().execute(exec));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V[]> get() {
        return endFor().endOn().endFor().get();
    }

}