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
package org.op4j.operators.intf.set;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Set;

import org.op4j.IOf;
import org.op4j.executables.ICall;
import org.op4j.executables.IConv;
import org.op4j.executables.IEval;
import org.op4j.executables.IFunc;
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
public interface ILevel1SetElementsOperator<T> 
		extends IUniqOperator<Set<T>>,
        		INavigatingCollectionOperator<T>,
        		ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {

    
    public ILevel0SetOperator<T> endFor();
    
    public <X> ILevel1SetElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel1SetElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel1SetElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel1SetElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel1SetElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel1SetElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel1SetElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel1SetElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel1SetElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel1SetElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel1SetElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel1SetElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel1SetElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel1SetElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel1SetElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel1SetElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel1SetElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel1SetElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel1SetElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel1SetElementsOperator<?> raw();
    
                                    
}
