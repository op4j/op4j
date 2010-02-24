package org.op4j.operators.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapEntriesSelectedOperator<K,V> {


    public Level1MapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K,V> endIf() {
        return new Level1MapEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level2MapEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level1MapEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
