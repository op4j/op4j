package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> {


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
