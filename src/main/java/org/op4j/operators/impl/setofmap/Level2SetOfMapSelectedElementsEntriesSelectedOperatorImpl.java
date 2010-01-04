package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> {


    public Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> endIf() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
