package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ListOfArraySelectedElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> distinct() {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ListOfArraySelectedElementsOperator<T> endIf() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> sort() {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public List<T[]> get() {
        return null;
    }



}
