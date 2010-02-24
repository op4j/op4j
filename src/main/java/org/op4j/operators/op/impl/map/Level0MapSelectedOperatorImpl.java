package org.op4j.operators.op.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FMap;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0MapSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level0MapSelectedOperator<K,V,I> {


    public Level0MapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapSelectedOperatorImpl<K,V,I> insertAll(final int position, final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.InsertAll<K,V>(position, map)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> removeAllTrue(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.RemoveAllTrue<K,V>(eval)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> removeAllFalse(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.RemoveAllFalse<K,V>(eval)));
    }


    public Level0MapOperatorImpl<K,V,I> endIf() {
        return new Level0MapOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level1MapSelectedEntriesOperatorImpl<K,V,I> forEachEntry() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> removeAllKeys(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.RemoveAllKeys<K,V>(keys)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> execIfNotNullAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> put(final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.Put<K,V>(newKey, newValue)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> putAll(final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.PutAll<K,V>(map)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.Insert<K,V>(position, newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperatorImpl<K,V,I> sort() {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.SortByKey()));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().execute(new FMap.SortEntries<K,V>(comparator)));
    }


    public Level0MapSelectedOperatorImpl<K,V,I> replaceWith(final Map<K,V> replacement) {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
