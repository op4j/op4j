package org.op4j.operators.op.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level2MapEntriesKeyOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesKeySelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapEntriesKeySelectedOperator<K,V,I> {


    public Level2MapEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesKeyOperator<K,V,I> endIf() {
        return new Level2MapEntriesKeyOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapEntriesKeySelectedOperator<K,V,I> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesKeySelectedOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
