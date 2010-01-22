package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1ArrayOfMapSelectedElementsOperator<K,V,I> {


    public Level1ArrayOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNull() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level1ArrayOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> insertAll(final int position, final Map<K,V> map) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> endFor() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.ARRAY, Map.class));
    }


    public Level2ArrayOfMapSelectedElementsEntriesOperator<K,V,I> forEachEntry() {
        return new Level2ArrayOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> removeAllKeys(final K... keys) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> putAll(final Map<K,V> map) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> sort() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> replaceWith(final Map<K,V> replacement) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public Map<K,V>[] get() {
        return endFor().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endFor().createOperation();
    }



}
