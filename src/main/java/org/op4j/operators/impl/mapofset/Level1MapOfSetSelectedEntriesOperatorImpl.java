package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level0MapOfSetSelectedOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfSetSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfSetSelectedEntriesOperator<K,V> {


    public Level1MapOfSetSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapOfSetSelectedOperator<K,V> endFor() {
        return new Level0MapOfSetSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfSetSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> onKey() {
        return new Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> onValue() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> execAsMapOfSetEntry(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_OF_SET_ENTRY));
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> replaceWith(final Entry<K,Set<V>> replacement) {
        return new Level1MapOfSetSelectedEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_SET_ENTRY));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }



}
