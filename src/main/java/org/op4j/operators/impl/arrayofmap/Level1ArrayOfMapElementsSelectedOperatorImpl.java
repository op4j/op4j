package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1ArrayOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ArrayOfMapElementsSelectedOperator<K,V> {


    public Level1ArrayOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1ArrayOfMapElementsOperator<K,V> endIf() {
        return new Level1ArrayOfMapElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2ArrayOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapElementsSelectedOperator<K,V> sort() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
