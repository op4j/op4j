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
public interface ILevel2ListOfListElementsElementsOperator<T> 
		extends IUniqOperator<List<List<T>>>,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfListElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> call(final ICall<X,? super T> call);

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
    public ILevel2ListOfListElementsElementsOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel2ListOfListElementsElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel2ListOfListElementsElementsOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2ListOfListElementsElementsOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2ListOfListElementsElementsOperator<X> exec(final IFunc<X,? super T> exec);
    
    public <X> ILevel2ListOfListElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ListOfListElementsElementsOperator<?> raw();
    
                                    
}
