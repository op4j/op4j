package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
