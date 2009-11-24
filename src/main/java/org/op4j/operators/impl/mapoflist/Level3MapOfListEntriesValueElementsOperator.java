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
package org.op4j.operators.impl.mapoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


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
        return new Level3MapOfListEntriesValueElementsOperator<K, Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, String> callString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
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

    public ILevel3MapOfListEntriesValueElementsOperator<K, Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> exec(final IFunc<X, ? super V> exec) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, ?> raw() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget());
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }

}
