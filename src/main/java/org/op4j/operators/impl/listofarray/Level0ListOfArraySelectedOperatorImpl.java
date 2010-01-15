package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
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


    public Level0ListOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfArraySelectedElementsOperator<T> forEach() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListOfArraySelectedOperator<T> distinct() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0ListOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0ListOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public Level0ListOfArraySelectedOperator<T> removeNulls() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T[]>()));
    }


    public Level0ListOfArraySelectedOperator<T> eval(final IEvaluator<? extends List<? extends T[]>,? super List<T[]>> eval) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ListOfArrayOperator<T> endIf() {
        return new Level0ListOfArrayOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListOfArraySelectedOperator<T> add(final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T[]>(newElements)));
    }


    public Level0ListOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T[]>(collection)));
    }


    public Level0ListOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T[]>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfArraySelectedOperator<T> sort() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ListOfArraySelectedOperator<T> exec(final IFunction<? extends List<? extends T[]>,? super List<T[]>> function) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0ListOfArraySelectedOperator<T> convert(final IConverter<? extends List<? extends T[]>,? super List<T[]>> converter) {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
