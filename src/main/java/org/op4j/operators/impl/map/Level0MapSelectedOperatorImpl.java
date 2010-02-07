package org.op4j.operators.impl.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level0MapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapSelectedOperator<K,V> {


    public Level0MapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0MapSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level0MapSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level0MapSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level0MapSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level0MapOperator<K,V> endIf() {
        return new Level0MapOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level1MapSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level0MapSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level0MapSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level0MapSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level0MapSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level0MapSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level0MapSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0MapSelectedOperator<K,V> sort() {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level0MapSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level0MapSelectedOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level0MapSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level0MapSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
