package org.op4j.operators.impl.fn.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.fn.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedValueOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqFnOperator<I,Map<K,V>>, Level2MapEntriesSelectedValueOperator<I,K,V> {


    public Level2MapEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesSelectedValueOperatorImpl<I,K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapEntriesSelectedOperatorImpl<I,K,V> endOn() {
        return new Level1MapEntriesSelectedOperatorImpl<I,K,V>(getTarget().endOn());
    }


    public Level2MapEntriesSelectedValueOperatorImpl<I,K,V> replaceWith(final V replacement) {
        return new Level2MapEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedValueOperatorImpl<I,K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
