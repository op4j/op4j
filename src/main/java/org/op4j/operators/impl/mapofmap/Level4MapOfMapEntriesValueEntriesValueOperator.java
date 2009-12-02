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
package org.op4j.operators.impl.mapofmap;

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
import org.op4j.operators.intf.mapofmap.ILevel3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel4MapOfMapEntriesValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> extends Operator
        implements ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V> {

    
    public Level4MapOfMapEntriesValueEntriesValueOperator(final Target target) {
        super(target);
    }

    
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> convert(final IConverter<X, ? super V> converter) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(converter));
    }    
    
    

    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> call(final IMethodCaller<X, ? super V> call) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(call));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> endOn() {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(eval));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigDecimal>(getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, BigInteger>(getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Boolean>(getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> evalForObject(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Object>(getTarget().execute(Eval.forObject(evalExpression, parameters)));
    }

    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(Eval.forObjectOfType(resultType, evalExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Byte>(getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Calendar>(getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Double>(getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Float>(getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Integer>(getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Long>(getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Short>(getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, String>(getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Character>(getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, Date>(getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> exec(final IFunction<X, ? super V> function) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget().execute(function));
    }


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X> of(final Type<X> of) {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, X>(getTarget());
    }


    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1, K2, ?> raw() {
        return new Level4MapOfMapEntriesValueEntriesValueOperator<K1, K2, V>(getTarget());
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().endOn().endFor().get();
    }

}
