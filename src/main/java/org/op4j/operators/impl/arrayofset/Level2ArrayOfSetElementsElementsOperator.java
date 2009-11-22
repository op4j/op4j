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
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
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


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> conv(final IConv<X> conv) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(conv));
    }

    public ILevel1ArrayOfSetElementsOperator<T> endFor() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2ArrayOfSetElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2ArrayOfSetElementsElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2ArrayOfSetElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<T>[] get() {
        return endFor().endFor().get();
    }

}
