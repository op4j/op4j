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
package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
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
public class Level0MapOfSetOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0MapOfSetOperator<K,V> {

    
    public Level0MapOfSetOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K> extractKeys() {
        return new Level0SetOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level0ListOfSetOperator<V> extractValues() {
        return new Level0ListOfSetOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level1MapOfSetEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfSetEntriesOperatorImpl<K, V>(getTarget().iterate());
    }








    public Level0MapOfSetOperator<K, V> put(final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K, Set<V>>(newKey, NormalizationUtils.normalizeSet(newValue))));
    }


    public Level0MapOfSetOperator<K, V> insert(final int position, final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K, Set<V>>(position, newKey, NormalizationUtils.normalizeSet(newValue))));
    }


    public Level0MapOfSetOperator<K, V> putAll(final Map<K, Set<V>> map) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K, Set<V>>(NormalizationUtils.normalizeMapOfSet(map))));
    }


    public Level0MapOfSetOperator<K, V> insertAll(final int position, final Map<K, Set<V>> map) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, Set<V>>(position, NormalizationUtils.normalizeMapOfSet(map))));
    }


    public Level0MapOfSetOperator<K, V> removeAllKeys(final K... keys) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, Set<V>>(keys)));
    }


    public Level0MapOfSetOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, Set<V>>(eval)));
    }

    public Level0MapOfSetOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, Set<V>>> eval) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, Set<V>>(eval)));
    }


    public Level0MapOfSetOperator<K, V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, Set<V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOfSetOperator<K, V> sort() {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfSetOperator<K, V> sort(final Comparator<? super Entry<K, Set<V>>> comparator) {
        return new Level0MapOfSetOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, Set<V>>(comparator)));
    }


    public Level0MapOfArrayOperator<K, V> toMapOfArray(final Type<V> of) {
        return forEachEntry().onValue().toArray(of).endOn().endFor();
    }


    public Level0MapOfListOperator<K, V> toMapOfList() {
        return forEachEntry().onValue().toList().endOn().endFor();
    }


    public <K2> Level0MapOfMapOperator<K, K2, V> toMapOfMap(final IEvaluator<K2, ? super V> keyEval) {
        return forEachEntry().onValue().toMap(keyEval).endOn().endFor();
    }


    public <K2, V2> Level0MapOfMapOperator<K, K2, V2> toMapOfMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return forEachEntry().onValue().toMap(mapBuild).endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, Set<V>> get() {
        return (Map<K,Set<V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, Set<V>>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, Set<V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level0MapOfSetOperator<X,Y> asMapOfSetOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfSetOf(keyType, valueType);
    }


    public Level0MapOfSetOperator<?,?> asMapOfSetOfUnknown() {
        return asMapOfSetOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfSetSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNull() {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNull() {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfSetSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0MapOfSetOperator<X, Y> convert(final IConverter<? extends Map<X, ? extends Set<Y>>, ? super Map<K, Set<V>>> converter) {
        return new Level0MapOfSetOperatorImpl<X, Y>(getTarget().execute(converter, Normalization.MAP_OF_SET));
    }


    public <X, Y> Level0MapOfSetOperator<X, Y> eval(final IEvaluator<? extends Map<X, ? extends Set<Y>>, ? super Map<K, Set<V>>> eval) {
        return new Level0MapOfSetOperatorImpl<X, Y>(getTarget().execute(eval, Normalization.MAP_OF_SET));
    }


    public <X, Y> Level0MapOfSetOperator<X, Y> exec(final IFunction<? extends Map<X, ? extends Set<Y>>, ? super Map<K, Set<V>>> function) {
        return new Level0MapOfSetOperatorImpl<X, Y>(getTarget().execute(function, Normalization.MAP_OF_SET));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, Set<V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, Set<V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, Set<V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }

    

}
