package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedValueOperator<K,V> {


    public Level2MapOfListEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
