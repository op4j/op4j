package org.op4j.operators.op.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapSelectedEntriesValueSelectedOperator<K,V,I> {


    public Level2MapSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueOperator<K,V,I> endIf() {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
