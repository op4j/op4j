package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueOperator<K,V> endIf() {
        return new Level3ArrayOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ArrayOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
