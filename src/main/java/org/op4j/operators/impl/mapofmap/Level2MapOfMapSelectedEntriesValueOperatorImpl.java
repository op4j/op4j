package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesOperator;
import org.op4j.target.Target;


public class Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> {


    public Level2MapOfMapSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNull() {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNull() {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K2,V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesOperator<K1,K2,V> forEachEntry() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> removeKeys(final K2... keys) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> removeKeysNot(final K2... keys) {
        return null;
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> put(final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> putAll(final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> exec(final IFunction<? extends Map<K2,V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> sort() {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> convert(final IConverter<? extends Map<K2,V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
