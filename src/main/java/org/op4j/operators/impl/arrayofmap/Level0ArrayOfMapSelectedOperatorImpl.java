package org.op4j.operators.impl.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ArrayOfMapSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0ArrayOfMapSelectedOperator<K,V,I> {


    public Level0ArrayOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V,I> forEach() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> distinct() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Distinct<Map<K,V>>()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V>... map) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<Map<K,V>>(indices)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllEqual(final Map<K,V>... values) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<Map<K,V>>(values)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<Map<K,V>>(indices)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> removeAllNull() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<Map<K,V>>()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> eval(final IEvaluator<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.ARRAY_OF_MAP));
    }


    public Level0ArrayOfMapOperator<K,V,I> endIf() {
        return new Level0ArrayOfMapOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapSelectedOperator<K,V,I> add(final Map<K,V> newElement) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> addAll(final Map<K,V>... newElements) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> addAll(final Collection<Map<K,V>> collection) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.AddAll<Map<K,V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapSelectedOperator<K,V,I> insert(final int position, final Map<K,V> newElement) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Insert<Map<K,V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> exec(final IFunction<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> function) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.ARRAY_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapSelectedOperator<K,V,I> sort() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> replaceWith(final Map<K,V>[] replacement) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfMapSelectedOperator<K,V,I> convert(final IConverter<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> converter) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.ARRAY_OF_MAP));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }


    public Operation<Map<K,V>[],I> createOperation() {
        return endIf().createOperation();
    }



}
