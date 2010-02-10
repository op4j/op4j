package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> {


    public Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> endIf() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3SetOfMapSelectedElementsEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3SetOfMapSelectedElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2SetOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
