package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfArraySelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level0SetOfArraySelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1SetOfArraySelectedElementsOperator<T> forEach() {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> eval(final IEvaluator<? extends Set<T[]>,? super Set<T[]>> eval) {
        return null;
    }


    public Level0SetOfArrayOperator<T> endIf() {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> add(final T[]... newElements) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> exec(final IFunction<? extends Set<T[]>,? super Set<T[]>> function) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> sort() {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return null;
    }


    public Level0SetOfArraySelectedOperator<T> convert(final IConverter<? extends Set<T[]>,? super Set<T[]>> converter) {
        return null;
    }


    public Set<T[]> get() {
        return null;
    }



}
