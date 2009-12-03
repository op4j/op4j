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
package org.op4j.operators.impl.listofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ListOfArrayElementsElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ListOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level2ListOfArrayElementsElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
    }



    public ILevel1ListOfArrayElementsOperator<T> endFor() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Object>(Types.OBJECT, getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2ListOfArrayElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<X>(resultType, getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2ListOfArrayElementsElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2ListOfArrayElementsElementsOperator<X>(of, getTarget());
    }


    public ILevel2ListOfArrayElementsElementsOperator<?> raw() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public List<T[]> get() {
        return endFor().endFor().get();
    }

}
