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
package org.op4j.operators.impl.setofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.commands.Call;
import org.op4j.commands.Eval;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofmap.ILevel2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.ILevel3SetOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3SetOfMapElementsEntriesValueOperator<K,V> extends Operator
        implements ILevel3SetOfMapElementsEntriesValueOperator<K,V>  {

    
    public Level3SetOfMapElementsEntriesValueOperator(final Target target) {
        super(target);
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(call));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> exec(final IExec<X, ? super V> exec) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }

}
