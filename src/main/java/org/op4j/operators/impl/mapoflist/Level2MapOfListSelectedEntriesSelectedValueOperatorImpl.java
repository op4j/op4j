package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListSelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> {


    public Level2MapOfListSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListSelectedEntriesSelectedValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return null;
    }


    public Level1MapOfListSelectedEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return null;
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
