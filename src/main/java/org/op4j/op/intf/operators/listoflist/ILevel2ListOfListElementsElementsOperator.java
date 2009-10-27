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
package org.op4j.op.intf.operators.listoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.op4j.op.commands.ICall;
import org.op4j.op.commands.IEval;
import org.op4j.op.commands.IExec;
import org.op4j.op.intf.parameters.IConv;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.qualities.ICallableOperator;
import org.op4j.op.intf.qualities.IConvertibleOperator;
import org.op4j.op.intf.qualities.IEvaluableOperator;
import org.op4j.op.intf.qualities.IExecutableOperator;
import org.op4j.op.intf.qualities.INavigatingCollectionOperator;
import org.op4j.op.intf.qualities.ITypeParameterizableXOperator;
import org.op4j.op.intf.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2ListOfListElementsElementsOperator<T> 
		extends IUniqOperator<List<List<T>>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfListElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2ListOfListElementsElementsOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2ListOfListElementsElementsOperator<X> conv(final IConv<X,? super T> conv);
    
    public ILevel2ListOfListElementsElementsOperator<Byte> convToByte(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Short> convToShort(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Integer> convToInteger(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Long> convToLong(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Float> convToFloat(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Double> convToDouble(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<String> convToString(final Object... parameters);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ListOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2ListOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IExec<X,? super T> exec);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final IOf<X> of);
    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final Class<X> ofClass);
    
    public ILevel2ListOfListElementsElementsOperator<?> raw();
    
                                    
}
