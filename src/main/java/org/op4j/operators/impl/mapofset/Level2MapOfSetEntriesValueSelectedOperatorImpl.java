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
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetEntriesValueSelectedOperator<K,V> {


    public Level2MapOfSetEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetEntriesValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveIndexes<V>(indices)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveEquals<V>(values)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<V>(indices)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> removeNulls() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNulls<V>()));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfSetEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
