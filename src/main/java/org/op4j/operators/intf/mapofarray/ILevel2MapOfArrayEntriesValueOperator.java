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
package org.op4j.operators.intf.mapofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ISortableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapOfArrayEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,V[]>>,
		        INavigableCollectionOperator<V>,
	        	INavigatingMapEntryOperator,
		        IDistinguishableOperator,
		        ISortableOperator<V>,
                IExecutableOperator<V[]>,
                IConvertibleOperator<V[]>,
                ICallableOperator<V[]>,
                IEvaluableOperator<V[]>,
                ITypeParameterizableXOperator<V>,
                IModifiableCollectionOperator<V>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<V> {
    
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEach();
    
    public ILevel1MapOfArrayEntriesOperator<K,V> endOn();

    public ILevel2MapOfArrayEntriesValueOperator<K,V> distinct();
    
    public ILevel2MapOfArrayEntriesValueOperator<K,V> sort();
    public ILevel2MapOfArrayEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator);
    
    public <X> ILevel2MapOfArrayEntriesValueOperator<K,X> of(final Type<X> of);
    
        
    public ILevel2MapOfArrayEntriesValueOperator<K,?> raw();
    public ILevel2MapOfArrayEntriesValueOperator<K,V> add(final V... newElements);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> insert(final int position, final V... newElements);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> addAll(final Collection<V> collection);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeIndexes(final int... indices);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeEquals(final V... values);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeSelected(final ISelector<V> selector);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeIndexesNot(final int... indices);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeNulls();
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2MapOfArrayEntriesValueOperator<K,V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel2MapOfListEntriesValueOperator<K,V> toList();
    
    public ILevel2MapOfSetEntriesValueOperator<K,V> toSet();
    
    public ILevel2MapOfMapEntriesValueOperator<K,V,V> toMap();
    public <K2> ILevel2MapOfMapEntriesValueOperator<K,K2,V> toMap(final IEvaluator<K2,? super V> keyEval);
    public <K2,V2> ILevel2MapOfMapEntriesValueOperator<K,K2,V2> toMap(final IMapBuilder<K2,V2,? super V> mapBuild);

    
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachIndex(final int... indices);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNullOrMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNotNullMatching(final IEvaluator<Boolean, ? super V> eval);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachSelected(final ISelector<V> selector);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNull();
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachIndexNot(final int... indices);
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNotNull();
    public ILevel3MapOfArrayEntriesValueElementsOperator<K,V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    
    
    
    
    
    public <X> ILevel2MapEntriesValueOperator<K,X> convert(final IConverter<X,? super V[]> converter);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> call(final IMethodCaller<X,? super V[]> call);

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

    
    
    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEvaluator<X,? super V[]> eval);

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


    public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super V[]> function);
    
    
    
}
