package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfSetEntriesSelectedValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> {


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueElementsOperator<K,V> endIf() {
        return new Level3MapOfSetEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfSetEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfSetEntriesSelectedValueElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfSetEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
