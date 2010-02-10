package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level3SetOfMapElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapElementsSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
