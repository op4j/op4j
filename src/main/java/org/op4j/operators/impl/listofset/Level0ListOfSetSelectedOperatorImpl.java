package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ListOfSetSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ListOfSetSelectedOperator<T,I> {


    public Level0ListOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> forEach() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOfSetSelectedOperator<T,I> distinct() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOfSetSelectedOperator<T,I> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllEqual(final Set<T>... values) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }


    public Level0ListOfSetSelectedOperator<T,I> removeAllNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0ListOfSetSelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.LIST_OF_SET));
    }


    public Level0ListOfSetOperator<T,I> endIf() {
        return new Level0ListOfSetOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T,I> add(final Set<T> newElement) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0ListOfSetSelectedOperator<T,I> addAll(final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0ListOfSetSelectedOperator<T,I> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(NormalizationUtils.normalizeSets(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T,I> insert(final int position, final Set<T> newElement) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0ListOfSetSelectedOperator<T,I> exec(final IFunction<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> function) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.LIST_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T,I> sort() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetSelectedOperator<T,I> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ListOfSetSelectedOperator<T,I> replaceWith(final List<Set<T>> replacement) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfSetSelectedOperator<T,I> convert(final IConverter<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> converter) {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.LIST_OF_SET));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }


    public Operation<List<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
