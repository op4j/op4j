package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1SetOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArrayElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level1SetOfArrayElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeAllNull() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY));
    }


    public Level1SetOfArrayElementsOperator<T> endIf() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsSelectedOperator<T> add(final T newElement) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsSelectedOperator<T> sort() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
