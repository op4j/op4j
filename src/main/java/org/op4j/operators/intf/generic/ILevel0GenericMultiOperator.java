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
package org.op4j.operators.intf.generic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IBuilderMultiOperator;
import org.op4j.operators.qualities.IBuilderOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IModifiableGrowableOperator;
import org.op4j.operators.qualities.IModifiableShrinkableOperator;
import org.op4j.operators.qualities.IMultiOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqableOperator;
import org.op4j.select.ISelector;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericMultiOperator<T> 
        extends IMultiOperator<T>,
                IUniqableOperator<T>,
        		IBuilderOperator<T>,
        		IBuilderMultiOperator<T>,
        		ICallableOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableGrowableOperator<T>,
                IModifiableShrinkableOperator<T> {

    
    public ILevel0GenericUniqOperator<T> uniq();

    
    
    public <X> ILevel0GenericMultiOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel0GenericMultiOperator<X> call(final IMethodCaller<X,? super T> call);

    public ILevel0GenericMultiOperator<?> callForObject(final String methodName, final Object... optionalParameters);
    public <X> ILevel0GenericMultiOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel0GenericMultiOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel0GenericMultiOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel0GenericMultiOperator<?> evalForObject(final String evalExpression, final Object... optionalArguments);
    public <X> ILevel0GenericMultiOperator<X> evalForObjectOfType(final Type<X> resultType, final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericMultiOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel0GenericMultiOperator<X> exec(final IFunction<X, ? super T> function);
    
    
    
    public <X> ILevel0GenericMultiOperator<X> of(final Type<X> of);
        
    public ILevel0GenericMultiOperator<?> raw();
    public ILevel0GenericMultiOperator<T> add(final T... newElements);
    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements);
    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection);
    public ILevel0GenericMultiOperator<T> removeIndexes(final int... indices);
    public ILevel0GenericMultiOperator<T> removeEquals(final T... values);
    public ILevel0GenericMultiOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0GenericMultiOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0GenericMultiOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public ILevel0GenericMultiOperator<T> removeSelected(final ISelector<T> selector);
    public ILevel0GenericMultiOperator<T> removeIndexesNot(final int... indices);
    public ILevel0GenericMultiOperator<T> removeNulls();
    public ILevel0GenericMultiOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeNullOrMatching(final String expression, final Object... optionalExpParams);
    
    
    public ILevel0ListOperator<T> buildList();
    
    
    public ILevel0SetOperator<T> buildSet();
    
    
    public ILevel0ArrayOperator<T> buildArray(final Type<T> of);
    
    
    public <K> ILevel0MapOperator<K,T> buildMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> buildMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfListOperator<K,T> buildMapOfList(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfSetOperator<K,T> buildMapOfSet(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuilder<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfArrayOperator<K,T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel0MapOperator<T,T> buildMap();
    
    public ILevel0MapOfListOperator<T,T> buildMapOfList();
    
    public ILevel0MapOfSetOperator<T,T> buildMapOfSet();
    
    public ILevel0MapOfArrayOperator<T,T> buildMapOfArray(final Type<T> of);
    
    
    public T[] getAsArray(final Type<T> type); 
    public List<T> getAsList(); 
    

}
