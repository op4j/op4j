package org.op4j.operators.impl.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ListOfMapSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0ListOfMapSelectedOperator<K,V,I> {


    public Level0ListOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsOperator<K,V,I> forEach() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0ListOfMapSelectedOperator<K,V,I> distinct() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Distinct<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V>... map) {
        return null;
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllEqual(final Map<K,V>... values) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<Map<K,V>>(values)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> removeAllNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.RemoveAllNull<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> eval(final IEvaluator<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.LIST_OF_MAP));
    }


    public Level0ListOfMapOperator<K,V,I> endIf() {
        return new Level0ListOfMapOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V,I> add(final Map<K,V> newElement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> addAll(final Map<K,V>... newElements) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> addAll(final Collection<Map<K,V>> collection) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.AddAll<Map<K,V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V,I> insert(final int position, final Map<K,V> newElement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Insert<Map<K,V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> exec(final IFunction<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> function) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.LIST_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V,I> sort() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ListFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> replaceWith(final List<Map<K,V>> replacement) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfMapSelectedOperator<K,V,I> convert(final IConverter<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> converter) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.LIST_OF_MAP));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
