package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
