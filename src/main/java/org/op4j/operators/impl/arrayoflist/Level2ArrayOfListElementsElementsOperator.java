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
package org.op4j.operators.impl.arrayoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel2ArrayOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfListElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfListElementsElementsOperator<T>  {

    
    public Level2ArrayOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1ArrayOfListElementsOperator<T> endFor() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2ArrayOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2ArrayOfListElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2ArrayOfListElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2ArrayOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ArrayOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ArrayOfListElementsElementsOperator<?> raw() {
        return new Level2ArrayOfListElementsElementsOperator<T>(getTarget());
    }


    public List<T>[] get() {
        return endFor().endFor().get();
    }

}
