package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> {


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
