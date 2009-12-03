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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
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


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(converter));
    }



    public ILevel2SetOfMapElementsEntriesOperator<K, V> endOn() {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(eval));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, ?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel3SetOfMapElementsEntriesValueOperator<K, String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel3SetOfMapElementsEntriesValueOperator<K, Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel3SetOfMapElementsEntriesValueOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3SetOfMapElementsEntriesValueOperator<K, X>(getTarget().execute(function));
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
