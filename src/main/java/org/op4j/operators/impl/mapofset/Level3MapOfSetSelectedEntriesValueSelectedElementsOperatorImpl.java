package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> {


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }



}
