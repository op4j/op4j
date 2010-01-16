package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1ListOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListSelectedElementsSelectedOperator<T> {


    public Level1ListOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> distinct() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level1ListOfListSelectedElementsOperator<T> endIf() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsSelectedOperator<T> sort() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
