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


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> removeAllNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
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
