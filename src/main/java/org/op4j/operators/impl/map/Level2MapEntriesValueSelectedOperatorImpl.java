package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.map.Level2MapEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapEntriesValueSelectedOperator<K,V> {


    public Level2MapEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapEntriesValueOperator<K,V> endIf() {
        return new Level2MapEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapEntriesValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level2MapEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
