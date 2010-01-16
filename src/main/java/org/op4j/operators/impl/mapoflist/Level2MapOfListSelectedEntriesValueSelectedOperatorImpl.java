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
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveIndexes<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveEquals<V>(values)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> removeNulls() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNulls<V>()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends V>,? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level2MapOfListSelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends List<? extends V>,? super List<V>> converter) {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
