package org.op4j.operators.f.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.op.intf.map.Level2MapEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapEntriesValueSelectedOperator<K,V,I> {


    public Level2MapEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesValueOperator<K,V,I> endIf() {
        return new Level2MapEntriesValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapEntriesValueSelectedOperator<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
