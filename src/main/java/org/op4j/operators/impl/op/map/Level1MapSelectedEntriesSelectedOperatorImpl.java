package org.op4j.operators.op.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.op.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapSelectedEntriesSelectedOperator<K,V,I> {


    public Level1MapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapSelectedEntriesOperator<K,V,I> endIf() {
        return new Level1MapSelectedEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().onKey());
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().onValue());
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
