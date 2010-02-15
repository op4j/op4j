package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3SetOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3SetOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endOn().get();
    }



}
