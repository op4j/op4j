package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ArrayOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArrayElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level1ArrayOfArrayElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeAllNull() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ArrayOfArrayElementsOperator<T> endIf() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public T[][] get() {
        return endIf().get();
    }



}
