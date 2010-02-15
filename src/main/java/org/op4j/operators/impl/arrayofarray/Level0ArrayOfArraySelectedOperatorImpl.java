package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0ArrayOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfArraySelectedOperator<T> {


    private final Type<T> type;


    public Level0ArrayOfArraySelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> forEach() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArrayOfArraySelectedOperator<T> distinct() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T[]>(indexes)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllEqual(final T[]... values) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T[]>(indexes)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeAllNull() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T[]>()));
    }


    public Level0ArrayOfArrayOperator<T> endIf() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level0ArrayOfArraySelectedOperator<T> execIfNotNullAsArrayOfArray(final IFunction<? extends T[][],? super T[][]> function) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOfArraySelectedOperator<T> execAsArrayOfArray(final IFunction<? extends T[][],? super T[][]> function) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0ArrayOfArraySelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> add(final T[] newElement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> insert(final int position, final T[] newElement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> sort() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArraySelectedOperator<T> replaceWith(final T[][] replacement) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY_OF_ARRAY(this.type.getRawClass())));
    }


    public T[][] get() {
        return endIf().get();
    }



}
