package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
