package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedKeyOperator<K,V> {


    public Level2MapOfListEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
