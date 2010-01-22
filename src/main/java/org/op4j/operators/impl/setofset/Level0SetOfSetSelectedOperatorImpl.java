package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0SetOfSetSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0SetOfSetSelectedOperator<T,I> {


    public Level0SetOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> forEach() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0SetOfSetSelectedOperator<T,I> insertAll(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Set<T>>(indices)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllEqual(final Set<T>... values) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Set<T>>(indices)));
    }


    public Level0SetOfSetSelectedOperator<T,I> removeAllNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0SetOfSetSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET_OF_SET));
    }


    public Level0SetOfSetOperator<T,I> endIf() {
        return new Level0SetOfSetOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T,I> add(final Set<T> newElement) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0SetOfSetSelectedOperator<T,I> addAll(final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalizationUtils.normalizeSets(newElements))));
    }


    public Level0SetOfSetSelectedOperator<T,I> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(NormalizationUtils.normalizeSets(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T,I> insert(final int position, final Set<T> newElement) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalizationUtils.normalizeSet(newElement))));
    }


    public Level0SetOfSetSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> function) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T,I> sort() {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetSelectedOperator<T,I> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0SetOfSetSelectedOperator<T,I> replaceWith(final Set<Set<T>> replacement) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfSetSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> converter) {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET_OF_SET));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
