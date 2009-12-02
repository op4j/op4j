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
package org.op4j.operators.intf.listofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
public interface ILevel2ListOfSetElementsElementsOperator<T> 
		extends IUniqOperator<List<Set<T>>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel2ListOfSetElementsElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel2ListOfSetElementsElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2ListOfSetElementsElementsOperator<?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel2ListOfSetElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfSetElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ListOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ListOfSetElementsElementsOperator<?> raw();
    
                                    
}
