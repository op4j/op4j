package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> {


    public Level1ArrayOfMapSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> endIf() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2ArrayOfMapSelectedElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> sort() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
