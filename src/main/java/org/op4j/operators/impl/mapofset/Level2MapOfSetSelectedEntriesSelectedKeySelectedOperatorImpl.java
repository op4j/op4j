package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
