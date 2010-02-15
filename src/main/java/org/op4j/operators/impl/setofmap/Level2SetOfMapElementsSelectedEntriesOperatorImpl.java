package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2SetOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> endFor() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return new Level3SetOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Set<Map<K,V>> get() {
        return endFor().get();
    }



}
