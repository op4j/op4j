package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfArraySelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArraySelectedEntriesOperator<K,V> {


    private final Type<V> type;


    public Level1MapOfArraySelectedEntriesOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level0MapOfArraySelectedOperator<K,V> endFor() {
        return new Level0MapOfArraySelectedOperatorImpl<K,V>(this.type, getTarget().endIterate(null));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectMapKeys(keys));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().selectMapKeysNot(keys));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> onKey() {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.type, getTarget().onKey());
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> onValue() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.type, getTarget().onValue());
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> execIfNotNullAsMapOfArrayEntry(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
