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
package org.op4j.operators.intf.list;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ListElementsOperator<T> 
		extends IUniqOperator<List<T>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

    
    public ILevel0ListOperator<T> endFor();
    
    public <X> ILevel1ListElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel1ListElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel1ListElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Number> evalForNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel1ListElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1ListElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ListElementsOperator<?> raw();
    
                                    
}
