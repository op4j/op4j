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
package org.op4j.operators.impl.arrayofset;

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
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfSetElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfSetElementsElementsOperator<T>  {

    
    public Level2ArrayOfSetElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1ArrayOfSetElementsOperator<T> endFor() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<?> raw() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget());
    }


    public Set<T>[] get() {
        return endFor().endFor().get();
    }

}
