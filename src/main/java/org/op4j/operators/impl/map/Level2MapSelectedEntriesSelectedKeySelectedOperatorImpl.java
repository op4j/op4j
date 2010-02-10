package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
