package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesKeySelectedOperator<K,V> {


    public Level2MapOfArrayEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfArrayEntriesKeyOperator<K,V> endIf() {
        return new Level2MapOfArrayEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfArrayEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArrayEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
