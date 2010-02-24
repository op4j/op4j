package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level2MapSelectedEntriesSelectedKeyOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNullOrFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNullAndFalse(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNullOrTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNullAndTrue(final IFunction<? super K,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> execIfNotNull(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> endOn() {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V> exec(final IFunction<? super K,? extends K> function) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
