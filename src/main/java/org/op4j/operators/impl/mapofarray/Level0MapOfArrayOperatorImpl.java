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
package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
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
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfArrayOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0MapOfArrayOperator<K,V> {

    
    public Level0MapOfArrayOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K> extractKeys() {
        return new Level0SetOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level0ListOfArrayOperator<V> extractValues() {
        return new Level0ListOfArrayOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(getTarget().iterate());
    }







    public Level0MapOfArrayOperator<K, V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K,V[]>(newKey, newValue)));
    }


    public Level0MapOfArrayOperator<K, V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K,V[]>(position, newKey, newValue)));
    }


    public Level0MapOfArrayOperator<K, V> putAll(final Map<K, V[]> map) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K,V[]>(map)));
    }

    
    public Level0MapOfArrayOperator<K, V> insertAll(final int position, final Map<K, V[]> map) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K,V[]>(position, map)));
    }


    public Level0MapOfArrayOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K,V[]>(keys)));
    }


    public Level0MapOfArrayOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K,V[]>(eval)));
    }

    public Level0MapOfArrayOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,V[]>(eval)));
    }


    public Level0MapOfArrayOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K,V[]>(keys)));
    }






    @SuppressWarnings("unchecked")
    public Level0MapOfArrayOperator<K, V> sort() {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfArrayOperator<K, V> sort(final Comparator<? super Entry<K, V[]>> comparator) {
        return new Level0MapOfArrayOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V[]>(comparator)));
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


    public Level0MapOfSetOperator<K, V> toMapOfSet() {
        return forEachEntry().onValue().toSet().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, V[]> get() {
        return (Map<K,V[]>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V[]>> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X,Y> Level0MapOfArrayOperator<X,Y> asMapOfArrayOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asMapOfArrayOf(keyType, valueType);
    }


    public Level0MapOfArrayOperator<?,?> asMapOfArrayOfUnknown() {
        return asMapOfArrayOf(Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfArraySelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNull() {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNull() {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfArraySelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0MapOfArrayOperator<X, Y> convert(final IConverter<? extends Map<X, Y[]>, ? super Map<K, V[]>> converter) {
        return new Level0MapOfArrayOperatorImpl<X, Y>(getTarget().execute(converter));
    }


    public <X, Y> Level0MapOfArrayOperator<X, Y> eval(final IEvaluator<? extends Map<X, Y[]>, ? super Map<K, V[]>> eval) {
        return new Level0MapOfArrayOperatorImpl<X, Y>(getTarget().execute(eval));
    }


    public <X, Y> Level0MapOfArrayOperator<X, Y> exec(final IFunction<? extends Map<X, Y[]>, ? super Map<K, V[]>> function) {
        return new Level0MapOfArrayOperatorImpl<X, Y>(getTarget().execute(function));
    }

    
}
