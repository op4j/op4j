package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> {


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level3SetOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
