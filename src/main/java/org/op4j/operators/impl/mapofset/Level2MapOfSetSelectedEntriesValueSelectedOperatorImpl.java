package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<V>,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends Set<V>,? super Set<V>> function) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends Set<V>,? super Set<V>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
