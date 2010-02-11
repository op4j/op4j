package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2ListOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> endFor() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapSelectedElementsEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3ListOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return new Level3ListOfMapSelectedElementsEntriesKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> evalAsMapEntry(final IEvaluator<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> eval) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> convertAsMapEntry(final IConverter<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> converter) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }



}
