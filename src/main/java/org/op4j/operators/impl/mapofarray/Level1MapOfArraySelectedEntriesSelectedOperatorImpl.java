package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArraySelectedEntriesSelectedOperator<K,V> {


    private final Type<V> type;


    public Level1MapOfArraySelectedEntriesSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> endIf() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(this.type, getTarget().onKey());
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().onValue());
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
