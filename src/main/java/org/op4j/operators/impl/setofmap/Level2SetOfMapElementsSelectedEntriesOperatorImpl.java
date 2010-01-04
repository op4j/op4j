package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapElementsSelectedEntriesOperator<K,V> {


    public Level2SetOfMapElementsSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Entry<K,V>> eval) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeys(keys));
    }


    public Level2SetOfMapElementsSelectedEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return new Level2SetOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().selectMapKeysNot(keys));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
