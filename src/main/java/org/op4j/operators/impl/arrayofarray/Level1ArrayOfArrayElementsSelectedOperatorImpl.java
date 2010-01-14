package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArrayElementsSelectedOperator<T> {


    private final Type<T[]> type;


    public Level1ArrayOfArrayElementsSelectedOperatorImpl(final Type<T[]> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ArrayOfArrayElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNulls() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level1ArrayOfArrayElementsOperator<T> endIf() {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArrayElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public T[][] get() {
        return endIf().get();
    }



}
