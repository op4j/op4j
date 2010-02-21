package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> {


    private final Type<V> type;


    public Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
