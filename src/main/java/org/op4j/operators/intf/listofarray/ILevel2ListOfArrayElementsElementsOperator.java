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
package org.op4j.operators.intf.listofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.op4j.IOf;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
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
public interface ILevel2ListOfArrayElementsElementsOperator<T> 
		extends IUniqOperator<List<T[]>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfArrayElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2ListOfArrayElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfArrayElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2ListOfArrayElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ListOfArrayElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2ListOfArrayElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2ListOfArrayElementsElementsOperator<?> raw();
    
                                    
}
