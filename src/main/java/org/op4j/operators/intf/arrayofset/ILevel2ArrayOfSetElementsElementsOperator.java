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
package org.op4j.operators.intf.arrayofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Set;

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
public interface ILevel2ArrayOfSetElementsElementsOperator<T> 
		extends IUniqOperator<Set<T>[]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
		    
    public ILevel1ArrayOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2ArrayOfSetElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2ArrayOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2ArrayOfSetElementsElementsOperator<?> raw();
    
		                                    
}
