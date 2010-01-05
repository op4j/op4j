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
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level1SetOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapSelectedElementsOperator<K,V> {


    public Level1SetOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0SetOfMapSelectedOperator<K,V> endFor() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return null;
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapSelectedElementsOperator<K,V> sort() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
