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
public interface ILevel2SetOfSetElementsElementsOperator<T> 
		extends IUniqOperator<Set<Set<T>>>,
		        INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1SetOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel2SetOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel2SetOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2SetOfSetElementsElementsOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Number> evalForNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2SetOfSetElementsElementsOperator<?> raw();
    
                                    
}
