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
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.IBuilderOperator;
import org.op4j.operators.qualities.ICallableOperator;
import org.op4j.operators.qualities.ICastableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IModifiableGrowableOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericUniqOperator<T> 
        extends IUniqOperator<T>,
                ICastableOperator,
        		IBuilderOperator<T>,
        		ICallableOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableGrowableOperator<T> {
    
    public <X> ILevel0GenericUniqOperator<X> call(final ICall<X,? super T> call);

    public ILevel0GenericUniqOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<String> callString(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Character> callCharacter(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Number> callNumber(final String methodName, final Object... optionalParameters);
    public ILevel0GenericUniqOperator<Date> callDate(final String methodName, final Object... optionalParameters);

    
    
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
    
    public <X> ILevel0GenericUniqOperator<X> of(final Type<X> of);
    public <X> ILevel0GenericUniqOperator<X> of(final Class<X> ofClass);
    
    public ILevel0GenericUniqOperator<?> raw();
    public ILevel0GenericMultiOperator<T> add(final T... newElements);
    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements);
    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection);

    
    public ILevel0ListOperator<T> buildList();
    
    
    public ILevel0SetOperator<T> buildSet();
    
    
    public ILevel0ArrayOperator<T> buildArray(final Type<T> of);
    
    
    public <K> ILevel0MapOperator<K,T> buildMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> buildMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfListOperator<K,T> buildMapOfList(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfSetOperator<K,T> buildMapOfSet(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfArrayOperator<K,T> buildMapOfArray(final Type<T> valueArrayOf, final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuild<K,V,? super T> mapBuild);

    
    
    public ILevel0ArrayOfArrayOperator<?> castAsArrayOfArray();
    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(final Type<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(final Class<X> of);
    
    public ILevel0ArrayOfListOperator<?> castAsArrayOfList();
    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(final Type<X> of);
    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(final Class<X> of);
    
    public ILevel0ArrayOfMapOperator<?,?> castAsArrayOfMap();
    public <K,V> ILevel0ArrayOfMapOperator<K,V> castAsArrayOfMap(final Type<K> keyOf,final Type<V> valueOf);
    
    public ILevel0ArrayOfSetOperator<?> castAsArrayOfSet();
    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(final Type<X> of);
    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(final Class<X> of);
    
    public ILevel0ListOfArrayOperator<?> castAsListOfArray();
    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(final Type<X> of);
    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(final Class<X> of);
    
    public ILevel0ListOfListOperator<?> castAsListOfList();
    public <X> ILevel0ListOfListOperator<X> castAsListOfList(final Type<X> of);
    public <X> ILevel0ListOfListOperator<X> castAsListOfList(final Class<X> of);
    
    public ILevel0ListOfMapOperator<?,?> castAsListOfMap();
    public <K,V> ILevel0ListOfMapOperator<K,V> castAsListOfMap(final Type<K> keyOf,final Type<V> valueOf);
    
    public ILevel0ListOfSetOperator<?> castAsListOfSet();
    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(final Type<X> of);
    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(final Class<X> of);
    
    public ILevel0MapOfArrayOperator<?,?> castAsMapOfArray();
    public <K,V> ILevel0MapOfArrayOperator<K,V> castAsMapOfArray(final Type<K> keyOf, final Type<V> valueOf);
    public <K,V> ILevel0MapOfArrayOperator<K,V> castAsMapOfArray(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0MapOfListOperator<?,?> casstAsMapOfList();
    public <K,V> ILevel0MapOfListOperator<K,V> castAsMapOfList(final Type<K> keyOf, final Type<V> valueOf);
    public <K,V> ILevel0MapOfListOperator<K,V> castAsMapOfList(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0MapOfMapOperator<?,?,?> castAsMapOfMap();
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> castAsMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf);
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> castAsMapOfMap(final Class<K1> key1Of, final Class<K2> key2Of, final Class<V> valueOf);
    
    public ILevel0MapOfSetOperator<?,?> castAsMapOfSet();
    public <K,V> ILevel0MapOfSetOperator<K,V> castAsMapOfSet(final Type<K> keyOf, final Type<V> valueOf);
    public <K,V> ILevel0MapOfSetOperator<K,V> castAsMapOfSet(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0SetOfArrayOperator<?> castAsSetOfArray();
    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(final Type<X> of);
    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(final Class<X> of);
    
    public ILevel0SetOfListOperator<?> castAsSetOfList();
    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(final Type<X> of);
    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(final Class<X> of);
    
    public ILevel0SetOfMapOperator<?,?> castAsSetOfMap();
    public <K,V> ILevel0SetOfMapOperator<K,V> castAsSetOfMap(final Type<K> keyOf,final Type<V> valueOf);
    
    public ILevel0SetOfSetOperator<?> castAsSetOfSet();
    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(final Type<X> of);
    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(final Class<X> of);

    
    
    
}
