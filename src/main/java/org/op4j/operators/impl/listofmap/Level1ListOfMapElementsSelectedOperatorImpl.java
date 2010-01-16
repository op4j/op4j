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
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ListOfMapElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level1ListOfMapElementsSelectedOperator<K,V> {


    public Level1ListOfMapElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveMatching<K,V>(eval)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K,V>(eval)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>,? super Map<K,V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.MAP));
    }


    public Level1ListOfMapElementsOperator<K,V> endIf() {
        return new Level1ListOfMapElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2ListOfMapElementsSelectedEntriesOperator<K,V> forEachEntry() {
        return new Level2ListOfMapElementsSelectedEntriesOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> insertAll(final int position, final Map<K,V> map) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.InsertAll<K,V>(position, map)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeKeys(final K... keys) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeys<K,V>(keys)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> removeKeysNot(final K... keys) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K,V>(keys)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Put<K,V>(newKey, newValue)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> putAll(final Map<K,V> map) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.PutAll<K,V>(map)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.Insert<K,V>(position, newKey, newValue)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>,? super Map<K,V>> function) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.MAP));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfMapElementsSelectedOperator<K,V> sort() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> sort(final Comparator<? super Entry<K,V>> comparator) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(new MapFuncs.SortEntries<K,V>(comparator)));
    }


    public Level1ListOfMapElementsSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>,? super Map<K,V>> converter) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.MAP));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
