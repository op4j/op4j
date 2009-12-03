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
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
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


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> convert(final IConverter<X, ? super V> converter) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel2MapOfArrayEntriesValueOperator<K, V> endFor() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> eval(final IEvaluator<X, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, ?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Object>(Types.OBJECT, getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(resultType, getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Byte>(Types.BYTE, getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Long>(Types.LONG, getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Short>(Types.SHORT, getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, String>(Types.STRING, getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel3MapOfArrayEntriesValueElementsOperator<K, Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, Date>(Types.DATE, getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> exec(final IFunction<X, ? super V> function) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel3MapOfArrayEntriesValueElementsOperator<K, X> of(final Type<X> of) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, X>(of, getTarget());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, ?> raw() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget());
    }


    public Map<K, V[]> get() {
        return endFor().endOn().endFor().get();
    }

}
