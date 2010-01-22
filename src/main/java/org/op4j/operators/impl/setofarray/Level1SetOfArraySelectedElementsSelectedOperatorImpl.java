package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsSelectedOperator<T,I> {


    public Level1SetOfArraySelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> distinct() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> removeAllNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1SetOfArraySelectedElementsOperator<T,I> endIf() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> add(final T newElement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> sort() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Set<T[]> get() {
        return endIf().get();
    }


    public Operation<Set<T[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
