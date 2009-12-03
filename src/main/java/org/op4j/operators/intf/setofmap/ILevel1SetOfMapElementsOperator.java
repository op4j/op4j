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
package org.op4j.operators.intf.setofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableMapOperator;
import org.op4j.operators.qualities.IModifiableMapOperator;
import org.op4j.operators.qualities.INavigableMapOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXYOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1SetOfMapElementsOperator<K,V> 
		extends IUniqOperator<Set<Map<K,V>>>,
		        INavigableMapOperator<K,V>,
                INavigatingCollectionOperator<Map<K,V>>,
		        ISortableOperator<Map.Entry<K,V>>,
                ITypeParameterizableXYOperator<K,V>,
                IExecutableOperator<Map<K,V>>,
                IConvertibleOperator<Map<K,V>>,
                ICallableOperator<Map<K,V>>,
                IEvaluableOperator<Map<K,V>>,
                IModifiableMapOperator<K,V>,
                IExtractableMapOperator<K,V> {

    
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntry();
    
    public ILevel0SetOfMapOperator<K,V> endFor();
    
    public ILevel1SetOfMapElementsOperator<K,V> sort();
    public ILevel1SetOfMapElementsOperator<K,V> sort(final Comparator<? super Map.Entry<K,V>> comparator);
    
    public <X,Y> ILevel1SetOfMapElementsOperator<X,Y> of(final Type<X> ofX, final Type<Y> ofY);
        
    public ILevel1SetOfMapElementsOperator<?,?> raw();
    
    public ILevel1SetOfMapElementsOperator<K,V> put(final K newKey, final V newValue);
    public ILevel1SetOfMapElementsOperator<K,V> insert(final int position, final K newKey, final V newValue);
    public ILevel1SetOfMapElementsOperator<K,V> putAll(final Map<K,V> map);
    public ILevel1SetOfMapElementsOperator<K,V> insertAll(final int position, final Map<K,V> map);
    public ILevel1SetOfMapElementsOperator<K,V> removeKeys(final K... keys);
    public ILevel1SetOfMapElementsOperator<K,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetOfMapElementsOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel1SetOfMapElementsOperator<K,V> removeSelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel1SetOfMapElementsOperator<K,V> removeKeysNot(final K... keys);
    
    
    public ILevel1SetOfSetElementsOperator<K> extractKeys();
    public ILevel1SetOfListElementsOperator<V> extractValues();
    
    
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryWithKeys(final K... keys);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryMatching(final IEvaluator<Boolean, ? super Map.Entry<K,V>> eval);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntrySelected(final ISelector<Map.Entry<K,V>> selector);
    public ILevel2SetOfMapElementsEntriesOperator<K,V> forEachEntryWithKeysNot(final K... keys);
    

    
    
    
    public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X,? super Map<K,V>> converter);
    
    public <X> ILevel1SetElementsOperator<X> call(final IMethodCaller<X,? super Map<K,V>> call);

    public ILevel1SetElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel1SetElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1SetElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X,? super Map<K,V>> eval);

    public ILevel1SetElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel1SetElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1SetElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function);
    
    
}
