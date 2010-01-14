package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> endIf() {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level3ArrayOfMapSelectedElementsEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ArrayOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2ArrayOfMapSelectedElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
