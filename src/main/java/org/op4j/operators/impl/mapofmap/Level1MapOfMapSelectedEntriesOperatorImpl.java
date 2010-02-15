package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesOperator<K1,K2,V> {


    public Level1MapOfMapSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifTrue(final IFunction<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifFalse(final IFunction<Boolean, ? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level0MapOfMapSelectedOperator<K1,K2,V> endFor() {
        return new Level0MapOfMapSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(null));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeys(keys));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> ifKeyNotEquals(final K1... keys) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfMapSelectedEntriesKeyOperator<K1,K2,V> onKey() {
        return new Level2MapOfMapSelectedEntriesKeyOperatorImpl<K1,K2,V>(getTarget().onKey());
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> onValue() {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().onValue());
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> execAsMapOfMapEntry(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.MAP_OF_MAP_ENTRY));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> execIfNotNullAsMapOfMapEntry(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_OF_MAP_ENTRY));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> replaceWith(final Entry<K1,Map<K2,V>> replacement) {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.MAP_OF_MAP_ENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }



}
