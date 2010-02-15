package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsSelectedOperator<K,V> {


    public Level1ListOfMapSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeAllTrue(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeAllFalse(final IFunction<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> endIf() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> execIfNotNullAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> sort() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
