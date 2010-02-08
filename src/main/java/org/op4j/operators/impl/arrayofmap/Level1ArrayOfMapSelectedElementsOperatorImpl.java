package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ArrayOfMapSelectedElementsOperator<K,V> {


    public Level1ArrayOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> endFor() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().endIterate(Map.class));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Map<K,V>[] get() {
        return endFor().get();
    }



}
