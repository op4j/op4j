package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedKeyOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level2MapEntriesSelectedKeyOperator<I,K,V> {


    public Level2MapEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNullOrFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNull() {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNull());
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNullOrTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNull() {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapEntriesSelectedKeySelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K,V> endOn() {
        return new Level1MapEntriesSelectedOperatorImpl<I,K,V>(getTarget().endOn());
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> replaceWith(final K replacement) {
        return new Level2MapEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedKeyOperatorImpl<I,K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapEntriesSelectedKeyOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
