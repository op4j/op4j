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
package org.op4j.operators.intf.mapoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
public interface ILevel3MapOfListEntriesValueElementsOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigatingCollectionOperator<V>,
                ICallableOperator<V>,
                IConvertibleOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel2MapOfListEntriesValueOperator<K,V> endFor();
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> convert(final IConverter<X,? super V> converter);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> call(final IMethodCaller<X,? super V> call);

    public ILevel3MapOfListEntriesValueElementsOperator<K,?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> eval(final IEvaluator<X,? super V> eval);

    public ILevel3MapOfListEntriesValueElementsOperator<K,?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> exec(final IFunction<X, ? super V> function);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> of(final Type<X> of);
    
        
    public ILevel3MapOfListEntriesValueElementsOperator<K,?> raw();
    
                                            
}
