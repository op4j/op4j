package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListSelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesValueOperator<K,V> {


    public Level2MapOfListSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super List<V>> eval) {
        return null;
    }


    public Level3MapOfListSelectedEntriesValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return null;
    }


    public Level1MapOfListSelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
