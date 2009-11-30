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
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
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

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> exec(final IFunc<X, ? super V> exec) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(exec));
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, ?> raw() {
        return new Level3SetOfMapElementsEntriesValueOperator<K, V>(getTarget());
    }


    public Set<Map<K, V>> get() {
        return endOn().endFor().endFor().get();
    }

}
