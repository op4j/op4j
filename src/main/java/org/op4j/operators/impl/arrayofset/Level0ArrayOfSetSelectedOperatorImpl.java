package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ArrayOfSetSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ArrayOfSetSelectedOperator<T,I> {


    public Level0ArrayOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsOperator<T,I> forEach() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ArrayOfSetSelectedOperator<T,I> distinct() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllEqual(final Set<T>... values) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> removeAllNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>[],? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.ARRAY_OF_SET));
    }


    public Level0ArrayOfSetOperator<T,I> endIf() {
        return new Level0ArrayOfSetOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T,I> add(final Set<T> newElement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> addAll(final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(NormalizationUtils.normalizeSets(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T,I> insert(final int position, final Set<T> newElement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>[],? super Set<T>[]> function) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.ARRAY_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T,I> sort() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> replaceWith(final Set<T>[] replacement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfSetSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>[],? super Set<T>[]> converter) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.ARRAY_OF_SET));
    }


    public Set<T>[] get() {
        return endIf().get();
    }


    public Operation<Set<T>[],I> createOperation() {
        return endIf().createOperation();
    }



}
