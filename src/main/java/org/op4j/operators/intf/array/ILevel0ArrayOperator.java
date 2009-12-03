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
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IGenerizableOperator;
import org.op4j.operators.qualities.IModifiableCollectionOperator;
import org.op4j.operators.qualities.INavigableCollectionOperator;
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
public interface ILevel0ArrayOperator<T> 
		extends IUniqOperator<T[]>,
		        INavigableCollectionOperator<T>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
		        IModifiableCollectionOperator<T>,
		        IGenerizableOperator<T[]>,
		        IExecutableOperator<T[]>,
		        IConvertibleOperator<T[]>,
		        ICallableOperator<T[]>,
		        IEvaluableOperator<T[]>,
		        IConvertibleToListOperator,
		        IConvertibleToSetOperator,
		        IConvertibleToMapOperator<T> {


    public ILevel1ArrayElementsOperator<T> forEach();

    public ILevel0ArrayOperator<T> distinct();
    
    public ILevel0ArrayOperator<T> sort();
    public ILevel0ArrayOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel0ArrayOperator<X> of(final Type<X> of);
        
    public ILevel0ArrayOperator<?> raw();
    
    public ILevel0ArrayOperator<T> add(final T... newElements);
    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements);
    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection);
    public ILevel0ArrayOperator<T> removeIndexes(final int... indices);
    public ILevel0ArrayOperator<T> removeEquals(final T... values);
    public ILevel0ArrayOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0ArrayOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel0ArrayOperator<T> removeIndexesNot(final int... indices);
    public ILevel0ArrayOperator<T> removeNulls();
    public ILevel0ArrayOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ArrayOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel0ListOperator<T> toList();
    
    public ILevel0SetOperator<T> toSet();
    
    public ILevel0MapOperator<T,T> toMap();
    public <K> ILevel0MapOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public ILevel1ArrayElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1ArrayElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel1ArrayElementsOperator<T> forEachNull();
    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1ArrayElementsOperator<T> forEachNotNull();
    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    


    
    public ILevel0GenericUniqOperator<T[]> generic();

    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super T[]> converter);
    
    public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X,? super T[]> call);

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

    
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super T[]> eval);

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


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super T[]> function);
    
    
        
}
