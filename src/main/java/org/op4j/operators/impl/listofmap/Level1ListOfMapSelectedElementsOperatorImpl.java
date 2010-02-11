package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ListOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsOperator<K,V> {


    public Level1ListOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> endFor() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().iterate(Structure.MAP));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeAllKeys(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeAllKeysNot(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> convertAsMap(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.MAP));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> evalAsMap(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.MAP));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> execAsMap(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfMapSelectedElementsOperator<K,V> sort() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> replaceWith(final Map<K,V> replacement) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }



}
