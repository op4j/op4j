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
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1SetOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsOperator<T> {


    private final Type<T> type;


    public Level1SetOfArraySelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> forEach() {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level1SetOfArraySelectedElementsOperator<T> distinct() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeAllNull() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> convertAsArray(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArraySelectedElementsOperator<T> evalAsArray(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level1SetOfArraySelectedElementsOperator<T> execAsArray(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0SetOfArraySelectedOperator<T> endFor() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().endIterate(null));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsOperator<T> add(final T newElement) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> replaceWith(final T[] replacement) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Set<T[]> get() {
        return endFor().get();
    }



}
