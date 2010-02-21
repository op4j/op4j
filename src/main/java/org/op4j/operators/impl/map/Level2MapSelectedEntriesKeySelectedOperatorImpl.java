package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesKeySelectedOperator<K,V> {


    public Level2MapSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
