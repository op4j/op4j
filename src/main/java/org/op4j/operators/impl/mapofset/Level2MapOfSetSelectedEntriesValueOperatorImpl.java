package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetSelectedEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesValueOperator<K,V> {


    public Level2MapOfSetSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super Set<V>> eval) {
        return null;
    }


    public Level3MapOfSetSelectedEntriesValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends Set<V>,? super Set<V>> eval) {
        return null;
    }


    public Level1MapOfSetSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends Set<V>,? super Set<V>> function) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends Set<V>,? super Set<V>> converter) {
        return null;
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
