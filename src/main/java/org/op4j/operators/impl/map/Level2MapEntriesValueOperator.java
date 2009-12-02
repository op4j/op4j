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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
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


    public <X> ILevel2MapEntriesValueOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(converter));
    }



    public <X> ILevel2MapEntriesValueOperator<K, X> call(final IMethodCaller<X, ? super V> call) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(call));
    }

    public ILevel2MapEntriesValueOperator<K, ?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2MapEntriesValueOperator<K, X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K, Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel2MapEntriesValueOperator<K, BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, ?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2MapEntriesValueOperator<K, X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K, String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K, Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K, Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level2MapEntriesValueOperator<K, X>(getTarget().execute(function));
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
