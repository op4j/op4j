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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ListOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListElementsSelectedOperator<T> {


    public Level1ListOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfListElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1ListOfListElementsSelectedOperator<T> distinct() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ListOfListElementsSelectedOperator<T> removeAllNull() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfListElementsOperator<T> endIf() {
        return new Level1ListOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfListElementsSelectedOperator<T> convertAsList(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST));
    }


    public Level1ListOfListElementsSelectedOperator<T> evalAsList(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST));
    }


    public Level1ListOfListElementsSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1ListOfListElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ListOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListElementsSelectedOperator<T> sort() {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListElementsSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level1ListOfListElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
