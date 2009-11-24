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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ListOfArrayElementsElementsOperator<X>(call.getResultType(), getTarget().execute(call));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2ListOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel1ListOfArrayElementsOperator<T> endFor() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, this.arrayOf.getRawClass()));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ListOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<String>(Types.STRING, getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Number>(Types.NUMBER, getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ListOfArrayElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ListOfArrayElementsElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ListOfArrayElementsElementsOperator<X>(exec.getResultType(), getTarget().execute(exec));
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ListOfArrayElementsElementsOperator<?> raw() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget());
    }


    public List<T[]> get() {
        return endFor().endFor().get();
    }

}
