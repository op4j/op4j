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
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetSelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
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
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
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
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends Set<V>,? super Set<V>> converter) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
