package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> {


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> endIf() {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
