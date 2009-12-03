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
package org.op4j.operators.impl.listoflist;

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
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfListElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfListElementsElementsOperator<T>  {

    
    public Level2ListOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(converter));
    }



    public ILevel1ListOfListElementsOperator<T> endFor() {
        return new Level1ListOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2ListOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2ListOfListElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2ListOfListElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfListElementsElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ListOfListElementsElementsOperator<X>(getTarget());
    }


    public ILevel2ListOfListElementsElementsOperator<?> raw() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget());
    }


    public List<List<T>> get() {
        return endFor().endFor().get();
    }

}
