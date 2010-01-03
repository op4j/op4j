package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;


public class Level1ListOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsOperator<K,V> {


    public Level1ListOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ListOfMapSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> sort() {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
