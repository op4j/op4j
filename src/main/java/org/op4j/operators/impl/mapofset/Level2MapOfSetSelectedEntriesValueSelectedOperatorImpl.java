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
import org.op4j.target.Target.Normalization;


public class Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfSetSelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfSetSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends Set<? extends V>,? super Set<V>> eval) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.SET));
    }


    public Level2MapOfSetSelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfSetSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends Set<? extends V>,? super Set<V>> function) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfSetSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends Set<? extends V>,? super Set<V>> converter) {
        return new Level2MapOfSetSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }



}
