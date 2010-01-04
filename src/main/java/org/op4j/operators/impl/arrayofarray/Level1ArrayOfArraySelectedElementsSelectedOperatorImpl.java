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


public class Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArraySelectedElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ArrayOfArraySelectedElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArraySelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[][] get() {
        return null;
    }



}
