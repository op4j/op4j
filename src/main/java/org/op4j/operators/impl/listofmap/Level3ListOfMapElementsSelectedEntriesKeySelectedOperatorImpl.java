package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> {


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3ListOfMapElementsSelectedEntriesKeyOperator<K,V> endIf() {
        return new Level3ListOfMapElementsSelectedEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapElementsSelectedEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ListOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
