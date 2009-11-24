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
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
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

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> exec(final IFunc<X, ? super V> exec) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3ArrayOfMapElementsEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel3ArrayOfMapElementsEntriesValueOperator<K, ?> raw() {
        return new Level3ArrayOfMapElementsEntriesValueOperator<K, V>(getTarget());
    }


    public Map<K, V>[] get() {
        return endOn().endFor().endFor().get();
    }

}
