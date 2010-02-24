package org.op4j.operators.impl.fn.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level1MapSelectedEntriesSelectedOperator<I,K,V> {


    public Level1MapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesOperatorImpl<I,K,V> endIf() {
        return new Level1MapSelectedEntriesOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> onKey() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> onValue() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
