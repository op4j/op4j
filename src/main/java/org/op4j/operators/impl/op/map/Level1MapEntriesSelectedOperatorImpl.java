package org.op4j.operators.impl.op.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapEntriesSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level1MapEntriesSelectedOperator<I,K,V> {


    public Level1MapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperatorImpl<I,K,V> endIf() {
        return new Level1MapEntriesOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> onKey() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().onKey());
    }


    public Level2MapEntriesSelectedValueOperatorImpl<I,K,V> onValue() {
        return new Level2MapEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().onValue());
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K,V> execAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K,V> execIfNotNullAsMapEntry(final IFunction<? super Entry<K,V>,? extends Entry<? extends K,? extends V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapEntriesSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
