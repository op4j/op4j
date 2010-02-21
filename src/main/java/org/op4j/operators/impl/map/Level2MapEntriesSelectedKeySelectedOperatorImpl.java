package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
