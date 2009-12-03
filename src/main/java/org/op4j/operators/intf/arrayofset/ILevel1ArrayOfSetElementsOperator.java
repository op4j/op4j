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
package org.op4j.operators.intf.arrayofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOperator;
import org.op4j.operators.qualities.IConvertibleToListOperator;
import org.op4j.operators.qualities.IConvertibleToMapOperator;
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
public interface ILevel1ArrayOfSetElementsOperator<T> 
		extends IUniqOperator<Set<T>[]>,
		        INavigableCollectionOperator<T>,
                INavigatingCollectionOperator<Set<T>>,
		        ISortableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableCollectionOperator<T>,
                IExecutableOperator<Set<T>>,
                IConvertibleOperator<Set<T>>,
                ICallableOperator<Set<T>>,
                IEvaluableOperator<Set<T>>,
                IConvertibleToArrayOperator<T>,
                IConvertibleToListOperator,
                IConvertibleToMapOperator<T> {

    
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach();
    
    public ILevel0ArrayOfSetOperator<T> endFor();
    
    public ILevel1ArrayOfSetElementsOperator<T> sort();
    public ILevel1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator);
    
    public <X> ILevel1ArrayOfSetElementsOperator<X> of(final Type<X> of);
        
    public ILevel1ArrayOfSetElementsOperator<?> raw();
    public ILevel1ArrayOfSetElementsOperator<T> add(final T... newElements);
    public ILevel1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements);
    public ILevel1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection);
    public ILevel1ArrayOfSetElementsOperator<T> removeIndexes(final int... indices);
    public ILevel1ArrayOfSetElementsOperator<T> removeEquals(final T... values);
    public ILevel1ArrayOfSetElementsOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel1ArrayOfSetElementsOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel1ArrayOfSetElementsOperator<T> removeIndexesNot(final int... indices);
    public ILevel1ArrayOfSetElementsOperator<T> removeNulls();
    public ILevel1ArrayOfSetElementsOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ArrayOfSetElementsOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of);
    
    
    public ILevel1ArrayOfListElementsOperator<T> toList();
    
    public ILevel1ArrayOfMapElementsOperator<T,T> toMap();
    public <K> ILevel1ArrayOfMapElementsOperator<K,T> toMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel1ArrayOfMapElementsOperator<K,V> toMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachIndex(final int... indices);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachSelected(final ISelector<T> selector);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNull();
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNull();
    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    

    

    
    
    public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X,? super Set<T>> converter);
    
    public <X> ILevel1ArrayElementsOperator<X> call(final IMethodCaller<X,? super Set<T>> call);

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

    
    
    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X,? super Set<T>> eval);

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


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function);
    
    
		                            
}
