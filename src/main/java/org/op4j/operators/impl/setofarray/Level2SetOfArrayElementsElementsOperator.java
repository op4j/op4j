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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2SetOfArrayElementsElementsOperator<X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1SetOfArrayElementsOperator<T> endFor() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2SetOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2SetOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2SetOfArrayElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfArrayElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2SetOfArrayElementsElementsOperator<X>(exec.getResultType(), getTarget().execute(exec));
    }


    public <X> ILevel2SetOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfArrayElementsElementsOperator<?> raw() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public Set<T[]> get() {
        return endFor().endFor().get();
    }

}
