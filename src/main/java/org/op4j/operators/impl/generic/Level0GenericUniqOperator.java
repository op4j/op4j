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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperator;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
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
import org.op4j.target.Target;
import org.op4j.util.TargetUtils;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericUniqOperator<T> extends Operator
        implements ILevel0GenericUniqOperator<T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public ILevel0GenericMultiOperator<T> add(final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Add<T>(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel0ArrayOperator<T> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperator<T>(arrayOf, getTarget().execute(new ToArray.FromObject<T>(arrayOf)));
    }


    public ILevel0ListOperator<T> buildList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> ILevel0MapOperator<K, T> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> ILevel0MapOfArrayOperator<K, T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperator<K, T>(valueArrayOf, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperator<K, V>(valueArrayOf, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0SetOperator<T> buildSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel0ArrayOperator<X> asArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsArray(type, get());
        return new Level0ArrayOperator<X>(type, getTarget());
    }


    public <X> ILevel0ListOperator<X> asListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsList(type, get());
        return new Level0ListOperator<X>(getTarget());
    }


    public <K,V> ILevel0MapOperator<K,V> asMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsMap(keyType, valueType, get());
        return new Level0MapOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOperator<X> asSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsSet(type, get());
        return new Level0SetOperator<X>(getTarget());
    }


    public <X> ILevel0ArrayOfArrayOperator<X> asArrayOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsArrayOfArray(type, get());
        return new Level0ArrayOfArrayOperator<X>(type, getTarget());
    }


    public <X> ILevel0ArrayOfListOperator<X> asArrayOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsArrayOfList(type, get());
        return new Level0ArrayOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> asArrayOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsArrayOfMap(keyType, valueType, get());
        return new Level0ArrayOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0ArrayOfSetOperator<X> asArrayOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsArrayOfSet(type, get());
        return new Level0ArrayOfSetOperator<X>(getTarget());
    }


    public <X> ILevel0ListOfArrayOperator<X> asListOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsListOfArray(type, get());
        return new Level0ListOfArrayOperator<X>(type, getTarget());
    }


    public <X> ILevel0ListOfListOperator<X> asListOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsListOfList(type, get());
        return new Level0ListOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> asListOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsListOfMap(keyType, valueType, get());
        return new Level0ListOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0ListOfSetOperator<X> asListOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsListOfSet(type, get());
        return new Level0ListOfSetOperator<X>(getTarget());
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> asMapOfArrayOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsMapOfArray(keyType, valueType, get());
        return new Level0MapOfArrayOperator<K,V>(valueType, getTarget());
    }


    public <K, V> ILevel0MapOfListOperator<K, V> asMapOfListOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsMapOfList(keyType, valueType, get());
        return new Level0MapOfListOperator<K,V>(getTarget());
    }


    public <K1, K2, V> ILevel0MapOfMapOperator<K1, K2, V> asMapOfMapOf(final Type<K1> key1Type, final Type<K2> key2Type, final Type<V> valueType) {
    	Validate.notNull(key1Type, "A type representing the keys of the first-level map must be specified");
    	Validate.notNull(key2Type, "A type representing the keys of the second-level maps must be specified");
    	Validate.notNull(valueType, "A type representing the values of the second-level maps must be specified");
    	TargetUtils.checkIsMapOfMap(key1Type, key2Type, valueType, get());
        return new Level0MapOfMapOperator<K1,K2,V>(getTarget());
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> asMapOfSetOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsMapOfSet(keyType, valueType, get());
        return new Level0MapOfSetOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOfArrayOperator<X> asSetOfArrayOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsSetOfArray(type,get());
        return new Level0SetOfArrayOperator<X>(type, getTarget());
    }


    public <X> ILevel0SetOfListOperator<X> asSetOfListOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsSetOfList(type,get());
        return new Level0SetOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> asSetOfMapOf(final Type<K> keyType, final Type<V> valueType) {
    	Validate.notNull(keyType, "A type representing the keys must be specified");
    	Validate.notNull(valueType, "A type representing the values must be specified");
    	TargetUtils.checkIsSetOfMap(keyType, valueType, get());
        return new Level0SetOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOfSetOperator<X> asSetOfSetOf(final Type<X> type) {
    	Validate.notNull(type, "A type representing the elements must be specified");
    	TargetUtils.checkIsSetOfSet(type,get());
        return new Level0SetOfSetOperator<X>(getTarget());
    }


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel0GenericUniqOperator<X> asType(final Type<X> type) {
        Validate.notNull(type, "A type representing the target object must be specified");
        TargetUtils.checkIs(type, get());
        return new Level0GenericUniqOperator<X>(getTarget());
    }

    public ILevel0GenericUniqOperator<?> asUnknown() {
        return asType(Types.OBJECT);
    }


    public ILevel0ArrayOfArrayOperator<?> asArrayOfArrayOfUnknown() {
        return asArrayOfArrayOf(Types.OBJECT);
    }


    public ILevel0ArrayOfListOperator<?> asArrayOfListOfUnknown() {
        return asArrayOfListOf(Types.OBJECT);
    }


    public ILevel0ArrayOfMapOperator<?, ?> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0ArrayOfSetOperator<?> asArrayOfSetOfUnknown() {
        return asArrayOfSetOf(Types.OBJECT);
    }


    public ILevel0ArrayOperator<?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public ILevel0ListOfArrayOperator<?> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public ILevel0ListOfListOperator<?> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public ILevel0ListOfMapOperator<?, ?> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0ListOfSetOperator<?> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public ILevel0ListOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public ILevel0MapOfArrayOperator<?, ?> asMapOfArrayOfUnknown() {
        return asMapOfArrayOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0MapOfListOperator<?, ?> asMapOfListOfUnknown() {
        return asMapOfListOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0MapOfMapOperator<?, ?, ?> asMapOfMapOfUnknown() {
        return asMapOfMapOf(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }


    public ILevel0MapOfSetOperator<?, ?> asMapOfSetOfUnknown() {
        return asMapOfSetOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0MapOperator<?, ?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0SetOfArrayOperator<?> asSetOfArrayOfUnknown() {
        return asSetOfArrayOf(Types.OBJECT);
    }


    public ILevel0SetOfListOperator<?> asSetOfListOfUnknown() {
        return asSetOfListOf(Types.OBJECT);
    }


    public ILevel0SetOfMapOperator<?, ?> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public ILevel0SetOfSetOperator<?> asSetOfSetOfUnknown() {
        return asSetOfSetOf(Types.OBJECT);
    }


    public ILevel0SetOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }

    
    







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }
    
    
    
    
    
}
