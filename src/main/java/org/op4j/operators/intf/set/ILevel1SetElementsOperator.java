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
import java.util.Date;
import java.util.Set;

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
public interface ILevel1SetElementsOperator<T> 
		extends IUniqOperator<Set<T>>,
        		INavigatingCollectionOperator<T>,
        		ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

    
    public ILevel0SetOperator<T> endFor();
    
    public <X> ILevel1SetElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel1SetElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel1SetElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel1SetElementsOperator<?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel1SetElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel1SetElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1SetElementsOperator<X> of(final Type<X> of);
        
    public ILevel1SetElementsOperator<?> raw();
    
                                    
}
