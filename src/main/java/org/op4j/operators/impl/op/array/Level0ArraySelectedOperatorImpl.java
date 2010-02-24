package org.op4j.operators.impl.op.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.structures.FArray;
import org.op4j.operators.impl.op.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ArraySelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements UniqOpOperator<T[],I>, Level0ArraySelectedOperator<T,I> {


    private final Type<T> type;


    public Level0ArraySelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperatorImpl<T,I> forEach() {
        return new Level1ArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArraySelectedOperatorImpl<T,I> distinct() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Distinct<T>()));
    }


    public Level0ArraySelectedOperatorImpl<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElements)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllIndexes(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllEqual<T>(values)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllIndexesNot(final int... indexes) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> removeAllNull() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.RemoveAllNull<T>()));
    }


    public Level0ArraySelectedOperatorImpl<T,I> execIfNotNullAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<T,I> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<T,I> mapIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level0ArrayOperatorImpl<T,I> endIf() {
        return new Level0ArrayOperatorImpl<T,I>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<T,I> add(final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Add<T>(newElement)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> addAll(final T... newElements) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Add<T>(newElements)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<T,I> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperatorImpl<T,I> sort() {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.Sort()));
    }


    public Level0ArraySelectedOperatorImpl<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().execute(new FArray.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperatorImpl<T,I> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperatorImpl<T,I> map(final IFunction<? extends T,? super T> function) {
        return new Level0ArraySelectedOperatorImpl<T,I>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public T[] get() {
        return endIf().get();
    }



}
