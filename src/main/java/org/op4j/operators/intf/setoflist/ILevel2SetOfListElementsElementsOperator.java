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
package org.op4j.operators.intf.setoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
public interface ILevel2SetOfListElementsElementsOperator<T> 
		extends IUniqOperator<Set<List<T>>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1SetOfListElementsOperator<T> endFor();
    
    public <X> ILevel2SetOfListElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2SetOfListElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfListElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2SetOfListElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2SetOfListElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2SetOfListElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2SetOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2SetOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2SetOfListElementsElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel2SetOfListElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2SetOfListElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2SetOfListElementsElementsOperator<?> raw();
    
                                    
}