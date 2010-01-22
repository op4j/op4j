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
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsSelectedOperator<T,I> {


    public Level1SetOfSetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> forEach() {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> removeAllNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> endIf() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> add(final T newElement) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> sort() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
