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
package org.op4j.operators.impl.setoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfListElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfListElementsElementsOperator<T>  {

    
    public Level2SetOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1SetOfListElementsOperator<T> endFor() {
        return new Level1SetOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2SetOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2SetOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2SetOfListElementsElementsOperator<?> raw() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget());
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }

}
