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

import java.util.Collection;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
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
import org.op4j.operators.qualities.ICastableToArrayOfArrayOperator;
import org.op4j.operators.qualities.ICastableToArrayOfListOperator;
import org.op4j.operators.qualities.ICastableToArrayOfMapOperator;
import org.op4j.operators.qualities.ICastableToArrayOfSetOperator;
import org.op4j.operators.qualities.ICastableToArrayOperator;
import org.op4j.operators.qualities.ICastableToListOfArrayOperator;
import org.op4j.operators.qualities.ICastableToListOfListOperator;
import org.op4j.operators.qualities.ICastableToListOfMapOperator;
import org.op4j.operators.qualities.ICastableToListOfSetOperator;
import org.op4j.operators.qualities.ICastableToListOperator;
import org.op4j.operators.qualities.ICastableToMapOfArrayOperator;
import org.op4j.operators.qualities.ICastableToMapOfListOperator;
import org.op4j.operators.qualities.ICastableToMapOfMapOperator;
import org.op4j.operators.qualities.ICastableToMapOfSetOperator;
import org.op4j.operators.qualities.ICastableToMapOperator;
import org.op4j.operators.qualities.ICastableToSetOfArrayOperator;
import org.op4j.operators.qualities.ICastableToSetOfListOperator;
import org.op4j.operators.qualities.ICastableToSetOfMapOperator;
import org.op4j.operators.qualities.ICastableToSetOfSetOperator;
import org.op4j.operators.qualities.ICastableToSetOperator;
import org.op4j.operators.qualities.IConvertibleOperator;
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
                ICastableToArrayOperator,
                ICastableToListOperator,
                ICastableToMapOperator,
                ICastableToSetOperator,
                ICastableToArrayOfArrayOperator,
                ICastableToArrayOfListOperator,
                ICastableToArrayOfMapOperator,
                ICastableToArrayOfSetOperator,
                ICastableToListOfArrayOperator,
                ICastableToListOfListOperator,
                ICastableToListOfMapOperator,
                ICastableToListOfSetOperator,
                ICastableToMapOfArrayOperator,
                ICastableToMapOfListOperator,
                ICastableToMapOfMapOperator,
                ICastableToMapOfSetOperator,
                ICastableToSetOfArrayOperator,
                ICastableToSetOfListOperator,
                ICastableToSetOfMapOperator,
                ICastableToSetOfSetOperator,
        		IBuilderOperator<T>,
        		IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T>,
                IModifiableGrowableOperator<T> {
    
    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel0GenericUniqOperator<X> of(final Type<X> of);
        
    public ILevel0GenericUniqOperator<?> raw();
    public ILevel0GenericMultiOperator<T> add(final T... newElements);
    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements);
    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection);

    
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

    
    
    public <X> ILevel0ArrayOperator<X> asArray(final Type<X> of);
    public <X> ILevel0ListOperator<X> asList(final Type<X> of);
    public <K,V> ILevel0MapOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0SetOperator<X> asSet(final Type<X> of);
    public ILevel0ArrayOperator<?> asArrayOfUnknown();
    public ILevel0ListOperator<?> asListOfUnknown();
    public ILevel0MapOperator<?,?> asMapOfUnknown();
    public ILevel0SetOperator<?> asSetOfUnknown();
    
    
    
    public <X> ILevel0ArrayOfArrayOperator<X> asArrayOfArray(final Type<X> of);
    public <X> ILevel0ArrayOfListOperator<X> asArrayOfList(final Type<X> of);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> asArrayOfMap(final Type<K> keyOf,final Type<V> valueOf);
    public <X> ILevel0ArrayOfSetOperator<X> asArrayOfSet(final Type<X> of);
    public <X> ILevel0ListOfArrayOperator<X> asListOfArray(final Type<X> of);
    public <X> ILevel0ListOfListOperator<X> asListOfList(final Type<X> of);
    public <K,V> ILevel0ListOfMapOperator<K,V> asListOfMap(final Type<K> keyOf,final Type<V> valueOf);
    public <X> ILevel0ListOfSetOperator<X> asListOfSet(final Type<X> of);
    public <K,V> ILevel0MapOfArrayOperator<K,V> asMapOfArray(final Type<K> keyOf, final Type<V> valueOf);
    public <K,V> ILevel0MapOfListOperator<K,V> asMapOfList(final Type<K> keyOf, final Type<V> valueOf);
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> asMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf);
    public <K,V> ILevel0MapOfSetOperator<K,V> asMapOfSet(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0SetOfArrayOperator<X> asSetOfArray(final Type<X> of);
    public <X> ILevel0SetOfListOperator<X> asSetOfList(final Type<X> of);
    public <K,V> ILevel0SetOfMapOperator<K,V> asSetOfMap(final Type<K> keyOf,final Type<V> valueOf);
    public <X> ILevel0SetOfSetOperator<X> asSetOfSet(final Type<X> of);
    public ILevel0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown();
    public ILevel0ArrayOfListOperator<?> asArrayOfListOfUnknown();
    public ILevel0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown();
    public ILevel0ArrayOfSetOperator<?> asArrayOfSetOfUnknown();
    public ILevel0ListOfArrayOperator<?> asListOfArrayOfUnknown();
    public ILevel0ListOfListOperator<?> asListOfListOfUnknown();
    public ILevel0ListOfMapOperator<?,?> asListOfMapOfUnknown();
    public ILevel0ListOfSetOperator<?> asListOfSetOfUnknown();
    public ILevel0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown();
    public ILevel0MapOfListOperator<?,?> asMapOfListOfUnknown();
    public ILevel0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown();
    public ILevel0MapOfSetOperator<?,?> asMapOfSetOfUnknown();
    public ILevel0SetOfArrayOperator<?> asSetOfArrayOfUnknown();
    public ILevel0SetOfListOperator<?> asSetOfListOfUnknown();
    public ILevel0SetOfMapOperator<?,?> asSetOfMapOfUnknown();
    public ILevel0SetOfSetOperator<?> asSetOfSetOfUnknown();
    
    
    
}
