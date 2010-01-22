package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ArrayOfListSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ArrayOfListSelectedOperator<T,I> {


    public Level0ArrayOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsOperator<T,I> forEach() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ArrayOfListSelectedOperator<T,I> distinct() {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<List<T>>()));
    }


    public Level0ArrayOfListSelectedOperator<T,I> insertAll(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllEqual(final List<T>... values) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> removeAllNull() {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<List<T>>()));
    }


    public Level0ArrayOfListSelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends T>[],? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.ARRAY_OF_LIST));
    }


    public Level0ArrayOfListOperator<T,I> endIf() {
        return new Level0ArrayOfListOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T,I> add(final List<T> newElement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalizationUtils.normalizeList(newElement))));
    }


    public Level0ArrayOfListSelectedOperator<T,I> addAll(final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListSelectedOperator<T,I> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T,I> insert(final int position, final List<T> newElement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeList(newElement))));
    }


    public Level0ArrayOfListSelectedOperator<T,I> exec(final IFunction<? extends List<? extends T>[],? super List<T>[]> function) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.ARRAY_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T,I> sort() {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfListSelectedOperator<T,I> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfListSelectedOperator<T,I> replaceWith(final List<T>[] replacement) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfListSelectedOperator<T,I> convert(final IConverter<? extends List<? extends T>[],? super List<T>[]> converter) {
        return new Level0ArrayOfListSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.ARRAY_OF_LIST));
    }


    public List<T>[] get() {
        return endIf().get();
    }


    public Operation<List<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
