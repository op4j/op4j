package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfListSelectedEntriesValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListSelectedEntriesValueElementsOperator<K,V> {


    public Level3MapOfListSelectedEntriesValueElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListSelectedEntriesValueElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> endFor() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfListSelectedEntriesValueElementsOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfListSelectedEntriesValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfListSelectedEntriesValueElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfListSelectedEntriesValueElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }



}
