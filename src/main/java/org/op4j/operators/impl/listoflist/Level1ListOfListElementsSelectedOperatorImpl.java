package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListElementsSelectedOperator<T> {


    public Level1ListOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfListElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfListElementsSelectedOperator<T> distinct() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeNulls() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfListElementsSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListOfListElementsOperator<T> endIf() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfListElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ListOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfListElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListElementsSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsSelectedOperator<T> sort() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListElementsSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
