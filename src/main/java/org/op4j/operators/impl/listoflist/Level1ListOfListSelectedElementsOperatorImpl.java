package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level0ListOfListSelectedOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfListSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListOfListSelectedElementsOperator<T,I> {


    public Level1ListOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> forEach() {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1ListOfListSelectedElementsOperator<T,I> distinct() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> removeAllNull() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level0ListOfListSelectedOperator<T,I> endFor() {
        return new Level0ListOfListSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsOperator<T,I> sort() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    public Operation<List<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
