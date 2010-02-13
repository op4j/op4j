package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListElementsSelectedOperator<T> {


    public Level1ArrayOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsSelectedElementsOperator<T> forEach() {
        return new Level2ArrayOfListElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> distinct() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> removeAllNull() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfListElementsOperator<T> endIf() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ArrayOfListElementsSelectedOperator<T> convertAsList(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> evalAsList(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfListElementsSelectedOperator<T> sort() {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level1ArrayOfListElementsSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level1ArrayOfListElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
