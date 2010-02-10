package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> {


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> endIf() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
