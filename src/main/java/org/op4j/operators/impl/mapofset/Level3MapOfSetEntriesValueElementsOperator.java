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
package org.op4j.operators.impl.mapofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel3MapOfSetEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


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


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(converter));
    }



    public ILevel2MapOfSetEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, ?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel3MapOfSetEntriesValueElementsOperator<K, Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget().execute(function));
    }


    public <X> ILevel3MapOfSetEntriesValueElementsOperator<K, X> of(final Type<X> of) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, X>(getTarget());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, ?> raw() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget());
    }


    public Map<K, Set<V>> get() {
        return endFor().endOn().endFor().get();
    }

}
