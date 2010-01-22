package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArrayOfArrayElementsSelectedOperator<T,I> {


    private final Type<? extends T[]> type;


    public Level1ArrayOfArrayElementsSelectedOperatorImpl(final Type<? extends T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> distinct() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> removeAllNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1ArrayOfArrayElementsOperator<T,I> endIf() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T,I> add(final T newElement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> addAll(final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T,I> sort() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.ARRAY));
    }


    public T[][] get() {
        return endIf().get();
    }


    public Operation<T[][],I> createOperation() {
        return endIf().createOperation();
    }



}
