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
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends Set<V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends Set<V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return null;
    }



}
