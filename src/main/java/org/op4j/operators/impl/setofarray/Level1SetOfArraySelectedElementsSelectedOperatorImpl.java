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
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsSelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1SetOfArraySelectedElementsSelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> distinct() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1SetOfArraySelectedElementsOperator<T> endIf() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
