package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.NormalisationUtils;


public class Level0ListOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfArraySelectedOperator<T> {


    public Level0ListOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfArraySelectedElementsOperator<T> forEach() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfArraySelectedOperator<T> distinct() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements))));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllEqual(final T[]... values) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T> removeAllNull() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T> eval(final IEvaluator<? extends List<? extends T[]>,? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST_OF_ARRAY));
    }


    public Level0ListOfArrayOperator<T> endIf() {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T> add(final T[] newElement) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement))));
    }


    public Level0ListOfArraySelectedOperator<T> addAll(final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements))));
    }


    public Level0ListOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T> insert(final int position, final T[] newElement) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement))));
    }


    public Level0ListOfArraySelectedOperator<T> exec(final IFunction<? extends List<? extends T[]>,? super List<T[]>> function) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST_OF_ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T> sort() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ListOfArraySelectedOperator<T> replaceWith(final List<T[]> replacement) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfArraySelectedOperator<T> convert(final IConverter<? extends List<? extends T[]>,? super List<T[]>> converter) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST_OF_ARRAY));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
