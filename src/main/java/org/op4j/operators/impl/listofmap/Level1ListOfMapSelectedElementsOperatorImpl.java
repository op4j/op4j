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
import org.op4j.target.Target.Structure;


public class Level1ListOfMapSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapSelectedElementsOperator<K,V> {


    public Level1ListOfMapSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level1ListOfMapSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveMatching<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,V>(eval)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> eval(final IEvaluator<? extends Map<K,V>,? super Map<K,V>> eval) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0ListOfMapSelectedOperator<K,V> endFor() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V> forEachEntry() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeKeys(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeys<K,V>(keys)));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> removeKeysNot(final K... keys) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K,V>(keys)));
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


    public Level1ListOfMapSelectedElementsOperator<K,V> exec(final IFunction<? extends Map<K,V>,? super Map<K,V>> function) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfMapSelectedElementsOperator<K,V> sort() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> convert(final IConverter<? extends Map<K,V>,? super Map<K,V>> converter) {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return endFor().get();
    }



}
