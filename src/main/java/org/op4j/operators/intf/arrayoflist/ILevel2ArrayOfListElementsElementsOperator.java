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
public interface ILevel2ArrayOfListElementsElementsOperator<T> 
		extends IUniqOperator<List<T>[]>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
		    
    public ILevel1ArrayOfListElementsOperator<T> endFor();
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> call(final ICall<X,? super T> call);

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
    public ILevel2ArrayOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel2ArrayOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ArrayOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2ArrayOfListElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ArrayOfListElementsElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel2ArrayOfListElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ArrayOfListElementsElementsOperator<?> raw();
    
		                                    
}
