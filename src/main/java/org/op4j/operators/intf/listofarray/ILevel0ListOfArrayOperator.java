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
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfListOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToArrayOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToListOfListOperator;
import org.op4j.operators.qualities.IConvertibleToListOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToListOfSetOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfArrayOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfListOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfMapOperator;
import org.op4j.operators.qualities.IConvertibleToSetOfSetOperator;
import org.op4j.operators.qualities.IDistinguishableOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.IFlattenableAsListOperator;
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
public interface ILevel0ListOfArrayOperator<T> 
		extends IUniqOperator<List<T[]>>,
		        INavigableCollectionOperator<T[]>,
		        IDistinguishableOperator,
		        ISortableOperator<T[]>,
                ITypeParameterizableXOperator<T>,
                IFlattenableAsListOperator<T>,
		        IModifiableCollectionOperator<T[]>,
		        IGenerizableOperator<List<T[]>>,
                IExecutableOperator<List<T[]>>,
                IConvertibleOperator<List<T[]>>,
                IEvaluableOperator<List<T[]>>,
                IConvertibleToArrayOfArrayOperator<T>,
                IConvertibleToArrayOfListOperator<T>,
                IConvertibleToArrayOfSetOperator<T>,
                IConvertibleToListOfListOperator<T>,
                IConvertibleToListOfSetOperator<T>,
                IConvertibleToSetOfArrayOperator<T>,
                IConvertibleToSetOfListOperator<T>,
                IConvertibleToSetOfSetOperator<T>,
                IConvertibleToArrayOfMapOperator<T>,
                IConvertibleToListOfMapOperator<T>,
                IConvertibleToSetOfMapOperator<T> {


    public ILevel1ListOfArrayElementsOperator<T> forEach();

    public ILevel0ListOfArrayOperator<T> distinct();
    
    public ILevel0ListOfArrayOperator<T> sort();
    public ILevel0ListOfArrayOperator<T> sort(final Comparator<? super T[]> comparator);
    
    public <X> ILevel0ListOfArrayOperator<X> of(final Type<X> of);
        
    public ILevel0ListOfArrayOperator<?> raw();
    
    public ILevel0ListOperator<T> flatten();
    public ILevel0ListOfArrayOperator<T> add(final T[]... newElements);
    public ILevel0ListOfArrayOperator<T> insert(final int position, final T[]... newElements);
    public ILevel0ListOfArrayOperator<T> addAll(final Collection<T[]> collection);
    public ILevel0ListOfArrayOperator<T> removeIndexes(final int... indices);
    public ILevel0ListOfArrayOperator<T> removeEquals(final T[]... values);
    public ILevel0ListOfArrayOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ListOfArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel0ListOfArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel0ListOfArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel0ListOfArrayOperator<T> removeSelected(final ISelector<T[]> selector);
    public ILevel0ListOfArrayOperator<T> removeIndexesNot(final int... indices);
    public ILevel0ListOfArrayOperator<T> removeNulls();
    public ILevel0ListOfArrayOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel0ListOfArrayOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    
    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of);
    
    public ILevel0ArrayOfListOperator<T> toArrayOfList();
    
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet();
    
    public ILevel0ListOfListOperator<T> toListOfList();
    
    public ILevel0ListOfSetOperator<T> toListOfSet();
    
    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of);
    
    
    public ILevel0SetOfListOperator<T> toSetOfList();
    
    public ILevel0SetOfSetOperator<T> toSetOfSet();
    
    public ILevel0ArrayOfMapOperator<T,T> toArrayOfMap();
    public <K> ILevel0ArrayOfMapOperator<K,T> toArrayOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> toArrayOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0ListOfMapOperator<T,T> toListOfMap();
    public <K> ILevel0ListOfMapOperator<K,T> toListOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0ListOfMapOperator<K,V> toListOfMap(final IMapBuilder<K,V,? super T> mapBuild);
    
    public ILevel0SetOfMapOperator<T,T> toSetOfMap();
    public <K> ILevel0SetOfMapOperator<K,T> toSetOfMap(final IEvaluator<K,? super T> keyEval);
    public <K,V> ILevel0SetOfMapOperator<K,V> toSetOfMap(final IMapBuilder<K,V,? super T> mapBuild);

    
    public ILevel1ListOfArrayElementsOperator<T> forEachIndex(final int... indices);
    public ILevel1ListOfArrayElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListOfArrayElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel1ListOfArrayElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel1ListOfArrayElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval);
    public ILevel1ListOfArrayElementsOperator<T> forEachSelected(final ISelector<T[]> selector);
    public ILevel1ListOfArrayElementsOperator<T> forEachNull();
    public ILevel1ListOfArrayElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams);
    public ILevel1ListOfArrayElementsOperator<T> forEachIndexNot(final int... indices);
    public ILevel1ListOfArrayElementsOperator<T> forEachNotNull();
    public ILevel1ListOfArrayElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams);
    
    




    
    public ILevel0GenericUniqOperator<List<T[]>> generic();
    
    
    
    
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super List<T[]>> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super List<T[]>> eval);

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


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T[]>> function);
    
    
    
}
