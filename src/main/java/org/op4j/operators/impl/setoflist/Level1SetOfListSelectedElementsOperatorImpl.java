package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetOfListSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsOperator<T,I> {


    public Level1SetOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T,I> forEach() {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1SetOfListSelectedElementsOperator<T,I> distinct() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> removeAllNull() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level0SetOfListSelectedOperator<T,I> endFor() {
        return new Level0SetOfListSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T,I> sort() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfListSelectedElementsOperator<T,I> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
