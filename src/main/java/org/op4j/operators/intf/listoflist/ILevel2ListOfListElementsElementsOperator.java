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
package org.op4j.operators.intf.listoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
public interface ILevel2ListOfListElementsElementsOperator<T> 
		extends IUniqOperator<List<List<T>>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfListElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel2ListOfListElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel2ListOfListElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2ListOfListElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel2ListOfListElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ListOfListElementsElementsOperator<?> raw();
    
                                    
}
