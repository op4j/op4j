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
package org.op4j.op.impl.operators.mapofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.op4j.op.commands.ICall;
import org.op4j.op.commands.IEval;
import org.op4j.op.commands.IExec;
import org.op4j.op.commands.impl.Call;
import org.op4j.op.commands.impl.Eval;
import org.op4j.op.impl.operators.Operator;
import org.op4j.op.intf.operators.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.op.intf.operators.mapofset.ILevel3MapOfSetEntriesValueElementsOperator;
import org.op4j.op.intf.parameters.IConv;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level3MapOfSetEntriesValueElementsOperator<K,V> extends Operator
        implements ILevel3MapOfSetEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfSetEntriesValueElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(call));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> exec(final IExec<X, ? super V> exec) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, Set<V>> get() {
        return endFor().endOn().endFor().get();
    }

}
