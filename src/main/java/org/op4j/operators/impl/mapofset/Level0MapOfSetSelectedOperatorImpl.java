package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0MapOfSetSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0MapOfSetSelectedOperator<K,V,I> {


    public Level0MapOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfSetSelectedOperator<K,V,I> insertAll(final int position, final Map<K,Set<V>> map) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.InsertAll<K,Set<V>>(position, NormalizationUtils.normalizeMapOfSet(map))));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,Set<V>>(eval)));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,Set<V>>(eval)));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAP_OF_SET));
    }


    public Level0MapOfSetOperator<K,V,I> endIf() {
        return new Level0MapOfSetOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V,I> forEachEntry() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0MapOfSetSelectedOperator<K,V,I> removeAllKeys(final K... keys) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,Set<V>>(keys)));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,Set<V>>(keys)));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> put(final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Put<K,Set<V>>(newKey, NormalizationUtils.normalizeSet(newValue))));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> putAll(final Map<K,Set<V>> map) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.PutAll<K,Set<V>>(NormalizationUtils.normalizeMapOfSet(map))));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> insert(final int position, final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Insert<K,Set<V>>(position, newKey, NormalizationUtils.normalizeSet(newValue))));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> function) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAP_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfSetSelectedOperator<K,V,I> sort() {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> sort(final Comparator<? super Entry<K,Set<V>>> comparator) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortEntries<K,Set<V>>(comparator)));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> replaceWith(final Map<K,Set<V>> replacement) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfSetSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> converter) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAP_OF_SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
