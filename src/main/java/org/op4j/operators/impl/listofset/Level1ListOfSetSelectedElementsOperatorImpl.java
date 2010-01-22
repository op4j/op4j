package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfSetSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1ListOfSetSelectedElementsOperator<T,I> {


    public Level1ListOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T,I> forEach() {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> removeAllNull() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level0ListOfSetSelectedOperator<T,I> endFor() {
        return new Level0ListOfSetSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsOperator<T,I> sort() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfSetSelectedElementsOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }


    public Operation<List<Set<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
