package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0ArraySelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0ArraySelectedOperator<T,I> {


    public Level0ArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArraySelectedElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level0ArraySelectedOperator<T,I> distinct() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ArraySelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0ArraySelectedOperator<T,I> removeAllNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level0ArraySelectedOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level0ArrayOperator<T,I> endIf() {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T,I> add(final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level0ArraySelectedOperator<T,I> addAll(final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level0ArraySelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level0ArraySelectedOperator<T,I> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T,I> sort() {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArraySelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperator<T,I> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ArraySelectedOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level0ArraySelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public T[] get() {
        return endIf().get();
    }


    public Operation<T[],I> createOperation() {
        return endIf().createOperation();
    }



}
