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
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1SetOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level1SetOfArraySelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> distinct() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeAllNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArraySelectedElementsOperator<T> endIf() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T> add(final T newElement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
