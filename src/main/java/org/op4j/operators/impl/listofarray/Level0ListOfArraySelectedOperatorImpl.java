package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ListOfArraySelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ListOfArraySelectedOperator<T,I> {


    public Level0ListOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> forEach() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOfArraySelectedOperator<T,I> distinct() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T,I> insertAll(final int position, final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllEqual(final T[]... values) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T,I> removeAllNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends T[]>,? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.LIST_OF_ARRAY));
    }


    public Level0ListOfArrayOperator<T,I> endIf() {
        return new Level0ListOfArrayOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T,I> add(final T[] newElement) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T[]>(NormalizationUtils.normalizeArray(newElement))));
    }


    public Level0ListOfArraySelectedOperator<T,I> addAll(final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T[]>(NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0ListOfArraySelectedOperator<T,I> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T[]>(NormalizationUtils.normalizeArrays(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T,I> insert(final int position, final T[] newElement) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArray(newElement))));
    }


    public Level0ListOfArraySelectedOperator<T,I> exec(final IFunction<? extends List<? extends T[]>,? super List<T[]>> function) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.LIST_OF_ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T,I> sort() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArraySelectedOperator<T,I> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ListOfArraySelectedOperator<T,I> replaceWith(final List<T[]> replacement) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfArraySelectedOperator<T,I> convert(final IConverter<? extends List<? extends T[]>,? super List<T[]>> converter) {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.LIST_OF_ARRAY));
    }


    public List<T[]> get() {
        return endIf().get();
    }


    public Operation<List<T[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
