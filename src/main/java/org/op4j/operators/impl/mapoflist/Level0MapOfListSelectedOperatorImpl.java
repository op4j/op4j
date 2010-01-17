package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0MapOfListSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfListSelectedOperator<K,V> {


    public Level0MapOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfListSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveMatching<K,List<V>>(eval)));
    }


    public Level0MapOfListSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,List<V>>(eval)));
    }


    public Level0MapOfListSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAP_OF_LIST));
    }


    public Level0MapOfListOperator<K,V> endIf() {
        return new Level0MapOfListOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0MapOfListSelectedOperator<K,V> insertAll(final int position, final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,List<V>>(position, NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V> removeKeys(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeys<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,List<V>>(newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListSelectedOperator<K,V> putAll(final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,List<V>>(NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,List<V>>(position, newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> function) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAP_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfListSelectedOperator<K,V> sort() {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfListSelectedOperator<K,V> sort(final Comparator<? super Entry<K,List<V>>> comparator) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,List<V>>(comparator)));
    }


    public Level0MapOfListSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> converter) {
        return new Level0MapOfListSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAP_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
