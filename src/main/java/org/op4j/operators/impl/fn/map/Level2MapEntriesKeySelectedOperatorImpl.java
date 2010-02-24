package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesKeySelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqFnOperator<Map<K,V>,I>, Level2MapEntriesKeySelectedOperator<K,V,I> {


    public Level2MapEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesKeyOperatorImpl<K,V,I> endIf() {
        return new Level2MapEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapEntriesKeySelectedOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<K,V,I> replaceWith(final K replacement) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperatorImpl<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
