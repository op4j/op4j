package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.ArrayFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArraySelectedOperator<T> {


    private final Type<T> type;


    public Level0ArraySelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperator<T> forEach() {
        return new Level1ArraySelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArraySelectedOperator<T> distinct() {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ArraySelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level0ArraySelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ArraySelectedOperator<T> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ArraySelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArraySelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ArraySelectedOperator<T> removeAllNull() {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level0ArraySelectedOperator<T> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOperator<T> endIf() {
        return new Level0ArrayOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> add(final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level0ArraySelectedOperator<T> addAll(final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level0ArraySelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> sort() {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArraySelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level0ArraySelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public T[] get() {
        return endIf().get();
    }



}
