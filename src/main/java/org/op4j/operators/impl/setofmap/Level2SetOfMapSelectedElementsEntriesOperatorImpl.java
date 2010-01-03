package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesSelectedOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapSelectedElementsEntriesValueOperator;
import org.op4j.target.Target;


public class Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2SetOfMapSelectedElementsEntriesOperator<K,V> {


    public Level2SetOfMapSelectedElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> eval(final IEvaluator<? extends Entry<K,V>,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> endFor() {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyEquals(final K... keys) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesSelectedOperator<K,V> ifKeyNotEquals(final K... keys) {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesKeyOperator<K,V> onKey() {
        return null;
    }


    public Level3SetOfMapSelectedElementsEntriesValueOperator<K,V> onValue() {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> exec(final IFunction<? extends Entry<K,V>,? super Entry<K,V>> function) {
        return null;
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> convert(final IConverter<? extends Entry<K,V>,? super Entry<K,V>> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
