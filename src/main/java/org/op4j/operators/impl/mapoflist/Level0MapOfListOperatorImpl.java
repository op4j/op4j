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
package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperatorImpl;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
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
public class Level0MapOfListOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level0MapOfListOperator<K,V,I> {

    
    public Level0MapOfListOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K,I> extractKeys() {
        return new Level0SetOperatorImpl<K,I>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level0ListOfListOperator<V,I> extractValues() {
        return new Level0ListOfListOperatorImpl<V,I>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level1MapOfListEntriesOperator<K, V,I> forEachEntry() {
        return new Level1MapOfListEntriesOperatorImpl<K, V,I>(getTarget().iterate());
    }







    public Level0MapOfListOperator<K, V,I> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Put<K, List<V>>(newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListOperator<K, V,I> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Insert<K, List<V>>(position, newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListOperator<K, V,I> putAll(final Map<K, List<V>> map) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.PutAll<K, List<V>>(NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListOperator<K, V,I> insertAll(final int position, final Map<K, List<V>> map) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.InsertAll<K, List<V>>(position, NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListOperator<K, V,I> removeAllKeys(final K... keys) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, List<V>>(keys)));
    }


    public Level0MapOfListOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, List<V>>(eval)));
    }

    public Level0MapOfListOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, List<V>>> eval) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, List<V>>(eval)));
    }


    public Level0MapOfListOperator<K, V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, List<V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOfListOperator<K, V,I> sort() {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfListOperator<K, V,I> sort(final Comparator<? super Entry<K, List<V>>> comparator) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortEntries<K, List<V>>(comparator)));
    }


    public Level0MapOfArrayOperator<K, V,I> toMapOfArray(final Type<V> of) {
        return new Level0MapOfArrayOperatorImpl<K, V,I>(getTarget().replaceWith(forEachEntry().onValue().toArray(of).endOn().endFor().get()));
    }


    public <K2> Level0MapOfMapOperator<K, K2, V,I> toMapOfMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level0MapOfMapOperatorImpl<K, K2, V,I>(getTarget().replaceWith(forEachEntry().onValue().toMap(keyEval).endOn().endFor().get()));
    }


    public <K2, V2> Level0MapOfMapOperator<K, K2, V2,I> toMapOfMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level0MapOfMapOperatorImpl<K, K2, V2,I>(getTarget().replaceWith(forEachEntry().onValue().toMap(mapBuild).endOn().endFor().get()));
    }


    public Level0MapOfSetOperator<K, V,I> toMapOfSet() {
        return new Level0MapOfSetOperatorImpl<K, V,I>(getTarget().replaceWith(forEachEntry().onValue().toSet().endOn().endFor().get()));
    }


    @SuppressWarnings("unchecked")
    public Map<K, List<V>> get() {
        return (Map<K,List<V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, List<V>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, List<V>>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level0MapOfListOperator<X,Y,I> asMapOfListOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfListOf(keyType, valueType);
    }


    public Level0MapOfListOperator<?,?,I> asMapOfListOfUnknown() {
        return asMapOfListOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNotNull() {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNull() {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfListSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0MapOfListOperator<X, Y,I> convert(final IConverter<? extends Map<X, ? extends List<Y>>, ? super Map<K, List<V>>> converter) {
        return new Level0MapOfListOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAP_OF_LIST));
    }


    public <X, Y> Level0MapOfListOperator<X, Y,I> eval(final IEvaluator<? extends Map<X, ? extends List<Y>>, ? super Map<K, List<V>>> eval) {
        return new Level0MapOfListOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAP_OF_LIST));
    }


    public <X, Y> Level0MapOfListOperator<X, Y,I> exec(final IFunction<? extends Map<X, ? extends List<Y>>, ? super Map<K, List<V>>> function) {
        return new Level0MapOfListOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAP_OF_LIST));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, List<V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, List<V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, List<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0MapOfListOperator<K, V,I> replaceWith(final Map<K, List<V>> replacement) {
        return new Level0MapOfListOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfListOperator<K, V,I> replaceIfNullWith(final Map<K, List<V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, List<V>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<Map<K, List<V>>, I>((OperationChainingTarget) target);
    }

    
    
}
