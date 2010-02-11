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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListSelectedElementsSelectedOperator<T> {


    public Level1ArrayOfListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> removeAllNull() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> endIf() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> convertAsList(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> evalAsList(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListSelectedElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
