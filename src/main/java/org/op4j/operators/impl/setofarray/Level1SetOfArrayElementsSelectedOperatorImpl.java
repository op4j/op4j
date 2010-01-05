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
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArrayElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1SetOfArrayElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1SetOfArrayElementsOperator<T> endIf() {
        return new Level1SetOfArrayElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level1SetOfArrayElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArrayElementsSelectedOperator<T> sort() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
