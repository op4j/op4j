package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> {


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.InsertAll<K2,V>(position, map)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K2,V>(eval)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K2,V>(eval)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V> endIf() {
        return new Level2MapOfMapSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> forEachEntry() {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().iterate(Structure.MAP));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeAllKeys(final K2... keys) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K2,V>(keys)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> removeAllKeysNot(final K2... keys) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K2,V>(keys)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> convertAsMap(final IConverter<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> evalAsMap(final IEvaluator<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> execAsMap(final IFunction<? extends Map<? extends K2,? extends V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Put<K2,V>(newKey, newValue)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> putAll(final Map<K2,V> map) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.PutAll<K2,V>(map)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Insert<K2,V>(position, newKey, newValue)));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> sort() {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> replaceWith(final Map<K2,V> replacement) {
        return new Level2MapOfMapSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
