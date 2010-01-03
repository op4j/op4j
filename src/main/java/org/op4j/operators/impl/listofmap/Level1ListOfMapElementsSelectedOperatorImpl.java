package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1ListOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapElementsSelectedOperator<K,V> {


    public Level1ListOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return null;
    }


    public Level1ListOfMapElementsOperator<K,V> endIf() {
        return null;
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> sort() {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return null;
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return null;
    }


    public List<Map<K,V>> get() {
        return null;
    }



}
