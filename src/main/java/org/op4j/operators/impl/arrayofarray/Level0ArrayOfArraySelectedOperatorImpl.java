package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfArraySelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level0ArrayOfArraySelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> distinct() {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> eval(final IEvaluator<? extends T[][],? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0ArrayOfArrayOperator<T> endIf() {
        return new Level0ArrayOfArrayOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level0ArrayOfArraySelectedOperator<T> add(final T[]... newElements) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> exec(final IFunction<? extends T[][],? super T[][]> function) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level0ArrayOfArraySelectedOperator<T> sort() {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return null;
    }


    public Level0ArrayOfArraySelectedOperator<T> convert(final IConverter<? extends T[][],? super T[][]> converter) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[][] get() {
        return null;
    }



}
