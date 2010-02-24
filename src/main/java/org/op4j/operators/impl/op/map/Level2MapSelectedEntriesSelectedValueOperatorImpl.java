package org.op4j.operators.impl.op.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> extends AbstractOperatorImpl implements UniqOpOperator<I,Map<K,V>>, Level2MapSelectedEntriesSelectedValueOperator<I,K,V> {


    public Level2MapSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifIndex(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNullOrFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNullAndFalse(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNullOrTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifIndexNot(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V> ifNotNullAndTrue(final IFunction<? super V,Boolean> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<I,K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> execIfNotNull(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V> endOn() {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<I,K,V>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> exec(final IFunction<? super V,? extends V> function) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<I,K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
