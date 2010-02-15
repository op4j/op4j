package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesSelectedOperator<K,V> {


    public Level1MapOfSetSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endIf() {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfSetSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> execAsMapOfSetEntry(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_OF_SET_ENTRY));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> execIfNotNullAsMapOfSetEntry(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_OF_SET_ENTRY));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,Set<V>> replacement) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_SET_ENTRY));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
