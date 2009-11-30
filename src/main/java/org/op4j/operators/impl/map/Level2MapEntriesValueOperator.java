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
package org.op4j.operators.impl.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapEntriesValueOperator<K,V> {

    
    public Level2MapEntriesValueOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(call));
    }

    public ILevel2MapEntriesValueOperator<K, Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel2MapEntriesValueOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2MapEntriesValueOperator<K, X> exec(final IFunc<X, ? super V> exec) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapEntriesValueOperator<K, ?> raw() {
        return new Level2MapEntriesValueOperator<K, V>(getTarget());
    }


    public Map<K, V> get() {
        return endOn().endFor().get();
    }

}
