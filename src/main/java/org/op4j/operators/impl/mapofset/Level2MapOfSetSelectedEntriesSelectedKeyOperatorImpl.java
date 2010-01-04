package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> {


    public Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfSetSelectedEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfSetSelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfSetSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
