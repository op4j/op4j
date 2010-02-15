package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesKeyOperator<K,V> {


    public Level2MapOfListSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> endOn() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endOn().get();
    }



}
