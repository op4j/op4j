package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
