package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> {


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueOperator<K,V> endIf() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
