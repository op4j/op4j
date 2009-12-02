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
package org.op4j.operators.intf.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,V>>,
				INavigatingMapEntryOperator,
                ICallableOperator<V>,
                IConvertibleOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel1MapEntriesOperator<K,V> endOn();
    
    public <X> ILevel2MapEntriesValueOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> call(final IMethodCaller<X,? super V> call);

    public ILevel2MapEntriesValueOperator<K,?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel2MapEntriesValueOperator<K,X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public ILevel2MapEntriesValueOperator<K,?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel2MapEntriesValueOperator<K,X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapEntriesValueOperator<K,Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> of(final Type<X> of);
    
        
    public ILevel2MapEntriesValueOperator<K,?> raw();
    
    
}
