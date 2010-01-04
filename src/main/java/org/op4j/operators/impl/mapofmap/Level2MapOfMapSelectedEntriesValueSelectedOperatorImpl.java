package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator;
import org.op4j.target.Target;


public class Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> {


    public Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K2,V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level2MapOfMapSelectedEntriesValueOperator<K1,K2,V> endIf() {
        return new Level2MapOfMapSelectedEntriesValueOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V> forEachEntry() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> removeKeys(final K2... keys) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> removeKeysNot(final K2... keys) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> put(final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> putAll(final Map<K2,V> map) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> exec(final IFunction<? extends Map<K2,V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> sort() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V> convert(final IConverter<? extends Map<K2,V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
