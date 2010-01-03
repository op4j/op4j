package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesKeyOperator<K,V> {


    public Level2MapOfSetSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
