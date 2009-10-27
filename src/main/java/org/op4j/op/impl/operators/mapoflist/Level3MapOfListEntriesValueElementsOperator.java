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
package org.op4j.op.impl.operators.mapoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.op4j.op.commands.ICall;
import org.op4j.op.commands.IEval;
import org.op4j.op.commands.IExec;
import org.op4j.op.commands.impl.Call;
import org.op4j.op.commands.impl.Eval;
import org.op4j.op.impl.operators.Operator;
import org.op4j.op.intf.operators.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.op.intf.operators.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
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
public class Level3MapOfListEntriesValueElementsOperator<K,V> extends Operator
        implements ILevel3MapOfListEntriesValueElementsOperator<K,V> {

    
    public Level3MapOfListEntriesValueElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(call));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> conv(
            IConv<X, ? super V> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Byte> convToByte(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> convToDouble(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> convToFloat(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> convToLong(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> convToShort(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, String> convToString(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> exec(final IExec<X, ? super V> exec) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }

}
