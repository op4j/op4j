package org.op4j.operators.impl.fn.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level1MapSelectedEntriesOperator<I,K,V> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifTrue(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifFalse(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperatorImpl<I,K,V> endFor() {
        return new Level0MapSelectedOperatorImpl<I,K,V>(getTarget().endIterate(null));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperatorImpl<I,K,V> onKey() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<I,K,V>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesValueOperatorImpl<I,K,V> onValue() {
        return new Level2MapSelectedEntriesValueOperatorImpl<I,K,V>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endFor().get();
    }



}
