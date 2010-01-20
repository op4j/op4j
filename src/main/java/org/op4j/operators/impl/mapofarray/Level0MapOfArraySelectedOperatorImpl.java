package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0MapOfArraySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfArraySelectedOperator<K,V> {


    public Level0MapOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfArraySelectedOperator<K,V> insertAll(final int position, final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V[]>(position, NormalizationUtils.normalizeMapOfArray(map))));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V[]>(eval)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V[]>(eval)));
    }


    public Level0MapOfArraySelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> eval) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAP_OF_ARRAY));
    }


    public Level0MapOfArrayOperator<K,V> endIf() {
        return new Level0MapOfArrayOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V[]>(keys)));
    }


    public Level0MapOfArraySelectedOperator<K,V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V[]>(newKey, NormalizationUtils.normalizeArray(newValue))));
    }


    public Level0MapOfArraySelectedOperator<K,V> putAll(final Map<K,V[]> map) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V[]>(NormalizationUtils.normalizeMapOfArray(map))));
    }


    public Level0MapOfArraySelectedOperator<K,V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V[]>(position, newKey, NormalizationUtils.normalizeArray(newValue))));
    }


    public Level0MapOfArraySelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> function) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAP_OF_ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfArraySelectedOperator<K,V> sort() {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfArraySelectedOperator<K,V> sort(final Comparator<? super Entry<K,V[]>> comparator) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V[]>(comparator)));
    }


    public Level0MapOfArraySelectedOperator<K,V> replaceWith(final Map<K,V[]> replacement) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfArraySelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V[]>,? super Map<K,V[]>> converter) {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAP_OF_ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
