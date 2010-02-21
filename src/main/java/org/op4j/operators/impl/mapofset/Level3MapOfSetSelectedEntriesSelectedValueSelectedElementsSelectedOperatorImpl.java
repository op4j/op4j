package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> {


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
