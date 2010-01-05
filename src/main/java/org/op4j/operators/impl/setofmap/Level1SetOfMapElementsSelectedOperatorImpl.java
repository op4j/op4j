package org.op4j.operators.impl.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1SetOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapElementsSelectedOperator<K,V> {


    public Level1SetOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1SetOfMapElementsOperator<K,V> endIf() {
        return new Level1SetOfMapElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapElementsSelectedOperator<K,V> sort() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1SetOfMapElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}