package org.op4j.operators.impl.array;

import java.util.Collection;
import java.util.Comparator;
import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.array.Level0ArraySelectedOperator;
import org.op4j.operators.intf.array.Level1ArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArraySelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level0ArraySelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ArraySelectedElementsOperator<T> forEach() {
        return new Level1ArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level0ArraySelectedOperator<T> distinct() {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level0ArraySelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ArraySelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ArraySelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0ArrayOperator<T> endIf() {
        return new Level0ArrayOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level0ArraySelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level0ArraySelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level0ArraySelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level0ArraySelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<T> sort() {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArraySelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArraySelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level0ArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[] get() {
        return null;
    }



}
