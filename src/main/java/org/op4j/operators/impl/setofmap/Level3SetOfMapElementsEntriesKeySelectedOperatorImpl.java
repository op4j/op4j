package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> {


    public Level3SetOfMapElementsEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsEntriesKeyOperator<K,V> endIf() {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
