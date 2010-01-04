package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> {


    public Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull() {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull() {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return null;
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K1,? super K1> function) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
