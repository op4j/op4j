package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
