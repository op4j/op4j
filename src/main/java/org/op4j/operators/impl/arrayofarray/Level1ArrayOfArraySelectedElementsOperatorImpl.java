package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfArraySelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ArrayOfArraySelectedElementsOperator<T,I> {


    private final Type<? extends T[]> type;


    public Level1ArrayOfArraySelectedElementsOperatorImpl(final Type<? extends T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> distinct() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> removeAllNull() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level0ArrayOfArraySelectedOperator<T,I> endFor() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsOperator<T,I> sort() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.ARRAY));
    }


    public T[][] get() {
        return endFor().get();
    }


    public Operation<T[][],I> createOperation() {
        return endFor().createOperation();
    }



}
