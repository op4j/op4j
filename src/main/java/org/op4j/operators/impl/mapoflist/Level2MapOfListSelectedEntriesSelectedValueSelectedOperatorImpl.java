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
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfListSelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends V>,? super List<V>> eval) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level2MapOfListSelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfListSelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends List<? extends V>,? super List<V>> function) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfListSelectedEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends List<? extends V>,? super List<V>> converter) {
        return new Level2MapOfListSelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
