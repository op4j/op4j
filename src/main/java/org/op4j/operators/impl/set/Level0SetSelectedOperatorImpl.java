package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0SetSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0SetSelectedOperator<T,I> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<T,I> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0SetSelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level0SetSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0SetSelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0SetSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0SetSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0SetSelectedOperator<T,I> removeAllNull() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level0SetSelectedOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level0SetOperator<T,I> endIf() {
        return new Level0SetOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T,I> add(final T newElement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level0SetSelectedOperator<T,I> addAll(final T... newElements) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level0SetSelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    public Level0SetSelectedOperator<T,I> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<T,I> sort() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetSelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level0SetSelectedOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetSelectedOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET));
    }


    public Set<T> get() {
        return endIf().get();
    }


    public Operation<Set<T>,I> createOperation() {
        return endIf().createOperation();
    }



}
