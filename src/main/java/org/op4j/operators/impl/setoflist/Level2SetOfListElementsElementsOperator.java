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
package org.op4j.operators.impl.setoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2SetOfListElementsElementsOperator<T> extends Operator
        implements ILevel2SetOfListElementsElementsOperator<T>  {

    
    public Level2SetOfListElementsElementsOperator(final Target target) {
        super(target);
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> call(final ICall<X, ? super T> call) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(call));
    }

    public ILevel2SetOfListElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level2SetOfListElementsElementsOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public <X> ILevel2SetOfListElementsElementsOperator<X> conv(final IConv<X> conv) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(conv));
    }

    public ILevel1SetOfListElementsOperator<T> endFor() {
        return new Level1SetOfListElementsOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel2SetOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel2SetOfListElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level2SetOfListElementsElementsOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel2SetOfListElementsElementsOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level2SetOfListElementsElementsOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2SetOfListElementsElementsOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2SetOfListElementsElementsOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Set<List<T>> get() {
        return endFor().endFor().get();
    }

}
