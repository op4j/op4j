package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.NormalisationUtils;


public class Level0ArrayOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfArraySelectedOperator<T> {


    public Level0ArrayOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> forEach(final Type<T[]> elementType) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level0ArrayOfArraySelectedOperator<T> distinct() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements))));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllEqual(final T[]... values) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T[]>()));
    }


    public Level0ArrayOfArraySelectedOperator<T> eval(final IEvaluator<? extends T[][],? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.ARRAY_OF_ARRAY));
    }


    public Level0ArrayOfArrayOperator<T> endIf() {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> add(final T[] newElement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement))));
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements))));
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> insert(final int position, final T[] newElement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement))));
    }


    public Level0ArrayOfArraySelectedOperator<T> exec(final IFunction<? extends T[][],? super T[][]> function) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.ARRAY_OF_ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> sort() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArraySelectedOperator<T> replaceWith(final T[][] replacement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0ArrayOfArraySelectedOperator<T> convert(final IConverter<? extends T[][],? super T[][]> converter) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.ARRAY_OF_ARRAY));
    }


    public T[][] get() {
        return endIf().get();
    }



}
