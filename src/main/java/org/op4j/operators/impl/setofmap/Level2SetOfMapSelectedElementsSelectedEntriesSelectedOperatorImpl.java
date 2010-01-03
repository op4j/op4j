package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
