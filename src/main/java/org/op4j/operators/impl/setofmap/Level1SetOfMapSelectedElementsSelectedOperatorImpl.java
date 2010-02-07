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
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapSelectedElementsSelectedOperator<K,V> {


    public Level1SetOfMapSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> endIf() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> sort() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
