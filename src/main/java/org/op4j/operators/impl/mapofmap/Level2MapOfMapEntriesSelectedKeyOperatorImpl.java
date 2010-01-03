package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> {


    public Level2MapOfMapEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull() {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull() {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return null;
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K1,? super K1> function) {
        return null;
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
