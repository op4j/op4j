package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeyOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesKeySelectedOperator<K,V> {


    public Level2MapSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level2MapSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapSelectedEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V> get() {
        return endIf().get();
    }



}
