package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1MapOfArrayEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1MapOfArrayEntriesSelectedOperator<K,V> {


    private final Type<V> type;


    public Level1MapOfArrayEntriesSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1MapOfArrayEntriesOperator<K,V> endIf() {
        return new Level1MapOfArrayEntriesOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level2MapOfArrayEntriesSelectedKeyOperatorImpl<K,V>(this.type, getTarget().onKey());
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> onValue() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().onValue());
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> execAsMapOfArrayEntry(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.MAP_OF_ARRAY_ENTRY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
