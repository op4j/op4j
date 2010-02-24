package org.op4j.operators.op.impl.map;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level1MapEntriesOperator;
import org.op4j.operators.op.intf.map.Level1MapEntriesSelectedOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesSelectedKeyOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapEntriesSelectedOperator<K,V,I> {


    public Level1MapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapEntriesOperator<K,V,I> endIf() {
        return new Level1MapEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().onKey());
    }


    public Level2MapEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().onValue());
    }


    public Level1MapEntriesSelectedOperator<K,V,I> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<K,V,I> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level1MapEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V> replacement) {
        return new Level1MapEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
