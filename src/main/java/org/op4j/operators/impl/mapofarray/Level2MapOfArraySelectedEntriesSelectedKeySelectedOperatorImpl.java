package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
