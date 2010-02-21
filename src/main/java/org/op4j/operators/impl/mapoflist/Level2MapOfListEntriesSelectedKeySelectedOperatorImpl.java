package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfListEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
