package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> eval(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().iterateIndex(0));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3SetOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().iterateIndex(1));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> exec(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> convert(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
