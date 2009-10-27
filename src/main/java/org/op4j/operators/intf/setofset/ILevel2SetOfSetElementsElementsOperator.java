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
package org.op4j.operators.intf.setofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
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
public interface ILevel2SetOfSetElementsElementsOperator<T> 
		extends IUniqOperator<Set<Set<T>>>,
		        INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1SetOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2SetOfSetElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2SetOfSetElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2SetOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2SetOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2SetOfSetElementsElementsOperator<?> raw();
    
                                    
}
