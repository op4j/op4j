package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfSetEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedKeyOperator<K,V> {


    public Level2MapOfSetEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super K> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
