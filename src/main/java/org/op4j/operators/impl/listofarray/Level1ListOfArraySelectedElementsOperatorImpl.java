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
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ListOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsOperator<T> {


    private final Type<T> type;


    public Level1ListOfArraySelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> forEach() {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1ListOfArraySelectedElementsOperator<T> distinct() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeAllNull() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ListOfArraySelectedElementsOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1ListOfArraySelectedElementsOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ListOfArraySelectedOperator<T> endFor() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.type, getTarget().endIterate(null));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T> add(final T newElement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T> sort() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> replaceWith(final T[] replacement) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public List<T[]> get() {
        return endFor().get();
    }



}
