package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArraySelectedElementsSelectedOperator<T> {


    private final Type<? extends T[]> type;


    public Level1ArrayOfArraySelectedElementsSelectedOperatorImpl(final Type<? extends T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArraySelectedElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalization.ARRAY));
    }


    public T[][] get() {
        return endIf().get();
    }



}
