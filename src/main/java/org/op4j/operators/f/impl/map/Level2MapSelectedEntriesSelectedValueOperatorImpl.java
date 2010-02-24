package org.op4j.operators.f.impl.map;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.map.Level1MapSelectedEntriesSelectedOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.op.intf.map.Level2MapSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapSelectedEntriesSelectedValueOperator<K,V,I> {


    public Level2MapSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifIndex(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifIndexNot(final int... indexes) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNull() {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapSelectedEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapSelectedEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V,I> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1MapSelectedEntriesSelectedOperator<K,V,I> endOn() {
        return new Level1MapSelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().endOn());
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapSelectedEntriesSelectedValueOperator<K,V,I> replaceWith(final V replacement) {
        return new Level2MapSelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V> get() {
        return endOn().get();
    }



}
