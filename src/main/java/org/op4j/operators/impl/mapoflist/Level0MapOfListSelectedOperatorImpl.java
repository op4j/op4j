package org.op4j.operators.impl.mapoflist;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.Level0MapOfListSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0MapOfListSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0MapOfListSelectedOperator<K,V,I> {


    public Level0MapOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfListSelectedOperator<K,V,I> insertAll(final int position, final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.InsertAll<K,List<V>>(position, NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,List<V>>(eval)));
    }


    public Level0MapOfListSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,List<V>>(eval)));
    }


    public Level0MapOfListSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> eval) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAP_OF_LIST));
    }


    public Level0MapOfListOperator<K,V,I> endIf() {
        return new Level0MapOfListOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> forEachEntry() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0MapOfListSelectedOperator<K,V,I> removeAllKeys(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,List<V>>(keys)));
    }


    public Level0MapOfListSelectedOperator<K,V,I> put(final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Put<K,List<V>>(newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListSelectedOperator<K,V,I> putAll(final Map<K,List<V>> map) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.PutAll<K,List<V>>(NormalizationUtils.normalizeMapOfList(map))));
    }


    public Level0MapOfListSelectedOperator<K,V,I> insert(final int position, final K newKey, final List<V> newValue) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Insert<K,List<V>>(position, newKey, NormalizationUtils.normalizeList(newValue))));
    }


    public Level0MapOfListSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> function) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAP_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfListSelectedOperator<K,V,I> sort() {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfListSelectedOperator<K,V,I> sort(final Comparator<? super Entry<K,List<V>>> comparator) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortEntries<K,List<V>>(comparator)));
    }


    public Level0MapOfListSelectedOperator<K,V,I> replaceWith(final Map<K,List<V>> replacement) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfListSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends List<? extends V>>,? super Map<K,List<V>>> converter) {
        return new Level0MapOfListSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAP_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
