package org.op4j.operators.impl.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapElementsSelectedOperator<K,V> {


    public Level1SetOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level1SetOfMapElementsOperator<K,V> endIf() {
        return new Level1SetOfMapElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapElementsSelectedOperator<K,V> sort() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAP));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
