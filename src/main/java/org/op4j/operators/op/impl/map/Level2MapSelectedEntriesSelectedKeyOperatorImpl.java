package org.op4j.operators.op.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapSelectedEntriesSelectedKeyOperator<K,V,I> {


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifIndex(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indexes));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifIndexNot(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapSelectedEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I> endOn() {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I> replaceWith(final K replacement) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapSelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
