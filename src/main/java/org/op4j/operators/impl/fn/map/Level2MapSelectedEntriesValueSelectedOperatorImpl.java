package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level2MapSelectedEntriesValueSelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueOperatorImpl<I,K,V> endIf() {
        return new Level2MapSelectedEntriesValueOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V> execIfNotNull(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V> exec(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
