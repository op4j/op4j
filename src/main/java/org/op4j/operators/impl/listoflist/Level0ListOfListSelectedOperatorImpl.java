package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListSelectedOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ListOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfListSelectedOperator<T> {


    public Level0ListOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListSelectedElementsOperator<T> forEach() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfListSelectedOperator<T> distinct() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<List<T>>()));
    }


    public Level0ListOfListSelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }


    public Level0ListOfListSelectedOperator<T> removeAllNull() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<List<T>>()));
    }


    public Level0ListOfListSelectedOperator<T> replaceBy(final List<List<T>> replacement) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level0ListOfListSelectedOperator<T> eval(final IEvaluator<? extends List<? extends List<? extends T>>,? super List<List<T>>> eval) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST_OF_LIST));
    }


    public Level0ListOfListOperator<T> endIf() {
        return new Level0ListOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListOfListSelectedOperator<T> add(final List<T>... newElements) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ListOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    public Level0ListOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ListOfListSelectedOperator<T> exec(final IFunction<? extends List<? extends List<? extends T>>,? super List<List<T>>> function) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.LIST_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfListSelectedOperator<T> sort() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ListOfListSelectedOperator<T> convert(final IConverter<? extends List<? extends List<? extends T>>,? super List<List<T>>> converter) {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST_OF_LIST));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
