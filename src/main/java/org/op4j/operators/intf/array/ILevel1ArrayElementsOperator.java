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

import org.op4j.IOf;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
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
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {

		    
    public ILevel0ArrayOperator<T> endFor();
    
    public <X> ILevel1ArrayElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel1ArrayElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> IConvertibleOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel1ArrayElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel1ArrayElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel1ArrayElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel1ArrayElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel1ArrayElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel1ArrayElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel1ArrayElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel1ArrayElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel1ArrayElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel1ArrayElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel1ArrayElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel1ArrayElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel1ArrayElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel1ArrayElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel1ArrayElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel1ArrayElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1ArrayElementsOperator<?> raw();
    
		    
}
