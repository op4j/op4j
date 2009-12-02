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
package org.op4j.operators.intf.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.ICastableToFirstLevelStructuresOperator;
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
public interface ILevel1ArrayElementsOperator<T> 
		extends IUniqOperator<T[]>,
		        ICastableToFirstLevelStructuresOperator,
                INavigatingCollectionOperator<T>,
                ICallableOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {

		    
    public ILevel0ArrayOperator<T> endFor();
    
    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel1ArrayElementsOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel1ArrayElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel1ArrayElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1ArrayElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel1ArrayElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel1ArrayElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel1ArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ArrayElementsOperator<?> raw();
    
    
    
    public <X> ILevel1ArrayOfArrayElementsOperator<X> asArray(final Type<X> of);
    public <X> ILevel1ArrayOfListElementsOperator<X> asList(final Type<X> of);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel1ArrayOfSetElementsOperator<X> asSet(final Type<X> of);
	
    
}
