package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfListSelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesSelectedKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfListSelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListSelectedEntriesSelectedKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfListSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
