package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> endOn() {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> replaceWith(final V replacement) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,V>[] get() {
        return endOn().get();
    }



}
