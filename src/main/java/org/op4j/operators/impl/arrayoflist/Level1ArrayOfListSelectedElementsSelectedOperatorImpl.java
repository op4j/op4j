package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListSelectedElementsSelectedOperator<T> {


    public Level1ArrayOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
