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
package org.op4j.operators.intf.listofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
import org.op4j.operators.qualities.INavigatingCollectionOperator;
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
public interface ILevel1ListOfArrayElementsOperator<T> 
		extends IUniqOperator<List<T[]>>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T>,
                IExecutableOperator<T[]>,
                IConvertibleOperator<T[]>,
                ICallableOperator<T[]>,
                IEvaluableOperator<T[]>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToSetOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ListOfArrayElementsElementsOperator<T> forEach();
    
    public ILevel0ListOfArrayOperator<T> endFor();

    public ILevel1ListOfArrayElementsOperator<T> distinct();
    
    public ILevel1ListOfArrayElementsOperator<T> sort();
    public ILevel1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ListOfArrayElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ListOfArrayElementsOperator<?> raw();
    public ILevel1ListOfArrayElementsOperator<T> add(final T... newElements);
    public ILevel1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ListOfArrayElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ListOfArrayElementsOperator<T> removeEquals(final T... values);
    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ListOfArrayElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1ListOfArrayElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ListOfArrayElementsOperator<T> removeNulls();
    public ILevel1ListOfArrayElementsOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListOfArrayElementsOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel1ListOfListElementsOperator<T> toList();
    
    public ILevel1ListOfSetElementsOperator<T> toSet();
    
    public ILevel1ListOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ListOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ListOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull();
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull();
    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    


    
    
    public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X,? super T[]> converter);
    
    public <X> ILevel1ListElementsOperator<X> call(final IMethodCaller<X,? super T[]> call);

    public ILevel1ListElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel1ListElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel1ListElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X,? super T[]> eval);

    public ILevel1ListElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel1ListElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T[]> function);
    
                                    
}
