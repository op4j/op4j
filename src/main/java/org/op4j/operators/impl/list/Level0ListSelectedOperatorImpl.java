package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0ListSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ListSelectedOperator<T,I> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<T,I> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListSelectedOperator<T,I> distinct() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ListSelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ListSelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ListSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0ListSelectedOperator<T,I> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level0ListSelectedOperator<T,I> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level0ListOperator<T,I> endIf() {
        return new Level0ListOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T,I> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level0ListSelectedOperator<T,I> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level0ListSelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    public Level0ListSelectedOperator<T,I> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T,I> sort() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListSelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListSelectedOperator<T,I> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }


    public Operation<List<T>,I> createOperation() {
        return endIf().createOperation();
    }



}
