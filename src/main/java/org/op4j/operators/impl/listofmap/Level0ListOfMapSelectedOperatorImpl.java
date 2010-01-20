package org.op4j.operators.impl.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ListOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0ListOfMapSelectedOperator<K,V> {


    public Level0ListOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> forEach() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0ListOfMapSelectedOperator<K,V> distinct() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V> insertAll(final int position, final Map<K,V>... map) {
        return null;
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllEqual(final Map<K,V>... values) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllEqual<Map<K,V>>(values)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeAllNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveAllNull<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.LIST_OF_MAP));
    }


    public Level0ListOfMapOperator<K,V> endIf() {
        return new Level0ListOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V> add(final Map<K,V> newElement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ListOfMapSelectedOperator<K,V> addAll(final Map<K,V>... newElements) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ListOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<Map<K,V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V> newElement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<Map<K,V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ListOfMapSelectedOperator<K,V> exec(final IFunction<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> function) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.LIST_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V> sort() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ListOfMapSelectedOperator<K,V> replaceWith(final List<Map<K,V>> replacement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfMapSelectedOperator<K,V> convert(final IConverter<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> converter) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.LIST_OF_MAP));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
