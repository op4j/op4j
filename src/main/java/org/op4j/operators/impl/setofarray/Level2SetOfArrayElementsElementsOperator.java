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
package org.op4j.operators.impl.setofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel2SetOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfArrayElementsElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level2SetOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level2SetOfArrayElementsElementsOperator<X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Call.forNumber(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public ILevel1SetOfArrayElementsOperator<T> endFor() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2SetOfArrayElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.forByte(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.forLong(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.forShort(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<String> evalForString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.forString(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Number> evalForNumber(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Eval.forNumber(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.forDate(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level2SetOfArrayElementsElementsOperator<X>(function.getResultType(), getTarget().execute(function));
    }


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        return new Level2SetOfArrayElementsElementsOperator<X>(of, getTarget());
    }


    public ILevel2SetOfArrayElementsElementsOperator<?> raw() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public Set<T[]> get() {
        return endFor().endFor().get();
    }

}
