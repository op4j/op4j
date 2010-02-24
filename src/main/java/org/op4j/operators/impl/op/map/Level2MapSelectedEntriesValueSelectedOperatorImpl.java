package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapSelectedEntriesValueSelectedOperator<K,V,I> {


    public Level2MapSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueOperatorImpl<K,V,I> endIf() {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
