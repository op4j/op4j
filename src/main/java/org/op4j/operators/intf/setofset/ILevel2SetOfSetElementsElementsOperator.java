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
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
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
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> call(final ICall<X,? super T> call);

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

    
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2SetOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2SetOfSetElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2SetOfSetElementsElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel2SetOfSetElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2SetOfSetElementsElementsOperator<?> raw();
    
                                    
}
