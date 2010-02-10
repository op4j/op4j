package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> {


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> endIf() {
        return new Level2ListOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ListOfMapSelectedElementsSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
