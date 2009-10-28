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
package org.op4j.operators.intf.arrayofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.op4j.IOf;
import org.op4j.executables.ICall;
import org.op4j.executables.IConv;
import org.op4j.executables.IEval;
import org.op4j.executables.IExec;
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
public interface ILevel2ArrayOfArrayElementsElementsOperator<T> 
		extends IUniqOperator<T[][]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ArrayOfArrayElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw();
    
                                    
}
