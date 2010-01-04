package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfListEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<V>,? super List<V>> eval) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends List<V>,? super List<V>> function) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends List<V>,? super List<V>> converter) {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
