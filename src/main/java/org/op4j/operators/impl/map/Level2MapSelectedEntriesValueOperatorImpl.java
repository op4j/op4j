package org.op4j.operators.impl.map;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level1MapSelectedEntriesOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueOperator;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level2MapSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapSelectedEntriesValueOperator<K,V> {


    public Level2MapSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level2MapSelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V> get() {
        return null;
    }



}
