package org.op4j.operators.impl.mapofset;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public class Level0MapOfSetSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfSetSelectedOperator<K,V> {


    public Level0MapOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapOfSetSelectedOperator<K,V> insertAll(final int position, final Map<K,Set<V>> map) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,Set<V>>(position, NormalisationUtils.normaliseMapOfSet(map))));
    }


    public Level0MapOfSetSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,Set<V>>(eval)));
    }


    public Level0MapOfSetSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,Set<V>>(eval)));
    }


    public Level0MapOfSetSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> eval) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_OF_SET));
    }


    public Level0MapOfSetOperator<K,V> endIf() {
        return new Level0MapOfSetOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapOfSetSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,Set<V>>(keys)));
    }


    public Level0MapOfSetSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,Set<V>>(keys)));
    }


    public Level0MapOfSetSelectedOperator<K,V> put(final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,Set<V>>(newKey, NormalisationUtils.normaliseSet(newValue))));
    }


    public Level0MapOfSetSelectedOperator<K,V> putAll(final Map<K,Set<V>> map) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,Set<V>>(NormalisationUtils.normaliseMapOfSet(map))));
    }


    public Level0MapOfSetSelectedOperator<K,V> insert(final int position, final K newKey, final Set<V> newValue) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,Set<V>>(position, newKey, NormalisationUtils.normaliseSet(newValue))));
    }


    public Level0MapOfSetSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> function) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfSetSelectedOperator<K,V> sort() {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapOfSetSelectedOperator<K,V> sort(final Comparator<? super Entry<K,Set<V>>> comparator) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,Set<V>>(comparator)));
    }


    public Level0MapOfSetSelectedOperator<K,V> replaceWith(final Map<K,Set<V>> replacement) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfSetSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends Set<? extends V>>,? super Map<K,Set<V>>> converter) {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_OF_SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
