package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> {


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
