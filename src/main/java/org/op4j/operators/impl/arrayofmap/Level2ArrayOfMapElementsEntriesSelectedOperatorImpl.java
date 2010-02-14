package org.op4j.operators.impl.arrayofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.arrayofmap.Level3ArrayOfMapElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> {


    public Level2ArrayOfMapElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfMapElementsEntriesOperator<K,V> endIf() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ArrayOfMapElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ArrayOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ArrayOfMapElementsEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ArrayOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level2ArrayOfMapElementsEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ArrayOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
