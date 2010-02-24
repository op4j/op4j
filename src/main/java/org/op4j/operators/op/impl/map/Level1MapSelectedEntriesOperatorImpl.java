package org.op4j.operators.op.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level0MapSelectedOperator;
import org.op4j.operators.op.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.op.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapSelectedEntriesOperator<K,V,I> {


    public Level1MapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifIndex(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indexes));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super Entry<K,V>> eval) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifIndexNot(final int... indexes) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapSelectedOperator<K,V,I> endFor() {
        return new Level0MapSelectedOperatorImpl<K,V,I>(getTarget().endIterate(null));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifKeyEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> ifKeyNotEquals(final K... keys) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V,I> onKey() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesValueOperator<K,V,I> onValue() {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesOperator<K,V,I> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endFor().get();
    }



}
