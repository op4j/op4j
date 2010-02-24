package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeySelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapEntriesSelectedKeySelectedOperator<K,V,I> {


    public Level2MapEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<K,V,I> endIf() {
        return new Level2MapEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I> replaceWith(final K replacement) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
