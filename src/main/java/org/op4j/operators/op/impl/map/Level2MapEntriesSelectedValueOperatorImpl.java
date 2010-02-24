package org.op4j.operators.op.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.intf.map.Level2MapEntriesSelectedValueOperator;
import org.op4j.operators.op.impl.AbstractOperatorImpl;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapEntriesSelectedValueOperatorImpl<K,V,I> extends AbstractOperatorImpl implements UniqOpOperator<Map<K,V>>, Level2MapEntriesSelectedValueOperator<K,V,I> {


    public Level2MapEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifIndex(final int... indexes) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indexes));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifIndexNot(final int... indexes) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNotNull() {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapEntriesSelectedValueOperatorImpl<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapEntriesSelectedOperatorImpl<K,V,I> endOn() {
        return new Level1MapEntriesSelectedOperatorImpl<K,V,I>(getTarget().endOn());
    }


    public Level2MapEntriesSelectedValueOperatorImpl<K,V,I> replaceWith(final V replacement) {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2MapEntriesSelectedValueOperatorImpl<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
