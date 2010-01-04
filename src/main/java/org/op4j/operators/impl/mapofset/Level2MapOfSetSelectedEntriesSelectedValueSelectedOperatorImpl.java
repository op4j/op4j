package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<V>,? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends Set<V>,? super Set<V>> function) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetSelectedEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends Set<V>,? super Set<V>> converter) {
        return new Level2MapOfSetSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
