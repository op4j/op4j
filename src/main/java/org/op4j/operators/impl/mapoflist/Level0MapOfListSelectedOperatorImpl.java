package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0MapOfListSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfListSelectedOperator<K,V> {


    public Level0MapOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfListSelectedOperator<K,V> insertAll(final int position, final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,List<V>>(position, NormalisationUtils.normaliseMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,List<V>>(eval)));
    }


    public Level0MapOfListSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,List<V>>(eval)));
    }


    public Level0MapOfListOperator<K,V> endIf() {
        return new Level0MapOfListOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapOfListSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V> execIfNotNullAsMapOfList(final IFunction<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> function) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_OF_LIST));
    }


    public Level0MapOfListSelectedOperator<K,V> execAsMapOfList(final IFunction<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> function) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_OF_LIST));
    }


    public Level0MapOfListSelectedOperator<K,V> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,List<V>>(newKey, NormalisationUtils.normaliseList(newValue))));
    }


    public Level0MapOfListSelectedOperator<K,V> putAll(final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,List<V>>(NormalisationUtils.normaliseMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,List<V>>(position, newKey, NormalisationUtils.normaliseList(newValue))));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfListSelectedOperator<K,V> sort() {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfListSelectedOperator<K,V> sort(final Comparator<? super Entry<K,List<V>>> comparator) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,List<V>>(comparator)));
    }


    public Level0MapOfListSelectedOperator<K,V> replaceWith(final Map<K,List<V>> replacement) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
