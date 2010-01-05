package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}