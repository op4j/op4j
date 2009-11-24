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
package org.op4j.operators.impl.arrayofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ArrayOfArrayElementsElementsOperator<T> extends Operator
        implements ILevel2ArrayOfArrayElementsElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level2ArrayOfArrayElementsElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1ArrayOfArrayElementsOperator<T> endFor() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfArrayElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfArrayElementsElementsOperator<X>(exec.getResultType(), getTarget().execute(exec));
    }


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public T[][] get() {
        return endFor().endFor().get();
    }

}
