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
package org.op4j.operators.intf.arrayofset;

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
public interface ILevel2ArrayOfSetElementsElementsOperator<T> 
		extends IUniqOperator<Set<T>[]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
		    
    public ILevel1ArrayOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> call(final ICall<X,? super T> call);

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfSetElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ArrayOfSetElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfSetElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel2ArrayOfSetElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ArrayOfSetElementsElementsOperator<?> raw();
    
		                                    
}
