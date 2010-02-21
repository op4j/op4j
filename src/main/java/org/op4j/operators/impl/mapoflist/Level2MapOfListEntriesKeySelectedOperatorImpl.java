package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfListEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesKeySelectedOperator<K,V> {


    public Level2MapOfListEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfListEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfListEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfListEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
