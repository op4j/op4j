package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ListOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfArraySelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level0ListOfArraySelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ListOfArraySelectedElementsOperator<T> forEach() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level0ListOfArraySelectedOperator<T> distinct() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> removeNulls() {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> eval(final IEvaluator<? extends List<T[]>,? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0ListOfArrayOperator<T> endIf() {
        return new Level0ListOfArrayOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level0ListOfArraySelectedOperator<T> add(final T[]... newElements) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> exec(final IFunction<? extends List<T[]>,? super List<T[]>> function) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T> sort() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ListOfArraySelectedOperator<T> convert(final IConverter<? extends List<T[]>,? super List<T[]>> converter) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public List<T[]> get() {
        return null;
    }



}
