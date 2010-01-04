package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> {


    public Level2SetOfMapSelectedElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapSelectedElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapSelectedElementsSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
