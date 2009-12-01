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
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
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


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> call(final IMethodCaller<X, ? super V> call) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(call));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Number>(getTarget().execute(Call.forNumber(methodName, optionalParameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel2MapOfListEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Number> evalForNumber(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Number>(getTarget().execute(Eval.forNumber(evalExpression, parameters)));
    }

    public ILevel3MapOfListEntriesValueElementsOperator<K, Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level3MapOfListEntriesValueElementsOperator<K, Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget().execute(function));
    }


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K, X> of(final Type<X> of) {
        return new Level3MapOfListEntriesValueElementsOperator<K, X>(getTarget());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, ?> raw() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget());
    }


    public Map<K, List<V>> get() {
        return endFor().endOn().endFor().get();
    }

}
