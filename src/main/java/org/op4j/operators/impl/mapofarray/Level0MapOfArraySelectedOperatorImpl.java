package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0MapOfArraySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfArraySelectedOperator<K,V> {


    private final Type<V> type;


    public Level0MapOfArraySelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level0MapOfArraySelectedOperator<K,V> insertAll(final int position, final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.InsertAll<K,V[]>(position, NormalisationUtils.normaliseMapOfArray(map, this.type.getRawClass()))));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllTrue(final IFunction<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.RemoveAllTrue<K,V[]>(eval)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllFalse(final IFunction<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.RemoveAllFalse<K,V[]>(eval)));
    }


    public Level0MapOfArrayOperator<K,V> endIf() {
        return new Level0MapOfArrayOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.type, getTarget().iterate(Structure.MAP));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.RemoveAllKeys<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> execIfNotNullAsMapOfArray(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0MapOfArraySelectedOperator<K,V> execAsMapOfArray(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0MapOfArraySelectedOperator<K,V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.Put<K,V[]>(newKey, NormalisationUtils.normaliseArray(newValue, this.type.getRawClass()))));
    }


    public Level0MapOfArraySelectedOperator<K,V> putAll(final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.PutAll<K,V[]>(NormalisationUtils.normaliseMapOfArray(map, this.type.getRawClass()))));
    }


    public Level0MapOfArraySelectedOperator<K,V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.Insert<K,V[]>(position, newKey, NormalisationUtils.normaliseArray(newValue, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfArraySelectedOperator<K,V> sort() {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfArraySelectedOperator<K,V> sort(final Comparator<? super Entry<K,V[]>> comparator) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().execute(new MapFuncs.SortEntries<K,V[]>(comparator)));
    }


    public Level0MapOfArraySelectedOperator<K,V> replaceWith(final Map<K,V[]> replacement) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.MAP_OF_ARRAY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
