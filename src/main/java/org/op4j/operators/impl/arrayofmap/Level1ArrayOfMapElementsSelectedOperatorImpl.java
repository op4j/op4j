package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ArrayOfMapElementsSelectedOperator<K,V> {


    public Level1ArrayOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1ArrayOfMapElementsOperator<K,V> endIf() {
        return new Level1ArrayOfMapElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level2ArrayOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> convertAsMap(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> evalAsMap(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapElementsSelectedOperator<K,V> sort() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
