package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ListOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArrayElementsSelectedOperator<T> {


    public Level1ListOfArrayElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeAllNull() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1ListOfArrayElementsOperator<T> endIf() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsSelectedOperator<T> sort() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
