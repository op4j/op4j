package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0ListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListSelectedOperator<T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<T> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ListSelectedOperator<T> distinct() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ListSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level0ListSelectedOperator<T> removeEquals(final T... values) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level0ListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level0ListSelectedOperator<T> removeNulls() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level0ListSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level0ListOperator<T> endIf() {
        return new Level0ListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListSelectedOperator<T> add(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level0ListSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ListSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> sort() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }



}
