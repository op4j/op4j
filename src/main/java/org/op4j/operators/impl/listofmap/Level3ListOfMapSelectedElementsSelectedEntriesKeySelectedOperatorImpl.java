package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
