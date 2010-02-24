package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level2MapSelectedEntriesSelectedKeySelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> endIf() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> execIfNotNull(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> exec(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
