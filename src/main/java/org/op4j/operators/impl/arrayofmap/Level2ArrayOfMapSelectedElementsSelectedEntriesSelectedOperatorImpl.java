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
import org.op4j.target.Target.Normalisation;


public class Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ArrayOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
