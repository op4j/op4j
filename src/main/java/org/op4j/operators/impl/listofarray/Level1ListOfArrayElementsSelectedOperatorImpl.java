package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArrayElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ListOfArrayElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return null;
    }


    public Level1ListOfArrayElementsOperator<T> endIf() {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ListOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return null;
    }


    public List<T[]> get() {
        return null;
    }



}
