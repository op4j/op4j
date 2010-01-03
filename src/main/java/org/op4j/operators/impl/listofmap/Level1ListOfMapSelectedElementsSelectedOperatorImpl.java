package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsSelectedOperator<K,V> {


    public Level1ListOfMapSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> endIf() {
        return null;
    }


    public Level2ListOfMapSelectedElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> sort() {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return null;
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
