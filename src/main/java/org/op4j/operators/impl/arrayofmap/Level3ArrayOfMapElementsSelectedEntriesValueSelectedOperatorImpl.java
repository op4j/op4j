package org.op4j.operators.impl.arrayofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> {


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueOperator<K,V> endIf() {
        return new Level3ArrayOfMapElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
