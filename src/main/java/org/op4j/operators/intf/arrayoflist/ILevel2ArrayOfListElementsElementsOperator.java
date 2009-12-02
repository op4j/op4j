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
package org.op4j.operators.intf.arrayoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
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
public interface ILevel2ArrayOfListElementsElementsOperator<T> 
		extends IUniqOperator<List<T>[]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
		    
    public ILevel1ArrayOfListElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel2ArrayOfListElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2ArrayOfListElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfListElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ArrayOfListElementsElementsOperator<?> raw();
    
		                                    
}
