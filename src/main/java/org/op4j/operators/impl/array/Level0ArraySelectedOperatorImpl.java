package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level0ArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArraySelectedOperator<T> {


    public Level0ArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArraySelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level1ArraySelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level0ArraySelectedOperator<T> distinct() {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ArraySelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level0ArraySelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ArraySelectedOperator<T> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0ArraySelectedOperator<T> removeAllNull() {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level0ArraySelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.ARRAY));
    }


    public Level0ArrayOperator<T> endIf() {
        return new Level0ArrayOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> add(final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level0ArraySelectedOperator<T> addAll(final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level0ArraySelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level0ArraySelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> sort() {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArraySelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0ArraySelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level0ArraySelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.ARRAY));
    }


    public T[] get() {
        return endIf().get();
    }



}
