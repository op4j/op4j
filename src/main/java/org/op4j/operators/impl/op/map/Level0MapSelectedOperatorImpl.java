package org.op4j.operators.impl.op.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FMap;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0MapSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level0MapSelectedOperator<I,K,V> {


    public Level0MapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapSelectedOperatorImpl<I,K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.InsertAll<K,V>(position, map)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> removeAllTrue(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.RemoveAllTrue<K,V>(eval)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> removeAllFalse(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.RemoveAllFalse<K,V>(eval)));
    }


    public Level0MapOperatorImpl<I,K,V> endIf() {
        return new Level0MapOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> forEachEntry() {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> removeAllKeys(final K... keys) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.RemoveAllKeys<K,V>(keys)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> execIfNotNullAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> put(final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.Put<K,V>(newKey, newValue)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> putAll(final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.PutAll<K,V>(map)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.Insert<K,V>(position, newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperatorImpl<I,K,V> sort() {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.SortByKey()));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().execute(new FMap.SortEntries<K,V>(comparator)));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> replaceWith(final Map<K,V> replacement) {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
