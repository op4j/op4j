package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetOfSetSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetOfSetSelectedElementsOperator<T,I> {


    public Level1SetOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsElementsOperator<T,I> forEach() {
        return new Level2SetOfSetSelectedElementsElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllEqual(final T... values) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> removeAllNull() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.SET));
    }


    public Level0SetOfSetSelectedOperator<T,I> endFor() {
        return new Level0SetOfSetSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T,I> add(final T newElement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> addAll(final T... newElements) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> addAll(final Collection<T> collection) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T,I> insert(final int position, final T newElement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetSelectedElementsOperator<T,I> sort() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfSetSelectedElementsOperator<T,I> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.SET));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
