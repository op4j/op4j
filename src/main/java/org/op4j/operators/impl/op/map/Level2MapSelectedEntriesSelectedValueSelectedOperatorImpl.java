package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level2MapSelectedEntriesSelectedValueSelectedOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> endIf() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
