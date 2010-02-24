package org.op4j.operators.op.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> {


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I> endIf() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
