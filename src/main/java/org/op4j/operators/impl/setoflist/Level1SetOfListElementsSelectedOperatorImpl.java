package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1SetOfListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListElementsSelectedOperator<T> {


    public Level1SetOfListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level1SetOfListElementsSelectedOperator<T> distinct() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1SetOfListElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfListElementsSelectedOperator<T> removeAllNull() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfListElementsOperator<T> endIf() {
        return new Level1SetOfListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfListElementsSelectedOperator<T> convertAsList(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST));
    }


    public Level1SetOfListElementsSelectedOperator<T> evalAsList(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST));
    }


    public Level1SetOfListElementsSelectedOperator<T> execAsList(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListElementsSelectedOperator<T> add(final T newElement) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1SetOfListElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListElementsSelectedOperator<T> sort() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfListElementsSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level1SetOfListElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }



}
