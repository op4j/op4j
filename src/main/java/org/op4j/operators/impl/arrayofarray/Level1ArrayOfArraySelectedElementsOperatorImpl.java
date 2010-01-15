package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArraySelectedElementsOperator<T> {


    private final Type<? extends T[]> type;


    public Level1ArrayOfArraySelectedElementsOperatorImpl(final Type<? extends T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> distinct() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNulls() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> endFor() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsOperator<T> sort() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public T[][] get() {
        return endFor().get();
    }



}
