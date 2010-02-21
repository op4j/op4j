package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
