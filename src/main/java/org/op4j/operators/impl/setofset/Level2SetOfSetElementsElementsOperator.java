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
package org.op4j.operators.impl.setofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.ILevel2SetOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfSetElementsElementsOperator<T>  {

    
    public Level2SetOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1SetOfSetElementsOperator<T> endFor() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2SetOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2SetOfSetElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2SetOfSetElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2SetOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2SetOfSetElementsElementsOperator<X>(getTarget());
    }


    public ILevel2SetOfSetElementsElementsOperator<?> raw() {
        return new Level2SetOfSetElementsElementsOperator<T>(getTarget());
    }


    public Set<Set<T>> get() {
        return endFor().endFor().get();
    }

}
