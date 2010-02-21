package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> {


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endFor().get();
    }



}
