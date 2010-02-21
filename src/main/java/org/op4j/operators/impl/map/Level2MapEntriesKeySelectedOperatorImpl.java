package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapEntriesKeySelectedOperator<K,V> {


    public Level2MapEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesKeyOperator<K,V> endIf() {
        return new Level2MapEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
