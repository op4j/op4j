package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfArraySelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsOperator<T,I> {


    public Level1ListOfArraySelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T,I> forEach(final Type<T> elementType) {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T,I>(elementType, getTarget().iterate());
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> distinct() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> removeAllNull() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level0ListOfArraySelectedOperator<T,I> endFor() {
        return new Level0ListOfArraySelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T,I> sort() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> replaceWith(final T[] replacement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfArraySelectedElementsOperator<T,I> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public List<T[]> get() {
        return endFor().get();
    }


    public Operation<List<T[]>,I> createOperation() {
        return endFor().createOperation();
    }



}
