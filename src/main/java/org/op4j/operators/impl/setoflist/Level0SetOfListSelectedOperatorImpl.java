package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0SetOfListSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0SetOfListSelectedOperator<T,I> {


    public Level0SetOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsOperator<T,I> forEach() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0SetOfListSelectedOperator<T,I> insertAll(final int position, final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<List<T>>(indices)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllEqual(final List<T>... values) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<List<T>>(indices)));
    }


    public Level0SetOfListSelectedOperator<T,I> removeAllNull() {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<List<T>>()));
    }


    public Level0SetOfListSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET_OF_LIST));
    }


    public Level0SetOfListOperator<T,I> endIf() {
        return new Level0SetOfListOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T,I> add(final List<T> newElement) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalizationUtils.normalizeList(newElement))));
    }


    public Level0SetOfListSelectedOperator<T,I> addAll(final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0SetOfListSelectedOperator<T,I> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T,I> insert(final int position, final List<T> newElement) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeList(newElement))));
    }


    public Level0SetOfListSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> function) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T,I> sort() {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfListSelectedOperator<T,I> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0SetOfListSelectedOperator<T,I> replaceWith(final Set<List<T>> replacement) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfListSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> converter) {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET_OF_LIST));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
