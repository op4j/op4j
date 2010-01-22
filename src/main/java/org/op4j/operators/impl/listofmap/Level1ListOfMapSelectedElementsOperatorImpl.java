package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfMapSelectedElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsOperator<K,V,I> {


    public Level1ListOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> insertAll(final int position, final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> endFor() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> forEachEntry() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> removeAllKeys(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> removeAllKeysNot(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> put(final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> putAll(final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfMapSelectedElementsOperator<K,V,I> sort() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> replaceWith(final Map<K,V> replacement) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
