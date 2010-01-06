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
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapSelectedElementsSelectedOperator<K,V> {


    public Level1SetOfMapSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveMatching<K,V>(eval)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,V>(eval)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> endIf() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2SetOfMapSelectedElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> sort() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
