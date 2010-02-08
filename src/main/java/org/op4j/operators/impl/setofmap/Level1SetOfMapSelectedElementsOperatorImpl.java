package org.op4j.operators.impl.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1SetOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1SetOfMapSelectedElementsOperator<K,V> {


    public Level1SetOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level1SetOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> endFor() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2SetOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return new Level2SetOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> convertAsMap(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> evalAsMap(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfMapSelectedElementsOperator<K,V> sort() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Set<Map<K,V>> get() {
        return endFor().get();
    }



}
