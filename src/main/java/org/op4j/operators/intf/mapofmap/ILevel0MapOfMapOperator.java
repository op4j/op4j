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
package org.op4j.operators.intf.mapofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYZOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0MapOfMapOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
		        INavigableMapOperator<K1,Map<K2,V>>,
		        ISortableOperator<Map.Entry<K1,Map<K2,V>>>,
                ITypeParameterizableXYZOperator<K1,K2,V>,
                IExecutableOperator<Map<K1,Map<K2,V>>>,
                IConvertibleOperator<Map<K1,Map<K2,V>>>,
                ICallableOperator<Map<K1,Map<K2,V>>>,
                IEvaluableOperator<Map<K1,Map<K2,V>>>,
		        IModifiableMapOperator<K1,Map<K2,V>>,
                IExtractableMapOperator<K1,Map<K2,V>>,
		        IGenerizableOperator<Map<K1,Map<K2,V>>> {

    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntry();
    
    public ILevel0MapOfMapOperator<K1,K2,V> sort();
    public ILevel0MapOfMapOperator<K1,K2,V> sort(final Comparator<? super Map.Entry<K1,Map<K2,V>>> comparator);
    
    public <X,Y,Z> ILevel0MapOfMapOperator<X,Y,Z> of(final Type<X> ofX, final Type<Y> ofY, final Type<Z> ofZ);
        
    public ILevel0MapOfMapOperator<?,?,?> raw();
    
    public ILevel0MapOfMapOperator<K1,K2,V> put(final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> insert(final int position, final K1 newKey, final Map<K2,V> newValue);
    public ILevel0MapOfMapOperator<K1,K2,V> putAll(final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> insertAll(final int position, final Map<K1,Map<K2,V>> map);
    public ILevel0MapOfMapOperator<K1,K2,V> removeKeys(final K1... keys);
    public ILevel0MapOfMapOperator<K1,K2,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0MapOfMapOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public ILevel0MapOfMapOperator<K1,K2,V> removeSelected(final ISelector<Map.Entry<K1,Map<K2,V>>> selector);
    public ILevel0MapOfMapOperator<K1,K2,V> removeKeysNot(final K1... keys);
    
    
    public ILevel0SetOperator<K1> extractKeys();
    public ILevel0ListOfMapOperator<K2,V> extractValues();
    
    
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeys(final K1... keys);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K1,Map<K2,V>>> eval);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntrySelected(final ISelector<Map.Entry<K1,Map<K2,V>>> selector);
    public ILevel1MapOfMapEntriesOperator<K1,K2,V> forEachEntryWithKeysNot(final K1... keys);
    

    
    
    public ILevel0GenericUniqOperator<Map<K1,Map<K2,V>>> generic();
    

    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super Map<K1,Map<K2,V>>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X,? super Map<K1,Map<K2,V>>> call);

    public ILevel0GenericUniqOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel0GenericUniqOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super Map<K1,Map<K2,V>>> eval);

    public ILevel0GenericUniqOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel0GenericUniqOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0GenericUniqOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K1,Map<K2,V>>> function);
    
    
}
