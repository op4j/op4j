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
import java.util.Date;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
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
public interface ILevel2ArrayOfArrayElementsElementsOperator<T> 
		extends IUniqOperator<T[][]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ArrayOfArrayElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel2ArrayOfArrayElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfArrayElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2ArrayOfArrayElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfArrayElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ArrayOfArrayElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ArrayOfArrayElementsElementsOperator<?> raw();
    
                                    
}
