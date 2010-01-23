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
package org.op4j.operators.impl.generic;

import java.util.Collection;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperatorImpl;
import org.op4j.operators.impl.list.Level0ListOperatorImpl;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperatorImpl;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperatorImpl;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperatorImpl;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqSelectedOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericUniqOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0GenericUniqOperator<T,I>  {

    
    public Level0GenericUniqOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> add(final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level0GenericMultiOperator<T,I> addAll(final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Add<T>(newElements)));
    }

    @SuppressWarnings("unchecked")
    public Level0GenericMultiOperator<T,I> insert(final int position, final T newElement) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level0GenericMultiOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0GenericMultiOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOperator<T,I> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ToArray.FromObject<T>(arrayOf)));
    }


    public Level0ListOperator<T,I> buildList() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> Level0MapOperator<K, T,I> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V,I> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOfArrayOperator<K, T,I> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperatorImpl<K, T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> Level0MapOfArrayOperator<K, V,I> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public <K> Level0MapOfListOperator<K, T,I> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperatorImpl<K, T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfListOperator<K, V,I> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> Level0MapOfSetOperator<K, T,I> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperatorImpl<K, T,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOfSetOperator<K, V,I> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T,I> buildSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> Level0ArrayOperator<X,I> asArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsArray(type, get());
        return new Level0ArrayOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0ListOperator<X,I> asListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsList(type, get());
        return new Level0ListOperatorImpl<X,I>(getTarget());
    }


    public <K,V> Level0MapOperator<K,V,I> asMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsMap(keyType, valueType, get());
        return new Level0MapOperatorImpl<K,V,I>(getTarget());
    }


    public <X> Level0SetOperator<X,I> asSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsSet(type, get());
        return new Level0SetOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0ArrayOfArrayOperator<X,I> asArrayOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsArrayOfArray(type, get());
        return new Level0ArrayOfArrayOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0ArrayOfListOperator<X,I> asArrayOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsArrayOfList(type, get());
        return new Level0ArrayOfListOperatorImpl<X,I>(getTarget());
    }


    public <K, V> Level0ArrayOfMapOperator<K, V,I> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsArrayOfMap(keyType, valueType, get());
        return new Level0ArrayOfMapOperatorImpl<K,V,I>(getTarget());
    }


    public <X> Level0ArrayOfSetOperator<X,I> asArrayOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsArrayOfSet(type, get());
        return new Level0ArrayOfSetOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0ListOfArrayOperator<X,I> asListOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsListOfArray(type, get());
        return new Level0ListOfArrayOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0ListOfListOperator<X,I> asListOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsListOfList(type, get());
        return new Level0ListOfListOperatorImpl<X,I>(getTarget());
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> asListOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsListOfMap(keyType, valueType, get());
        return new Level0ListOfMapOperatorImpl<K,V,I>(getTarget());
    }


    public <X> Level0ListOfSetOperator<X,I> asListOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsListOfSet(type, get());
        return new Level0ListOfSetOperatorImpl<X,I>(getTarget());
    }


    public <K, V> Level0MapOfArrayOperator<K, V,I> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsMapOfArray(keyType, valueType, get());
        return new Level0MapOfArrayOperatorImpl<K,V,I>(getTarget());
    }


    public <K, V> Level0MapOfListOperator<K, V,I> asMapOfListOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsMapOfList(keyType, valueType, get());
        return new Level0MapOfListOperatorImpl<K,V,I>(getTarget());
    }


    public <K1, K2, V> Level0MapOfMapOperator<K1, K2, V,I> asMapOfMapOf(final Type<K1> key1Type, final Type<K2> key2Type, final Type<V> valueType) {
    	Validate.notNull(key1Type, "A type representing the keys of the first-level map must be specified");
    	Validate.notNull(key2Type, "A type representing the keys of the second-level maps must be specified");
    	Validate.notNull(valueType, "A type representing the values of the second-level maps must be specified");
    	NormalizationUtils.checkIsMapOfMap(key1Type, key2Type, valueType, get());
        return new Level0MapOfMapOperatorImpl<K1,K2,V,I>(getTarget());
    }


    public <K, V> Level0MapOfSetOperator<K, V,I> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsMapOfSet(keyType, valueType, get());
        return new Level0MapOfSetOperatorImpl<K,V,I>(getTarget());
    }


    public <X> Level0SetOfArrayOperator<X,I> asSetOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsSetOfArray(type,get());
        return new Level0SetOfArrayOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0SetOfListOperator<X,I> asSetOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsSetOfList(type,get());
        return new Level0SetOfListOperatorImpl<X,I>(getTarget());
    }


    public <K, V> Level0SetOfMapOperator<K, V,I> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	NormalizationUtils.checkIsSetOfMap(keyType, valueType, get());
        return new Level0SetOfMapOperatorImpl<K,V,I>(getTarget());
    }


    public <X> Level0SetOfSetOperator<X,I> asSetOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	NormalizationUtils.checkIsSetOfSet(type,get());
        return new Level0SetOfSetOperatorImpl<X,I>(getTarget());
    }


    public <X> Level0GenericUniqOperator<X,I> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the target object must be specified");
        NormalizationUtils.checkIs(type, get());
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget());
    }

    public Level0GenericUniqOperator<?,I> asUnknown() {
        return asType(Types.OBJECT);
    }


    public Level0ArrayOfArrayOperator<?,I> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public Level0ArrayOfListOperator<?,I> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }


    public Level0ArrayOfMapOperator<?, ?,I> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0ArrayOfSetOperator<?,I> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public Level0ArrayOperator<?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level0ListOfArrayOperator<?,I> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public Level0ListOfListOperator<?,I> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public Level0ListOfMapOperator<?, ?,I> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0ListOfSetOperator<?,I> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level0MapOfArrayOperator<?, ?,I> asMapOfArrayOfUnknown() {
        return asMapOfArrayOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfListOperator<?, ?,I> asMapOfListOfUnknown() {
        return asMapOfListOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfMapOperator<?, ?, ?,I> asMapOfMapOfUnknown() {
        return asMapOfMapOf(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfSetOperator<?, ?,I> asMapOfSetOfUnknown() {
        return asMapOfSetOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOperator<?, ?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0SetOfArrayOperator<?,I> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public Level0SetOfListOperator<?,I> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }


    public Level0SetOfMapOperator<?, ?,I> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0SetOfSetOperator<?,I> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public Level0SetOperator<?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }


    public Level0GenericUniqSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNull() {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0GenericUniqSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0GenericUniqSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final IConverter<X, ? super T> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final IEvaluator<X, ? super T> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0GenericUniqOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericUniqOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0GenericUniqOperator<T,I> replaceIfNullWith(final T replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<T, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<T,I>(ocTarget);
    }
    
    
    
    
    
}
