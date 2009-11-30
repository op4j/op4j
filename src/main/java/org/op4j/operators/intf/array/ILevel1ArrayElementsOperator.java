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
package org.op4j.operators.intf.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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
public interface ILevel1ArrayElementsOperator<T> 
		extends IUniqOperator<T[]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

		    
    public ILevel0ArrayOperator<T> endFor();
    
    public <X> ILevel1ArrayElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel1ArrayElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel1ArrayElementsOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel1ArrayElementsOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel1ArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ArrayElementsOperator<?> raw();
    
		    
}
