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
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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
    
    private final Type<? super V> arrayOf; 

    
    public Level3MapOfArrayEntriesValueElementsOperator(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> call(final ICall<X, ? super V> call) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Byte>(Types.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Short>(Types.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Integer>(Types.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Long>(Types.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Float>(Types.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Double>(Types.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Boolean>(Types.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Calendar>(Types.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, String>(Types.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Character>(Types.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Number>(Types.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Date>(Types.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel2MapOfArrayEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> eval(final IEval<X, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Boolean>(Types.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Byte>(Types.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Calendar>(Types.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Double>(Types.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Float>(Types.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Integer>(Types.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Long>(Types.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Short>(Types.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> evalString(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, String>(Types.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Character>(Types.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Number>(Types.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Date>(Types.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> exec(final IFunc<X, ? super V> exec) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(exec.getResultType(), getTarget().execute(exec));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> of(
            Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, ?> raw() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget());
    }


    public Map<K, V[]> get() {
        return endFor().endOn().endFor().get();
    }

}
