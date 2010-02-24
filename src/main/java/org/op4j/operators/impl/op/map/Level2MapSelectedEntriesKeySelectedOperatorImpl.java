package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeySelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapSelectedEntriesKeySelectedOperator<K,V,I> {


    public Level2MapSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesKeyOperatorImpl<K,V,I> endIf() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}