package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
