package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ArrayOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfSetSelectedElementsOperator<T> {


    public Level1ArrayOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> removeAllNull() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalisation.SET));
    }


    public Level0ArrayOfSetSelectedOperator<T> endFor() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().endIterate(Set.class));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsOperator<T> add(final T newElement) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetSelectedElementsOperator<T> sort() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalisation.SET));
    }


    public Set<T>[] get() {
        return endFor().get();
    }



}
