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

import org.javaruntype.type.Type;
import org.op4j.Of;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.qualities.IBuilderMultiOperator;
import org.op4j.operators.qualities.IBuilderOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IExtractableOperator;
import org.op4j.operators.qualities.IModifiableOperator;
import org.op4j.operators.qualities.IMultiOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqableOperator;


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
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
        		IConvertibleOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableOperator<T>,
                IExtractableOperator<T> {

    
    public ILevel0GenericUniqOperator<T> uniq();

    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEval<X,? super T> eval);

    public ILevel0GenericUniqOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel0GenericUniqOperator<Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunc<X,? super T> exec);

    
    public <X> ILevel0GenericUniqOperator<X> conv(final IConv<X> conv);
    public <X> ILevel0GenericUniqOperator<X> convTo(final Type<X> resultType, final Object... parameters);
    
    public ILevel0GenericUniqOperator<Byte> convToByte(final Object... parameters);
    public ILevel0GenericUniqOperator<Short> convToShort(final Object... parameters);
    public ILevel0GenericUniqOperator<Integer> convToInteger(final Object... parameters);
    public ILevel0GenericUniqOperator<Long> convToLong(final Object... parameters);
    public ILevel0GenericUniqOperator<Float> convToFloat(final Object... parameters);
    public ILevel0GenericUniqOperator<Double> convToDouble(final Object... parameters);
    public ILevel0GenericUniqOperator<BigInteger> convToBigInteger(final Object... parameters);
    public ILevel0GenericUniqOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel0GenericUniqOperator<Boolean> convToBoolean(final Object... parameters);
    public ILevel0GenericUniqOperator<Calendar> convToCalendar(final Object... parameters);
    public ILevel0GenericUniqOperator<String> convToString(final Object... parameters);
    
    
    public <X> ILevel0GenericMultiOperator<X> of(final Of<X> of);
    public <X> ILevel0GenericMultiOperator<X> of(final Class<X> ofClass);
    
    public ILevel0GenericMultiOperator<?> raw();
    

    public ILevel0GenericMultiOperator<T> add(final T newElement);
    public ILevel0GenericMultiOperator<T> add(final int position, final T newElement);
    public ILevel0GenericMultiOperator<T> addAll(final T... newElements);
    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection);
    public ILevel0GenericMultiOperator<T> remove(final int position);
    public ILevel0GenericMultiOperator<T> remove(final T value);
    public ILevel0GenericMultiOperator<T> removeAll(final int... positions);
    public ILevel0GenericMultiOperator<T> removeAll(final T... values);
    public ILevel0GenericMultiOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeAll(final ISelect<T> selector);
    public ILevel0GenericMultiOperator<T> removeAllBut(final int... positions);
    public ILevel0GenericMultiOperator<T> removeAllBut(final T... values);
    public ILevel0GenericMultiOperator<T> removeAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> removeAllBut(final ISelect<T> selector);
    
    
    public ILevel0ListOperator<T> buildList();
    
    
    public ILevel0SetOperator<T> buildSet();
    
    
    public <X> ILevel0ArrayOperator<X> buildArray(final Of<X> of);
    public <X> ILevel0ArrayOperator<X> buildArray(final Class<X> classOf);
    
    
    public <K> ILevel0MapOperator<K,T> buildMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> buildMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfListOperator<K,T> buildMapOfList(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfSetOperator<K,T> buildMapOfSet(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final Of<X> valueArrayOf);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final Of<V> valueArrayOf);
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final Class<X> valueArrayOfClass);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final Class<V> valueArrayOfClass);

    
    public ILevel0MapOperator<T,T> buildMap();
    
    public ILevel0MapOfListOperator<T,T> buildMapOfList();
    
    public ILevel0MapOfSetOperator<T,T> buildMapOfSet();
    
    public <X> ILevel0MapOfArrayOperator<X,X> buildMapOfArray(final Of<X> of);
    public <X> ILevel0MapOfArrayOperator<X,X> buildMapOfArray(final Class<X> arrayOfClass);
       
    
    public ILevel0GenericUniqOperator<T> extract(final int position);
    public ILevel0GenericUniqOperator<T> extract(final T value);
    public ILevel0GenericMultiOperator<T> extractAll(final int... positions);
    public ILevel0GenericMultiOperator<T> extractAll(final T... values);
    public ILevel0GenericMultiOperator<T> extractAll(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> extractAll(final ISelect<T> selector);
    public ILevel0GenericMultiOperator<T> extractAllBut(final int... positions);
    public ILevel0GenericMultiOperator<T> extractAllBut(final T... values);
    public ILevel0GenericMultiOperator<T> extractAllBut(final String expression, final Object... optionalExpParams);
    public ILevel0GenericMultiOperator<T> extractAllBut(final ISelect<T> selector);
    
    

}
