package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;


public class Level1ArrayOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ArrayOfMapSelectedElementsOperator<K,V> {


    public Level1ArrayOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort() {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return null;
    }


    public Map<K,V>[] get() {
        return null;
    }



}
