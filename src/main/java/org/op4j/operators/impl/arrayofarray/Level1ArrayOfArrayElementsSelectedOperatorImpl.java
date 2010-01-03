package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArrayElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ArrayOfArrayElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArrayElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return null;
    }


    public Level1ArrayOfArrayElementsOperator<T> endIf() {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ArrayOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return null;
    }


    public T[][] get() {
        return null;
    }



}
